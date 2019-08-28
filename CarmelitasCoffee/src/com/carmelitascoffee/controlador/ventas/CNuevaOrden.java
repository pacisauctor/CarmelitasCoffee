/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.ventas;

import com.carmelitascoffee.pojo.Producto;
import com.carmelitascoffee.pojo.Servicio;
import java.math.BigDecimal;
import org.hibernate.Session;

/**
 *
 * @author darce
 */
public class CNuevaOrden {

    Session s;
    public CNuevaOrden(Session s) {
        this.s = s;
    }

    public boolean existeProducto(int idProducto) {
       return true; 
    }

    public boolean existeServicio(int idServicio) {
        return true;
    }

    public Producto getProducto(int idProducto) {
        return new Producto(new BigDecimal(10), "CafeGourmet", 40);
    }

    public Servicio getServicios(int idServicio) {
        return new Servicio(new BigDecimal(20), "Pulir", "a");
    }
    
    
}
