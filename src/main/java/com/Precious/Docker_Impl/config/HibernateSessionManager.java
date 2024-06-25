package com.Precious.Docker_Impl.config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateSessionManager {

    @Autowired
    private SessionFactory sessionFactory;

    public void performDatabaseOperation() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            // Perform database operations
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            handleHibernateException(e);
        }
    }

    private void handleHibernateException(HibernateException e) {
        // Handle Hibernate exceptions here
        System.err.println("Exception occurred: " + e.getMessage());
        e.printStackTrace();

        // Optionally log the exception or perform other error handling

        // Rethrow the exception if necessary
        throw e;
    }
}
