package com.toan.nokia.hibernate.dao;

import com.toan.nokia.hibernate.entity.Book;

import java.util.List;

public interface BookDAO {

    Book findById(long id);

    void add(Book book);

    void update(Book book);

    void delete(long id);

    List<Book> listAll();

    boolean checkActive(long id);

    void unActive(long id);


    List<Book> listAllBookByAuthor(long authorId);

    void addBookwithAuthor(long authorId, Book book);
}
