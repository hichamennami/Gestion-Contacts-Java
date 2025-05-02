/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
*
* @author DevDécouverte | +237 6 97 17 39 62
*/
public class Connexion {
    protected Connection cnx;
    protected PreparedStatement pst;
    protected Statement st;
    protected ResultSet rs;
    
    protected String DBname = "contact";
    protected String UserName = "root";
    protected String password = "";
    protected String adrServer = "localhost";
    protected String piloteJDBC = "mysql";
    protected String driverName2 = "com.mysql.cj.jdbc.Driver";
    
    public Connexion(){
        try {
            //chargement du drive JDBC
            Class.forName(driverName2);
            System.out.println("drive ok");
            //connexion a la base de données
            this.cnx = DriverManager.getConnection("jdbc:"+this.piloteJDBC+"://"+this.adrServer+"/"+this.DBname, this.UserName, this.password);
            System.out.println("connexion reussi");
            //creation de l'objet Statement
            this.st = this.cnx.createStatement();
            System.out.println("tout est ok");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite\n"+e.getMessage());
        }
    }
    
    public ResultSet recover(String sql){
        try {
            this.rs = st.executeQuery(sql);
            System.out.println("requete executée avec succes");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite\n"+e.getMessage());
        }
        return this.rs;
    }
    public ResultSet recover(String sql, String[] values){
        try {
            this.pst = this.cnx.prepareStatement(sql);
            for (int i = 1; i <= values.length; i++) {
                pst.setString(i, values[i-1]);
            }
            this.rs = pst.executeQuery();
            System.out.println("execution réusi");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite\n"+e.getMessage());
        }
        return this.rs;
    }
    public void editor(String sql, String[] values){
        try {
            this.pst = this.cnx.prepareStatement(sql);
            
            for (int i = 1; i <= values.length; i++) {
                pst.setString(i, values[i-1]);
            }
            this.pst.executeUpdate();
            System.out.println("Enregistrement reussi!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite\n"+e.getMessage());
        }
    }
    public void editor(String sql){
        try {
            this.pst.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite\n"+e.getMessage());
        }
    }
    
    public static void dedicace(){
        System.out.println("SAINTETE A L'ETERNEL");
    }
}
