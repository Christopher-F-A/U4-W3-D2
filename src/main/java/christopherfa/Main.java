package christopherfa;

import christopherfa.dao.EventoDAO;
import christopherfa.entities.Evento;
import christopherfa.entities.TipoEvento;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // 1. Istanziamo il DAO
        EventoDAO ed = new EventoDAO();

        // 2. Creiamo nuovo evento di prova
        Evento concerto = new Evento();
        concerto.setTitolo("Concerto");
        concerto.setDataEvento(LocalDate.of(2026, 5, 20));
        concerto.setDescrizione("evento");
        concerto.setTipoEvento(TipoEvento.PUBBLICO);
        concerto.setNumeroMassimoPartecipanti(500);

        // 3. Salviamo nel database
        try {
            ed.save(concerto);
            System.out.println("Evento salvato con successo! ID: " + concerto.getId());
        } catch (Exception e) {
            System.err.println("Errore durante il salvataggio: " + e.getMessage());
            e.printStackTrace();
        }

        // 4. Prova a recuperarlo per vedere se lo legge
        Evento recuperato = ed.getById(1L);
        if (recuperato != null) {
            System.out.println("Evento trovato: " + recuperato.getTitolo());
        }
    }
}
