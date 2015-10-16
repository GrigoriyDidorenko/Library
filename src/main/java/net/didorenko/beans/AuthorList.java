package net.didorenko.beans;

import net.didorenko.db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * package: net.didorenko.beans
 * project: Library
 * class:
 *
 * @author: Grigoriy Didorenko
 * @date: 15.10.2015
 */

public class AuthorList {

    private ArrayList<Author> authors = new ArrayList<>();

    private ArrayList<Author> getAuthors() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = Database.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from author order by fio");
            while (rs.next()) {
                System.out.println(rs);
                Author author = new Author();
                author.setName(rs.getString("fio"));
                authors.add(author);
            }

        } catch (SQLException ex) {
//            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                //            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }

        return authors;
    }

    public ArrayList<Author> getAuthorList() {
        return (authors.isEmpty()) ? getAuthors() : authors;
    }
}
