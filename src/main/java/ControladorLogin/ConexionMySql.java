/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class ConexionMySql {
    String driver = "com.mysql.cj.jdbc.Driver";
    String user = "root";
    String password = "1234";
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    
    Connection con;
    
    public Connection conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a bd_ventas"); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        return con;
    }
}
