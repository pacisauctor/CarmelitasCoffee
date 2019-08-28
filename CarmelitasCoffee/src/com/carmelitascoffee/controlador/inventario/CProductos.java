/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.inventario;

import com.carmelitascoffee.controlador.HibernateUtil;
import com.carmelitascoffee.pojo.Producto;
import com.carmelitascoffee.vista.inventario.Productos;
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

public class CProductos {
    private DefaultTableModel modelo;
    private Session s;
    public CProductos(Session s, DefaultTableModel modelo) {
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
           
            try {
            
                Criteria criterio;
                criterio = s.createCriteria(com.carmelitascoffee.pojo.Producto.class);

                List lista = criterio.list();
                for (Object object : lista) {
                    com.carmelitascoffee.pojo.Producto p = (com.carmelitascoffee.pojo.Producto)object;

                    Object c[] = {p.getIdProducto(),p.getDescripcion(), p.getCantidadEnInventario() ,p.getPrecio()};

                    modelo.addRow(c);
                }
                tabla.setModel(modelo);
        
            } catch (Exception e) {
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
        
       /* public void ModificarProducto(JTable tabla, Productos panel){
            modelo.setRowCount(0);
            com.carmelitascoffee.vista.inventario.Productos pro = panel;
           // s.beginTransaction();
            try {           
                Criteria criterio;
                criterio = s.createCriteria(com.carmelitascoffee.pojo.Producto.class).add(Restrictions.idEq(pro.cod.getText()));
                
                List lista = criterio.list();
                JOptionPane.showMessageDialog(null ,lista.size());
                for (Object object : lista) {
                    com.carmelitascoffee.pojo.Producto p = (com.carmelitascoffee.pojo.Producto)object;
                    p.setIdProducto(Integer.parseInt(pro.cod.getText()));
                    p.setDescripcion(pro.nom.getText());
                    p.setCantidadEnInventario(Integer.parseInt(pro.cant.getText()));
                    p.setPrecio(BigDecimal.valueOf(Double.parseDouble(pro.pre.getText())));
                    s.update(p);
                    s.getTransaction().commit();
                }
        
            } catch (Exception e) {
                System.err.println(e);
            }
            LlenarTabla(tabla);
        }*/

    
        
        
}
