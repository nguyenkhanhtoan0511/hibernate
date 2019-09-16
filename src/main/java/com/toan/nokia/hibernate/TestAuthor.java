package com.toan.nokia.hibernate;

import com.toan.nokia.hibernate.entity.Author;
import com.toan.nokia.hibernate.service.AuthorServiceImpl;

import java.util.Date;
import java.util.List;

public class TestAuthor {

    public static void main(String[] args) {
        AuthorServiceImpl authorService = new AuthorServiceImpl();

        Date date = new Date();

        Author author1 = new Author("tma", "toan nguyen", date, "addresss1", "decription1");
//        Author author2 = new Author("", "name1", date, "addresss1", "decription2");
//        Author author3 = new Author("nguyen ", "name2", date, "addresss1", "decription3");
//        Author author4 = new Author("nguyen ", "name3", date, "addresss1", "decription4");
//
        authorService.add(author1);
//        authorService.add(author2);
//        authorService.add(author3);
//        authorService.add(author4);

//        long id = 1;
//
//        Author authorID26 = authorService.findById(id);
//        if (null == authorID26) {
//            System.out.println("Book has id = " + id + " does not exists");
//        } else  {
//            System.out.println("Book info: " + authorID26);
//        }
//
//        id = 3;
//
//        Author authorID25 = authorService.findById(id);
//        if(authorID25 != null){
//            authorID25.setAddress("hcm");
//            authorID25.setFirstName("nguyen");
//            authorID25.setLastName("loc");
//            authorService.update(authorID25);
//        }else{
//            System.out.println("id: "+ id + "does not exists");
//        }
//
//
//        authorService.delete(4);
//
//
//        List<Author> authors = authorService.listAll();
//        for(Author author:authors){
//            System.out.println(author.toString());
//        }
//
//
//        id = 2;
//        authorService.unActive(id);
//
//        if(authorService.checkActive(id)){
//            System.out.println("Author info: " + authorService.findById(id));
//        }else{
//            System.out.println("author: " +  id + " is not active");
//        }


    }

}
