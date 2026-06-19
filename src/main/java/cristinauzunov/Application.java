package cristinauzunov;

import DAO.ElementoCatalogoDAO;
import DAO.JpaUtil;
import DAO.PrestitoDAO;
import DAO.UtenteDAO;
import entities.*;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // creo l'EntityManager
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        // creo i DAO
        ElementoCatalogoDAO catalogoDAO = new ElementoCatalogoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        // creo un paio di libri
        Libro libro1 = new Libro("111", "Il Signore degli Anelli", 1954, 1200, "Tolkien", Genere.FANTASCIENZA);
        Libro libro2 = new Libro("222", "It", 1986, 1138, "Stephen King", Genere.HORROR);

        // creo una rivista
        Rivista rivista1 = new Rivista("333", "Focus", 2024, 100, Periodicita.MENSILE);

        // salvo nel database
        catalogoDAO.save(libro1);
        catalogoDAO.save(libro2);
        catalogoDAO.save(rivista1);

        // creo un utente
        Utente utente1 = new Utente("Cristina", "Uzunov", LocalDate.of(2000, 5, 10), "TESS001");
        utenteDAO.save(utente1);

        // creo un prestito
        Prestito prestito1 = new Prestito(LocalDate.now(), utente1, libro1);
        prestitoDAO.save(prestito1);

        // provo le ricerche
        System.out.println("\n--- Ricerca per ISBN ---");
        System.out.println(catalogoDAO.findByIsbn("111"));

        System.out.println("\n--- Ricerca per autore ---");
        List<Libro> libriTolkien = catalogoDAO.findByAutore("Tolkien");
        libriTolkien.forEach(System.out::println);

        System.out.println("\n--- Ricerca per anno ---");
        List<ElementoCatalogo> del1986 = catalogoDAO.findByAnno(1986);
        del1986.forEach(System.out::println);

        System.out.println("\n--- Prestiti dell'utente TESS001 ---");
        List<Prestito> prestitiUtente = prestitoDAO.findByTessera("TESS001");
        prestitiUtente.forEach(System.out::println);

        System.out.println("\n--- Prestiti scaduti ---");
        List<Prestito> scaduti = prestitoDAO.findScaduti();
        scaduti.forEach(System.out::println);

        // chiudo tutto
        em.close();
        JpaUtil.getEntityManagerFactory().close();
    }
}