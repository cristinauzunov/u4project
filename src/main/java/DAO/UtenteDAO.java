package DAO;

import entities.Utente;
import jakarta.persistence.EntityManager;

public class UtenteDAO {

    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    // salva un utente
    public void save(Utente utente) {
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
        System.out.println("Utente " + utente.getNome() + " salvato!");
    }

    // cerca un utente per id
    public Utente findById(Long id) {
        Utente trovato = em.find(Utente.class, id);
        return trovato;
    }

    // rimuove un utente
    public void delete(Long id) {
        Utente trovato = em.find(Utente.class, id);
        em.getTransaction().begin();
        em.remove(trovato);
        em.getTransaction().commit();
        System.out.println("Utente " + id + " eliminato!");
    }
}