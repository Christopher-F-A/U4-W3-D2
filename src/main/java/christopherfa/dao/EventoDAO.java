package christopherfa.dao;

import christopherfa.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EventoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D2");

    public void save(Evento e) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(e);
        et.commit();
        em.close();
    }

    public Evento getById(Long id) {
        EntityManager em = emf.createEntityManager();
        Evento e = em.find(Evento.class, id);
        em.close();
        return e;
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Evento e = em.find(Evento.class, id);
        if (e != null) {
            em.remove(e);
        }
        et.commit();
        em.close();
    }
}