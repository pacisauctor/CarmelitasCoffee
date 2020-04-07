/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.ventas;

import com.carmelitascoffee.pojo.DetalleOrdenProducto;
import com.carmelitascoffee.pojo.DetalleOrdenServicio;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
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
    
    public List MostrarOrdenServicio(String numeroFactura){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(DetalleOrdenServicio.class,"os");
            crit.createAlias("os.servicio", "s");
            crit.createAlias("os.orden", "o");
            ProjectionList projs = Projections.projectionList();
            projs.add(Projections.property("s.descripcion"));
            projs.add(Projections.property("os.cantidad"));
            projs.add(Projections.property("os.descuento"));
            crit.setProjection(projs);
            Criterion factura = Restrictions.eq("o.numeroFactura",numeroFactura);
            List os = crit.add(factura).list();
            return os;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public List MostrarOrdenProducto(String numeroFactura){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(DetalleOrdenProducto.class,"op");
            crit.createAlias("op.producto", "p");
            crit.createAlias("op.orden", "o");
            ProjectionList projs = Projections.projectionList();
            projs.add(Projections.property("p.descripcion"));
            projs.add(Projections.property("op.cantidad"));
            projs.add(Projections.property("op.descuento"));
            crit.setProjection(projs);
            Criterion factura = Restrictions.eq("o.numeroFactura",numeroFactura);
            List op = crit.add(factura).list();
            return op;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public List MostrarOrdenes(){
        s.flush();
        s.clear();
        try{
            List ep = s.createSQLQuery("select \n" +
                                       "(c.nombres + c.apellidos) as Cliente,\n" +
                                       "e.cedula_identidad as `Cedula de empleado`,\n" +
                                       "o.numero_factura as Factura,\n" +
                                       "o.fecha_orden as `Fecha de orden`,\n" +
                                       "o.fecha_entrega as `Fecha de entrega`,\n" +
                                       "o.fecha_requerida as `Fecha requerida`,\n" +
                                       "o.tipo_orden as `Tipo de orden`\n" +
                                       "from orden o\n" +
                                       "inner join empleado e on e.id_empleado = o.id_empleado\n" +
                                       "inner join cliente c on c.id_cliente = o.id_cliente").list();
            return ep;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
