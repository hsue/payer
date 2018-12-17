package entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hsue on 12/16/18.
 */
@Entity
public class Image {
  private Integer id;
  private Integer templateId;
  private List<Lender> lenders;
  private List<Loan> Loans;

  @OneToMany(mappedBy="image", orphanRemoval=true)
  public List<Lender> getLenders() {
    return lenders;
  }

  public void setLenders(List<Lender> lenders) {
    this.lenders = lenders;
  }


  @OneToMany(mappedBy="image", orphanRemoval=true)
  public List<Loan> getLoans() {
    return Loans;
  }

  public void setLoans(List<Loan> loans) {
    Loans = loans;
  }


  @Id
  @Column(name = "id", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "template_id", nullable = true)
  public Integer getTemplateId() {
    return templateId;
  }

  public void setTemplateId(Integer templateId) {
    this.templateId = templateId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Image image = (Image) o;

    if (id != null ? !id.equals(image.id) : image.id != null) return false;
    if (templateId != null ? !templateId.equals(image.templateId) : image.templateId != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (templateId != null ? templateId.hashCode() : 0);
    return result;
  }
}
