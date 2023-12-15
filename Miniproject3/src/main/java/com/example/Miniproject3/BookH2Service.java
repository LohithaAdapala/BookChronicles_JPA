package com.example.Miniproject3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.Miniproject3.BookRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookH2Service implements BookRepository{

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Book> getBooks() {
        List<Book> bookList= db.query("select * from book", new BookRowMapper());
        ArrayList<Book> books = new ArrayList<>(bookList);
        return books;
    }
    @Override
    public Book getBookById(int bookId){
        try {
            Book book = db.queryForObject("select * from book where id=?", new BookRowMapper(), bookId);
            return book;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


    }
    @Override
    public Book addBook(Book book){
        db.update("insert into book(name,imageUrl) values(?,?)", book.getBookName(),book.getImageUrl());
        try {
            Book savedBook = db.queryForObject("select * from book where name=? and imageUrl=?", new BookRowMapper(), book.getBookName(), book.getImageUrl());
            return savedBook;
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no result is found, e.g., return null or throw a custom exception
            return null;
        }

    }
    @Override
    public Book updateBook(int bookId,Book book){
        try{
            if(book.getBookName()!=null){
                db.update("update book set name=? where id=?",book.getBookName(),bookId);
            }
            if(book.getImageUrl()!=null){
                db.update("update book set imageUrl=? where id=?",book.getImageUrl(),bookId);

            }
            return getBookById(bookId);

        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public void deleteBook(int bookId){
        try{
            db.update("delete from book where id=?",bookId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
