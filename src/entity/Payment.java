package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by entity on 12/14/18.
 */
@Entity
public class Payment {
  private Integer id;
  private Integer payerId;
  private Integer amount;
  private Timestamp created;

  @Id
  @Column(name = "id", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "payer_id", nullable = false)
  public Integer getPayerId() {
    return payerId;
  }

  public void setPayerId(Integer payerId) {
    this.payerId = payerId;
  }

  @Basic
  @Column(name = "amount", nullable = false)
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @Basic
  @Column(name = "created", nullable = false)
  public Timestamp getCreated() {
    return created;
  }

  public void setCreated(Timestamp created) {
    this.created = created;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Payment payment = (Payment) o;

    if (id != null ? !id.equals(payment.id) : payment.id != null) return false;
    if (payerId != null ? !payerId.equals(payment.payerId) : payment.payerId != null) return false;
    if (amount != null ? !amount.equals(payment.amount) : payment.amount != null) return false;
    if (created != null ? !created.equals(payment.created) : payment.created != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (payerId != null ? payerId.hashCode() : 0);
    result = 31 * result + (amount != null ? amount.hashCode() : 0);
    result = 31 * result + (created != null ? created.hashCode() : 0);
    return result;
  }
}
