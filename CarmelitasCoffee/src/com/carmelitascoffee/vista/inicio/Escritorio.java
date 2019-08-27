/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.vista.inicio;

import com.carmelitascoffee.controlador.inicio.CEscritorio;
import com.carmelitascoffee.vista.compras.Compras;
import com.carmelitascoffee.vista.compras.Proveedores;
import com.carmelitascoffee.vista.egresos.Egresos;
import com.carmelitascoffee.vista.inventario.Insumos;
import com.carmelitascoffee.vista.inventario.Productos;
import com.carmelitascoffee.vista.inventario.Servicios;
import com.carmelitascoffee.vista.personal.AgregarEmpleado;
import com.carmelitascoffee.vista.personal.ModificarEmpleado;
import com.carmelitascoffee.vista.personal.Planillas;
import com.carmelitascoffee.vista.ventas.NuevaOrden;
import com.carmelitascoffee.vista.ventas.NuevaPersonaContacto;
import com.carmelitascoffee.vista.ventas.NuevoCliente;
import com.carmelitascoffee.vista.ventas.OrdenVista;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.hibernate.Session;
import swing.Contenedores.PanelZ;

/**
 *
 * @author darce
 */
public class Escritorio extends JFrame {

    private String title = "";
    private String rol;
    private Image imagenFondo;
    int x = 0, y = 0;
    private int idEmpleado;
    private Session s;
    private CEscritorio controlador;

    public Escritorio() {
        initComponents();
    }

