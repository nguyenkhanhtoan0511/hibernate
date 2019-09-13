package com.toan.nokia.hibernate;

import com.toan.nokia.hibernate.entity.Book;
import com.toan.nokia.hibernate.service.BookServiceIMpl;

import java.util.Date;
import java.util.List;

public class TestBook {

    public static void main(String[] args) {
        BookServiceIMpl bookServiceIMpl = new BookServiceIMpl();

        Date cDate = new Date();

        Book book5 = new Book("book3", "house", cDate, (float) 10.2);
        Book book6 = new Book("book4", "hibernate", cDate, (float) 60.6);

        bookServiceIMpl.add(book5);
        bookServiceIMpl.add(book6);
////
        long findId = 5;
        Book bookID1 = bookServiceIMpl.findById(findId);
        if (null == bookID1) {
            System.out.println("Book has id = " + findId + " does not exists");
        } else  {
            System.out.println("Book info: " + bookID1);
        }

        bookServiceIMpl.delete(3);

        Book bookId4 = bookServiceIMpl.findById(4);
        bookId4.setPrice(98);
        bookId4.setTitle("wall");
        bookServiceIMpl.update(bookId4);

        bookServiceIMpl.unActive(7);

        if(bookServiceIMpl.checkActive(7)){
            System.out.println("Author info: " + bookServiceIMpl.findById(7));
        }else{
            System.out.println("author id 7 is not active");
        }

        List<Book> bookList = bookServiceIMpl.listAll();
        for(Book book:bookList){
            System.out.println(book.toString());
        }


    }
}
