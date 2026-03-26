package christopherfa;

import christopherfa.dao.*;
import christopherfa.entities.*;
import java.time.LocalDate;

public class Main {
    public static <LocationDAO, PersonaDAO, PartecipazioneDAO> void main(String[] args) {

        EventoDAO ed = new EventoDAO();
        LocationDAO ld = new LocationDAO();
        PersonaDAO pd = new PersonaDAO();
        PartecipazioneDAO pard = new PartecipazioneDAO();

        try {

            Location location = new Location();
            location.setNome("Stadio Olimpico");
            location.setCitta("Roma");
            ld.save(location); //


            PartitaDiCalcio partita = new PartitaDiCalcio();
            partita.setTitolo("Derby del Cuore");
            partita.setDataEvento(LocalDate.of(2026, 6, 15));
            partita.setTipoEvento(TipoEvento.PUBBLICO);
            partita.setNumeroMassimoPartecipanti(50000);
            partita.setLocation(location);

            partita.setSquadraDiCasa("Roma");
            partita.setSquadraOspite("Lazio");
            partita.setGolSquadraDiCasa(2);
            partita.setGolSquadraOspite(1);
            partita.setSquadraVincente("Roma");
            ed.save(partita);


            Persona p = new Persona();
            p.setNome("Christopher");
            p.setCognome("F-A");
            p.setEmail("chris@example.com");
            p.setSesso(Sesso.M);
            pd.save(p); //


            Partecipazione part = new Partecipazione();
            part.setEvento(partita); //
            part.setPersona(p);      //
            part.setStato(StatoPartecipazione.CONFERMATA);
            pard.save(part);

            System.out.println("Tutto collegato e salvato correttamente!");

            System.out.println("Partite vinte in casa: " + ed.getPartiteVinteInCasa().size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}