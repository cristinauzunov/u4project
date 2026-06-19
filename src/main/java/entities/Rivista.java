package entities;

import jakarta.persistence.*;

// rivista eredita da ElementoCatalogo
@Entity
@DiscriminatorValue("RIVISTA")
public class Rivista extends ElementoCatalogo {

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    // costruttore vuoto per JPA
    public Rivista() {
    }

    public Rivista(String codiceISBN, String titolo, int annoPublicazione, int numeroPagine, Periodicita periodicita) {
        super(codiceISBN, titolo, annoPublicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    // getter e setter
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista [periodicita=" + periodicita + ", " + super.toString() + "]";
    }
}