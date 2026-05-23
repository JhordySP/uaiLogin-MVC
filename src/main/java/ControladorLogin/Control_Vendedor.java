/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorLogin;

import ModeloVendedor.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ControladorLogin.ConexionMySql;

/**
 *
 * @author ASUS
 */
public class Control_Vendedor {

    public Vendedor validarLogin(String nombre, String password) {
        String sql = "SELECT idVendedor, nombreVendedor FROM table_vendedor WHERE usuarioVendedor = ? AND password = ?";
    ConexionMySql mysql = new ConexionMySql();
        try (Connection conn = mysql.conectar();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.setString(1, nombre);
        pst.setString(2, password);
        
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                Vendedor v = new Vendedor();
                v.setId(rs.getInt("idVendedor"));
                v.setNombre(rs.getString("nombreVendedor"));
                return v;
            }
        }
    } catch (SQLException e) {
        System.out.println("Error en login: " + e.getMessage());
    }
    return null;
}
}