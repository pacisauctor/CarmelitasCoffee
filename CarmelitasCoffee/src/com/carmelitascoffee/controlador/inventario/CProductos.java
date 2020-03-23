/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.inventario;

import com.carmelitascoffee.pojo.Producto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.criterion.Criterion;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

public class CProductos {

    private DefaultTableModel modelo;
    private Session s;

    public CProductos(Session s, DefaultTableModel modelo) {
        this.s = s;
        this.modelo = modelo;
    }

    private void iniciarSesion() {
        s.beginTransaction();
    }

    private void terminarSesion() {
        s.getTransaction().commit();
    }

    public void LlenarTabla(JTable tabla) {

        try {
            modelo.setRowCount(0);
            Criteria criterio;
            criterio = s.createCriteria(Producto.class);

            List lista = criterio.list();
            for (Object object : lista) {
                com.carmelitascoffee.pojo.Producto p = (com.carmelitascoffee.pojo.Producto) object;

                Object c[] = {p.getIdProducto(), p.getDescripcion(), p.getCantidadEnInventario(), p.getPrecio(), p.isExentoIva()};

                modelo.addRow(c);
            }
            tabla.setModel(modelo);

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public int AgregarProducto(Producto producto) {
        int id = 0;
        iniciarSesion();
        id = (int) s.save(producto);
        terminarSesion();
        return id;

    }

    public void setProducto(Producto producto) {
        iniciarSesion();
        Producto probd = (Producto) s.get(Producto.class, producto.getIdProducto());
        probd.setDescripcion(producto.getDescripcion());
        probd.setPrecio(producto.getPrecio());
        probd.setCantidadEnInventario(producto.getCantidadEnInventario());
        s.update(probd);
        terminarSesion();
    }

    public List cargarFiltros(String filtro) {
        if (!filtro.equals("")) {
            Criterion descripcion;

            descripcion = Restrictions.like("descripcion", "%" + filtro + "%");

            Disjunction disjunction = Restrictions.or(descripcion);
            Criteria crit = s.createCriteria(Producto.class).add(disjunction);

            return crit.list();
        } else {
            return s.createCriteria(Producto.class).list();
        }
    }

    public Producto obtenerPorId(int id) {
        return (Producto) s.get(Producto.class, id);
    }
}
