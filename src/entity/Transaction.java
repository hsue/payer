package entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by entity on 12/14/18.
 */
@Entity
public class Transaction {
  private Integer id;
  private String scheduled;
  private String sent;
  private Lender lender;
  private Loan loan;
  private Integer payment;

  @Id
  @Column(name = "id", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "scheduled", nullable = false, length = 45)
  public String getScheduled() {
    return scheduled;
  }

  public void setScheduled(String scheduled) {
    this.scheduled = scheduled;
  }

  @Basic
  @Column(name = "sent", nullable = true, length = 45)
  public String getSent() {
    return sent;
  }

  public void setSent(String sent) {
    this.sent = sent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Transaction that = (Transaction) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (scheduled != null ? !scheduled.equals(that.scheduled) : that.scheduled != null) return false;
    if (sent != null ? !sent.equals(that.sent) : that.sent != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (scheduled != null ? scheduled.hashCode() : 0);
    result = 31 * result + (sent != null ? sent.hashCode() : 0);
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "lender_id", referencedColumnName = "id", nullable = false)
  public Lender getLender() {
    return lender;
  }

  public void setLender(Lender lenderByLenderId) {
    this.lender = lenderByLenderId;
  }

  @ManyToOne
  @JoinColumn(name = "loan_id", referencedColumnName = "id", nullable = false)
  public Loan getLoan() {
    return loan;
  }

  public void setLoan(Loan loanByLoanId) {
    this.loan = loanByLoanId;
  }

  @Basic
  @Column(name = "payment", nullable = false, length = 45)
  public Integer getPayment() {
    return payment;
  }

  public void setPayment(Integer paymentByPaymentId) {
    this.payment = paymentByPaymentId;
  }
}
