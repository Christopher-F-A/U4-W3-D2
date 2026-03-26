package christopherfa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Entity
    public class Concerto extends Evento {
        @Enumerated(EnumType.STRING)
        private GenereConcerto genere;
        private boolean inStreaming;

    }

