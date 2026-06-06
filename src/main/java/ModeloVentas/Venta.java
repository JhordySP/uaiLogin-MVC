/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVentas;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class Venta {
    private int idVenta;
    private int idCliente;
    private int idVendedor;
    private double total;
    // Aquí guardamos la lista de lo que contiene la tabla gráfica
    private ArrayList<Object[]> detalles; 

    public Venta() {
        this.detalles = new ArrayList<>();
    }

    // Getters y Setters
    public int getIdVenta() { return idVenta; }
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdVendedor() { return idVendedor; }
    public void setIdVendedor(int idVendedor) { this.idVendedor = idVendedor; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public ArrayList<Object[]> getDetalles() { return detalles; }
    public void setDetalles(ArrayList<Object[]> detalles) { this.detalles = detalles; }
}
