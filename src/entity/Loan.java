package entity;

import javax.persistence.*;

/**
 * Created by entity on 12/14/18.
 */
@Entity
public class Loan {
  private Integer id;
  private String name;
  private Integer descriptionId;
  private Integer foundedAmount;
  private String status;
  private Integer imageId;
  private String activity;
  private String sector;
  private String use;
  private Integer locationId;
  private Integer partnerId;
  private String postedDate;
  private Integer loanAmount;
  private Byte bonusCreditEligibility;
  private Integer journalId;
  private Integer remaingTerm;
  private Term term;


  @Id
  @Column(name = "id", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "term_id", referencedColumnName = "id", nullable = false)
  public Term getTerm() {
    return term;
  }

  public void setTerm(Term termByTermId) {
    this.term = termByTermId;
  }

  @Basic
  @Column(name = "name", nullable = true, length = 45)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "description_id", nullable = true)
  public Integer getDescriptionId() {
    return descriptionId;
  }

  public void setDescriptionId(Integer descriptionId) {
    this.descriptionId = descriptionId;
  }

  @Basic
  @Column(name = "founded_amount", nullable = true)
  public Integer getFoundedAmount() {
    return foundedAmount;
  }

  public void setFoundedAmount(Integer foundedAmount) {
    this.foundedAmount = foundedAmount;
  }

  @Basic
  @Column(name = "status", nullable = true, length = 45)
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Basic
  @Column(name = "image_id", nullable = true)
  public Integer getImageId() {
    return imageId;
  }

  public void setImageId(Integer imageId) {
    this.imageId = imageId;
  }

  @Basic
  @Column(name = "activity", nullable = true, length = 45)
  public String getActivity() {
    return activity;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }

  @Basic
  @Column(name = "sector", nullable = true, length = 45)
  public String getSector() {
    return sector;
  }

  public void setSector(String sector) {
    this.sector = sector;
  }

  @Basic
  @Column(name = "use", nullable = true, length = 45)
  public String getUse() {
    return use;
  }

  public void setUse(String use) {
    this.use = use;
  }

  @Basic
  @Column(name = "location_id", nullable = true)
  public Integer getLocationId() {
    return locationId;
  }

  public void setLocationId(Integer locationId) {
    this.locationId = locationId;
  }

  @Basic
  @Column(name = "partner_id", nullable = true)
  public Integer getPartnerId() {
    return partnerId;
  }

  public void setPartnerId(Integer partnerId) {
    this.partnerId = partnerId;
  }

  @Basic
  @Column(name = "posted_date", nullable = true, length = 45)
  public String getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(String postedDate) {
    this.postedDate = postedDate;
  }

  @Basic
  @Column(name = "loan_amount", nullable = true)
  public Integer getLoanAmount() {
    return loanAmount;
  }

  public void setLoanAmount(Integer loanAmount) {
    this.loanAmount = loanAmount;
  }

  @Basic
  @Column(name = "bonus_credit_eligibility", nullable = true)
  public Byte getBonusCreditEligibility() {
    return bonusCreditEligibility;
  }

  public void setBonusCreditEligibility(Byte bonusCreditEligibility) {
    this.bonusCreditEligibility = bonusCreditEligibility;
  }

  @Basic
  @Column(name = "journal_id", nullable = true)
  public Integer getJournalId() {
    return journalId;
  }

  public void setJournalId(Integer journalId) {
    this.journalId = journalId;
  }

  @Basic
  @Column(name = "remaing_term", nullable = false)
  public Integer getRemaingTerm() {
    return remaingTerm;
  }

  public void setRemaingTerm(Integer remaingTerm) {
    this.remaingTerm = remaingTerm;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Loan loan = (Loan) o;

    if (id != null ? !id.equals(loan.id) : loan.id != null) return false;
    if (name != null ? !name.equals(loan.name) : loan.name != null) return false;
    if (descriptionId != null ? !descriptionId.equals(loan.descriptionId) : loan.descriptionId != null) return false;
    if (foundedAmount != null ? !foundedAmount.equals(loan.foundedAmount) : loan.foundedAmount != null) return false;
    if (status != null ? !status.equals(loan.status) : loan.status != null) return false;
    if (imageId != null ? !imageId.equals(loan.imageId) : loan.imageId != null) return false;
    if (activity != null ? !activity.equals(loan.activity) : loan.activity != null) return false;
    if (sector != null ? !sector.equals(loan.sector) : loan.sector != null) return false;
    if (use != null ? !use.equals(loan.use) : loan.use != null) return false;
    if (locationId != null ? !locationId.equals(loan.locationId) : loan.locationId != null) return false;
    if (partnerId != null ? !partnerId.equals(loan.partnerId) : loan.partnerId != null) return false;
    if (postedDate != null ? !postedDate.equals(loan.postedDate) : loan.postedDate != null) return false;
    if (loanAmount != null ? !loanAmount.equals(loan.loanAmount) : loan.loanAmount != null) return false;
    if (bonusCreditEligibility != null ? !bonusCreditEligibility.equals(loan.bonusCreditEligibility) : loan.bonusCreditEligibility != null)
      return false;
    if (journalId != null ? !journalId.equals(loan.journalId) : loan.journalId != null) return false;
    if (remaingTerm != null ? !remaingTerm.equals(loan.remaingTerm) : loan.remaingTerm != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (descriptionId != null ? descriptionId.hashCode() : 0);
    result = 31 * result + (foundedAmount != null ? foundedAmount.hashCode() : 0);
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + (imageId != null ? imageId.hashCode() : 0);
    result = 31 * result + (activity != null ? activity.hashCode() : 0);
    result = 31 * result + (sector != null ? sector.hashCode() : 0);
    result = 31 * result + (use != null ? use.hashCode() : 0);
    result = 31 * result + (locationId != null ? locationId.hashCode() : 0);
    result = 31 * result + (partnerId != null ? partnerId.hashCode() : 0);
    result = 31 * result + (postedDate != null ? postedDate.hashCode() : 0);
    result = 31 * result + (loanAmount != null ? loanAmount.hashCode() : 0);
    result = 31 * result + (bonusCreditEligibility != null ? bonusCreditEligibility.hashCode() : 0);
    result = 31 * result + (journalId != null ? journalId.hashCode() : 0);
    result = 31 * result + (remaingTerm != null ? remaingTerm.hashCode() : 0);
    return result;
  }
}
