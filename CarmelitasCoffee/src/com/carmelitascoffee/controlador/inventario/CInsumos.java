/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.inventario;
import com.carmelitascoffee.controlador.HibernateUtil;
import com.carmelitascoffee.pojo.Insumo;
import com.carmelitascoffee.vista.inventario.Insumos;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.criterion.Criterion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
 



public class CInsumos {
    private DefaultTableModel modelo;
    private Session s;
    public CInsumos(Session s, DefaultTableModel modelo) {
           this.s = s;
           this.modelo = modelo;
        }
    
     private void iniciarSesion() {
        SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
        s = sessionfactory.openSession();
        s.getTransaction().begin();
    }

    private void terminarSesion() {
        s.getTransaction().commit();
        s.close();
    }
        
        public void LlenarTabla(JTable tabla)
        {
            Session se = com.carmelitascoffee.controlador.HibernateUtil.getSessionFactory().openSession();
            try {
            
                Criteria criterio;
                criterio = se.createCriteria(com.carmelitascoffee.pojo.Insumo.class);

                List lista = criterio.list();
                for (Object object : lista) {
                    com.carmelitascoffee.pojo.Insumo i = (com.carmelitascoffee.pojo.Insumo)object;

                    Object c[] = {i.getIdInsumo(),i.getDescripcion(), i.getCantidadInventario()};

                    modelo.addRow(c);
                }
                tabla.setModel(modelo);
        
            } catch (Exception e) {
            }finally{se.close();}

        }
        
        public int AgregarInsumo(Insumo insumo) {
        int id = 0;
        iniciarSesion();
        id = (int) s.save(insumo);
        terminarSesion();
        return id;

    }

    public void setInsumo(Insumo insumo) {
        iniciarSesion();
        Insumo insbd = (Insumo) s.get(Insumo.class, insumo.getIdInsumo());
        insbd.setDescripcion(insumo.getDescripcion());
        insbd.setCantidadInventario(insumo.getCantidadInventario());
        s.update(insbd);
        terminarSesion();
    }
    
     public List cargarFiltros(String filtro) {
        if (!filtro.equals("")) {
            Criterion descripcion;

            descripcion = Restrictions.like("descripcion", "%" + filtro + "%");
         

            Disjunction disjunction = Restrictions.or(descripcion);
            Criteria crit = s.createCriteria(Insumo.class).add(disjunction);

            return crit.list();
        } else {
            return s.createCriteria(Insumo.class).list();
        }
    }
}
