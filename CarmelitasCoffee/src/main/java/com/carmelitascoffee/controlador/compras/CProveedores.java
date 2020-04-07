/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.compras;

import com.carmelitascoffee.pojo.Proveedor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author darce
 */
public class CProveedores {
    Session s;

    public CProveedores(Session s) {
        this.s = s;
    }
    public boolean agregarProveedores(Proveedor p)
    {
        try {
            s.beginTransaction();
            s.save(p);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List getProveedores() {
        return s.createCriteria(Proveedor.class).list();
    }
}
