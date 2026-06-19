/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VistaProductos;

import ControladorProductos.Control_Producto;
import ModeloProductos.Producto;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class frmMantenimientoProductos extends JFrame {

    // 1. Declaramos los componentes (Añadimos lblStock y txtStock)
    private JLabel lblTitulo, lblId, lblNombre, lblPrecio, lblStock;
    private JTextField txtId, txtNombre, txtPrecio, txtStock;
    private JButton btnGuardar, btnActualizar, btnEliminar, btnLimpiar, btnRegresar;
    private JTable tblProductos;
    private DefaultTableModel modelo;
    private JScrollPane scrollPane;

    public frmMantenimientoProductos() {
        // 2. Configuramos la ventana
        setTitle("Gestión de Inventario - Productos");
        setSize(700, 480); // Le dimos un poquito más de alto a la ventana
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        // 3. Textos (Labels)
        lblTitulo = new JLabel("MANTENIMIENTO DE PRODUCTOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(20, 10, 300, 30);
        add(lblTitulo);

        lblId = new JLabel("ID:");
        lblId.setBounds(20, 60, 50, 25);
        add(lblId);

        lblNombre = new JLabel("Descripción:");
        lblNombre.setBounds(20, 100, 80, 25);
        add(lblNombre);

        lblPrecio = new JLabel("Precio (S/):");
        lblPrecio.setBounds(20, 140, 80, 25);
        add(lblPrecio);

        // NUEVO: Etiqueta de Stock
        lblStock = new JLabel("Stock:");
        lblStock.setBounds(20, 180, 80, 25);
        add(lblStock);

        // 4. Cajas de texto (TextFields)
        txtId = new JTextField();
        txtId.setBounds(100, 60, 80, 25);
        txtId.setEditable(false);
        add(txtId);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 100, 180, 25);
        add(txtNombre);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(100, 140, 100, 25);
        add(txtPrecio);

        // NUEVO: Caja de texto de Stock
        txtStock = new JTextField();
        txtStock.setBounds(100, 180, 100, 25);
        add(txtStock);

        // 5. Botones (Los bajamos un poco en el eje Y para hacer espacio)
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 230, 120, 30);
        add(btnGuardar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(160, 230, 120, 30);
        add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(20, 270, 120, 30);
        add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(160, 270, 120, 30);
        add(btnLimpiar);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(20, 390, 120, 30);
        add(btnRegresar);

        // 6. Tabla (Añadimos la columna Stock)
        String[] columnas = {"ID", "Descripción", "Precio", "Stock"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblProductos = new JTable(modelo);
        scrollPane = new JScrollPane(tblProductos);
        scrollPane.setBounds(300, 50, 360, 320);
        add(scrollPane);

        // 7. Cargamos los datos
        cargarTabla();

        // 8. EVENTOS
        btnLimpiar.addActionListener(e -> limpiarCampos());

        btnRegresar.addActionListener(e -> this.dispose());

        btnGuardar.addActionListener(e -> {
            if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() || txtStock.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llena todos los campos, incluyendo el Stock.");
                return;
            }
            try {
                Producto p = new Producto();
                p.setNombre(txtNombre.getText());
                p.setPrecio(Double.parseDouble(txtPrecio.getText()));
                p.setStock(Integer.parseInt(txtStock.getText())); // Capturamos el Stock

                Control_Producto control = new Control_Producto();
                if (control.registrarProducto(p)) {
                    JOptionPane.showMessageDialog(null, "Producto Guardado.");
                    limpiarCampos();
                    cargarTabla();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error: El precio y el stock deben ser números.");
            }
        });

        btnActualizar.addActionListener(e -> {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecciona un producto de la tabla primero.");
                return;
            }
            try {
                Producto p = new Producto();
                p.setId(Integer.parseInt(txtId.getText()));
                p.setNombre(txtNombre.getText());
                p.setPrecio(Double.parseDouble(txtPrecio.getText()));
                p.setStock(Integer.parseInt(txtStock.getText())); // Capturamos el Stock

                Control_Producto control = new Control_Producto();
                if (control.actualizarProducto(p)) {
                    JOptionPane.showMessageDialog(null, "Producto Actualizado.");
                    limpiarCampos();
                    cargarTabla();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error: El precio y el stock deben ser números.");
            }
        });

        btnEliminar.addActionListener(e -> {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecciona un producto de la tabla primero.");
                return;
            }
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminarlo?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(txtId.getText());
                Control_Producto control = new Control_Producto();
                if (control.eliminarProducto(id)) {
                    JOptionPane.showMessageDialog(null, "Producto Eliminado.");
                    limpiarCampos();
                    cargarTabla();
                }
            }
        });

        // Clic en la tabla (Ahora pasa 4 datos)
        tblProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tblProductos.getSelectedRow();
                if (fila >= 0) {
                    txtId.setText(tblProductos.getValueAt(fila, 0).toString());
                    txtNombre.setText(tblProductos.getValueAt(fila, 1).toString());
                    txtPrecio.setText(tblProductos.getValueAt(fila, 2).toString());
                    txtStock.setText(tblProductos.getValueAt(fila, 3).toString()); // Pasa el Stock
                }
            }
        });
    }

    // --- MÉTODOS DE APOYO ---
    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText(""); // Limpia el Stock
        txtNombre.requestFocus();
    }

    private void cargarTabla() {
        modelo.setRowCount(0);
        Control_Producto control = new Control_Producto();
        List<Producto> lista = control.obtenerListaProductos();
        if (lista != null) {
            for (Producto p : lista) {
                // Se añaden los 4 datos a la fila visual
                Object[] fila = {p.getId(), p.getNombre(), p.getPrecio(), p.getStock()};
                modelo.addRow(fila);
            }
        }
    }
}
