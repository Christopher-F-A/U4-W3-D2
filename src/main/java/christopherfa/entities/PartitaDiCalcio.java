package christopherfa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;



    @Entity
    @NamedQueries({
            @NamedQuery(name = "PartitaDiCalcio.getVinteInCasa",
                    query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa"),
            @NamedQuery(name = "PartitaDiCalcio.getVinteInTrasferta",
                    query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite"),
            @NamedQuery(name = "PartitaDiCalcio.getPareggiate",
                    query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente IS NULL")
    })
    public class PartitaDiCalcio extends Evento {

        this.campo = valore

        private String squadraDiCasa;
        private String squadraOspite;
        private String squadraVincente; // null se pareggio
        private int golSquadraDiCasa;
        private int golSquadraOspite;

        public void setSquadraDiCasa(String s) { this.squadraDiCasa = s; }
        public void setSquadraOspite(String s) { this.squadraOspite = s; }
        public void setSquadraVincente(String s) { this.squadraVincente = s; }
        public void setGolSquadraDiCasa(int g) { this.golSquadraDiCasa = g; }
        public void setGolSquadraOspite(int g) { this.golSquadraOspite = g; }
    }

