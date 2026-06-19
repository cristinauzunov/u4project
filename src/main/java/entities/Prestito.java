package entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInizio;
    private LocalDate dataRestituzione;
    private LocalDate dataRestituzioneEffettiva;

    // un prestito riguarda un solo utente

    @ManyToOne
    private Utente utente;

    // un prestito riguarda un solo elemento del catalogo

    @ManyToOne
    private ElementoCatalogo elementoCatalogo;

    // costruttore vuoto per JPA
    public Prestito() {
    }

    public Prestito(LocalDate dataInizio, Utente utente, ElementoCatalogo elementoCatalogo) {
        this.dataInizio = dataInizio;
        this.dataRestituzione = dataInizio.plusDays(30);
        this.utente = utente;
        this.elementoCatalogo = elementoCatalogo;
    }

    // getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoCatalogo getElementoCatalogo() {
        return elementoCatalogo;
    }

    public void setElementoCatalogo(ElementoCatalogo elementoCatalogo) {
        this.elementoCatalogo = elementoCatalogo;
    }

    @Override
    public String toString() {
        return "Prestito [id=" + id + ", dataInizio=" + dataInizio + ", dataRestituzione=" + dataRestituzione + ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva + "]";
    }
}