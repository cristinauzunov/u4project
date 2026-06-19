package DAO;

import entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO {

    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    // salva un prestito
    public void save(Prestito prestito) {
        em.getTransaction().begin();
        em.persist(prestito);
        em.getTransaction().commit();
        System.out.println("Prestito salvato!");
    }

    // cerca un prestito per id
    public Prestito findById(Long id) {
        Prestito trovato = em.find(Prestito.class, id);
        return trovato;
    }

    // rimuove un prestito
    public void delete(Long id) {
        Prestito trovato = em.find(Prestito.class, id);
        em.getTransaction().begin();
        em.remove(trovato);
        em.getTransaction().commit();
        System.out.println("Prestito " + id + " eliminato!");
    }

    // ricerca dei prestiti di un utente dato il numero di tessera
    public List<Prestito> findByTessera(String numeroTessera) {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :tessera", Prestito.class);
        query.setParameter("tessera", numeroTessera);
        return query.getResultList();
    }

    // ricerca dei prestiti scaduti e non ancora restituiti
    public List<Prestito> findScaduti() {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzione < :oggi AND p.dataRestituzioneEffettiva IS NULL", Prestito.class);
        query.setParameter("oggi", LocalDate.now());
        return query.getResultList();
    }
}