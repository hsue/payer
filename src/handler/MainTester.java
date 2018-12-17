package handler;

import beams.APIResponse;
import beams.LoanResponse;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class MainTester {

  /**
   * test to get all loans (requirement #1)
   * @throws IOException
   */
  public void getAllLoans() throws IOException{
    String res = getHTTPResponse("http://api.kivaws.org/v1/loans/search.json?status=funded");
    System.out.println(res);
  }

  /**
   * get loan with id 300000 and store in db (requirement #2)
   * @throws IOException
   * @throws JSONException
   */
  public void getLoan300000() throws IOException, JSONException {
    String res = getHTTPResponse("http://api.kivaws.org/v1/loans/300000.json");
    Gson gson = new Gson();
    LoanResponse result = gson.fromJson(res, LoanResponse.class);
    PersistenceManager manager = new PersistenceManager();
    manager.setup();

    //add this loan to the db if it's not added already
    if (result.getLoans()!=null && !result.getLoans().isEmpty()) {
      manager.addLoan(result.getLoans().get(0));
    }
  }

  /**
   * get all the lenders (requirement #3)
   * @throws IOException
   */
  public void getLenders() throws IOException {
    String res = getHTTPResponse("http://api.kivaws.org/v1/loans/300000/lenders.json");
    Gson gson = new Gson();
    APIResponse result = gson.fromJson(res, APIResponse.class);
    PersistenceManager manager = new PersistenceManager();
    manager.setup();
    manager.addLenders(result.getLenders());
  }

  /**
   *  Adds the repayment distribution into the transaction table (requirement #4)
   */
  public void addTransaction() {
    PersistenceManager manager = new PersistenceManager();
    manager.setup();
    manager.addTransaction(300000);
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
      //requirement #1
      job.getAllLoans();
      //requirement #2
      job.getLoan300000();
      //requirement #3
      job.getLenders();
      //requirement #4
      job.addTransaction();

      System.exit(0);
    }
}
