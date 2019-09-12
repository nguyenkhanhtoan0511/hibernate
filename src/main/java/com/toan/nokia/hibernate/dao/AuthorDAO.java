package com.toan.nokia.hibernate.dao;

import com.toan.nokia.hibernate.entity.Author;

import java.util.List;

public interface AuthorDAO {

    Author findById(long id) throws Throwable;

    void add(Author author);

    void update(Author author);

    void delete(long id);

    List<Author> listAll();

    void unActive(long id);

}
