package com.toan.nokia.hibernate.service;

import com.toan.nokia.hibernate.entity.Author;

import java.util.List;

public interface AuthorService {

    Author findById(long id);

    void add(Author author);

    void update(Author author);

    void delete(long id);

    List<Author> listAll();

    boolean checkActive(long id);

    void unActive(long id);

}
