package com.toan.nokia.hibernate;

import com.toan.nokia.hibernate.entity.Book;
import com.toan.nokia.hibernate.service.BookServiceIMpl;

import java.util.Date;
import java.util.List;

public class TestBook {

    public static void main(String[] args) {
        BookServiceIMpl bookServiceIMpl = new BookServiceIMpl();

        Date cDate = new Date();
//
        Book book1 = new Book("ahihi", "success", cDate, (float) 1);
//        Book book2 = new Book("book4", "hibernate", cDate, (float) 60.6);
//
//        Book book3 = new Book("book3", "house", cDate, (float) 10.2);
//        Book book4 = new Book("book4", "hibernate", cDate, (float) 60.6);
//
        bookServiceIMpl.add(book1);
//        bookServiceIMpl.add(book2);
//        bookServiceIMpl.add(book3);
//        bookServiceIMpl.add(book4);
//////
//        long findId = 5;
//        Book bookID1 = bookServiceIMpl.findById(findId);
//        if (null == bookID1) {
//            System.out.println("Book has id = " + findId + " does not exists");
//        } else  {
//            System.out.println("Book info: " + bookID1);
//        }

//        bookServiceIMpl.delete(3);

//        Book bookId4 = bookServiceIMpl.findById(4);
//        bookId4.setPrice(98);
//        bookId4.setTitle("wall");
//        bookServiceIMpl.update(bookId4);

//        long idUnactive = 1;
//        bookServiceIMpl.unActive(idUnactive);
//
//        if(bookServiceIMpl.checkActive(idUnactive)){
//            System.out.println("Author info: " + bookServiceIMpl.findById(idUnactive));
//        }else{
//            System.out.println("author id 1 is not active");
//        }
//
//        List<Book> bookList = bookServiceIMpl.listAll();
//        for(Book book:bookList){
//            System.out.println(book.toString());
//        }


    }
}
