package com.example.Miniproject3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Miniproject3.BookService;
import com.example.Miniproject3.Book;

import java.util.ArrayList;

@RestController
public class BookController {
    @Autowired
    private BookJpaService bookJpaService;

    @GetMapping("/books")
    public ArrayList<Book> getAllBooks(){
        return bookJpaService.getBooks();

    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId){

        return bookJpaService.getBookById(bookId);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){

        return bookJpaService.addBook(book);
    }

    @PutMapping("books/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book){
        return bookJpaService.updateBook(bookId,book);
    }

    @DeleteMapping("books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){

        bookJpaService.deleteBook(bookId);
    }






}
