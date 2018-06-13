package Service;

import model.ActiviteEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EnregistrerInscription {


    private EntityManager entityManager;

    public void insert(ActiviteEntity activite) throws Exception {

        entityManager = Persistence.createEntityManagerFactory("Cerisaie").createEntityManager();

        try {
            if (!entityManager.contains(activite)) {

                entityManager.getTransaction().begin();
                entityManager.persist(activite);
                entityManager.flush();
                entityManager.getTransaction().commit();
            }
            entityManager.close();

        } catch (Exception h) {
            System.err.println(h.getMessage());
        }
    }
}
