package com.woorifisa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-mapping");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
    }
}
