/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.compras;

import com.carmelitascoffee.pojo.Proveedor;
import com.carmelitascoffee.pojo.Proveedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author darce
 */
public class CProveedores {

    Session s;

    public CProveedores(Session s) {
        this.s = s;
    }

    private void iniciarSesion() {
        s.beginTransaction();
    }

    private void terminarSesion() {
        s.getTransaction().commit();
    }

    public boolean agregarProveedores(Proveedor p) {
        try {
            s.beginTransaction();
            s.save(p);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List cargarFiltros(String filtro) {
        if (filtro.isEmpty()) {
            Criteria lista = s.createCriteria(Proveedor.class);
            return lista.list();
        } else {
            Criterion nombreProveedor, descripcion, telefono, direccion, correo;
            nombreProveedor = Restrictions.like("nombreProveedor", "%" + filtro + "%");
            descripcion = Restrictions.like("descripcion", "%" + filtro + "%");
            telefono = Restrictions.like("telefono", "%" + filtro + "%");
            direccion = Restrictions.like("direccion", "%" + filtro + "%");
            correo = Restrictions.like("correo", "%" + filtro + "%");

            Disjunction d = Restrictions.or(nombreProveedor, descripcion, telefono, correo, direccion);
            Criteria lista = s.createCriteria(Proveedor.class).add(d);
            return lista.list();
        }
    }
    /**
     *  ¿Es necesario decir que hace?
     * @param proveedor modificado
     * @param opcion [0: nombre, 1: descripcion, 2: telefono, 3: direccion, 4: correo]
     */
    public void setProveedor(Proveedor proveedor, int opcion) {
        iniciarSesion();
        Proveedor provBD = (Proveedor) s.get(Proveedor.class, proveedor.getIdProveedor());
        switch (opcion) {
            case 0:
                provBD.setNombreProveedor(proveedor.getNombreProveedor());
                break;
            case 1:
                provBD.setDescripcion(proveedor.getDescripcion());
                break;
            case 2:
                provBD.setTelefono(proveedor.getTelefono());
                break;
            case 3:
                provBD.setDireccion(proveedor.getDireccion());
                break;
            case 4:
                provBD.setCorreo(proveedor.getCorreo());
                break;
        }
      
        s.update(provBD);
        terminarSesion();
    }

    public List getProveedores() {
        return s.createCriteria(Proveedor.class).list();
    }

    public Proveedor getElementById(int id) {
        return (Proveedor) s.get(Proveedor.class, id);
    }
}
