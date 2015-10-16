package net.didorenko.beans;

import net.didorenko.db.Database;

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

    private ArrayList<Book> getBooks(){
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book order by name");
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setGenre(rs.getString("genre"));
                book.setIsbn(rs.getString("isbn"));
                book.setPageCount(rs.getInt("page_count"));
                book.setPublishDate(rs.getDate("publish_date"));
                book.setPublisher(rs.getString("publisher"));
                books.add(book);
            }

        } catch (SQLException ex) {
//            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
//                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }

        return books;
    }

    public ArrayList<Book> getBookList(){
        return (books.isEmpty()) ? getBooks() : books;
    }
}
