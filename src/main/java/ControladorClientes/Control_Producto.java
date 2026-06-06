/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorClientes;
import ModeloClientes.Producto;
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
public class Control_Producto {
    public List<Producto> obtenerListaProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT idproducto, nombre_producto, precio_producto, stock_producto FROM table_producto";        
        ConexionMySql conexion = new ConexionMySql();        
        try (Connection conn = conexion.conectar();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("idproducto"));
                p.setNombre(rs.getString("nombre_producto"));
                p.setPrecio(rs.getDouble("precio_producto"));
                p.setStock(rs.getInt("stock_producto"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
