package utils;

import model.Activite;
import model.Emplacement;
import model.Sejour;
import model.Sport;
import org.omg.CORBA.SystemException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Tools {

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public List<Sport> getSports() {

        factory = Persistence.createEntityManagerFactory("PCerisaie");
        entityManager  = factory.createEntityManager();

        System.out.println("qsdfknqllllqsldknfqsldnfqosdnkfqsdknfqùpskdnfsqdknf");

        try {
            entityManager.getTransaction().begin();
            List<Sport> sports = entityManager.createQuery("SELECT s FROM SportEntity s").getResultList();

            System.out.println(sports);
            entityManager.close();

            return sports;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

    public List<Sejour> getSejours() {

        factory = Persistence.createEntityManagerFactory("PCerisaie");
        entityManager  = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            List<Sejour> sejours = entityManager.createQuery("SELECT s FROM SejourEntity s").getResultList();
            entityManager.close();

            return sejours;
        } catch (Exception e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

    public List<Activite> getActivites() {

        factory = Persistence.createEntityManagerFactory("PCerisaie");
        entityManager  = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            List<Activite> activites = entityManager.createQuery("SELECT a FROM ActiviteEntity a").getResultList();
            entityManager.close();

            return activites;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            return null;
        }
    }
}
