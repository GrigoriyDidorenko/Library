package net.didorenko.beans;

import net.didorenko.db.Database;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * package: net.didorenko
 * project: Library_JSF
 * class:
 *
 * @author: Grigoriy Didorenko
 * @date: 23.10.2015
 */

@ApplicationScoped
@ManagedBean(name = "genres")
public class Genres implements Serializable {

    private ArrayList<Genre> genres = new ArrayList<Genre>();

    private ArrayList<Genre> getGenres() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from genre order by name");
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setName(rs.getString("name"));
                genre.setId(rs.getLong("id"));
                genres.add(genre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return genres;
    }

    public ArrayList<Genre> getGenreList() {
        return (genres.isEmpty()) ? getGenres() : genres;
    }
}
