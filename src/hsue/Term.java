package hsue;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by hsue on 12/14/18.
 */
@Entity
public class Term {
  private Integer id;
  private String disbursalDate;
  private String disbursalCurrency;
  private Integer disbursalAmount;
  private String repaymentInterval;
  private Integer repaymentTerm;
  private Integer repaymentAmount;

  @Id
  @Column(name = "id", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "disbursal_date", nullable = true, length = 45)
  public String getDisbursalDate() {
    return disbursalDate;
  }

  public void setDisbursalDate(String disbursalDate) {
    this.disbursalDate = disbursalDate;
  }

  @Basic
  @Column(name = "disbursal_currency", nullable = true, length = 45)
  public String getDisbursalCurrency() {
    return disbursalCurrency;
  }

  public void setDisbursalCurrency(String disbursalCurrency) {
    this.disbursalCurrency = disbursalCurrency;
  }

  @Basic
  @Column(name = "disbursal_amount", nullable = true)
  public Integer getDisbursalAmount() {
    return disbursalAmount;
  }

  public void setDisbursalAmount(Integer disbursalAmount) {
    this.disbursalAmount = disbursalAmount;
  }

  @Basic
  @Column(name = "repayment_interval", nullable = true, length = 45)
  public String getRepaymentInterval() {
    return repaymentInterval;
  }

  public void setRepaymentInterval(String repaymentInterval) {
    this.repaymentInterval = repaymentInterval;
  }

  @Basic
  @Column(name = "repayment_term", nullable = true)
  public Integer getRepaymentTerm() {
    return repaymentTerm;
  }

  public void setRepaymentTerm(Integer repaymentTerm) {
    this.repaymentTerm = repaymentTerm;
  }

  @Basic
  @Column(name = "repayment_amount", nullable = true)
  public Integer getRepaymentAmount() {
    return repaymentAmount;
  }

  public void setRepaymentAmount(Integer repaymentAmount) {
    this.repaymentAmount = repaymentAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Term term = (Term) o;

    if (id != null ? !id.equals(term.id) : term.id != null) return false;
    if (disbursalDate != null ? !disbursalDate.equals(term.disbursalDate) : term.disbursalDate != null) return false;
    if (disbursalCurrency != null ? !disbursalCurrency.equals(term.disbursalCurrency) : term.disbursalCurrency != null)
      return false;
    if (disbursalAmount != null ? !disbursalAmount.equals(term.disbursalAmount) : term.disbursalAmount != null)
      return false;
    if (repaymentInterval != null ? !repaymentInterval.equals(term.repaymentInterval) : term.repaymentInterval != null)
      return false;
    if (repaymentTerm != null ? !repaymentTerm.equals(term.repaymentTerm) : term.repaymentTerm != null) return false;
    if (repaymentAmount != null ? !repaymentAmount.equals(term.repaymentAmount) : term.repaymentAmount != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (disbursalDate != null ? disbursalDate.hashCode() : 0);
    result = 31 * result + (disbursalCurrency != null ? disbursalCurrency.hashCode() : 0);
    result = 31 * result + (disbursalAmount != null ? disbursalAmount.hashCode() : 0);
    result = 31 * result + (repaymentInterval != null ? repaymentInterval.hashCode() : 0);
    result = 31 * result + (repaymentTerm != null ? repaymentTerm.hashCode() : 0);
    result = 31 * result + (repaymentAmount != null ? repaymentAmount.hashCode() : 0);
    return result;
  }
}
