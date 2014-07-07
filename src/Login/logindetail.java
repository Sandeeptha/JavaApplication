/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Sandeeptha
 */
public class logindetail {

    public static String username;
    public static String user_privilage;
    public static String logintime;
    public static String logindate;

    public static void Username(JTextField tuser) {
        try {
            Statement st = main.DB.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT `username` FROM `login`");
            ArrayList<String> items = new ArrayList<String>();
            while (rs.next()) {
                items.add(rs.getString(1));
            }
            main.AutoComplete.setupAutoComplete(tuser, items);
        } catch (SQLException ex) {
            Logger.getLogger(logindetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   // OK

    public static void Login(JTextField tuser, JTextField tpass, JFrame Login1) {
        username = null;
        logindate = null;
        logintime = null;

        int i = 0;
        try {
            Statement st = main.DB.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT username,type,password FROM `login` WHERE username='" + tuser.getText() + "'");
            while (rs.next()) {
                if (tpass.getText().equals(rs.getString(3))) {
                    username = rs.getString(1);
                    user_privilage = rs.getString(2);
                    logintime = main.Date_Time.getTime();
                    logindate = main.Date_Time.getDate();
                    new ujitha.Main().setVisible(true);
                    i = 1;
                }
            }
            if (i == 0) {
                JOptionPane.showMessageDialog(tpass, "Login Error");
                tuser.transferFocus();
                tpass.setText(null);
            } else {
                Login1.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(logindetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   // OK

    public static void Logout(ujitha.Main aThis) {
        try {
            Statement st = main.DB.con().createStatement();
            st.executeUpdate("INSERT INTO `logindetails` VALUES ('" + logintime + "','" + logindate + "','" + main.Date_Time.getTime() + "', '" + main.Date_Time.getDate() + "','" + username + "')");
            //username=null;
            //status=null;
            //logindate=null;
            //logintime=null;
            //userid=null;
            aThis.dispose();
            new Login().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(logindetail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }   // OK

    public static void FindSecurityQuestion(JTextField tuser, JTextField tsecurity) {
        try {
            Statement st = main.DB.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT `sq` FROM `login` where `username`='" + tuser.getText() + "'");
            while (rs.next()) {
                tsecurity.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(logindetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   // OK

    public static void NewPass(JTextField tuser, JTextField tquestion, JTextField tanswer, JTextField tnewpass, JTextField trepass, JLabel jlabel6) {
        try {
            Statement st = main.DB.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT `answer` FROM `login` where `username`='" + tuser.getText() + "'");
            while (rs.next()) {
                if (rs.getString(1).equalsIgnoreCase(tanswer.getText())) {
                    tnewpass.setEnabled(true);
                    trepass.setEnabled(true);
                    jlabel6.setText("Answer is correct");
                } else {
                    tnewpass.setEnabled(false);
                    trepass.setEnabled(false);
                    jlabel6.setText(null);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(logindetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   // OK

    public static void AddNewPass(JTextField tuser, JPasswordField tnewpass, FogetPassword aThis) {
        try {
            Statement st = main.DB.con().createStatement();
            st.executeUpdate("UPDATE `login` SET `password` = '" + tnewpass.getText() + "' WHERE `username` = '" + tuser.getText() + "';");
            aThis.dispose();
            new Login().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(logindetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   // OK

    public static void AddUser(JTextField tuser, JTextField tname, JComboBox cquestion, JTextField tanswer, JComboBox ctype, JPasswordField tnewpass, AddNewUser aThis, ujitha.Main aHome) {
        try {
            Statement st = main.DB.con().createStatement();
            st.executeUpdate("INSERT INTO `login` VALUES ('" + tuser.getText() + "','" + tname.getText() + "','" + cquestion.getSelectedItem().toString() + "','" + tanswer.getText() + "','" + ctype.getSelectedItem().toString() + "','" + tnewpass.getText() + "')");
            JOptionPane.showMessageDialog(aThis, "Successfully");
            aThis.dispose();
            aHome.dispose();
            logindetail.Logout(aHome);
            //new Main.Login().setVisible(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(aThis, "Error");
            Logger.getLogger(logindetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   // OK

    public static void User_Name_Availability(JTextField tuser, JLabel jLabel) {
        try {
            Statement st = main.DB.con().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `login` where `username`='" + tuser.getText() + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "User Name is already Taken", "Error", JOptionPane.ERROR_MESSAGE);
                tuser.setText(null);
                jLabel.setText(null);

            } else {
                jLabel.setText("Avalable");
                jLabel.setForeground(Color.blue);
            }
        } catch (SQLException ex) {
            Logger.getLogger(logindetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   // OK

}
