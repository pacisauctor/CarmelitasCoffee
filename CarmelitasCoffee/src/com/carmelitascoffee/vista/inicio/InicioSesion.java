/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.vista.inicio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author darce
 */
public class InicioSesion extends JFrame {

    private String title = "";
    int x = 0, y = 0;

    public InicioSesion() {
        initComponents();
    }

    public InicioSesion(String title) {
        this.title = title;
        initComponents();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Creates new form FrameZ
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pToolBar = new javax.swing.JPanel();
        lTitle = new javax.swing.JLabel();
        bCerrar = new javax.swing.JButton();
        bMinimizar = new javax.swing.JButton();
        pContent = new javax.swing.JPanel();
        labelZ1 = new swing.Controles.LabelZ();
        labelZ2 = new swing.Controles.LabelZ();
        textFieldZ1 = new swing.Controles.TextFieldZ();
        passwordFieldZ1 = new swing.Controles.PasswordFieldZ();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneZ1 = new swing.Controles.TextPaneZ();
        buttonZ1 = new swing.Controles.ButtonZ();

        setBackground(new java.awt.Color(97, 53, 1));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pToolBar.setBackground(new java.awt.Color(178, 122, 57));
        pToolBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pToolBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pToolBarMouseDragged(evt);
            }
        });
        pToolBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pToolBarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pToolBarMousePressed(evt);
            }
        });
        pToolBar.setLayout(new java.awt.GridBagLayout());

        lTitle.setBackground(new java.awt.Color(178, 122, 57));
        lTitle.setForeground(new java.awt.Color(255, 255, 255));
        lTitle.setText("Texto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        pToolBar.add(lTitle, gridBagConstraints);

        bCerrar.setBackground(new java.awt.Color(178, 122, 57));
        bCerrar.setToolTipText("");
        bCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCerrarMouseExited(evt);
            }
        });
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pToolBar.add(bCerrar, gridBagConstraints);

        bMinimizar.setBackground(new java.awt.Color(178, 122, 57));
        bMinimizar.setToolTipText("");
        bMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bMinimizarMouseExited(evt);
            }
        });
        bMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMinimizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pToolBar.add(bMinimizar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(pToolBar, gridBagConstraints);

        pContent.setBackground(new java.awt.Color(255, 247, 162));
        pContent.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pContent.setLayout(new java.awt.GridBagLayout());

        labelZ1.setText("Nombre de usuario");
        labelZ1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pContent.add(labelZ1, gridBagConstraints);

        labelZ2.setText("Contraseña");
        labelZ2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pContent.add(labelZ2, gridBagConstraints);

        textFieldZ1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 40, 51), 2, true));
        textFieldZ1.setForeground(new java.awt.Color(28, 40, 51));
        textFieldZ1.setText("");
        textFieldZ1.setCaretColor(new java.awt.Color(255, 255, 255));
        textFieldZ1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textFieldZ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldZ1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pContent.add(textFieldZ1, gridBagConstraints);

        passwordFieldZ1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 40, 51), 2, true));
        passwordFieldZ1.setForeground(new java.awt.Color(28, 40, 51));
        passwordFieldZ1.setText("");
        passwordFieldZ1.setCaretColor(new java.awt.Color(255, 255, 255));
        passwordFieldZ1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pContent.add(passwordFieldZ1, gridBagConstraints);

        textPaneZ1.setEditable(false);
        textPaneZ1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 40, 51), 0, true));
        textPaneZ1.setForeground(new java.awt.Color(28, 40, 51));
        textPaneZ1.setText("En caso de olvidar sus datos de usuario  comunicarselo al debido responsable ");
        jScrollPane1.setViewportView(textPaneZ1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pContent.add(jScrollPane1, gridBagConstraints);

        buttonZ1.setText("Iniciar");
        buttonZ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZ1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pContent.add(buttonZ1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.6;
        getContentPane().add(pContent, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void bCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCerrarMouseExited
        bCerrar.setBackground(new Color(178, 122, 57));
    }//GEN-LAST:event_bCerrarMouseExited

    private void bCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCerrarMouseEntered
        //[0,153,255]
        bCerrar.setBackground(new Color(215, 163, 100));
    }//GEN-LAST:event_bCerrarMouseEntered

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bCerrarActionPerformed

    private void bMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMinimizarMouseEntered
        bMinimizar.setBackground(new Color(215, 163, 100));
    }//GEN-LAST:event_bMinimizarMouseEntered

    private void bMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMinimizarMouseExited
        bMinimizar.setBackground(new Color(178, 122, 57));
    }//GEN-LAST:event_bMinimizarMouseExited

    private void bMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_bMinimizarActionPerformed

    private void pToolBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pToolBarMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_pToolBarMouseDragged

    private void pToolBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pToolBarMousePressed

        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_pToolBarMousePressed

    private void pToolBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pToolBarMouseClicked
        if (evt.getClickCount() == 2) {
            restaurarVentana();
        }
    }//GEN-LAST:event_pToolBarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getContentPane().setBackground(new Color(0, 0, 204));
        //creando iconos 
        ImageIcon iconoCerrar, iconoMinimizar, iconoMaximizar;
        URL ruta = getClass().getClassLoader().getResource("img//close.png");
        iconoCerrar = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        bCerrar.setIcon(iconoCerrar);
        ruta = getClass().getClassLoader().getResource("img//minimize.png");
        iconoMinimizar = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        bMinimizar.setIcon(iconoMinimizar);
        //escribiendo título
        if ("".equals(title)) {
            title = "Nueva Ventana";
        }
        lTitle.setText(title);
        ruta = getClass().getClassLoader().getResource("img//user.jpg");
        this.setIconImage(new ImageIcon(ruta).getImage());
        lTitle.setIcon(new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));

    }//GEN-LAST:event_formWindowOpened

    private void textFieldZ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldZ1ActionPerformed

    }//GEN-LAST:event_textFieldZ1ActionPerformed

    private void buttonZ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonZ1ActionPerformed
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int frameWidth = 1000;
        int frameHeight = 700;
        Escritorio frameZ = new Escritorio("Carmelitas Coffeee", "Maestro");
        Point initialLocation = new Point((int) toolkit.getScreenSize().getWidth() / 2 - frameWidth / 2,
                (int) toolkit.getScreenSize().getHeight() / 2 - frameHeight / 2);
        Dimension initialDimension = new Dimension(frameWidth, frameHeight);
        FullResizibleFrame fullResizibleFrame;
        fullResizibleFrame = new FullResizibleFrame(initialDimension, initialLocation, frameZ);
        frameZ.addPaneles();
        this.setVisible(false);
        frameZ.setVisible(true);
    }//GEN-LAST:event_buttonZ1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bMinimizar;
    private swing.Controles.ButtonZ buttonZ1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lTitle;
    private swing.Controles.LabelZ labelZ1;
    private swing.Controles.LabelZ labelZ2;
    private javax.swing.JPanel pContent;
    private javax.swing.JPanel pToolBar;
    private swing.Controles.PasswordFieldZ passwordFieldZ1;
    private swing.Controles.TextFieldZ textFieldZ1;
    private swing.Controles.TextPaneZ textPaneZ1;
    // End of variables declaration//GEN-END:variables

    private void restaurarVentana() {
        if (getExtendedState() == MAXIMIZED_BOTH) {
            this.setExtendedState(NORMAL);
        } else {
            this.setExtendedState(MAXIMIZED_BOTH);
        }
    }
}
