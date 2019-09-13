package com.toan.nokia.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil
{
//    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory sessionFactory= buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//            return new AnnotationConfiguration().configure().buildSessionFactory();

            Configuration configObj = new Configuration();
            configObj.configure("hibernate.cfg.xml");

            // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
            ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

            // Creating Hibernate SessionFactory Instance
            sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);
            return sessionFactory;

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}