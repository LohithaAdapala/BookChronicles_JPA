package com.example.Miniproject3;

import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int bookId;
    @Column(name="name")
    private String name;
    @Column(name="imageurl")
    private String imageUrl;
    public Book(int bookId,String name,String imageUrl){
        this.bookId=bookId;
        this.imageUrl=imageUrl;
        this.name=name;
    }
    public Book(){}
    public int getBookId(){
        return bookId;
    }
    public void setBookId(int bookId){
        this.bookId=bookId;
    }
    public String getBookName(){
        return name;
    }
    public void setBookName(String name){

        this.name=name;
    }
    public String getImageUrl(){
        return imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl=imageUrl;
    }
}
