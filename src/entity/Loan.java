package entity;

import javax.persistence.*;

/**
 * Created by entity on 12/14/18.
 */
@Entity
public class Loan extends Participant{
  private Integer id;
  private Integer founded_amount;
  private String status;
  private String activity;
  private String sector;
  private Integer partner_id;
  private String posted_date;
  private Integer loan_amount;
  private Boolean bonus_credit_eligibility;
  private Integer remainingTerm;
  private Term terms;


  @Id
  @Column(name = "id", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @OneToOne
  @JoinColumn(name = "term_id", referencedColumnName = "id", nullable = false)
  public Term getTerms() {
    return terms;
  }

  public void setTerms(Term termByTermId) {
    this.terms = termByTermId;
  }

  @Basic
  @Column(name = "founded_amount", nullable = true)
  public Integer getFounded_amount() {
    return founded_amount;
  }

  public void setFounded_amount(Integer foundedAmount) {
    this.founded_amount = foundedAmount;
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
  @Column(name = "partner_id", nullable = true)
  public Integer getPartner_id() {
    return partner_id;
  }

  public void setPartner_id(Integer partnerId) {
    this.partner_id = partnerId;
  }

  @Basic
  @Column(name = "posted_date", nullable = true, length = 45)
  public String getPosted_date() {
    return posted_date;
  }

  public void setPosted_date(String postedDate) {
    this.posted_date = postedDate;
  }

  @Basic
  @Column(name = "loan_amount", nullable = true)
  public Integer getLoan_amount() {
    return loan_amount;
  }

  public void setLoan_amount(Integer loanAmount) {
    this.loan_amount = loanAmount;
  }

  @Basic
  @Column(name = "bonus_credit_eligibility", nullable = true)
  public Boolean getBonus_credit_eligibility() {
    return bonus_credit_eligibility;
  }

  public void setBonus_credit_eligibility(Boolean bonusCreditEligibility) {
    this.bonus_credit_eligibility = bonusCreditEligibility;
  }

  @Basic
  @Column(name = "remaing_term", nullable = true)
  public Integer getRemainingTerm() {
    return remainingTerm;
  }

  public void setRemainingTerm(Integer remaingTerm) {
    this.remainingTerm = remaingTerm;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Loan loan = (Loan) o;

    if (id != null ? !id.equals(loan.id) : loan.id != null) return false;
    if (founded_amount != null ? !founded_amount.equals(loan.founded_amount) : loan.founded_amount != null) return false;
    if (status != null ? !status.equals(loan.status) : loan.status != null) return false;
    if (activity != null ? !activity.equals(loan.activity) : loan.activity != null) return false;
    if (sector != null ? !sector.equals(loan.sector) : loan.sector != null) return false;
    if (partner_id != null ? !partner_id.equals(loan.partner_id) : loan.partner_id != null) return false;
    if (posted_date != null ? !posted_date.equals(loan.posted_date) : loan.posted_date != null) return false;
    if (loan_amount != null ? !loan_amount.equals(loan.loan_amount) : loan.loan_amount != null) return false;
    if (bonus_credit_eligibility != null ? !bonus_credit_eligibility.equals(loan.bonus_credit_eligibility) : loan.bonus_credit_eligibility != null)
      return false;
    if (remainingTerm != null ? !remainingTerm.equals(loan.remainingTerm) : loan.remainingTerm != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (founded_amount != null ? founded_amount.hashCode() : 0);
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + (activity != null ? activity.hashCode() : 0);
    result = 31 * result + (sector != null ? sector.hashCode() : 0);
    result = 31 * result + (partner_id != null ? partner_id.hashCode() : 0);
    result = 31 * result + (posted_date != null ? posted_date.hashCode() : 0);
    result = 31 * result + (loan_amount != null ? loan_amount.hashCode() : 0);
    result = 31 * result + (bonus_credit_eligibility != null ? bonus_credit_eligibility.hashCode() : 0);
    result = 31 * result + (remainingTerm != null ? remainingTerm.hashCode() : 0);
    return result;
  }
}
