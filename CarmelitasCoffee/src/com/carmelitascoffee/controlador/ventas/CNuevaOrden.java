/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.ventas;

import com.carmelitascoffee.pojo.Cliente;
import com.carmelitascoffee.pojo.DetalleOrdenProducto;
import com.carmelitascoffee.pojo.DetalleOrdenServicio;
import com.carmelitascoffee.pojo.Empleado;
import com.carmelitascoffee.pojo.Orden;
import com.carmelitascoffee.pojo.Producto;
import com.carmelitascoffee.pojo.Servicio;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
        Criteria criteria = s.createCriteria(Producto.class).add(Restrictions.eq("idProducto", idProducto));
        if (criteria.list().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean existeServicio(int idServicio) {
        Criteria criteria = s.createCriteria(Servicio.class).add(Restrictions.eq("idServicio", idServicio));
        if (criteria.list().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public Producto getProducto(int idProducto) {
        Criteria criteria = s.createCriteria(Producto.class).add(Restrictions.eq("idProducto", idProducto));
        if (criteria.list().isEmpty()) {
            return null;
        } else {
            return (Producto) criteria.list().get(0);
        }
    }

    public Servicio getServicios(int idServicio) {
        Criteria criteria = s.createCriteria(Servicio.class).add(Restrictions.eq("idServicio", idServicio));
        if (criteria.list().isEmpty()) {
            return null;
        } else {
            return (Servicio) criteria.list().get(0);
        }
    }

    public Empleado getEmpleado(int idEmpleado) {
        Criteria criteria = s.createCriteria(Empleado.class).add(Restrictions.eq("idEmpleado", idEmpleado));
        if (criteria.list().isEmpty()) {
            return null;
        } else {
            return (Empleado) criteria.list().get(0);
        }
    }

    public Cliente getCliente(int idCliente) {
        Criteria criteria = s.createCriteria(Cliente.class).add(Restrictions.eq("idCliente", idCliente));
        if (criteria.list().isEmpty()) {
            return null;
        } else {
            return (Cliente) criteria.list().get(0);
        }
    }

    public Orden agregarOrden(Orden o) {
        s.beginTransaction();
        s.save(o);
        s.getTransaction().commit();
        Criteria crit = s.createCriteria(Orden.class).add(Restrictions.eq("numeroFactura", o.getNumeroFactura()));
        o = (Orden) crit.list().get(0);
        return o;
    }

    public void agregarDetalleOrdenServicio(DetalleOrdenServicio dos) {
        s.beginTransaction();
        s.save(dos);
        s.getTransaction().commit();
    }

    public void agregarDetalleOrdenProducto(DetalleOrdenProducto dop) {
        s.beginTransaction();
        s.save(dop);
        s.getTransaction().commit();
    }
}
