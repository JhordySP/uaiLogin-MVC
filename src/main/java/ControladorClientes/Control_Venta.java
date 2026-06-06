/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorClientes;

import java.sql.*;
import ModeloVentas.Venta;

/**
 *
 * @author ASUS
 */
public class Control_Venta {

    public boolean registrarVenta(Venta venta) {
        ControladorLogin.ConexionMySql mysql = new ControladorLogin.ConexionMySql();
        Connection cn = mysql.conectar();
        PreparedStatement psVenta = null;
        PreparedStatement psDetalle = null;
        PreparedStatement psStock = null;
        ResultSet rs = null;

        try {
            cn.setAutoCommit(false);

            String sqlVenta = "INSERT INTO table_venta (idcliente, idvendedor, total_venta) VALUES (?, ?, ?)";
            psVenta = cn.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS);
            psVenta.setInt(1, venta.getIdCliente());
            psVenta.setInt(2, venta.getIdVendedor());
            psVenta.setDouble(3, venta.getTotal());
            psVenta.executeUpdate();

            rs = psVenta.getGeneratedKeys();
            int idVentaGenerado = 0;
            if (rs.next()) {
                idVentaGenerado = rs.getInt(1);
            }

            String sqlDetalle = "INSERT INTO table_detalle_venta (idventa, idproducto, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
            String sqlStock = "UPDATE table_producto SET stock_producto = stock_producto - ? WHERE idproducto = ?";

            psDetalle = cn.prepareStatement(sqlDetalle);
            psStock = cn.prepareStatement(sqlStock);

            for (Object[] fila : venta.getDetalles()) {
                int idProd = Integer.parseInt(fila[0].toString());
                double precio = Double.parseDouble(fila[2].toString());
                int cant = Integer.parseInt(fila[3].toString());
                double subtotal = Double.parseDouble(fila[4].toString());

                psDetalle.setInt(1, idVentaGenerado);
                psDetalle.setInt(2, idProd);
                psDetalle.setInt(3, cant);
                psDetalle.setDouble(4, precio);
                psDetalle.setDouble(5, subtotal);
                psDetalle.addBatch(); // Lo acumulamos en un lote

                psStock.setInt(1, cant);
                psStock.setInt(2, idProd);
                psStock.addBatch(); // Lo acumulamos en un lote
            }

            psDetalle.executeBatch();
            psStock.executeBatch();

            cn.commit();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar venta: " + e.getMessage());
            try {
                if (cn != null) {
                    cn.rollback(); // Si algo falló, cancelamos la operación para no corromper la BD
                }
            } catch (SQLException ex) {
                System.out.println("Error en rollback: " + ex.getMessage());
            }
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psVenta != null) {
                    psVenta.close();
                }
                if (psDetalle != null) {
                    psDetalle.close();
                }
                if (psStock != null) {
                    psStock.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexiones: " + e.getMessage());
            }
        }
    }
}
