package handler;

import entity.Lender;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Manager {
  private static final String PERSISTENCE_UNIT_NAME = "payer";
  private static EntityManagerFactory factory;

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
  }
}