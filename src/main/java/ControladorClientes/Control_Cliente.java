/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorClientes;
import ModeloClientes.Cliente;
import ControladorLogin.ConexionMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class Control_Cliente {
    
    public List<Cliente> obtenerListaClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT idcliente, Nombre_Cliente, Apellido_Cliente FROM table_cliente"; 
    
        ConexionMySql conexion = new ConexionMySql();
        
        try (Connection conn = conexion.conectar(); 
             PreparedStatement pst = conn.prepareStatement(sql); 
             ResultSet rs = pst.executeQuery()) { 
            
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("idcliente")); 
                c.setNombre(rs.getString("Nombre_Cliente")); 
                c.setApellido(rs.getString("Apellido_Cliente")); 
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return lista;
    }
}

