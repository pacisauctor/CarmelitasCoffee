/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador;

import com.carmelitascoffee.vista.inicio.InicioSesion;
import com.carmelitascoffee.vista.inicio.LoadingApplication;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author darce
 */
public class Principal {

    public static void main(String[] args) {
        /* Create and display the form */
        CargandoApp app = new CargandoApp();
        app.start();
        Session s = HibernateUtil.getSessionFactory().openSession();
        app.terminar();
        InicioSesion inicioSesion = new InicioSesion("Inicio de Sesión", s);
        inicioSesion.setSize(280, 350);
        inicioSesion.setVisible(true);
        inicioSesion.setLocationRelativeTo(null);

    }
}

class CargandoApp extends Thread {

    boolean cargando = true;
    LoadingApplication primero;

    public CargandoApp() {
        primero = new LoadingApplication();
    }

    public void terminar() {
        cargando = false;
        primero.setVisible(false);
    }

    @Override
    public void run() {
        while (cargando) {
            try {
                Thread.sleep(200);
                
                primero.cambiarValorAumentandoEn(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(CargandoApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
