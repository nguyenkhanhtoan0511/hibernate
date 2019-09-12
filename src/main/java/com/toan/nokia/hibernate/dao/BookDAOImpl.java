package com.toan.nokia.hibernate.dao;

import com.toan.nokia.hibernate.entity.Book;
import com.toan.nokia.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    private Session currentSession;

    public BookDAOImpl() {
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Session openCurrentSession(){
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }


    public Session openCurrentSessionwithTransaction(){
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession(){
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction(){
        currentSession.getTransaction().commit();
        currentSession.close();
    }

    @Override
    public Book findById(long id) {
        try {
            Book book = (Book) getCurrentSession().get(Book.class, id);
            return book;
        }catch (Throwable e){
            throw e;
        }
    }

    @Override
    public void add(Book book) {
        try {
           getCurrentSession().save(book);
        }catch (Throwable e){
            throw e;
        }
    }

    @Override
    public void update(Book book) {
        try {
            getCurrentSession().update(book);
        }catch (Throwable e){
            throw e;
        }
    }

    @Override
    public void delete(long id) {
        try {
             Book book = (Book) getCurrentSession().load(Book.class, id);
            // get o ngoai service trc, check co roi moi delete, ham delete o trong DAO chi co 1 chuc nang la delete thoi, ko co if else gi o day het
            getCurrentSession().delete(book);
        }catch (Throwable e){
            throw e;
        }
    }

    @Override
    public List<Book> listAll() {
        try {
            Query query = getCurrentSession().createQuery("from Book");
            List<Book> books = query.list();
            return books;
        }catch (Throwable e){
            throw e;
        }
    }

    @Override
    public void isActive(long id) {
        try {
            Query query = getCurrentSession().createQuery("update Book set Book.isActive where id :=id");
            query.setParameter("id", id);
            query.executeUpdate();
        }catch (Throwable e){
            throw e;
        }
    }
}
