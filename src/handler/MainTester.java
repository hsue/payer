package handler;

import beams.APIResponse;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainTester {

  public void getAllLoans() throws IOException{
    String res = getHTTPResponse("http://api.kivaws.org/v1/loans/search.json?status=funded");
    System.out.println(res);
  }

  public void getLoan300000() throws IOException, JSONException {
    String res = getHTTPResponse("http://api.kivaws.org/v1/loans/300000.json");
    JSONObject obj = new JSONObject(res);
    JSONArray arr = obj.getJSONArray("loans");
    for (int i = 0; i < arr.length(); i++) {
      String name = arr.getJSONObject(i).getString("name");
      System.out.println(name);
    }
  }

  public void getLenders() throws IOException {
    String res = getHTTPResponse("http://api.kivaws.org/v1/loans/300000/lenders.json");
    Gson gson = new Gson();
    APIResponse result = gson.fromJson(res, APIResponse.class);
    System.out.println("lenders = "+result.getLenders());

    PersistenceManager manager = new PersistenceManager();
    manager.setup();
    manager.createLenders(result.getLenders());

  }

  public void getLoan() throws IOException {
    String res = getHTTPResponse("http://api.kivaws.org/v1/lenders/charmaine1388.json");
    System.out.println(res);
    Gson gson = new Gson();
    APIResponse result = gson.fromJson(res, APIResponse.class);
    System.out.println("lenders = "+result.getLenders());
  }

  private String getHTTPResponse(String urlStr) throws IOException {
    URL url = new URL(urlStr);
    return getHTTPResponse(url);
  }

  private String getHTTPResponse(URL url) throws IOException {
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Accept", "application/json");
    int responseCode = conn.getResponseCode();
    String output = IOUtils.toString(conn.getInputStream());

    if (responseCode != 200) {
      throw new RuntimeException(output);
    }
    conn.disconnect();

    return output;
  }

  public static void main(String[] args) throws IOException, JSONException {
      MainTester job = new MainTester();
      job.getAllLoans();
      job.getLoan300000();
      job.getLenders();
      //job.getTestLender();
    }
}
