/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mainn;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author CBC
 */
public class DBConnection {

    static Connection c = null;
    static String databasepass="1234";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (c==null) {
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanasa", "root", databasepass);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database Invalid");
            e.printStackTrace();
        }
        return c;

    }
}
