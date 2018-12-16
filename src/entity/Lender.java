package entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by entity on 12/14/18.
 */
@Entity
public class Lender {
  private Integer id;
  private String whereabouts;
  private String countryCode;
  private String uid;

  @Id
  @NotNull
  @Column(name = "id", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "whereabouts", nullable = true, length = 45)
  public String getWhereabouts() {
    return whereabouts;
  }

  public void setWhereabouts(String whereabouts) {
    this.whereabouts = whereabouts;
  }

  @Basic
  @Column(name = "country_code", nullable = true, length = 45)
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  @Basic
  @Column(name = "uid", nullable = true, length = 45)
  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Lender lender = (Lender) o;

    if (id != null ? !id.equals(lender.id) : lender.id != null) return false;
    if (whereabouts != null ? !whereabouts.equals(lender.whereabouts) : lender.whereabouts != null) return false;
    if (countryCode != null ? !countryCode.equals(lender.countryCode) : lender.countryCode != null) return false;
    if (uid != null ? !uid.equals(lender.uid) : lender.uid != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (whereabouts != null ? whereabouts.hashCode() : 0);
    result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
    result = 31 * result + (uid != null ? uid.hashCode() : 0);
    return result;
  }
}
