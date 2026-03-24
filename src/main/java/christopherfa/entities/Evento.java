package christopherfa.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Evento {
    public void setNumeroMassimoPartecipanti(int i) {
    }

    public void setTipoEvento(christopherfa.entities.TipoEvento tipoEvento) {
    }

    public void setDescrizione(String evento) {
    }

    public void setDataEvento(LocalDate of) {
    }

    public void setTitolo(String concerto) {
    }

    public String getId() {
        return "";
    }

    public String getTitolo() {
        return "";
    }

    public enum TipoEvento {
    PUBBLICO, PRIVATO
}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titolo;

    private LocalDate dataEvento;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    private int numeroMassimoPartecipanti;
}

