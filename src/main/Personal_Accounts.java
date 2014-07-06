/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import ujitha.Voucher;


/**
 *
 * @author Ujitha
 */
public class Personal_Accounts {
     public static int getSequence(){
         int seq = 0;
         try {
             Statement s = main.DB.con().createStatement();
             ResultSet rs = s.executeQuery("SELECT MAX(`sequence`)  FROM `"
                     + "sanasa`.`personal_account`");
             if (rs.next()) {
              seq =  rs.getInt(1);
             }
              
         } catch (Exception e) {             
              e.printStackTrace();
         }
    return seq;
}
     
      public static double getBalance(String contactid){
         double seq = 0.0;
         try {
             Statement s = main.DB.con().createStatement();
             ResultSet rs = s.executeQuery("SELECT balance FROM `sanasa`.`personal_account`"
                     + " WHERE `sequence` = (SELECT MAX(`sequence`) FROM "
                     + "`sanasa`.`personal_account` where contact_nic = '"+contactid+"')");
             if (rs.next()) {
              seq =  rs.getDouble(1);
             }
              
         } catch (Exception e) {             
              e.printStackTrace();
         }
    return seq;
    
}
     
}
