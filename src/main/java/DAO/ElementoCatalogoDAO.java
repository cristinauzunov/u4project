package DAO;

import entities.ElementoCatalogo;
import entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ElementoCatalogoDAO {

    private EntityManager em;

    public ElementoCatalogoDAO(EntityManager em) {
        this.em = em;
    }

    // salva un elemento (libro o rivista)
    public void save(ElementoCatalogo elemento) {
        em.getTransaction().begin();
        em.persist(elemento);
        em.getTransaction().commit();
        System.out.println("Elemento " + elemento.getCodiceISBN() + " salvato!");
    }

    // cerca per ISBN
    public ElementoCatalogo findByIsbn(String isbn) {
        ElementoCatalogo trovato = em.find(ElementoCatalogo.class, isbn);
        return trovato;
    }

    // rimuove un elemento dato l'ISBN
    public void deleteByIsbn(String isbn) {
        ElementoCatalogo trovato = em.find(ElementoCatalogo.class, isbn);
        em.getTransaction().begin();
        em.remove(trovato);
        em.getTransaction().commit();
        System.out.println("Elemento " + isbn + " eliminato!");
    }

    // ricerca per anno di pubblicazione
    public List<ElementoCatalogo> findByAnno(int anno) {
        TypedQuery<ElementoCatalogo> query = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.annoPublicazione = :anno", ElementoCatalogo.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    // ricerca per autore (solo i libri hanno l'autore)
    public List<Libro> findByAutore(String autore) {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.nomeAutore = :autore", Libro.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    // ricerca per titolo o parte di esso
    public List<ElementoCatalogo> findByTitolo(String titolo) {
        TypedQuery<ElementoCatalogo> query = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE :titolo", ElementoCatalogo.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }
}