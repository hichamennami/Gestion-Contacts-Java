package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import Model.*;
/**
*
* @author DevDécouverte | +237 6 97 17 39 62
*/
public class Index {
    public static int session_id = 0;
    public static int operation = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connect cn = new Connect();
        cn.setVisible(true);
        cn.setLocationRelativeTo(null);
    }
    
}
