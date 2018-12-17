package beams;

import entity.Lender;

import java.util.List;

/**
 * Created by hsue on 12/11/18.
 */
public class APIResponse {

  Paging paging;
  List<Lender> lenders;

  public List<Lender> getLenders() {
    return lenders;
  }

  public void setLenders(List<Lender> lenders) {
    this.lenders = lenders;
  }


  public Paging getPaging() {
    return paging;
  }

  public void setPaging(Paging paging) {
    this.paging = paging;
  }

}
