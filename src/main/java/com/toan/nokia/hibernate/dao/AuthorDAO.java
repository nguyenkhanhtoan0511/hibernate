package com.toan.nokia.hibernate.dao;

import com.toan.nokia.hibernate.entity.Author;

import java.util.List;

public interface AuthorDAO {

    Author findById(long id);

    void add(Author author);

    void update(Author author);

    void delete(long id);

    List<Author> listAll();

    boolean checkActive(long id);

    void unActive(long id);

}
