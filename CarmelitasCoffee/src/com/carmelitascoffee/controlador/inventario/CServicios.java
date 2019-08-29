/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.inventario;

import com.carmelitascoffee.controlador.HibernateUtil;
import com.carmelitascoffee.pojo.Servicio;
import com.carmelitascoffee.pojo.Servicio;
import com.carmelitascoffee.vista.inventario.Servicios;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class CServicios {

    private DefaultTableModel modelo;
    private Session s;

    public CServicios(Session s, DefaultTableModel modelo) {
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
            criterio = s.createCriteria(com.carmelitascoffee.pojo.Servicio.class);

            List lista = criterio.list();
            for (Object object : lista) {
                com.carmelitascoffee.pojo.Servicio s = (com.carmelitascoffee.pojo.Servicio) object;

                Object c[] = {s.getIdServicio(), s.getDescripcion(), s.getUnidad(), s.getPrecio()};

                modelo.addRow(c);
            }
            tabla.setModel(modelo);

        } catch (Exception e) {
        }

    }

    public int AgregarServicio(Servicio servicio) {
        int id = 0;
        iniciarSesion();
        id = (int) s.save(servicio);
        terminarSesion();
        return id;

    }

    public void setServicio(Servicio servicio) {
        iniciarSesion();
        Servicio serbd = (Servicio) s.get(Servicio.class, servicio.getIdServicio());
        serbd.setDescripcion(servicio.getDescripcion());
        serbd.setPrecio(servicio.getPrecio());
        serbd.setUnidad(servicio.getUnidad());
        s.update(serbd);
        terminarSesion();
    }

    public List cargarFiltros(String filtro) {
        if (!filtro.equals("")) {
            Criterion descripcion;

            descripcion = Restrictions.like("descripcion", "%" + filtro + "%");

            Disjunction disjunction = Restrictions.or(descripcion);
            Criteria crit = s.createCriteria(Servicio.class).add(disjunction);

            return crit.list();
        } else {
            return s.createCriteria(Servicio.class).list();
        }
    }
}
