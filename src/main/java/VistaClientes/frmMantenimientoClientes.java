/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VistaClientes;

import ControladorClientes.Control_Cliente;
import ModeloClientes.Cliente;
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
public class frmMantenimientoClientes extends JFrame {

    private JLabel lblTitulo, lblId, lblNombre, lblApellido;
    private JTextField txtId, txtNombre, txtApellido;
    private JButton btnGuardar, btnActualizar, btnEliminar, btnLimpiar, btnRegresar;
    private JTable tblClientes;
    private DefaultTableModel modelo;
    private JScrollPane scrollPane;

    public frmMantenimientoClientes() {
        // Configuramos la ventana
        setTitle("Gestión de Cartera - Clientes");
        setSize(700, 450);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        // Inicializamos los Labels
        lblTitulo = new JLabel("MANTENIMIENTO DE CLIENTES");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(20, 10, 300, 30);
        add(lblTitulo);

        lblId = new JLabel("ID:");
        lblId.setBounds(20, 60, 50, 25);
        add(lblId);

        lblNombre = new JLabel("Nombres:");
        lblNombre.setBounds(20, 100, 80, 25);
        add(lblNombre);

        lblApellido = new JLabel("Apellidos:");
        lblApellido.setBounds(20, 140, 80, 25);
        add(lblApellido);

        // Inicializamos los TextFields
        txtId = new JTextField();
        txtId.setBounds(100, 60, 80, 25);
        txtId.setEditable(false);
        add(txtId);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 100, 180, 25);
        add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setBounds(100, 140, 180, 25);
        add(txtApellido);

        // Inicializamos los Botones
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 190, 120, 30);
        add(btnGuardar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(160, 190, 120, 30);
        add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(20, 230, 120, 30);
        add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(160, 230, 120, 30);
        add(btnLimpiar);

        // --- EL NUEVO BOTÓN DE REGRESAR ---
        btnRegresar = new JButton("Regresar");
        // Lo ponemos en X=20 (pegado a la izquierda) y Y=370 (abajo)
        btnRegresar.setBounds(20, 370, 120, 30);
        add(btnRegresar);

        // Construimos la Tabla
        String[] columnas = {"ID", "Nombres", "Apellidos"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblClientes = new JTable(modelo);
        scrollPane = new JScrollPane(tblClientes);
        scrollPane.setBounds(300, 50, 360, 320);
        add(scrollPane);

        // Cargamos los datos
        cargarTabla();

        // --- EVENTOS ---
        btnLimpiar.addActionListener(e -> limpiarCampos());

        btnGuardar.addActionListener(e -> {
            if (txtNombre.getText().trim().isEmpty() || txtApellido.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llena los campos de Nombre y Apellido.");
                return;
            }
            Cliente c = new Cliente();
            c.setNombre(txtNombre.getText().trim());
            c.setApellido(txtApellido.getText().trim());

            Control_Cliente control = new Control_Cliente();
            if (control.registrarCliente(c)) {
                JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente.");
                limpiarCampos();
                cargarTabla();
            }
        });

        btnActualizar.addActionListener(e -> {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecciona un cliente de la tabla primero.");
                return;
            }
            Cliente c = new Cliente();
            c.setId(Integer.parseInt(txtId.getText()));
            c.setNombre(txtNombre.getText().trim());
            c.setApellido(txtApellido.getText().trim());

            Control_Cliente control = new Control_Cliente();
            if (control.actualizarCliente(c)) {
                JOptionPane.showMessageDialog(null, "Datos del cliente actualizados.");
                limpiarCampos();
                cargarTabla();
            }
        });

        btnEliminar.addActionListener(e -> {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecciona un cliente de la tabla primero.");
                return;
            }
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar a este cliente?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(txtId.getText());
                Control_Cliente control = new Control_Cliente();
                if (control.eliminarCliente(id)) {
                    JOptionPane.showMessageDialog(null, "Cliente eliminado del sistema.");
                    limpiarCampos();
                    cargarTabla();
                }
            }
        });
        // Clic en Regresar
        btnRegresar.addActionListener(e -> this.dispose());

        // Pasar datos de la tabla al formulario al hacer clic
        tblClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tblClientes.getSelectedRow();
                if (fila >= 0) {
                    txtId.setText(tblClientes.getValueAt(fila, 0).toString());
                    txtNombre.setText(tblClientes.getValueAt(fila, 1).toString());
                    txtApellido.setText(tblClientes.getValueAt(fila, 2).toString());
                }
            }
        });
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtNombre.requestFocus();
    }

    private void cargarTabla() {
        modelo.setRowCount(0);
        Control_Cliente control = new Control_Cliente();
        List<Cliente> lista = control.obtenerListaClientes();
        if (lista != null) {
            for (Cliente c : lista) {
                Object[] fila = {c.getId(), c.getNombre(), c.getApellido()};
                modelo.addRow(fila);
            }
        }
    }
}
