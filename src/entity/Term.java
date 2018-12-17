package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by entity on 12/14/18.
 */
@Entity
public class Term {
  private Integer id;
  private Date disbursal_date;
  private String disbursal_currency;
  private Integer disbursal_amount;
  private String repayment_interval;
  private Integer repayment_term;
  private Integer repayment_amount;
  private Loan loan;

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "disbursal_date", nullable = true, length = 45)
  public Date getDisbursal_date() {
    return disbursal_date;
  }

  public void setDisbursal_date(Date disbursalDate) {
    this.disbursal_date = disbursalDate;
  }

  @Basic
  @Column(name = "disbursal_currency", nullable = true, length = 45)
  public String getDisbursal_currency() {
    return disbursal_currency;
  }

  public void setDisbursal_currency(String disbursalCurrency) {
    this.disbursal_currency = disbursalCurrency;
  }

  @Basic
  @Column(name = "disbursal_amount", nullable = true)
  public Integer getDisbursal_amount() {
    return disbursal_amount;
  }

  public void setDisbursal_amount(Integer disbursalAmount) {
    this.disbursal_amount = disbursalAmount;
  }

  @Basic
  @Column(name = "repayment_interval", nullable = true, length = 45)
  public String getRepayment_interval() {
    return repayment_interval;
  }

  public void setRepayment_interval(String repaymentInterval) {
    this.repayment_interval = repaymentInterval;
  }

  @Basic
  @Column(name = "repayment_term", nullable = true)
  public Integer getRepayment_term() {
    return repayment_term;
  }

  public void setRepayment_term(Integer repaymentTerm) {
    this.repayment_term = repaymentTerm;
  }

  @Basic
  @Column(name = "repayment_amount", nullable = true)
  public Integer getRepayment_amount() {
    return repayment_amount;
  }

  public void setRepayment_amount(Integer repaymentAmount) {
    this.repayment_amount = repaymentAmount;
  }

  @OneToOne(mappedBy = "terms", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  public Loan getLoan() {
    return loan;
  }

  public void setLoan(Loan loan) {
    this.loan = loan;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Term term = (Term) o;

    if (id != null ? !id.equals(term.id) : term.id != null) return false;
    if (disbursal_date != null ? !disbursal_date.equals(term.disbursal_date) : term.disbursal_date != null) return false;
    if (disbursal_currency != null ? !disbursal_currency.equals(term.disbursal_currency) : term.disbursal_currency != null)
      return false;
    if (disbursal_amount != null ? !disbursal_amount.equals(term.disbursal_amount) : term.disbursal_amount != null)
      return false;
    if (repayment_interval != null ? !repayment_interval.equals(term.repayment_interval) : term.repayment_interval != null)
      return false;
    if (repayment_term != null ? !repayment_term.equals(term.repayment_term) : term.repayment_term != null) return false;
    if (repayment_amount != null ? !repayment_amount.equals(term.repayment_amount) : term.repayment_amount != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (disbursal_date != null ? disbursal_date.hashCode() : 0);
    result = 31 * result + (disbursal_currency != null ? disbursal_currency.hashCode() : 0);
    result = 31 * result + (disbursal_amount != null ? disbursal_amount.hashCode() : 0);
    result = 31 * result + (repayment_interval != null ? repayment_interval.hashCode() : 0);
    result = 31 * result + (repayment_term != null ? repayment_term.hashCode() : 0);
    result = 31 * result + (repayment_amount != null ? repayment_amount.hashCode() : 0);
    return result;
  }
}
