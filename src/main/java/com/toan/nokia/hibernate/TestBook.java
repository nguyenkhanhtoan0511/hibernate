package com.toan.nokia.hibernate;

import com.toan.nokia.hibernate.entity.Book;
import com.toan.nokia.hibernate.service.BookService;

import java.util.Date;
import java.util.List;

public class TestBook {

    public static void main(String[] args) {
        BookService bookService = new BookService();

//        Date cDate = new Date();
//
//        Book book1 = new Book("book1", "no thing", cDate, (float) 29.2);
//        Book book2 = new Book("book2", "nguyen khanh toan", cDate, (float) 29.2);
//        Book book3 = new Book("book3", "book service", cDate,  123);
//        Book book4 = new Book("book4", "java", cDate, (float)30);
//
//        bookService.add(book1);
//        bookService.add(book2);
//        bookService.add(book3);
//        bookService.add(book4);
//
        long id = 3;
        Book bookID1 = bookService.findById(id);
        if (null == bookID1) {
            System.out.println("Book has id = " + id + " does not exists");
        } else  {
            System.out.println("Book info: " + bookID1);
        }

        bookService.delete(3);

        Book bookId4 = bookService.findById(3);
        if (null == bookID1) {
            System.out.println("Book has id = " + id + " does not exists");
        } else  {
            System.out.println("Book info: " + bookID1);
        }        bookId4.setDescription("update");
        bookId4.setPrice(98);
        bookId4.setTitle("wall");
        bookService.update(bookId4);

        List<Book> bookList = bookService.listAll();
        for(Book book:bookList){
            System.out.println(book.toString());
        }

    }
}
