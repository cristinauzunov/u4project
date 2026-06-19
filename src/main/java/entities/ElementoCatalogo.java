package entities;

import jakarta.persistence.*;

// classe padre, da qui ereditano Libro e Rivista
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class ElementoCatalogo {

    @Id
    private String codiceISBN;
    private String titolo;
    private int annoPublicazione;
    private int numeroPagine;

    // costruttore vuoto per JPA
    public ElementoCatalogo() {
    }

    public ElementoCatalogo(String codiceISBN, String titolo, int annoPublicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.numeroPagine = numeroPagine;
    }

    // getter e setter
    public String getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public void setAnnoPublicazione(int annoPublicazione) {
        this.annoPublicazione = annoPublicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "ElementoCatalogo [codiceISBN=" + codiceISBN + ", titolo=" + titolo + ", anno=" + annoPublicazione + ", pagine=" + numeroPagine + "]";
    }
}