    public Escritorio(String title, String rol, int idEmpleado, Session s) {
        this.title = title;
        this.rol = rol;
        this.idEmpleado = idEmpleado;
        this.s = s;
        controlador = new CEscritorio(s);
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

        pCompras = new swing.Contenedores.PanelZ();
        bCompras = new swing.Controles.ButtonZ();
        bProveedores = new swing.Controles.ButtonZ();
        pEgresos = new swing.Contenedores.PanelZ();
        bEgresos = new swing.Controles.ButtonZ();
        pInventario = new swing.Contenedores.PanelZ();
        bInsumos = new swing.Controles.ButtonZ();
        bProductos = new swing.Controles.ButtonZ();
        bServicios = new swing.Controles.ButtonZ();
        pPersonal = new swing.Contenedores.PanelZ();
        bAgregarEmpleado = new swing.Controles.ButtonZ();
        bModificarEmpleado = new swing.Controles.ButtonZ();
        bPlanillas = new swing.Controles.ButtonZ();
        pVentas = new swing.Contenedores.PanelZ();
        bNuevaOrden = new swing.Controles.ButtonZ();
        bNuevaPersonaContacto = new swing.Controles.ButtonZ();
        bNuevoCliente = new swing.Controles.ButtonZ();
        bOrdenVista = new swing.Controles.ButtonZ();
        pAjustes = new swing.Contenedores.PanelZ();
        bAdminUser = new swing.Controles.ButtonZ();
        bCerrarSesion = new swing.Controles.ButtonZ();
        pToolBar = new javax.swing.JPanel();
        lTitle = new javax.swing.JLabel();
        bCerrar = new javax.swing.JButton();
        bMaximizar = new javax.swing.JButton();
        bMinimizar = new javax.swing.JButton();
        pContent = new javax.swing.JPanel();
        pMenu = new swing.Contenedores.PanelZ();
        dpEscritorio = new swing.Contenedores.DesktopPaneZ();

        pCompras.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(28, 40, 51))); // NOI18N
        pCompras.setName("Compras"); // NOI18N
        pCompras.setLayout(new java.awt.GridBagLayout());

        bCompras.setText("");
        bCompras.setToolTipText("Administrar Compras");
        bCompras.setMaximumSize(new java.awt.Dimension(50, 50));
        bCompras.setMinimumSize(new java.awt.Dimension(50, 50));
        bCompras.setName("Compras"); // NOI18N
        bCompras.setPreferredSize(new java.awt.Dimension(50, 50));
        bCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bComprasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        pCompras.add(bCompras, gridBagConstraints);

        bProveedores.setText("");
        bProveedores.setToolTipText("Administrar Proveedores");
        bProveedores.setMaximumSize(new java.awt.Dimension(50, 50));
        bProveedores.setMinimumSize(new java.awt.Dimension(50, 50));
        bProveedores.setPreferredSize(new java.awt.Dimension(50, 50));
        bProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProveedoresActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        pCompras.add(bProveedores, gridBagConstraints);

        pEgresos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Egresos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(28, 40, 51))); // NOI18N
        pEgresos.setName("Egresos"); // NOI18N
        pEgresos.setLayout(new java.awt.GridBagLayout());

        bEgresos.setText("");
        bEgresos.setToolTipText("Administrar Egresos");
        bEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEgresosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pEgresos.add(bEgresos, gridBagConstraints);

        pInventario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(28, 40, 51))); // NOI18N
        pInventario.setName("Inventario"); // NOI18N
        pInventario.setLayout(new java.awt.GridBagLayout());

        bInsumos.setText("");
        bInsumos.setToolTipText("Administrar Insumos");
        bInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsumosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pInventario.add(bInsumos, gridBagConstraints);

        bProductos.setText("");
        bProductos.setToolTipText("Administrar Productos");
        bProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProductosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pInventario.add(bProductos, gridBagConstraints);

        bServicios.setText("");
        bServicios.setToolTipText("Administrar Servicios");
        bServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bServiciosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pInventario.add(bServicios, gridBagConstraints);

        pPersonal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(28, 40, 51))); // NOI18N
        pPersonal.setName("Personal"); // NOI18N
        pPersonal.setLayout(new java.awt.GridBagLayout());

        bAgregarEmpleado.setText("");
        bAgregarEmpleado.setToolTipText("Agregar Empleado");
        bAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarEmpleadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pPersonal.add(bAgregarEmpleado, gridBagConstraints);

        bModificarEmpleado.setText("");
        bModificarEmpleado.setToolTipText("Modificar Empleado");
        bModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarEmpleadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pPersonal.add(bModificarEmpleado, gridBagConstraints);

        bPlanillas.setText("");
        bPlanillas.setToolTipText("Administrar Planillas");
        bPlanillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPlanillasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pPersonal.add(bPlanillas, gridBagConstraints);

        pVentas.setBorder(javax.swing.BorderFactory.createTitledBorder("Ventas"));
        pVentas.setName("Ventas"); // NOI18N
        pVentas.setLayout(new java.awt.GridBagLayout());

        bNuevaOrden.setText("");
        bNuevaOrden.setToolTipText("Nueva Orden");
        bNuevaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevaOrdenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pVentas.add(bNuevaOrden, gridBagConstraints);

        bNuevaPersonaContacto.setText("");
        bNuevaPersonaContacto.setToolTipText("Nueva Persona Contacto");
        bNuevaPersonaContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevaPersonaContactoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pVentas.add(bNuevaPersonaContacto, gridBagConstraints);

        bNuevoCliente.setText("");
        bNuevoCliente.setToolTipText("Nuevo Cliente");
        bNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pVentas.add(bNuevoCliente, gridBagConstraints);

        bOrdenVista.setText("");
        bOrdenVista.setToolTipText("Orden Vista");
        bOrdenVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdenVistaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pVentas.add(bOrdenVista, gridBagConstraints);

        pAjustes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ajustes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(28, 40, 51))); // NOI18N
        pAjustes.setName("Ajustes"); // NOI18N
        pAjustes.setLayout(new java.awt.GridBagLayout());

        bAdminUser.setText("");
        bAdminUser.setToolTipText("Administrar Usuarios");
        bAdminUser.setName("Compras"); // NOI18N
        bAdminUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdminUserActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pAjustes.add(bAdminUser, gridBagConstraints);

        bCerrarSesion.setText("");
        bCerrarSesion.setToolTipText("Cerrar Sesión");
        bCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarSesionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pAjustes.add(bCerrarSesion, gridBagConstraints);

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
        pToolBar.setForeground(new java.awt.Color(255, 255, 255));
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
        lTitle.setForeground(new java.awt.Color(255, 213, 162));
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

        bMaximizar.setBackground(new java.awt.Color(178, 122, 57));
        bMaximizar.setToolTipText("");
        bMaximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bMaximizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bMaximizarMouseExited(evt);
            }
        });
        bMaximizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMaximizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pToolBar.add(bMaximizar, gridBagConstraints);

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

        pContent.setBackground(new java.awt.Color(255, 213, 162));
        pContent.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pContent.setLayout(new java.awt.GridBagLayout());

        pMenu.setLayout(new javax.swing.BoxLayout(pMenu, javax.swing.BoxLayout.Y_AXIS));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        pContent.add(pMenu, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pContent.add(dpEscritorio, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        getContentPane().add(pContent, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void pToolBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pToolBarMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_pToolBarMouseDragged

    private void pToolBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pToolBarMousePressed

        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_pToolBarMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getContentPane().setBackground(new Color(0, 0, 204));
        //creando iconos 
        setIconosVentana();
        setIconosBotones();

    }//GEN-LAST:event_formWindowOpened

    private void pToolBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pToolBarMouseClicked
        if (evt.getClickCount() == 2) {
            restaurarVentana();
        }
    }//GEN-LAST:event_pToolBarMouseClicked

    private void bEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEgresosActionPerformed
        Egresos egresos = new Egresos(s);
        egresos.setVisible(true);
        egresos.pack();
        dpEscritorio.add(egresos);
    }//GEN-LAST:event_bEgresosActionPerformed

    private void bAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarEmpleadoActionPerformed
        AgregarEmpleado agregarEmpleado = new AgregarEmpleado();
        agregarEmpleado.setVisible(true);
        agregarEmpleado.pack();
        dpEscritorio.add(agregarEmpleado);
        agregarEmpleado.setSize(dpEscritorio.getSize());
    }//GEN-LAST:event_bAgregarEmpleadoActionPerformed

    private void bNuevaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevaOrdenActionPerformed
        NuevaOrden nuevaOrden = new NuevaOrden();
        nuevaOrden.setVisible(true);
        nuevaOrden.pack();
        dpEscritorio.add(nuevaOrden);
        nuevaOrden.setSize(dpEscritorio.getSize());

    }//GEN-LAST:event_bNuevaOrdenActionPerformed

    private void bNuevaPersonaContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevaPersonaContactoActionPerformed
        NuevaPersonaContacto nuevaPersonaContacto = new NuevaPersonaContacto();
        nuevaPersonaContacto.setVisible(true);
        nuevaPersonaContacto.pack();
        dpEscritorio.add(nuevaPersonaContacto);
        nuevaPersonaContacto.setSize(dpEscritorio.getSize());
    }//GEN-LAST:event_bNuevaPersonaContactoActionPerformed

    private void bNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoClienteActionPerformed
        NuevoCliente nuevoCliente = new NuevoCliente();
        nuevoCliente.setVisible(true);
        nuevoCliente.pack();
        dpEscritorio.add(nuevoCliente);
        nuevoCliente.setSize(dpEscritorio.getSize());
    }//GEN-LAST:event_bNuevoClienteActionPerformed

    private void bOrdenVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdenVistaActionPerformed
        OrdenVista ordenVista = new OrdenVista();
        ordenVista.setVisible(true);
        ordenVista.pack();
        dpEscritorio.add(ordenVista);
    }//GEN-LAST:event_bOrdenVistaActionPerformed

    private void bComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bComprasActionPerformed
        Compras compras = new Compras();
        compras.setVisible(true);
        compras.pack();
        dpEscritorio.add(compras);
    }//GEN-LAST:event_bComprasActionPerformed

    private void bProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProveedoresActionPerformed
        Proveedores proveedores = new Proveedores();
        proveedores.setVisible(true);
        proveedores.pack();
        dpEscritorio.add(proveedores);
    }//GEN-LAST:event_bProveedoresActionPerformed

    private void bInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInsumosActionPerformed
        Insumos insumos = new Insumos(s);
        insumos.pack();
        insumos.setVisible(true);
        dpEscritorio.add(insumos);
    }//GEN-LAST:event_bInsumosActionPerformed

    private void bProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProductosActionPerformed
        Productos productos = new Productos(s);
        productos.setVisible(true);
        productos.pack();
        dpEscritorio.add(productos);
    }//GEN-LAST:event_bProductosActionPerformed

    private void bServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bServiciosActionPerformed
        Servicios servicios = new Servicios(s);
        servicios.setVisible(true);
        servicios.pack();
        dpEscritorio.add(servicios);
    }//GEN-LAST:event_bServiciosActionPerformed

    private void bModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarEmpleadoActionPerformed
        ModificarEmpleado modificarEmpleado = new ModificarEmpleado();
        modificarEmpleado.setVisible(true);
        modificarEmpleado.pack();
        dpEscritorio.add(modificarEmpleado);
    }//GEN-LAST:event_bModificarEmpleadoActionPerformed

    private void bPlanillasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPlanillasActionPerformed
        Planillas p = new Planillas();
        p.setVisible(true);
        p.pack();
        dpEscritorio.add(p);
    }//GEN-LAST:event_bPlanillasActionPerformed

    private void bCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCerrarMouseEntered
        //[0,153,255]
        bCerrar.setBackground(new Color(215, 163, 100));
    }//GEN-LAST:event_bCerrarMouseEntered

    private void bCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCerrarMouseExited
        bCerrar.setBackground(new Color(178, 122, 57));
    }//GEN-LAST:event_bCerrarMouseExited

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bCerrarActionPerformed

    private void bMaximizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMaximizarMouseEntered
        bMaximizar.setBackground(new Color(215, 163, 100));
    }//GEN-LAST:event_bMaximizarMouseEntered

    private void bMaximizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMaximizarMouseExited
        bMaximizar.setBackground(new Color(178, 122, 57));
    }//GEN-LAST:event_bMaximizarMouseExited

    private void bMaximizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMaximizarActionPerformed
        restaurarVentana();
    }//GEN-LAST:event_bMaximizarActionPerformed

    private void bMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMinimizarMouseEntered
        bMinimizar.setBackground(new Color(215, 163, 100));
    }//GEN-LAST:event_bMinimizarMouseEntered

    private void bMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMinimizarMouseExited
        bMinimizar.setBackground(new Color(178, 122, 57));
    }//GEN-LAST:event_bMinimizarMouseExited

    private void bMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_bMinimizarActionPerformed

    private void bAdminUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdminUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bAdminUserActionPerformed

    private void bCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bCerrarSesionActionPerformed

    public void addPaneles() {
        if ("maestro".equals(rol)) {
            pMenu.add(pVentas, "Ventas");
            setIconosMenu(pVentas);
            pMenu.add(pCompras, "Compras");
            setIconosMenu(pCompras);
            pMenu.add(pEgresos, "Egresos");
            setIconosMenu(pEgresos);
            pMenu.add(pInventario, "Inventario");
            setIconosMenu(pInventario);
            pMenu.add(pPersonal, "Personal");
            setIconosMenu(pPersonal);
            pMenu.add(pAjustes, "Ajustes");
            setIconosMenu(pAjustes);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Controles.ButtonZ bAdminUser;
    private swing.Controles.ButtonZ bAgregarEmpleado;
    private javax.swing.JButton bCerrar;
    private swing.Controles.ButtonZ bCerrarSesion;
    private swing.Controles.ButtonZ bCompras;
    private swing.Controles.ButtonZ bEgresos;
    private swing.Controles.ButtonZ bInsumos;
    private javax.swing.JButton bMaximizar;
    private javax.swing.JButton bMinimizar;
    private swing.Controles.ButtonZ bModificarEmpleado;
    private swing.Controles.ButtonZ bNuevaOrden;
    private swing.Controles.ButtonZ bNuevaPersonaContacto;
    private swing.Controles.ButtonZ bNuevoCliente;
    private swing.Controles.ButtonZ bOrdenVista;
    private swing.Controles.ButtonZ bPlanillas;
    private swing.Controles.ButtonZ bProductos;
    private swing.Controles.ButtonZ bProveedores;
    private swing.Controles.ButtonZ bServicios;
    private swing.Contenedores.DesktopPaneZ dpEscritorio;
    private javax.swing.JLabel lTitle;
    private swing.Contenedores.PanelZ pAjustes;
    private swing.Contenedores.PanelZ pCompras;
    private javax.swing.JPanel pContent;
    private swing.Contenedores.PanelZ pEgresos;
    private swing.Contenedores.PanelZ pInventario;
    private swing.Contenedores.PanelZ pMenu;
    private swing.Contenedores.PanelZ pPersonal;
    private javax.swing.JPanel pToolBar;
    private swing.Contenedores.PanelZ pVentas;
    // End of variables declaration//GEN-END:variables

    private void restaurarVentana() {
        if (getExtendedState() == MAXIMIZED_BOTH) {
            this.setExtendedState(NORMAL);
        } else {
            this.setExtendedState(MAXIMIZED_BOTH);
        }
    }

    private void agregarFondoPantalla(Image image) {
        dpEscritorio.setImagenfondo(imagenFondo);
    }

    private void setIconosMenu(PanelZ panelZ) {
        URL ruta;
        switch (panelZ.getName()) {
            case "Personal":
                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//personal//agregarEmpleado.png");
                bAgregarEmpleado.setFondo(new ImageIcon(ruta).getImage());

                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//personal//administrarEmpleado.png");
                bModificarEmpleado.setFondo(new ImageIcon(ruta).getImage());

                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//personal//planilla.png");
                bPlanillas.setFondo(new ImageIcon(ruta).getImage());
                break;
            case "Egresos":
                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//egresos//egresos3.png");
                bEgresos.setFondo(new ImageIcon(ruta).getImage());
                break;
            case "Ventas":
                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//ventas//nuevoCliente.png");
                bNuevoCliente.setFondo(new ImageIcon(ruta).getImage());

                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//ventas//nuevoContacto.png");
                bNuevaPersonaContacto.setFondo(new ImageIcon(ruta).getImage());

                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//ventas//ordenNueva.png");
                bNuevaOrden.setFondo(new ImageIcon(ruta).getImage());

                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//ventas//ordenVista.png");
                bOrdenVista.setFondo(new ImageIcon(ruta).getImage());
                break;
            case "Compras":
                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//compras//compras2.png");
                bCompras.setFondo(new ImageIcon(ruta).getImage());

                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//compras//proveedor.png");
                bProveedores.setFondo(new ImageIcon(ruta).getImage());
                break;
            case "Inventario":
                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//inventario//insumo.png");
                bInsumos.setFondo(new ImageIcon(ruta).getImage());

                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//inventario//producto2.png");
                bProductos.setFondo(new ImageIcon(ruta).getImage());

                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//inventario//servicio4.png");
                bServicios.setFondo(new ImageIcon(ruta).getImage());
                break;
            case "Ajustes":
                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//ajuste//administrarUsuario.png");
                bAdminUser.setFondo(new ImageIcon(ruta).getImage());

                ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//menu//ajuste//cerrarSesion2.png");
                bCerrarSesion.setFondo(new ImageIcon(ruta).getImage());
                break;

        }
    }

    private void setIconosBotones() {

    }

    private void setIconosVentana() {
        ImageIcon iconoCerrar, iconoMinimizar, iconoMaximizar;
        URL ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//close.png");
        iconoCerrar = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        bCerrar.setIcon(iconoCerrar);
        ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//minimize.png");
        iconoMinimizar = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        bMinimizar.setIcon(iconoMinimizar);
        ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//maximizar.png");
        iconoMaximizar = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        bMaximizar.setIcon(iconoMaximizar);
        //escribiendo título
        if ("".equals(title)) {
            title = "Nueva Ventana";
        }
        lTitle.setText(title);
        ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//fondo.jpg");
        imagenFondo = new ImageIcon(ruta).getImage();
        agregarFondoPantalla(imagenFondo);
        ruta = getClass().getClassLoader().getResource("com//carmelitascoffee//img//coffee.png");
        lTitle.setIcon(new ImageIcon(ruta));
    }

}
