package christopherfa.dao;

import christopherfa.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D2");

    public void save(Persona p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }
}