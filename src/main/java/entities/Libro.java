package entities;

import jakarta.persistence.*;

// libro eredita da ElementoCatalogo
@Entity
@DiscriminatorValue("LIBRO")
public class Libro extends ElementoCatalogo {

    private String nomeAutore;

    @Enumerated(EnumType.STRING)
    private Genere genere;

    // costruttore vuoto per JPA
    public Libro() {
    }

    public Libro(String codiceISBN, String titolo, int annoPublicazione, int numeroPagine, String nomeAutore, Genere genere) {
        super(codiceISBN, titolo, annoPublicazione, numeroPagine);
        this.nomeAutore = nomeAutore;
        this.genere = genere;
    }

    // getter e setter
    public String getNomeAutore() {
        return nomeAutore;
    }

    public void setNomeAutore(String nomeAutore) {
        this.nomeAutore = nomeAutore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro [nomeAutore=" + nomeAutore + ", genere=" + genere + ", " + super.toString() + "]";
    }
}