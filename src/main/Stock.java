/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Ujitha
 */
public class Stock {

    public static double getSprice(String text) {
       double sprice = 0;
        try {
           
             Statement s = main.DB.con().createStatement();
             ResultSet rs = s.executeQuery("SELECT `sprice` FROM `sanasa`.`stock` "
                     + "WHERE `Inventory_id`='"+text+"' AND `batchNo`= '"+getBatchNo(text)+"'");
             if (rs.next()) {
              sprice =  rs.getDouble(1);
             }
            
        } catch (Exception e) {
             e.printStackTrace();
        }
         return sprice ;
    }

    public static int getBatchNo(String text) {
        int bno = -1;
        try {
             Statement s = main.DB.con().createStatement();
             ResultSet rs = s.executeQuery("SELECT MAX(`batchNo`) FROM "
                     + "`sanasa`.`stock` WHERE `Inventory_id`='"+text+"'");
             if (rs.next()) {
              bno =  rs.getInt(1);
             }
        } catch (Exception e) {
           e.printStackTrace();
        }
         return bno ;
    }
//    public static void main(String[] args) {
//    
//        System.out.println(getQty("RBBR0101"));
//    }

    public static int getQty(String metID) {
        int qty = 0;
        try {
             Statement s = main.DB.con().createStatement();
             ResultSet rs = s.executeQuery("SELECT sum(`qty`) FROM "
                     + "`sanasa`.`stock` WHERE `Inventory_id`='"+metID+"'");
             if (rs.next()) {
              qty =  rs.getInt(1);
             }
        } catch (Exception e) {
           e.printStackTrace();
        }
      return qty ;
    }

    public static double BPrice(String text) {
       double bprice = 0;
        try {
           
             Statement s = main.DB.con().createStatement();
             ResultSet rs = s.executeQuery("SELECT `bprice` FROM `sanasa`.`stock` "
                     + "WHERE `Inventory_id`='"+text+"' AND `batchNo`= '"+getBatchNo(text)+"'");
             if (rs.next()) {
              bprice =  rs.getDouble(1);
             }
            
        } catch (Exception e) {
             e.printStackTrace();
        }
         return bprice ;
    }
}
