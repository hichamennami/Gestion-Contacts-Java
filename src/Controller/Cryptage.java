/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;        

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
*
* @author DevDécouverte | +237 6 97 17 39 62
*/
public class Cryptage {
    public static String cryptage(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());

            // Convertir les bytes en format hexadécimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean verifyPassword(String inputPassword, String encryptedPassword) {
        String hashedInputPassword = cryptage(inputPassword);
        return MessageDigest.isEqual(hashedInputPassword.getBytes(), encryptedPassword.getBytes());
    }
    
}
