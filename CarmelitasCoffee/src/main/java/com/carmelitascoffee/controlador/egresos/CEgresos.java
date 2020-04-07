/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.egresos;

import com.carmelitascoffee.pojo.Deposito;
import com.carmelitascoffee.pojo.EmpleadoPlanilla;
import com.carmelitascoffee.pojo.FacturaInsumo;
import com.carmelitascoffee.pojo.Mantenimiento;
import com.carmelitascoffee.pojo.PagoEmpleado;
import com.carmelitascoffee.pojo.PagoInsumo;
import com.carmelitascoffee.pojo.PagoMantenimiento;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author darce
 */
public class CEgresos {

    private final Session s;
    
     public CEgresos(Session s) {
        this.s = s;
    }
     
    public void ModificarPagoMantenimiento(int idPagoMantenimiento, Deposito deposito, Mantenimiento factura){
        s.flush();
        s.clear();
        Transaction t=null;
        try{
            s.flush();
            s.clear();
            t=s.beginTransaction();
            PagoMantenimiento pm = (PagoMantenimiento) s.createCriteria(PagoMantenimiento.class).add(Restrictions.eq("idPagoMantenimiento", idPagoMantenimiento)).uniqueResult();
            pm.setDeposito(deposito);
            pm.setMantenimiento(factura);
            s.update(pm);
            t.commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar\n"+e.getMessage());
            t.rollback();
            throw e;
        }
    } 
    
