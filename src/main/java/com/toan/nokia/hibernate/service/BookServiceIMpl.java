package com.toan.nokia.hibernate.service;

import com.toan.nokia.hibernate.dao.AuthorDAOImpl;
import com.toan.nokia.hibernate.dao.BookDAOImpl;
import com.toan.nokia.hibernate.entity.Book;

import java.util.LinkedList;
import java.util.List;

public class BookServiceIMpl implements BookService{
    private BookDAOImpl bookDAOImpl;
    private AuthorDAOImpl authorDAOIpml;

    public BookServiceIMpl(){
        this.bookDAOImpl = new BookDAOImpl();
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public List<Book> listAll(){
        List<Book> books = new LinkedList<>();
        try{
            bookDAOImpl.openCurrentSession();
            books = bookDAOImpl.listAll();
        }catch (Exception e){
            System.out.println("Error while listAll book "+ e);
        }finally {
            bookDAOImpl.closeCurrentSession();
        }
        return books;
    }

    @Override
    public boolean checkActive(long id){
        boolean check = false;
        try{
            bookDAOImpl.openCurrentSessionwithTransaction();
            check = bookDAOImpl.checkActive(id);
        }catch (Exception e){
            System.out.println("Error while isActive book id "+ id +"."+ e);
        }finally {
            bookDAOImpl.closeCurrentSessionwithTransaction();
        }
        return check;
    }

    @Override
    public void unActive(long id){
        try{
            bookDAOImpl.openCurrentSessionwithTransaction();
            if(bookDAOImpl.findById(id) != null){
                bookDAOImpl.unActive(id);
            }else{
                throw new Exception("id: " + id + " does not exists");
            }
        }catch (Exception e){
            System.out.println("Error while unActive id: "+ id + "." + e);
        }finally {
            bookDAOImpl.closeCurrentSessionwithTransaction();
        }
    }

    @Override
    public List<Book> listAllBookByAuthor(long authorId) {
        List<Book> books = new LinkedList<>();
        try{
            bookDAOImpl.openCurrentSession();
            books = bookDAOImpl.listAllBookByAuthor(authorId);
        }catch (Exception e){
            System.out.println("Error while list Book by Author " + e);
        }finally {
            bookDAOImpl.closeCurrentSession();
        }
        return books;
    }

    @Override
    public void addBookwithAuthor(long authorId, Book book) {
        try{
            bookDAOImpl.openCurrentSessionwithTransaction();
            if(authorDAOIpml.findById(authorId)!=null){
                bookDAOImpl.addBookwithAuthor(authorId, book);
            }else{
                throw new Exception("Author ID: " + authorId + " does not exists");
            }
        }catch (Exception e){
            System.out.println("Error while adding book " + e);
        }finally{
            bookDAOImpl.closeCurrentSessionwithTransaction();
        }
    }

}
