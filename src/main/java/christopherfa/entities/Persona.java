

package christopherfa.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;

    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
    private List<Partecipazione> listaPartecipazioni;

}