    public void InsertarPagoMantenimiento(Deposito deposito, Mantenimiento factura){
        s.flush();
        s.clear();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            PagoMantenimiento pm = new PagoMantenimiento();
            if(this.getPagoMantenimiento(deposito,factura)==null){
                pm.setDeposito(deposito);
                pm.setMantenimiento(factura);
                s.save(pm);
                t.commit();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ya existe un pago de mantenimiento con ese comprobante");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar\n"+e.getMessage());
            t.rollback();
            throw e;
        }
    } 
    
    public PagoMantenimiento getPagoMantenimiento (Deposito deposito,Mantenimiento factura){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(PagoMantenimiento.class,"pm");
            crit.createAlias("pm.deposito", "d");
            crit.createAlias("pm.mantenimiento", "m");
            Criterion d = Restrictions.eq("d.numeroComprobante", deposito.getNumeroComprobante());
            Criterion m = Restrictions.eq("m.numeroFactura", factura.getNumeroFactura());
            LogicalExpression exp = Restrictions.and(d,m);
            PagoMantenimiento pm = (PagoMantenimiento) crit.add(exp).uniqueResult();
            return pm;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
     
    public Mantenimiento getMantenimiento (String numeroFactura){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(Mantenimiento.class).add(Restrictions.eq("numeroFactura", numeroFactura));
            Mantenimiento m = (Mantenimiento) crit.list().get(0);
            return m;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"get FacturaInsumo " +e.getMessage());
            s.getTransaction().rollback();
            return null;
        }
    }
     
    public List BuscarNuevosPagosMantenimiento(String txt_busqueda) {
        s.flush();
        s.clear();
        Criteria crit = s.createCriteria(PagoMantenimiento.class,"pm");
        crit.createAlias("pm.deposito", "d");
        crit.createAlias("pm.mantenimiento", "m");
        crit.createAlias("m.empleado", "e");
        crit.createAlias("m.proveedor", "p");
        ProjectionList projs = Projections.projectionList();
        projs.add(Projections.property("d.numeroComprobante"));
        projs.add(Projections.property("m.numeroFactura"));
        projs.add(Projections.property("e.cedulaIdentidad"));     
        projs.add(Projections.property("p.nombreProveedor"));
        crit.setProjection(projs);
        Criterion deposito = Restrictions.like("d.numeroComprobante","%"+txt_busqueda+"%");
        Criterion factura = Restrictions.like("m.numeroFactura","%"+txt_busqueda+"%");
        Criterion cedula = Restrictions.like("e.cedulaIdentidad","%"+txt_busqueda+"%");
        Criterion proveedor = Restrictions.like("p.nombreProveedor","%"+txt_busqueda+"%");
        Disjunction exp = Restrictions.or(deposito,factura,cedula,proveedor);
        List pagos_mantenimiento = crit.add(exp).list();
        return pagos_mantenimiento;
    } 
     
    public void ModificarPagoInsumo(int idPagoInsumoo, Deposito deposito, FacturaInsumo factura){
        s.flush();
        s.clear();
        Transaction t=null;
        try{
            s.flush();
            s.clear();
            t=s.beginTransaction();
            PagoInsumo pi = (PagoInsumo) s.createCriteria(PagoInsumo.class).add(Restrictions.eq("idPagoInsumo", idPagoInsumoo)).uniqueResult();
            pi.setDeposito(deposito);
            pi.setFacturaInsumo(factura);
            s.update(pi);
            t.commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar\n"+e.getMessage());
            t.rollback();
            throw e;
        }
     } 
     
    public PagoInsumo getPagoInsumo (Deposito deposito){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(PagoInsumo.class,"pi");
            crit.createAlias("pi.deposito", "d");
            Criterion d = Restrictions.eq("d.numeroComprobante", deposito.getNumeroComprobante());
            PagoInsumo pi = (PagoInsumo) crit.add(d).uniqueResult();
            return pi;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    } 
     
    public void InsertarPagoInsumo(Deposito deposito, FacturaInsumo factura){
        s.flush();
        s.clear();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            PagoInsumo pi = new PagoInsumo();
            if(this.getPagoInsumo(deposito)==null){
                pi.setDeposito(deposito);
                pi.setFacturaInsumo(factura);
                s.save(pi);
                t.commit();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ya existe un pago de insumo con ese comprobante");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar\n"+e.getMessage());
            t.rollback();
            throw e;
        }
    } 
     
    public FacturaInsumo getFacturaInsumo (String numeroFactura){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(FacturaInsumo.class).add(Restrictions.eq("numeroFactura", numeroFactura));
            FacturaInsumo fi = (FacturaInsumo) crit.list().get(0);
            return fi;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"get FacturaInsumo " +e.getMessage());
            s.getTransaction().rollback();
            return null;
        }
    } 
     
    public List BuscarNuevosPagosInsumo(String txt_busqueda) {
        s.flush();
        s.clear();
        Criteria crit = s.createCriteria(PagoInsumo.class,"pi");
        crit.createAlias("pi.deposito", "d");
        crit.createAlias("pi.facturaInsumo", "fi");
        crit.createAlias("fi.empleado", "e");
        crit.createAlias("fi.proveedor", "p");
        ProjectionList projs = Projections.projectionList();
        projs.add(Projections.property("d.numeroComprobante"));
        projs.add(Projections.property("fi.numeroFactura"));
        projs.add(Projections.property("e.cedulaIdentidad"));     
        projs.add(Projections.property("p.nombreProveedor"));
        crit.setProjection(projs);
        Criterion deposito = Restrictions.like("d.numeroComprobante","%"+txt_busqueda+"%");
        Criterion factura = Restrictions.like("fi.numeroFactura","%"+txt_busqueda+"%");
        Criterion cedula = Restrictions.like("e.cedulaIdentidad","%"+txt_busqueda+"%");
        Criterion proveedor = Restrictions.like("p.nombreProveedor","%"+txt_busqueda+"%");
        Disjunction exp = Restrictions.or(deposito,factura,cedula,proveedor);
        List pagos_insumo = crit.add(exp).list();
        return pagos_insumo;
    }
     
    public List BuscarNuevosPagosEmpleado(String txt_busqueda) {
        s.flush();
        s.clear();
        Criteria crit = s.createCriteria(PagoEmpleado.class,"pe");
        crit.createAlias("pe.empleadoPlanilla", "ep");
        crit.createAlias("ep.empleado", "e");
        crit.createAlias("ep.planilla", "p");
        crit.createAlias("pe.deposito", "d");
        ProjectionList projs = Projections.projectionList();
        projs.add(Projections.property("e.cedulaIdentidad"));
        projs.add(Projections.property("p.numeroPlanilla"));
        projs.add(Projections.property("d.numeroComprobante"));     
        projs.add(Projections.property("pe.modoPago"));
        projs.add(Projections.property("pe.descripcion"));
        crit.setProjection(projs);
        Criterion cedula = Restrictions.like("e.cedulaIdentidad","%"+txt_busqueda+"%");
        Criterion planilla = Restrictions.like("p.numeroPlanilla","%"+txt_busqueda+"%");
        Criterion comprobante = Restrictions.like("d.numeroComprobante","%"+txt_busqueda+"%");
        Criterion modo = Restrictions.like("pe.modoPago","%"+txt_busqueda+"%");
        Criterion descripcion = Restrictions.like("pe.descripcion","%"+txt_busqueda+"%");
        Disjunction exp = Restrictions.or(cedula,planilla,comprobante,modo,descripcion);
        List pagos_empleado = crit.add(exp).list();
        return pagos_empleado;
    } 
     
    public void InsertarPagoEmpleado(Deposito deposito, EmpleadoPlanilla empleadoPlanilla, String modoPago, String descripcion){
        s.flush();
        s.clear();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            PagoEmpleado pe = new PagoEmpleado();
            if(this.getPagoEmpleado(this.getEmpleadoPlanilla(empleadoPlanilla.getEmpleado().getCedulaIdentidad(), empleadoPlanilla.getPlanilla().getNumeroPlanilla()))==null){
                pe.setDeposito(deposito);
                pe.setEmpleadoPlanilla(empleadoPlanilla);
                pe.setModoPago(modoPago);
                pe.setDescripcion(descripcion);
                s.save(pe);
                t.commit();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ya existe un pago para ese Empleado-Planilla");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar\n"+e.getMessage());
            t.rollback();
            throw e;
        }
    }
    
    public int getIdDeposito(String comprobante) {
        s.flush();
        s.clear();
        Criteria crit = s.createCriteria(Deposito.class).add(Restrictions.eq("numeroComprobante", comprobante));
        Deposito d = (Deposito) crit.list().get(0);
        return d.getIdDeposito();
    }
    
    public PagoEmpleado getPagoEmpleado (EmpleadoPlanilla empleadoPlanilla){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(PagoEmpleado.class,"pe");
            crit.createAlias("pe.empleadoPlanilla", "ep");
            crit.createAlias("ep.empleado", "e");
            crit.createAlias("ep.planilla", "p");
            Criterion ep = Restrictions.eq("ep.idEmpleadoPlanilla", empleadoPlanilla.getIdEmpleadoPlanilla());
            PagoEmpleado pe = (PagoEmpleado) crit.add(ep).uniqueResult();
            return pe;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public PagoEmpleado getPagoEmpleado (String cedulaEmpleado,String numeroPlanilla ){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(PagoEmpleado.class,"pe");
            crit.createAlias("pe.empleadoPlanilla", "ep");
            crit.createAlias("ep.empleado", "e");
            crit.createAlias("ep.planilla", "p");
            Criterion cedula = Restrictions.eq("e.cedulaIdentidad", cedulaEmpleado);
            Criterion planilla = Restrictions.eq("p.numeroPlanilla",numeroPlanilla);
            LogicalExpression ANDexp = Restrictions.and(cedula, planilla);
            PagoEmpleado pe = (PagoEmpleado) crit.add(ANDexp).uniqueResult();
            return pe;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public Deposito getDeposito (String comprobante){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(Deposito.class).add(Restrictions.eq("numeroComprobante", comprobante));
            Deposito d = (Deposito) crit.list().get(0);
            return d;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"get deposito" +e.getMessage());
            s.getTransaction().rollback();
            return null;
        }
    }
    
    public EmpleadoPlanilla getEmpleadoPlanilla (String cedulaEmpleado,String numeroPlanilla){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(EmpleadoPlanilla.class,"ep");
            crit.createAlias("ep.empleado", "e");
            crit.createAlias("ep.planilla", "p");
            Criterion empleado = Restrictions.eq("e.cedulaIdentidad",cedulaEmpleado);
            Criterion planilla = Restrictions.eq("p.numeroPlanilla",numeroPlanilla);
            LogicalExpression ANDexp = Restrictions.and(empleado, planilla);
            EmpleadoPlanilla ep = (EmpleadoPlanilla) crit.add(ANDexp).uniqueResult();
            return ep;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public void ModificarPagoEmpleado(int idPagoEmpleado, Deposito deposito, EmpleadoPlanilla empleadoPlanilla, String modoPago, String descripcion){
        s.flush();
        s.clear();
        Transaction t=null;
        try{
            s.flush();
            s.clear();
            t=s.beginTransaction();
            PagoEmpleado pe = (PagoEmpleado) s.createCriteria(PagoEmpleado.class).add(Restrictions.eq("idPagoEmpleado", idPagoEmpleado)).uniqueResult();
            pe.setDeposito(deposito);
            pe.setEmpleadoPlanilla(empleadoPlanilla);
            pe.setModoPago(modoPago);
            pe.setDescripcion(descripcion);
            s.update(pe);
            t.commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar\n"+e.getMessage());
            t.rollback();
            throw e;
        }
     } 
    
    public void ModificarDeposito(int idDeposito,String numeroComprobante, String banco, BigDecimal monto, String moneda, Date fecha){
        s.flush();
        s.clear();
        Transaction t=null;
        try{
            t=s.beginTransaction();
            Deposito d = (Deposito) s.createCriteria(Deposito.class).add(Restrictions.eq("idDeposito", idDeposito)).uniqueResult();
            d.setNumeroComprobante(numeroComprobante);
            d.setBanco(banco);
            d.setMonto(monto);
            d.setMoneda(moneda);
            d.setFecha(fecha);
            s.update(d);
            t.commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar\n"+e.getMessage());
            t.rollback();
            throw e;
        }
     } 
     
    public void InsertarDeposito(String numeroComprobante, String banco, BigDecimal monto, String moneda, Date fecha){
        s.flush();
        s.clear();
        Transaction t = null;
        try{
            t = s.beginTransaction();
            Deposito d = new Deposito();
            d.setNumeroComprobante(numeroComprobante);
            d.setBanco(banco);
            d.setMonto(monto);
            d.setMoneda(moneda);
            d.setFecha(fecha);
            s.save(d);
            t.commit();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar\n"+e.getMessage());
            t.rollback();
            throw e;
        }
    }
     
     public List BuscarPagosMantenimiento(String txt_busqueda) {
        s.flush();
        s.clear();
        Criteria crit = s.createCriteria(PagoMantenimiento.class,"pm");
        crit.createAlias("pm.mantenimiento", "m");
        crit.createAlias("m.proveedor", "p");
        crit.createAlias("pm.deposito", "d");
        ProjectionList projs = Projections.projectionList();
        projs.add(Projections.property("p.nombreProveedor"));
        projs.add(Projections.property("p.descripcion"));
        projs.add(Projections.property("m.numeroFactura"));
        projs.add(Projections.property("d.numeroComprobante"));     
        projs.add(Projections.property("d.monto"));
        projs.add(Projections.property("d.moneda"));
        projs.add(Projections.property("d.fecha"));
        crit.setProjection(projs);
        Criterion Proveedor = Restrictions.like("p.nombreProveedor","%"+txt_busqueda+"%");
        Criterion Descripcion = Restrictions.like("p.descripcion","%"+txt_busqueda+"%");
        Criterion Factura = Restrictions.like("m.numeroFactura","%"+txt_busqueda+"%");
        Criterion Comprobante = Restrictions.like("d.numeroComprobante","%"+txt_busqueda+"%");
        Criterion Moneda = Restrictions.like("d.moneda","%"+txt_busqueda+"%");
        Disjunction exp = Restrictions.or(Proveedor,Descripcion,Factura,Comprobante,Moneda);
        List pagos_mantenimiento = crit.add(exp).list();
        return pagos_mantenimiento;
    }
    
    public List BuscarPagosInsumo(String txt_busqueda) {
        s.flush();
        s.clear();
        Criteria crit = s.createCriteria(PagoInsumo.class,"pi");
        crit.createAlias("pi.facturaInsumo", "fi");
        crit.createAlias("fi.proveedor", "p");
        crit.createAlias("pi.deposito", "d");
        ProjectionList projs = Projections.projectionList();
        projs.add(Projections.property("p.nombreProveedor"));
        projs.add(Projections.property("p.descripcion"));
        projs.add(Projections.property("fi.numeroFactura"));
        projs.add(Projections.property("d.numeroComprobante"));     
        projs.add(Projections.property("d.monto"));
        projs.add(Projections.property("d.moneda"));
        projs.add(Projections.property("d.fecha"));
        crit.setProjection(projs);
        Criterion Proveedor = Restrictions.like("p.nombreProveedor","%"+txt_busqueda+"%");
        Criterion Descripcion = Restrictions.like("p.descripcion","%"+txt_busqueda+"%");
        Criterion Factura = Restrictions.like("fi.numeroFactura","%"+txt_busqueda+"%");
        Criterion Comprobante = Restrictions.like("d.numeroComprobante","%"+txt_busqueda+"%");
        Criterion Moneda = Restrictions.like("d.moneda","%"+txt_busqueda+"%");
        Disjunction exp = Restrictions.or(Proveedor,Descripcion,Factura,Comprobante,Moneda);
        List pagos_insumo = crit.add(exp).list();
        return pagos_insumo;
    }
    
    public List BuscarPagosEmpleado(String txt_busqueda) {
        s.flush();
        s.clear();
        Criteria crit = s.createCriteria(PagoEmpleado.class,"pe");
        crit.createAlias("pe.empleadoPlanilla", "ep");
        crit.createAlias("ep.empleado", "e");
        crit.createAlias("ep.planilla", "p");
        crit.createAlias("pe.deposito", "d");
        ProjectionList projs = Projections.projectionList();
        projs.add(Projections.property("e.primerNombre"),"Nombre");
        projs.add(Projections.property("e.primerApellido"),"Apellido");
        projs.add(Projections.property("p.numeroPlanilla"),"Planilla");
        projs.add(Projections.property("d.monto"),"Monto");     
        projs.add(Projections.property("d.moneda"),"Moneda");
        projs.add(Projections.property("pe.modoPago"),"Modo de pago");
        projs.add(Projections.property("pe.descripcion"),"Descripcion");
        crit.setProjection(projs);
        Criterion Nombre = Restrictions.like("e.primerNombre","%"+txt_busqueda+"%");
        Criterion Apellido = Restrictions.like("e.primerApellido","%"+txt_busqueda+"%");
        Criterion Planilla = Restrictions.like("p.numeroPlanilla","%"+txt_busqueda+"%");
        Criterion Moneda = Restrictions.like("d.moneda","%"+txt_busqueda+"%");
        Criterion Modo = Restrictions.like("pe.modoPago","%"+txt_busqueda+"%");
        Criterion Descripcion = Restrictions.like("pe.descripcion","%"+txt_busqueda+"%");
        Disjunction exp = Restrictions.or(Nombre,Apellido,Planilla,Moneda,Modo,Descripcion);
        List pagos_empleado = crit.add(exp).list();
        return pagos_empleado;
    }
    
    public List<Deposito> MostrarDepositos() {
        s.flush();
        s.clear();
        Criteria crit = s.createCriteria(Deposito.class);
        List<Deposito> depositos = crit.list();
        return depositos;
    }
    
   public List<Deposito> BuscarDepositos(String txt_busqueda) {
        s.flush();
        s.clear();
        Criterion comprobante = Restrictions.like("numeroComprobante","%"+txt_busqueda+"%");
        Criterion banco = Restrictions.like("banco","%"+txt_busqueda+"%");
        Criterion moneda = Restrictions.like("moneda","%"+txt_busqueda+"%");
        Disjunction exp = Restrictions.or(comprobante, banco,moneda);
        Criteria crit = s.createCriteria(Deposito.class).add(exp);
        List<Deposito> depositos = crit.list();
        return depositos;
    }
}
