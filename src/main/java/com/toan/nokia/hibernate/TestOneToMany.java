package com.toan.nokia.hibernate;

import com.toan.nokia.hibernate.entity.Author;
import com.toan.nokia.hibernate.entity.Book;
import com.toan.nokia.hibernate.service.BookServiceIMpl;
import com.toan.nokia.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TestOneToMany {

    public static void main(String[] args) {
        BookServiceIMpl bookServiceIMpl = new BookServiceIMpl();

        long idAuthor = 10;

        Date cDate = new Date();

        Book book1 = new Book("37293 nowaday", "akjsdh", cDate, (float) 123);
//        Book book2 = new Book("telephone", "message", cDate, (float) 22);

        bookServiceIMpl.addBookwithAuthor(idAuthor, book1);
//        bookServiceIMpl.addBookwithAuthor(idAuthor, book2);

        List<Book> books = bookServiceIMpl.listAllBookByAuthor(idAuthor);
        for(Book b:books){
            System.out.println(b.toString());
        }
    }

}
