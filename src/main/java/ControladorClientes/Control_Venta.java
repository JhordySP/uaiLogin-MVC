/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorClientes;

import ControladorLogin.ConexionMySql;
import ModeloVentas.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class Control_Venta {

    public boolean registrarVenta(Venta venta) {
        boolean respuesta = false;
        ConexionMySql mysql = new ConexionMySql();
        Connection cn = mysql.conectar();

        try {
            cn.setAutoCommit(false); // Iniciamos la transacción segura

            // 1. Insertar la cabecera de la venta en la tabla 'ventas'
            String sqlVenta = "INSERT INTO ventas (id_cliente, id_usuario, total) VALUES (?, ?, ?)";
            PreparedStatement pstVenta = cn.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS);
            pstVenta.setInt(1, venta.getIdCliente());
            pstVenta.setInt(2, venta.getIdVendedor());
            pstVenta.setDouble(3, venta.getTotal());
            pstVenta.executeUpdate();

            // Capturamos el ID de la venta
            ResultSet rs = pstVenta.getGeneratedKeys();
            int idVentaGenerada = 0;
            if (rs.next()) {
                idVentaGenerada = rs.getInt(1);
            }

            // 2. Preparamos las consultas para los detalles y para el descuento de stock
            String sqlDetalle = "INSERT INTO detalle_ventas (id_venta, id_producto, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstDetalle = cn.prepareStatement(sqlDetalle);

            // LA MAGIA ESTÁ AQUÍ: Le decimos a MySQL que actualice restando la cantidad
            String sqlStock = "UPDATE table_productos SET stock = stock - ? WHERE idProductos = ?";
            PreparedStatement pstStock = cn.prepareStatement(sqlStock);

            // 3. Recorremos el carrito
            for (Object[] fila : venta.getDetalles()) {
                // A. Guardamos el detalle en el voucher
                pstDetalle.setInt(1, idVentaGenerada);
                pstDetalle.setInt(2, Integer.parseInt(fila[0].toString())); // id_producto
                pstDetalle.setInt(3, Integer.parseInt(fila[3].toString())); // cantidad
                pstDetalle.setDouble(4, Double.parseDouble(fila[2].toString())); // precio
                pstDetalle.setDouble(5, Double.parseDouble(fila[4].toString())); // subtotal
                pstDetalle.executeUpdate();

                // B. PASO CLAVE: RESTAR EL STOCK DEL INVENTARIO
                pstStock.setInt(1, Integer.parseInt(fila[3].toString())); // Cantidad a restar
                pstStock.setInt(2, Integer.parseInt(fila[0].toString())); // id_producto
                pstStock.executeUpdate();
            }

            // 4. Si todo salió perfecto, confirmamos la transacción
            cn.commit();
            respuesta = true;

        } catch (SQLException e) {
            System.out.println("Error al registrar la venta: " + e.getMessage());
            try {
                cn.rollback();
            } catch (SQLException ex) {
                System.out.println("Error en el rollback: " + ex.getMessage());
            }
        } finally {
            try {
                cn.setAutoCommit(true);
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }

        return respuesta;
    }
}
