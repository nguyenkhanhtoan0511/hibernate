package com.toan.nokia.hibernate.service;

import com.toan.nokia.hibernate.dao.BookDAOImpl;
import com.toan.nokia.hibernate.entity.Book;

import java.util.List;

public class BookService {
    private BookDAOImpl bookDAOImpl;

    public BookService(){
        this.bookDAOImpl = new BookDAOImpl();
    }

    public Book findById(long id){
        Book book = null;
        try{
            bookDAOImpl.openCurrentSession();
            book = bookDAOImpl.findById(id);

        }catch (Exception e){
            System.out.println("Error while find id "+ id +'.' + e);
        }finally {
            bookDAOImpl.closeCurrentSession();
        }
        return book;
    }

    public void add(Book book){
        try{
            bookDAOImpl.openCurrentSessionwithTransaction();
            bookDAOImpl.add(book);
        }catch (Exception e){
            System.out.println("Error while adding book " + e);
        }finally{
            bookDAOImpl.closeCurrentSessionwithTransaction();
        }

    }

    public void update(Book book){
        try{
            bookDAOImpl.openCurrentSessionwithTransaction();
            bookDAOImpl.update(book);
        }catch (Exception e){
            System.out.println("error while updating "+ e);
        }finally{
            bookDAOImpl.closeCurrentSessionwithTransaction();
        }
    }

    public void delete(long id){
        try {
            bookDAOImpl.openCurrentSessionwithTransaction();
            if(bookDAOImpl.findById(id)!= null){
                bookDAOImpl.delete(id);
            } else {
                throw new Exception(id + "does not exists");
            }
        } catch (Exception e) {
            System.out.println("Error while deleting book with id " + id + ". " + e);
        } finally {
            bookDAOImpl.closeCurrentSessionwithTransaction();
        }
    }

    public List<Book> listAll(){
        List<Book> books = null;
        try{
            bookDAOImpl.openCurrentSession();
            books = bookDAOImpl.listAll();
            return books;
        }catch (Exception e){
            System.out.println("Error while listAll book "+ e);
        }finally {
            bookDAOImpl.closeCurrentSession();
        }
        return books;
    }

    public void isActive(long id){
        try{
            bookDAOImpl.openCurrentSessionwithTransaction();
            bookDAOImpl.isActive(id);
        }catch (Exception e){
            System.out.println("Error while isActive book id "+ id +"."+ e);
        }finally {
            bookDAOImpl.closeCurrentSessionwithTransaction();
        }
    }

}
