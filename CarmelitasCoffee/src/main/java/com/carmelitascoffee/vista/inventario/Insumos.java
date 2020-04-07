/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.vista.inventario;

import com.carmelitascoffee.controlador.inventario.CInsumos;
import com.carmelitascoffee.pojo.Insumo;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class Insumos extends JInternalFrame {

    private CInsumos controlador;
    private Session se;
    private DefaultTableModel modelo;

    /**
     * Creates new form InternalFrameZ
     */
    public Insumos(Session s) {
        initComponents();
        se = s;
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");;
        controlador = new CInsumos(se, modelo);
        controlador.LlenarTabla(tInsumos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jdAgregarInsumo = new javax.swing.JDialog();
        pAgregar = new swing.Contenedores.PanelZ();
        lTitulo = new swing.Controles.LabelZ();
        lDescripcion = new swing.Controles.LabelZ();
        lCantidad = new swing.Controles.LabelZ();
        tfDescripcion = new swing.Controles.TextFieldZ();
        tfCantidad = new swing.Controles.TextFieldZ();
        bAgregarInsumo = new swing.Controles.ButtonZ();
        labelZ2 = new swing.Controles.LabelZ();
        Bus = new swing.Controles.TextFieldZ();
        jScrollPane1 = new javax.swing.JScrollPane();
        tInsumos = new swing.Controles.TableZ();
        btnAñadir = new swing.Controles.ButtonZ();

        pAgregar.setPreferredSize(new java.awt.Dimension(400, 190));
        pAgregar.setLayout(new java.awt.GridBagLayout());

        lTitulo.setText("Agregar Insumo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pAgregar.add(lTitulo, gridBagConstraints);

        lDescripcion.setText("Descripción: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pAgregar.add(lDescripcion, gridBagConstraints);

        lCantidad.setText("Cantidad En Inventario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pAgregar.add(lCantidad, gridBagConstraints);

        tfDescripcion.setText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pAgregar.add(tfDescripcion, gridBagConstraints);

        tfCantidad.setText("");
        tfCantidad.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pAgregar.add(tfCantidad, gridBagConstraints);

        bAgregarInsumo.setText("Agregar");
        bAgregarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarInsumoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        pAgregar.add(bAgregarInsumo, gridBagConstraints);

        jdAgregarInsumo.getContentPane().add(pAgregar, java.awt.BorderLayout.CENTER);

        setBackground(new java.awt.Color(255, 247, 162));
        setClosable(true);
        setIconifiable(true);
        setTitle("Insumos");
        setVisible(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        labelZ2.setText("Buscar por nombre de Insumo:");
        labelZ2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(labelZ2, gridBagConstraints);

        Bus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        Bus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Bus.setText("");
        Bus.setCaretColor(new java.awt.Color(255, 255, 255));
        Bus.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Bus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BusKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.9;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(Bus, gridBagConstraints);

        tInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tInsumosMouseClicked(evt);
            }
        });
        tInsumos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tInsumosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tInsumosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tInsumos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.6;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(btnAñadir, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tInsumosMouseClicked

    }//GEN-LAST:event_tInsumosMouseClicked

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        jdAgregarInsumo.setSize(400, 190);
        jdAgregarInsumo.setLocationRelativeTo(this);
        jdAgregarInsumo.setVisible(true);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void BusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BusKeyTyped
        cargarTabla(Bus.getText());
    }//GEN-LAST:event_BusKeyTyped

    private void tInsumosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tInsumosKeyPressed


    }//GEN-LAST:event_tInsumosKeyPressed

    private void tInsumosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tInsumosKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int columna = tInsumos.getSelectedColumn();
            int fila = tInsumos.getSelectedRow();
            int codigo = Integer.parseInt(tInsumos.getValueAt(fila, 0).toString());
            Insumo insumo = controlador.buscarPorId(codigo);
            // modificar nombre
            if (columna == 1) {
                insumo.setDescripcion((String) tInsumos.getValueAt(fila, 1));
                // modificar cantidad en inventario
            } else if (columna == 2) {
                insumo.setCantidadInventario(Integer.parseInt(tInsumos.getValueAt(fila, 2).toString()));
            }
            controlador.setInsumo(insumo);
            controlador.LlenarTabla(tInsumos);
        }
    }//GEN-LAST:event_tInsumosKeyReleased

    private void bAgregarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarInsumoActionPerformed
        try {
            String descripcion = tfDescripcion.getText();
            int cantidad = Integer.parseInt(tfCantidad.getText());
            Insumo insumo = new Insumo(descripcion, cantidad);
            controlador.AgregarInsumo(insumo);
            controlador.LlenarTabla(tInsumos);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tfCantidad.setText("");
        tfDescripcion.setText("");
        jdAgregarInsumo.setVisible(false);

    }//GEN-LAST:event_bAgregarInsumoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Controles.TextFieldZ Bus;
    private swing.Controles.ButtonZ bAgregarInsumo;
    private swing.Controles.ButtonZ btnAñadir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog jdAgregarInsumo;
    private swing.Controles.LabelZ lCantidad;
    private swing.Controles.LabelZ lDescripcion;
    private swing.Controles.LabelZ lTitulo;
    private swing.Controles.LabelZ labelZ2;
    private swing.Contenedores.PanelZ pAgregar;
    private swing.Controles.TableZ tInsumos;
    private swing.Controles.TextFieldZ tfCantidad;
    private swing.Controles.TextFieldZ tfDescripcion;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla(String textFiltro) {
        DefaultTableModel dtm = (DefaultTableModel) tInsumos.getModel();
        dtm.setRowCount(0);
        List lista = controlador.cargarFiltros(textFiltro);
        Object[] row = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            Insumo in = (Insumo) lista.get(i);
            row[0] = in.getIdInsumo();
            row[1] = in.getDescripcion();
            row[2] = in.getCantidadInventario();
            dtm.addRow(row);
        }
        tInsumos.setModel(dtm);
    }

}
