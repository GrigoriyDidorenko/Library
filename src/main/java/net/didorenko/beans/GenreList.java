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
public class GenreList {

    private ArrayList<Genre> genres = new ArrayList<>();

    private ArrayList<Genre> getGenres(){
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try{
            conn = Database.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM genre ORDER  BY name");
            while (rs.next()){
                Genre genre = new Genre();
                genre.setId(rs.getLong("id"));
                genre.setName(rs.getString("name"));
                genres.add(genre);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        finally {
                try {
                    if(stmt!=null)  stmt.close();
                    if (rs!=null) rs.close();
                    if (conn!=null) conn.close();
                } catch (SQLException ex) {
//                    Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
        }
        return  genres;
    }

    public  ArrayList<Genre> getGenresList(){
        return (genres.isEmpty()) ? getGenres() : genres;
    }

}
