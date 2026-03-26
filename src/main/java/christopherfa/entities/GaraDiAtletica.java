package christopherfa.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {
    @ManyToMany
    @JoinTable(name = "atleti_gara",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private Set<Persona> atleti;

    @ManyToOne
    private Persona vincitore;
    // Getter, Setter e Costruttori
}