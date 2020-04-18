/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.JButton;
import swing.Controles.ButtonZ;

/**
 *
 * @author Axel Eleazar García Darce
 */
public class Utilidades {

    public String division;
    public Object frame;

    public Utilidades(Object frame) {
        String sSistemaOperativo = System.getProperty("os.name");
        if (sSistemaOperativo.equals("Linux")) {
            division = "//";
        } else {
            division = "\\\\";
        }
        this.frame = frame;
    }

    public String slash() {

        return division;
    }

    public static void cambiarColorBotonEntered(MouseEvent evt) {
        try {
            ButtonZ b = (ButtonZ) evt.getComponent();
            b.setBackground(new Color(89, 42, 42));
        } catch (ClassCastException e) {
            JButton b = (JButton) evt.getComponent();
            b.setBackground(new Color(89, 42, 42));
        }

    }

    public static void cambiarColorBotonExited(MouseEvent evt) {
        try {
            ButtonZ b = (ButtonZ) evt.getComponent();
            b.setBackground(new Color(89, 24, 24));
        } catch (ClassCastException e) {
            JButton b = (JButton) evt.getComponent();
            b.setBackground(new Color(89, 24, 24));
        }
    }

    public URL getImg(String nombre) {
        return frame.getClass().getClassLoader().getResource("com" + division + "carmelitascoffee" + division + "img" + division + nombre);
    }

    public URL getImgMenu(String nombre) {
        return frame.getClass().getClassLoader().getResource("com" + division + "carmelitascoffee" + division + "img" + division + "menu" + division + nombre);
    }

    public URL getImgMenuAjuste(String nombre) {
        return frame.getClass().getClassLoader().getResource("com" + division + "carmelitascoffee" + division + "img" + division + "menu" + division + "ajuste" + division + nombre);
    }

    public URL getImgMenuCompras(String nombre) {
        return frame.getClass().getClassLoader().getResource("com" + division + "carmelitascoffee" + division + "img" + division + "menu" + division + "compras" + division + nombre);
    }

    public URL getImgMenuEgresos(String nombre) {
        return frame.getClass().getClassLoader().getResource("com" + division + "carmelitascoffee" + division + "img" + division + "menu" + division + "egresos" + division + nombre);
    }

    public URL getImgMenuInventario(String nombre) {
        return frame.getClass().getClassLoader().getResource("com" + division + "carmelitascoffee" + division + "img" + division + "menu" + division + "inventario" + division + nombre);
    }

    public URL getImgMenuPersonal(String nombre) {
        return frame.getClass().getClassLoader().getResource("com" + division + "carmelitascoffee" + division + "img" + division + "menu" + division + "personal" + division + nombre);
    }

    public URL getImgMenuVentas(String nombre) {
        return frame.getClass().getClassLoader().getResource("com" + division + "carmelitascoffee" + division + "img" + division + "menu" + division + "ventas" + division + nombre);
    }

    public double getIVA() {
        return 0.25;
    }
}
