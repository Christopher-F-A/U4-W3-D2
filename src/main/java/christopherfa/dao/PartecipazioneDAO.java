package christopherfa.dao;

import christopherfa.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PartecipazioneDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D2");

    public void save(Partecipazione part) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(part);
        em.getTransaction().commit();
        em.close();
    }
}