package christopherfa.dao;

import christopherfa.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

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

    // --- METODI ESERCIZIO #2 ---

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        EntityManager em = emf.createEntityManager(); // <--- IMPORTANTE: Inizializza em!
        List<PartitaDiCalcio> res = em.createNamedQuery("PartitaDiCalcio.getVinteInCasa", PartitaDiCalcio.class).getResultList();
        em.close();
        return res;
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        EntityManager em = emf.createEntityManager();
        List<PartitaDiCalcio> res = em.createNamedQuery("PartitaDiCalcio.getVinteInTrasferta", PartitaDiCalcio.class).getResultList();
        em.close();
        return res;
    }

    public List<Concerto> getConcertiInStreaming(boolean streaming) {
        EntityManager em = emf.createEntityManager();
        List<Concerto> res = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :s", Concerto.class)
                .setParameter("s", streaming)
                .getResultList();
        em.close();
        return res;
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
        EntityManager em = emf.createEntityManager();
        List<Concerto> res = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :g", Concerto.class)
                .setParameter("g", genere)
                .getResultList();
        em.close();
        return res;
    }

    // EXTRA: Gare di atletica per vincitore
    public List<GaraDiAtletica> getGareDiAtleticaPerVincitore(Persona vincitore) {
        EntityManager em = emf.createEntityManager();
        List<GaraDiAtletica> res = em.createQuery("SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :v", GaraDiAtletica.class)
                .setParameter("v", vincitore)
                .getResultList();
        em.close();
        return res;
    }
}