package net.didorenko.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * package: net.didorenko.db
 * project: Library_JSF
 * class:
 *
 * @author: Grigoriy Didorenko
 * @date: 23.10.2015
 */
public class Database {
    private static Connection conn;
    private static InitialContext ic;
    private static DataSource ds;

    public static Connection getConnection() {
        try {
            ic = new InitialContext();
            ds = (DataSource) ic.lookup("jdbc/library");
            conn = ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }
}
