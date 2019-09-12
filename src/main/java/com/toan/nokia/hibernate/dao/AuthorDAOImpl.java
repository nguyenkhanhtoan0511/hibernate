package com.toan.nokia.hibernate.dao;

import com.toan.nokia.hibernate.entity.Author;
import com.toan.nokia.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {

    private Session currentSession;

    public AuthorDAOImpl(){
    }

    public Session getCurrentSession(){
        return currentSession;
    }

    public Session openCurrentSession(){
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public void closeCurrentSession(){
        currentSession.close();
    }

    public Session openCurrentSessionwithTransaction(){
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentSession.getTransaction();
        return currentSession;
    }

    public void closeCurrentSessionwithTransaction(){
        currentSession.close();
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Author findById(long id) {
        try {
            Author author = (Author) getCurrentSession().get(Author.class, id);
            return author;
        }catch (Throwable e){
            throw e;

        }
    }

    public void add(Author author) {
        try {
            getCurrentSession().save(author);
        }catch (Throwable e){
            throw e;
        }
    }

    public void update(Author author) {
        try {
            getCurrentSession().update(author);
        }catch (Throwable e){
            throw e;
        }
    }

    public void delete(long id) {
        try {
            Author author = (Author) getCurrentSession().load(Author.class, id);
            getCurrentSession().delete(author);
        }catch (Throwable e){
            throw e;
        }
    }

    public List<Author> listAll() {
        try {
            Query query = getCurrentSession().createQuery("from Author");
            List<Author> authors = query.list();
            return authors;
        }catch (Throwable e){
            throw e;
        }
    }

    public void unActive(long id) {
        try {
            Query query = getCurrentSession().createQuery("update Author a set a.is_active='false' where a.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
        }catch (Throwable e){
            throw e;
        }
    }
}
