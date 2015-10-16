package net.didorenko;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestConnection {

    public void check() {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("jdbc/Library");
            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from book");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(net.didorenko.TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(net.didorenko.TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
