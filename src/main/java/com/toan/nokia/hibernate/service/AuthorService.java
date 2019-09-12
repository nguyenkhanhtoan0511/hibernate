package com.toan.nokia.hibernate.service;

import com.toan.nokia.hibernate.dao.AuthorDAO;
import com.toan.nokia.hibernate.dao.AuthorDAOImpl;
import com.toan.nokia.hibernate.entity.Author;

import java.util.List;

public class AuthorService {
    private AuthorDAOImpl authorDAOImpl;

    public AuthorService(){
        this.authorDAOImpl = new AuthorDAOImpl();
    }

    public Author findById(long id){
        authorDAOImpl.openCurrentSession();
        Author author = authorDAOImpl.findById(id);
        authorDAOImpl.closeCurrentSession();
        return author;
    }

    public void add(Author author){
        authorDAOImpl.openCurrentSessionwithTransaction();
        authorDAOImpl.add(author);
        authorDAOImpl.closeCurrentSessionwithTransaction();
    }

    public void update(Author author){
        authorDAOImpl.openCurrentSessionwithTransaction();
        authorDAOImpl.update(author);
        authorDAOImpl.closeCurrentSessionwithTransaction();
    }

    public void delete(long id){
        authorDAOImpl.openCurrentSessionwithTransaction();
        authorDAOImpl.delete(id);
        authorDAOImpl.closeCurrentSessionwithTransaction();
    }

    public List<Author> listAll(){
        authorDAOImpl.openCurrentSession();
        List<Author> authors = authorDAOImpl.listAll();
        authorDAOImpl.closeCurrentSession();
        return authors;
    }

    public void unActive(long id){
        authorDAOImpl.openCurrentSessionwithTransaction();
        authorDAOImpl.unActive(id);
        authorDAOImpl.closeCurrentSessionwithTransaction();
    }



}
