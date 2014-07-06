/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mainn;

import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JTextField;

/**
 *
 * @author Sandeeptha
 */
public class GeneralClass {

    public static void IsDesimalNO(JTextField textfield, KeyEvent evt) {
        if (Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '.') {
            if (!Character.isDigit(evt.getKeyChar()) && textfield.getText().indexOf(".") != -1) {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }

    public static void IsMinusAndPlusInt(JTextField textField, KeyEvent evt) {
        if (textField.getText().toCharArray().length < 1 && evt.getKeyChar() == '-') {
        } else if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public static void IsMinusAndPlusDecimal(JTextField textField, KeyEvent evt) {
        if (textField.getText().toCharArray().length < 1 && evt.getKeyChar() == '-') {
        } else if (Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '.') {
            if (!Character.isDigit(evt.getKeyChar()) && textField.getText().indexOf(".") != -1) {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }
    
    public static float Two_decimalPoint (float num) {
        DecimalFormat dc=new DecimalFormat(".##");
        float f=Float.parseFloat(dc.format(num));
        return f;
    } 
    
    public static float four_decimalPoint (float num) {
        DecimalFormat dc=new DecimalFormat(".####");
        float f=Float.parseFloat(dc.format(num));
        return f;
    }

//    public static void setIconToFrame(Main aThis) {
//        try {
//            
//        } catch (Exception e) {
//        }
//    }
}
