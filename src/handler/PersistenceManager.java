package handler;

import entity.Image;
import entity.Lender;
import entity.Loan;
import entity.Transaction;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class PersistenceManager {
  private static final String PERSISTENCE_UNIT_NAME = "PayerUnit";
  private static EntityManagerFactory factory;

  /**
   * run this main to test if db connection is working
   * @param args
   */
  public static void main(String[] args) {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
    // read the existing entries and write to console
    Query q = em.createQuery("select t from Lender t");
    List<Lender> LenderList = q.getResultList();
    for (Lender lender : LenderList) {
      System.out.println(lender);
    }
    System.out.println("Size: " + LenderList.size());

    // create new lender
    em.getTransaction().begin();
    Lender lender = new Lender();
    lender.setCountryCode("US");
    lender.setWhereabouts("Fremont, CA");
    lender.setUid("12345");
    em.persist(lender);
    em.getTransaction().commit();

    em.close();
    System.exit(0);
  }

  public void setup() {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
  }

  /**
   *
   * @param lenders
   */
  public void addLenders(List<Lender> lenders) {
    EntityManager em = factory.createEntityManager();

    for(Lender lender: lenders) {

      //add the image obj if it's not added already
      if (lender.getImage() != null
          && (getImages(lender.getImage(), em)== null
          || getImages(lender.getImage(), em).isEmpty())) {

        addImage(lender.getImage(), em);
      }
      // add lender if it's not added already
      if (getLenderByUid(lender, em)== null || getLenderByUid(lender, em).isEmpty()) {
        em.getTransaction().begin();
        em.persist(lender);
        em.getTransaction().commit();
        em.clear();
      }
    }
    em.close();
  }


  public List<Image> getImages(Image image, EntityManager em) {
    return em.createQuery(
        "SELECT i FROM Image i WHERE i.id = :imageId")
        .setParameter("imageId", image.getId())
        .getResultList();
  }

  public List<Lender> getLenderByUid(Lender lender, EntityManager em) {
    return em.createQuery(
        "SELECT i FROM Lender i WHERE i.uid = :lenderUid")
        .setParameter("lenderUid", lender.getUid())
        .getResultList();
  }

  public void addLoan(Loan loan) {
    EntityManager em = factory.createEntityManager();

    if (loan!=null && (getLoanById(loan.getId(), em)==null || getLoanById(loan.getId(), em).isEmpty())) {

      if (loan.getTerms()!=null) {
        em.getTransaction().begin();
        em.persist(loan.getTerms());
        em.getTransaction().commit();
        em.clear();
      }

      if (loan.getImage() != null
          && (getImages(loan.getImage(), em)== null
          || getImages(loan.getImage(), em).isEmpty())) {

        addImage(loan.getImage(), em);
      }

      em.getTransaction().begin();
      em.persist(loan);
      em.getTransaction().commit();
    }
    em.close();
  }

  /**
   * adds the transaction needed for the repayment
   * @param loanId
   */
  public void addTransaction(int loanId) {
    EntityManager em = factory.createEntityManager();
    Loan loan = getLoanById(loanId, em).get(0);
    int amount = loan.getLoan_amount();

    // we assume the payment can be fully divided for now
    int payment = amount/ getAllLenders(em).size();

    for (Lender lender : getAllLenders(em)) {
      Transaction transaction = new Transaction();
      transaction.setLender(lender);
      transaction.setLoan(loan);
      transaction.setPayment(payment);
      transaction.setScheduled(new Date());

      em.getTransaction().begin();
      em.persist(transaction);
      em.getTransaction().commit();
      em.clear();
    }
    em.close();
  }



  public List<Loan> getLoanById(int loanId, EntityManager em) {
    return em.createQuery(
        "SELECT i FROM Loan i WHERE i.id = :loanId")
        .setParameter("loanId", loanId)
        .getResultList();
  }


  // todo: refactor this to a generic save
  public void addImage(Image image, EntityManager em) {
    em.getTransaction().begin();
    em.persist(image);
    em.getTransaction().commit();
    em.clear();
  }

  public List<Lender> getAllLenders(EntityManager em) {
    return em.createQuery(
        "SELECT i FROM Lender i")
        .getResultList();
  }


}