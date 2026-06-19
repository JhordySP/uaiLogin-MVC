/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorProductos;

import ControladorLogin.ConexionMySql;
import ModeloProductos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Control_Producto {

    // 1. LEER (Con Stock incluido)
    public List<Producto> obtenerListaProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT idProductos, nombreProductos, preciosProductos, stock FROM table_productos";
        ConexionMySql mysql = new ConexionMySql();
        try (Connection conn = mysql.conectar(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("idProductos"));
                p.setNombre(rs.getString("nombreProductos"));
                p.setPrecio(rs.getDouble("preciosProductos"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

    // 2. CREAR NUEVO (Con Stock)
    public boolean registrarProducto(Producto p) {
        String sql = "INSERT INTO table_productos (nombreProductos, preciosProductos, stock) VALUES (?, ?, ?)";
        ConexionMySql mysql = new ConexionMySql();
        try (Connection conn = mysql.conectar(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, p.getNombre());
            pst.setDouble(2, p.getPrecio());
            pst.setInt(3, p.getStock());
            pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 3. ACTUALIZAR (Con Stock)
    public boolean actualizarProducto(Producto p) {
        String sql = "UPDATE table_productos SET nombreProductos = ?, preciosProductos = ?, stock = ? WHERE idProductos = ?";
        ConexionMySql mysql = new ConexionMySql();
        try (Connection conn = mysql.conectar(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, p.getNombre());
            pst.setDouble(2, p.getPrecio());
            pst.setInt(3, p.getStock());
            pst.setInt(4, p.getId());
            pst.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 4. ELIMINAR (El que NetBeans no encontraba)
    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM table_productos WHERE idProductos = ?";
        ConexionMySql mysql = new ConexionMySql();
        try (Connection conn = mysql.conectar(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }
}
