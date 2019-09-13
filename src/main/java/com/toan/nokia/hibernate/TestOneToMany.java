package com.toan.nokia.hibernate;

import com.toan.nokia.hibernate.entity.Author;
import com.toan.nokia.hibernate.entity.Book;
import com.toan.nokia.hibernate.service.BookServiceIMpl;
import com.toan.nokia.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestOneToMany {

    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    public static void main(String[] args) {
        try{
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            Date cDate = new Date();

            Book book1 = new Book("test1", "onetomany", cDate, (float) 200);
            Book book2 = new Book("english", "language", cDate, (float) 100);

            Author author1 = new Author("pham", "trung", cDate, "hiep binh chanh", "khong nao");

//        Set<Book> books = new HashSet<Book>();
//        books.add(book1);
//        books.add(book2);

//        author1.setBooks(books);

            sessionObj.save(author1);
            sessionObj.save(book1);
            sessionObj.save(book2);

            sessionObj.getTransaction().commit();

        }catch(Exception e){
            System.out.println(e);
        }finally{
            if(sessionObj != null) {
                sessionObj.close();
            }
        }

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Date cDate = new Date();
//
//        Book book1 = new Book("test1", "onetomany", cDate, (float) 200);
//        Book book2 = new Book("english", "language", cDate, (float) 100);
//
//        Author author1 = new Author("pham", "trung", cDate, "hiep binh chanh", "khong nao");
//
////        Set<Book> books = new HashSet<Book>();
////        books.add(book1);
////        books.add(book2);
//
////        author1.setBooks(books);
//
//        session.save(author1);
//        session.save(book1);
//        session.save(book2);
//
//        session.getTransaction().commit();
//
//        HibernateUtil.shutdown();


//        BookServiceIMpl bookServiceIMpl = new BookServiceIMpl();
//
//        long authorId = 1;
//
//        List<Book> books = bookServiceIMpl.listAllBookByAuthor(authorId);
//
//        for(Book b:books){
//            System.out.println("Info book: " + b);
//        }


    }

}
