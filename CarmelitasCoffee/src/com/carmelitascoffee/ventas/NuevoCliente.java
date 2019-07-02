/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.ventas;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author admin
 */
public class NuevoCliente extends JInternalFrame {

    /**
     * Creates new form InternalFrameZ
     */
    public NuevoCliente() {
        initComponents();
        setImagenes();
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

        lNombres = new swing.Controles.LabelZ();
        tfNombre1 = new swing.Controles.TextFieldZ();
        tfNombre2 = new swing.Controles.TextFieldZ();
        lApelildos = new swing.Controles.LabelZ();
        tfApellido1 = new swing.Controles.TextFieldZ();
        tfApellido2 = new swing.Controles.TextFieldZ();
        lTelefono = new swing.Controles.LabelZ();
        tfTelefono = new swing.Controles.TextFieldZ();
        lDireccion = new swing.Controles.LabelZ();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDireccion = new swing.Controles.TextAreaZ();
        lCorreo = new swing.Controles.LabelZ();
        tfCorreo = new swing.Controles.TextFieldZ();
        labelZ1 = new swing.Controles.LabelZ();
        comboBoxZ1 = new swing.Controles.ComboBoxZ();
        bActualizar = new swing.Controles.ButtonZ();
        bNuevoCliente = new swing.Controles.ButtonZ();
        bAgregarCliente = new swing.Controles.ButtonZ();

        setBackground(new java.awt.Color(255, 247, 162));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Nuevo Cliente");
        setVisible(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lNombres.setText("Nombre: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lNombres, gridBagConstraints);

        tfNombre1.setText("primerNombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(tfNombre1, gridBagConstraints);

        tfNombre2.setText("segundoNombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(tfNombre2, gridBagConstraints);

        lApelildos.setText("Nombre: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lApelildos, gridBagConstraints);

        tfApellido1.setText("primerApellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(tfApellido1, gridBagConstraints);

        tfApellido2.setText("segundoApellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(tfApellido2, gridBagConstraints);

        lTelefono.setText("Teléfono: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lTelefono, gridBagConstraints);

        tfTelefono.setText("+50581380937");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(tfTelefono, gridBagConstraints);

        lDireccion.setText("Dirección: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lDireccion, gridBagConstraints);

        taDireccion.setColumns(20);
        taDireccion.setRows(5);
        taDireccion.setText("De por aquí hasta alla\n");
        jScrollPane1.setViewportView(taDireccion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        lCorreo.setText("Correo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lCorreo, gridBagConstraints);

        tfCorreo.setText("tumail@example.com");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(tfCorreo, gridBagConstraints);

        labelZ1.setText("Persona de Contacto: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(labelZ1, gridBagConstraints);

        comboBoxZ1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PersonaContacto 1", "PersonaContacto 2", "PersonaContacto 3" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(comboBoxZ1, gridBagConstraints);

        bActualizar.setBorder(null);
        bActualizar.setText("");
        bActualizar.setMaximumSize(new java.awt.Dimension(25, 25));
        bActualizar.setOpaque(false);
        bActualizar.setPreferredSize(new java.awt.Dimension(25, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        getContentPane().add(bActualizar, gridBagConstraints);

        bNuevoCliente.setBackground(new java.awt.Color(255, 247, 162));
        bNuevoCliente.setBorder(null);
        bNuevoCliente.setText("Nueva Persona de Contacto");
        bNuevoCliente.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        bNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.2;
        getContentPane().add(bNuevoCliente, gridBagConstraints);

        bAgregarCliente.setText("Agregar Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(bAgregarCliente, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void bNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoClienteActionPerformed
        JDesktopPane jdp = getDesktopPane();
        NuevaPersonaContacto npc = new NuevaPersonaContacto();
        npc.pack();
        npc.setVisible(true);
        jdp.add(npc);
    }//GEN-LAST:event_bNuevoClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Controles.ButtonZ bActualizar;
    private swing.Controles.ButtonZ bAgregarCliente;
    private swing.Controles.ButtonZ bNuevoCliente;
    private swing.Controles.ComboBoxZ comboBoxZ1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.Controles.LabelZ lApelildos;
    private swing.Controles.LabelZ lCorreo;
    private swing.Controles.LabelZ lDireccion;
    private swing.Controles.LabelZ lNombres;
    private swing.Controles.LabelZ lTelefono;
    private swing.Controles.LabelZ labelZ1;
    private swing.Controles.TextAreaZ taDireccion;
    private swing.Controles.TextFieldZ tfApellido1;
    private swing.Controles.TextFieldZ tfApellido2;
    private swing.Controles.TextFieldZ tfCorreo;
    private swing.Controles.TextFieldZ tfNombre1;
    private swing.Controles.TextFieldZ tfNombre2;
    private swing.Controles.TextFieldZ tfTelefono;
    // End of variables declaration//GEN-END:variables
 private void setImagenes() {
        ImageIcon iconoActualizar;
        URL ruta = getClass().getClassLoader().getResource("img//update.png");
        iconoActualizar = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        bActualizar.setIcon(iconoActualizar);

    }
}
