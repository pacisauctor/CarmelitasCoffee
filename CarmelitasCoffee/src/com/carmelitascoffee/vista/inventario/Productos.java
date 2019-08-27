/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.vista.inventario;

import com.carmelitascoffee.controlador.inventario.CProductos;
import com.carmelitascoffee.controlador.inventario.CProductos;
import com.carmelitascoffee.pojo.Producto;
import java.math.BigDecimal;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class Productos extends JInternalFrame {
    private CProductos controlador;
    private Session se;
    private DefaultTableModel modelo;
    /**
     * Creates new form InternalFrameZ
     */
    public Productos(Session s) {
        initComponents();
        se = s;
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        controlador = new CProductos(se,modelo);
        controlador.LlenarTabla(tableZ1);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelZ1 = new swing.Contenedores.PanelZ();
        labelZ1 = new swing.Controles.LabelZ();
        textFieldZ1 = new swing.Controles.TextFieldZ();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableZ1 = new swing.Controles.TableZ();
        labelZ2 = new swing.Controles.LabelZ();
        labelZ3 = new swing.Controles.LabelZ();
        labelZ4 = new swing.Controles.LabelZ();
        labelZ5 = new swing.Controles.LabelZ();
        nom = new swing.Controles.TextFieldZ();
        cant = new swing.Controles.TextFieldZ();
        pre = new swing.Controles.TextFieldZ();
        cod = new swing.Controles.TextFieldZ();
        btnBuscar = new swing.Controles.ButtonZ();
        btnEditar = new swing.Controles.ButtonZ();
        btnAñadir = new swing.Controles.ButtonZ();

        setBackground(new java.awt.Color(0, 51, 102));
        setClosable(true);
        setIconifiable(true);
        setTitle("Productos");
        setVisible(true);

        labelZ1.setForeground(new java.awt.Color(29, 32, 98));
        labelZ1.setText("Código");
        labelZ1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        textFieldZ1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        textFieldZ1.setText("");
        textFieldZ1.setCaretColor(new java.awt.Color(255, 255, 255));
        textFieldZ1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        textFieldZ1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        tableZ1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Cantidad", "Precio"
            }
        ));
        tableZ1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableZ1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableZ1);

        labelZ2.setForeground(new java.awt.Color(29, 32, 98));
        labelZ2.setText("Código de producto");
        labelZ2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        labelZ3.setForeground(new java.awt.Color(29, 32, 98));
        labelZ3.setText("Cantidad");
        labelZ3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        labelZ4.setForeground(new java.awt.Color(29, 32, 98));
        labelZ4.setText("Precio");
        labelZ4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        labelZ5.setForeground(new java.awt.Color(29, 32, 98));
        labelZ5.setText("Nombre");
        labelZ5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        nom.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        nom.setText("");
        nom.setCaretColor(new java.awt.Color(255, 255, 255));
        nom.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        nom.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        cant.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        cant.setText("");
        cant.setCaretColor(new java.awt.Color(255, 255, 255));
        cant.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        cant.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        pre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        pre.setText("");
        pre.setCaretColor(new java.awt.Color(255, 255, 255));
        pre.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        pre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        cod.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        cod.setText("");
        cod.setCaretColor(new java.awt.Color(255, 255, 255));
        cod.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        cod.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        btnBuscar.setText("Buscar");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelZ1Layout = new javax.swing.GroupLayout(panelZ1);
        panelZ1.setLayout(panelZ1Layout);
        panelZ1Layout.setHorizontalGroup(
            panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelZ1Layout.createSequentialGroup()
                .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelZ1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(labelZ5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168)
                        .addComponent(labelZ4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelZ1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelZ1Layout.createSequentialGroup()
                                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelZ1Layout.createSequentialGroup()
                                        .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(pre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panelZ1Layout.createSequentialGroup()
                                    .addGap(138, 138, 138)
                                    .addComponent(textFieldZ1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelZ1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(labelZ1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(labelZ3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelZ1Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(labelZ2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        panelZ1Layout.setVerticalGroup(
            panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelZ1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelZ2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldZ1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelZ3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelZ1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelZ1Layout.createSequentialGroup()
                        .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelZ4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelZ5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelZ1Layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelZ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelZ1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelZ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableZ1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableZ1MouseClicked
        // TODO add your handling code here:
        int Selec = tableZ1.rowAtPoint(evt.getPoint());
        cod.setText(String.valueOf(tableZ1.getValueAt(Selec, 0)));
        nom.setText(String.valueOf(tableZ1.getValueAt(Selec, 1)));
        cant.setText(String.valueOf(tableZ1.getValueAt(Selec, 2)));
        pre.setText(String.valueOf(tableZ1.getValueAt(Selec, 3)));
    }//GEN-LAST:event_tableZ1MouseClicked

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        String descripcion;
        int cantidadEnInventario;
        float precio;

        descripcion = nom.getText();
        cantidadEnInventario = Integer.parseInt(cant.getText());
        precio = Float.parseFloat(pre.getText());
        
        Producto producto = new Producto(new BigDecimal(precio), descripcion, cantidadEnInventario);
        controlador.AgregarProducto(producto);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
      Producto producto = new Producto(new BigDecimal(pre.getText()), nom.getText(),Integer.parseInt(cant.getText()));
        producto.setIdProducto(Integer.parseInt(cod.getText()));
        controlador.setProducto(producto);
        
        controlador.LlenarTabla(tableZ1);
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Controles.ButtonZ btnAñadir;
    private swing.Controles.ButtonZ btnBuscar;
    private swing.Controles.ButtonZ btnEditar;
    public swing.Controles.TextFieldZ cant;
    public swing.Controles.TextFieldZ cod;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.Controles.LabelZ labelZ1;
    private swing.Controles.LabelZ labelZ2;
    private swing.Controles.LabelZ labelZ3;
    private swing.Controles.LabelZ labelZ4;
    private swing.Controles.LabelZ labelZ5;
    public swing.Controles.TextFieldZ nom;
    private swing.Contenedores.PanelZ panelZ1;
    public swing.Controles.TextFieldZ pre;
    private swing.Controles.TableZ tableZ1;
    private swing.Controles.TextFieldZ textFieldZ1;
    // End of variables declaration//GEN-END:variables
}
