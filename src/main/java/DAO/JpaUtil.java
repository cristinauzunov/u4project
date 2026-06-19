package DAO;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    // si collega al persistence unit del persistence.xml
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4project");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}