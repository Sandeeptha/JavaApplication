/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login_History;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sandeeptha
 */
public class History_Class {

    public static void Search_All(JTable jTable1) {
        try {
            Statement st = main.DB.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `logindetails` ORDER BY indate DESC");
            DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v=new Vector();
                v.add(rs.getString(5));
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                dtm.addRow(v);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void Search_All_Date(JTable jTable1, String dto1, String dfrom1) {
        try {
            Statement st = main.DB.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM logindetails WHERE indate BETWEEN '"+dfrom1+"' AND '"+dto1+"' ORDER BY indate DESC");
            DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v=new Vector();
                v.add(rs.getString(5));
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                dtm.addRow(v);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    static void Search_User(JTextField tuser) {
        try {
            Statement st = main.DB.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT `username` FROM `login`");
            ArrayList<String> items = new ArrayList<String>();
            while (rs.next()) {
                items.add(rs.getString(1));
            }
            main.AutoComplete.setupAutoComplete(tuser, items);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }   //

    static void Find_Name(JTextField tuser, JTextField tnam) {
        try {
            Statement st = main.DB.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT `name` FROM `login` WHERE `username`='" + tuser.getText() + "'");
            if (rs.next()) {
                tnam.setText(rs.getString(1));
            }
            else{
                tnam.setText(null);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }   //

    static void search_All_User(JTable jTable1, JTextField tuser) {
        try {
            Statement st = main.DB.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM logindetails WHERE username='" + tuser.getText() + "' ORDER BY indate DESC");
            DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v=new Vector();
                v.add(rs.getString(5));
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                dtm.addRow(v);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    static void search_user_Date(JTable jTable1, JTextField tuser, String dfrom1, String dto1) {
        try {
            Statement st = main.DB.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM logindetails WHERE username='" + tuser.getText() + "' AND indate BETWEEN '"+dfrom1+"' AND '"+dto1+"' ORDER BY indate DESC");
            DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v=new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                dtm.addRow(v);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
