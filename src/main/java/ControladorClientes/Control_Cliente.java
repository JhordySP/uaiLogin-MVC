/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorClientes;

import ControladorLogin.ConexionMySql;
import ModeloClientes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Control_Cliente {

    public List<Cliente> obtenerListaClientes() {
        List<Cliente> lista = new ArrayList<>();
        // Consulta exacta para tu tabla clientes
        String sql = "SELECT id, nombre, apellido FROM clientes";

        ConexionMySql mysql = new ConexionMySql();

        try (Connection conn = mysql.conectar(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener clientes: " + e.getMessage());
            e.printStackTrace(); // Esto nos dirá en consola si falla la base de datos
        }
        return lista;
    }

    public boolean registrarCliente(ModeloClientes.Cliente c) {
        String sql = "INSERT INTO clientes (nombre, apellido) VALUES (?, ?)";
        ControladorLogin.ConexionMySql mysql = new ControladorLogin.ConexionMySql();
        try (java.sql.Connection conn = mysql.conectar(); java.sql.PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, c.getNombre());
            pst.setString(2, c.getApellido());
            pst.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al registrar cliente: " + e.getMessage());
            return false;
        }
    }

    // MÉTODO PARA ACTUALIZAR
    public boolean actualizarCliente(ModeloClientes.Cliente c) {
        String sql = "UPDATE clientes SET nombre = ?, apellido = ? WHERE id = ?";
        ControladorLogin.ConexionMySql mysql = new ControladorLogin.ConexionMySql();
        try (java.sql.Connection conn = mysql.conectar(); java.sql.PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, c.getNombre());
            pst.setString(2, c.getApellido());
            pst.setInt(3, c.getId());
            pst.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    // MÉTODO PARA ELIMINAR
    public boolean eliminarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        ControladorLogin.ConexionMySql mysql = new ControladorLogin.ConexionMySql();
        try (java.sql.Connection conn = mysql.conectar(); java.sql.PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
}
