package christopherfa.dao;

import christopherfa.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D2");

    public void save(Location l) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        em.close();
    }
}