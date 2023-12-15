package com.example.Miniproject3;

import org.springframework.jdbc.core.RowMapper;
import com.example.Miniproject3.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(rs.getInt("id"), rs.getString("name"),rs.getString("imageUrl"));



    }
}
