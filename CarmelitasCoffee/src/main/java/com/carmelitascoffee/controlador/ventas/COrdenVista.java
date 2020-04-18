/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.ventas;

import com.carmelitascoffee.pojo.DetalleOrdenProducto;
import com.carmelitascoffee.pojo.DetalleOrdenServicio;
import com.carmelitascoffee.pojo.Orden;
import com.carmelitascoffee.pojo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author darce
 */
public class COrdenVista {

    private final Session s;

    public COrdenVista(Session s) {
        this.s = s;
    }

    public List MostrarOrdenServicio(String numeroFactura) {
        s.flush();
        s.clear();
        try {
            Criteria c = s.createCriteria(Orden.class);
            Criterion cn = Restrictions.eq("numeroFactura", numeroFactura);
            c.add(cn);
            Orden orden = (Orden) c.list().get(0);
            return  new ArrayList<>(orden.getDetalleOrdenServicios());
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public List MostrarOrdenProducto(String numeroFactura) {
        s.flush();
        s.clear();
        try {
            Criteria c = s.createCriteria(Orden.class);
            Criterion cn = Restrictions.eq("numeroFactura", numeroFactura);
            c.add(cn);
            Orden orden = (Orden) c.list().get(0);
            return  new ArrayList<>(orden.getDetalleOrdenProductos());
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public List MostrarOrdenes() {
        s.flush();
        s.clear();
        try {
            Criteria criterio;
            criterio = s.createCriteria(Orden.class);

            List lista = criterio.list();
            return lista;
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
