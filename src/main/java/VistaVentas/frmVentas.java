/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VistaVentas;

import ModeloVendedor.Vendedor;
import ModeloClientes.Producto;
import VistaClientes.frmProductos;

/**
 *
 * @author ASUS
 */
public class frmVentas extends javax.swing.JFrame {

    private Vendedor vendedorActual;

    public frmVentas(Vendedor v) {
        initComponents();
        this.vendedorActual = v;
        this.setLocationRelativeTo(null);
        lblVendedor.setText("Vendedor: " + v.getNombre());
        ((javax.swing.table.DefaultTableModel) tblDetalleVenta.getModel()).setRowCount(0);
    }

    // 4. Deja el constructor vacío abajo por si NetBeans lo necesita para el diseño visual
    public frmVentas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVendedor = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        txtClienteSeleccionado = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleVenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnFinalizarVenta = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblVendedor.setText("Vendedor");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        txtClienteSeleccionado.setEditable(false);

        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Descripción", "Precio Unitario", "Cantidad", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tblDetalleVenta);

        jLabel1.setText("Total S/");

        lblTotal.setText("0.0");

        btnFinalizarVenta.setText("Finalizar Venta");
        btnFinalizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVentaActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("Eliminar Producto");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscarCliente)
                        .addGap(127, 127, 127)
                        .addComponent(txtClienteSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVendedor)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarProducto)
                        .addGap(29, 29, 29)
                        .addComponent(btnEliminarProducto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnRegresar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnFinalizarVenta)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarCliente)
                            .addComponent(txtClienteSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProducto)
                    .addComponent(btnEliminarProducto))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnFinalizarVenta)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(jLabel1)
                    .addComponent(lblTotal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        VistaVentas.frmPrincipal menu = new VistaVentas.frmPrincipal(this.vendedorActual);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        frmProductos catalogo = new frmProductos(null, true);
        catalogo.setLocationRelativeTo(this);
        catalogo.setVisible(true);

        Producto elegido = catalogo.getProductoSeleccionado();

        if (elegido != null) {
            String cantStr = javax.swing.JOptionPane.showInputDialog(this,
                    "Producto: " + elegido.getNombre() + "\nPrecio: S/." + elegido.getPrecio() + "\n\nIngrese la cantidad:",
                    "Cantidad", javax.swing.JOptionPane.QUESTION_MESSAGE);

            if (cantStr != null && !cantStr.trim().isEmpty()) {
                try {
                    int cantidadInput = Integer.parseInt(cantStr);

                    if (cantidadInput <= 0) {
                        javax.swing.JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0, mano.");
                        return;
                    }

                    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblDetalleVenta.getModel();
                    int filas = tblDetalleVenta.getRowCount();
                    boolean productoExiste = false;

                    for (int i = 0; i < filas; i++) {
                        int idTabla = Integer.parseInt(tblDetalleVenta.getValueAt(i, 0).toString());

                        if (idTabla == elegido.getId()) {
                            productoExiste = true;
                            int cantidadActual = Integer.parseInt(tblDetalleVenta.getValueAt(i, 3).toString());

                            // 💡 VENTANITA DE DECISIÓN: Preguntamos al usuario qué desea hacer
                            String[] opciones = {"Sumar a la actual", "Reemplazar por la nueva", "Cancelar"};
                            int seleccion = javax.swing.JOptionPane.showOptionDialog(this,
                                    "El producto ya está en el carrito.\n¿Desea sumar la nueva cantidad o reemplazar la anterior?",
                                    "Producto Duplicado",
                                    javax.swing.JOptionPane.DEFAULT_OPTION,
                                    javax.swing.JOptionPane.QUESTION_MESSAGE,
                                    null, opciones, opciones[0]);

                            int cantidadFinalMismaFila = 0;

                            if (seleccion == 0) {
                                // Opción: Sumar (2 + 3 = 5)
                                cantidadFinalMismaFila = cantidadActual + cantidadInput;
                            } else if (seleccion == 1) {
                                // Opción: Reemplazar (Se queda en 3)
                                cantidadFinalMismaFila = cantidadInput;
                            } else {
                                // Opción: Cancelar o cerrar ventana
                                return;
                            }

                            // Validación de Stock contra la cantidad final decidida
                            if (cantidadFinalMismaFila > elegido.getStock()) {
                                javax.swing.JOptionPane.showMessageDialog(this, "Supera el stock disponible: " + elegido.getStock());
                                return;
                            }

                            double nuevoSubtotal = elegido.getPrecio() * cantidadFinalMismaFila;

                            // Modificamos la fila existente
                            tblDetalleVenta.setValueAt(cantidadFinalMismaFila, i, 3);
                            tblDetalleVenta.setValueAt(nuevoSubtotal, i, 4);
                            break;
                        }
                    }

                    if (!productoExiste) {
                        if (cantidadInput > elegido.getStock()) {
                            javax.swing.JOptionPane.showMessageDialog(this, "Stock insuficiente. Quedan: " + elegido.getStock());
                            return;
                        }

                        double subtotal = elegido.getPrecio() * cantidadInput;
                        Object[] nuevaFila = {
                            elegido.getId(),
                            elegido.getNombre(),
                            elegido.getPrecio(),
                            cantidadInput,
                            subtotal
                        };
                        modelo.addRow(nuevaFila);
                    }

                    calcularTotalGeneral();

                } catch (NumberFormatException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero válido.");
                }
            }
        }
    }

    private void calcularTotalGeneral() {
        double total = 0.0;
        int filas = tblDetalleVenta.getRowCount();

        for (int i = 0; i < filas; i++) {

            total += Double.parseDouble(tblDetalleVenta.getValueAt(i, 4).toString());
        }

        lblTotal.setText(String.valueOf(total));

    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        VistaClientes.frmClientes buscador = new VistaClientes.frmClientes(null, true);
        buscador.setLocationRelativeTo(this);
        buscador.setVisible(true); // Se congela el código aquí hasta elegir un cliente

        ModeloClientes.Cliente elegido = buscador.getClienteSeleccionado();

        if (elegido != null) {
            txtClienteSeleccionado.setText(elegido.getNombre());
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int filaSeleccionada = tblDetalleVenta.getSelectedRow();

        if (filaSeleccionada >= 0) {
            int confirmar = javax.swing.JOptionPane.showConfirmDialog(this,
                    "¿Seguro que deseas quitar este producto del carrito?",
                    "Eliminar Producto", javax.swing.JOptionPane.YES_NO_OPTION);

            if (confirmar == javax.swing.JOptionPane.YES_OPTION) {
                javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblDetalleVenta.getModel();

                modelo.removeRow(filaSeleccionada);

                calcularTotalGeneral();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Mano, debes hacer clic sobre una fila de la tabla para poder eliminarla.");
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnFinalizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVentaActionPerformed
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblDetalleVenta.getModel();

        if (txtClienteSeleccionado.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Mano, debes asignar un cliente a la venta primero.");
            return;
        }
        if (modelo.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "El carrito de compras está vacío, agrega algún producto.");
            return;
        }

        int confirmar = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Deseas procesar y finalizar esta venta?",
                "Confirmar Venta", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirmar != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        ModeloVentas.Venta nuevaVenta = new ModeloVentas.Venta();

        nuevaVenta.setIdCliente(1);

        nuevaVenta.setIdVendedor(this.vendedorActual.getId());
        nuevaVenta.setTotal(Double.parseDouble(lblTotal.getText()));

        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            Object[] filaDetalle = {
                modelo.getValueAt(i, 0), // Id Producto
                modelo.getValueAt(i, 1), // Descripción
                modelo.getValueAt(i, 2), // Precio Unitario
                modelo.getValueAt(i, 3), // Cantidad
                modelo.getValueAt(i, 4) // Subtotal
            };
            nuevaVenta.getDetalles().add(filaDetalle);
        }

        ControladorClientes.Control_Venta control = new ControladorClientes.Control_Venta();

        if (control.registrarVenta(nuevaVenta)) {
            javax.swing.JOptionPane.showMessageDialog(this, "¡Venta registrada con éxito en la base de datos, mano! El stock ha sido actualizado.");

            modelo.setRowCount(0);
            txtClienteSeleccionado.setText("");
            lblTotal.setText("0.0");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Hubo un error crítico al intentar guardar la transacción.");
        }
    }//GEN-LAST:event_btnFinalizarVentaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnFinalizarVenta;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JTable tblDetalleVenta;
    private javax.swing.JTextField txtClienteSeleccionado;
    // End of variables declaration//GEN-END:variables
}
