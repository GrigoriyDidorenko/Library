package net.didorenko.beans;

import net.didorenko.db.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * package: net.didorenko.beans
 * project: Library
 * class:
 *
 * @author: Grigoriy Didorenko
 * @date: 15.10.2015
 */
public class BookList {

    ArrayList<Book> books = new ArrayList<>();

    private ArrayList<Book> getBooks(String str) {

        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            System.out.println(str);
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("name"));
                book.setGenre(rs.getString("genre_id"));
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author_id"));
                book.setPageCount(rs.getInt("page_count"));
                book.setPublishDate(rs.getInt("publish_year"));
                book.setPublisher(rs.getString("publisher_id"));
                book.setImage(rs.getBytes("image"));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(books);
        return books;
    }

    public ArrayList<Book> getBookList(){
        return (books.isEmpty()) ? getBooks("Select * from book order by name") : books;
    }

    public ArrayList<Book> getBooksById(long id){
        return getBooks("SELECT * FROM book" +
                " INNER JOIN `genre` on book.genre_id = `genre`.`id`" +
                " WHERE genre_id=" +id+
                " ORDER BY book.`name`" +
                " limit 5");
    }
}
