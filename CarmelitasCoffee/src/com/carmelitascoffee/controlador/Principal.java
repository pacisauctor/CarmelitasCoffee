/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador;

import com.carmelitascoffee.vista.inicio.InicioSesion;
import org.hibernate.Session;

/**
 *
 * @author darce
 */
public class Principal {

    public static void main(String[] args) {
        /* Create and display the form */
        Session s = HibernateUtil.getSessionFactory().openSession();
        InicioSesion inicioSesion = new InicioSesion("Inicio de Sesión", s);
        inicioSesion.setSize(280, 350);
        inicioSesion.setVisible(true);
        inicioSesion.setLocationRelativeTo(null);

    }
}
