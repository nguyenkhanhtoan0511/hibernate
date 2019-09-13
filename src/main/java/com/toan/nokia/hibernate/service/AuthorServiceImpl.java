package com.toan.nokia.hibernate.service;

import com.toan.nokia.hibernate.dao.AuthorDAOImpl;
import com.toan.nokia.hibernate.entity.Author;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class AuthorServiceImpl {

    private AuthorDAOImpl authorDAOImpl;

    public AuthorServiceImpl(){
        this.authorDAOImpl = new AuthorDAOImpl();
    }

    public Author findById(long id){
        Author author = new Author();
        try{
            authorDAOImpl.openCurrentSession();
            author = authorDAOImpl.findById(id);
        }catch (Exception e){
            System.out.println("Error while find id = " + id + "." + e);
        }finally {
            authorDAOImpl.closeCurrentSession();
        }
        return author;
    }

    public void add(Author author){
        try{
            authorDAOImpl.openCurrentSessionwithTransaction();
            authorDAOImpl.add(author);
        }catch (Exception e ){
            System.out.println("Error while adding author " + e);
        }finally {
            authorDAOImpl.closeCurrentSessionwithTransaction();
        }
    }

    public void update(Author author){
        author.setDob(new Date());
        authorDAOImpl.openCurrentSessionwithTransaction();
        authorDAOImpl.update(author);
        authorDAOImpl.closeCurrentSessionwithTransaction();
    }

    public void delete(long id){
        try{
            authorDAOImpl.openCurrentSessionwithTransaction();
            if(authorDAOImpl.findById(id)!= null){

                authorDAOImpl.delete(id);
            }else {
                throw new Exception(id + "does not exists");
            }
        }catch (Exception e){
            System.out.println("Error while deleting id: "+ id +"." + e);
        }finally {

            authorDAOImpl.closeCurrentSessionwithTransaction();
        }

    }

    public List<Author> listAll(){
        List<Author> authors = new LinkedList<>();
        try{
            authorDAOImpl.openCurrentSession();
            authors = authorDAOImpl.listAll();
        }catch(Exception e){
            System.out.println("Error while listing Author. " + e);
        }finally{
            authorDAOImpl.closeCurrentSession();
        }

        return authors;
    }

    public void unActive(long id){
        try{
            authorDAOImpl.openCurrentSessionwithTransaction();
            if(authorDAOImpl.findById(id)!= null){
                authorDAOImpl.unActive(id);
            }else {
                throw new Exception(id + " does not exists");
            }
        }catch (Exception e){
            System.out.println("Error while unActive "+  id + "." + e);
        }finally {
            authorDAOImpl.closeCurrentSessionwithTransaction();
        }
    }

    public boolean checkActive(long id){
        boolean check = false;
        try {
            authorDAOImpl.openCurrentSession();
            if(authorDAOImpl.findById(id) != null){
                check = authorDAOImpl.checkActive(id);
            }else{
                throw new Exception(id + " does not exists");
            }

        }catch (Exception e){
            System.out.println("Error while check active id: "+ id + "." + e);
        }finally {
            authorDAOImpl.closeCurrentSession();
        }
        return check;
    }

}
