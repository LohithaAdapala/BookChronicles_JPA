package com.example.Miniproject3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookJpaService implements BookRepository{
    @Autowired
    private BookJpaRepository bookJpaRepository;
    @Override
    public ArrayList<Book> getBooks(){
        List<Book> bookList = bookJpaRepository.findAll();
        ArrayList<Book> bookss = new ArrayList<>(bookList);
        return bookss;

    }
    public Book getBookById(int id){
        try{
            Book book = bookJpaRepository.findById(id).get();
            return book;

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
    public Book addBook(Book book){
        bookJpaRepository.save(book);

        return book;

    }
    public Book updateBook(int bookId,Book book){
        try{
            Book newBook = bookJpaRepository.findById(bookId).get();
            if(book.getBookName()!=null){
                newBook.setBookName(book.getBookName());
            }
            if(book.getImageUrl()!=null){
                newBook.setImageUrl(book.getImageUrl());
            }
            return newBook;

        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
    public void deleteBook(int bookId) {

        bookJpaRepository.deleteById(bookId);

    }


}
