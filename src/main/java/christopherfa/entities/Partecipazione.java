package christopherfa.entities;

import jakarta.persistence.*;

@Entity
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private StatoPartecipazione stato;

    public void setEvento(PartitaDiCalcio partita) {
    }

    public void setPersona(Persona p) {
    }

    public void setStato(StatoPartecipazione statoPartecipazione) {
    }
    // Costruttore, Getter e Setter
}