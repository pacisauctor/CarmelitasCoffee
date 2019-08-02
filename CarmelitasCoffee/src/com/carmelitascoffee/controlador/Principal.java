/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador;

import com.carmelitascoffee.vista.inicio.InicioSesion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author darce
 */
public class Principal {

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            
            InicioSesion inicioSesion = new InicioSesion("Inicio de Sesión");
            inicioSesion.setSize(280, 350);
            inicioSesion.setVisible(true);
            inicioSesion.setLocationRelativeTo(null);

        });
    }
}
