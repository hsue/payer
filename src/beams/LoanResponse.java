package beams;

import entity.Loan;

import java.util.List;

/**
 * Created by hsue on 12/16/18.
 */
public class LoanResponse {
  List<Loan> loans;

  public List<Loan> getLoans() {
    return loans;
  }

  public void setLoans(List<Loan> loans) {
    this.loans = loans;
  }
}
