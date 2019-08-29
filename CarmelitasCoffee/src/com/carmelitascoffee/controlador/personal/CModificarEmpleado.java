/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.personal;

import com.carmelitascoffee.pojo.Contrato;
import com.carmelitascoffee.pojo.Empleado;
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
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author darce
 */
public class CModificarEmpleado {
    private final Session s;
    
     public CModificarEmpleado(Session s) {
        this.s = s;
    }
     
    public void ModificarContrato(String puesto,String sueldo,String comisiones,Date fechacontrato,String estado){
        s.flush();
        s.clear();
        Transaction t=null;
        try{
            t=s.beginTransaction();
            Contrato c = (Contrato) s.createCriteria(Contrato.class).add(Restrictions.eq("puesto", puesto)).uniqueResult();
            c.setSueldo(new BigDecimal(sueldo));
            c.setComisiones(new BigDecimal(comisiones));
            c.setFechaContratacion(fechacontrato);
            c.setEstado(estado);
            s.update(c);
            t.commit();
            JOptionPane.showMessageDialog(null,"Actualizacion terminada");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar\n"+e.getMessage());
            t.rollback();
            throw e;
        }
     }  
     
    public void ModificarEmpleado(String cedula, String pnombre,String snombre,String papellido,String sapellido,String sexo,String direccion,String Telefono,String estadocivil){
        s.flush();
        s.clear();
        Transaction t=null;
        try{
            t=s.beginTransaction();
            Empleado e = (Empleado) s.createCriteria(Empleado.class).add(Restrictions.eq("cedulaIdentidad", cedula)).uniqueResult();
            e.setPrimerNombre(pnombre);
            e.setSegundoNombre(snombre);
            e.setPrimerApellido(papellido);
            e.setSegundoApellido(sapellido);
            e.setSexo(sexo.toCharArray()[0]);
            e.setDireccion(direccion);
            e.setTelefono(Telefono);
            e.setEstadoCivil(estadocivil);
            s.update(e);
            t.commit();
            JOptionPane.showMessageDialog(null,"Actualizacion terminada");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo insertar\n"+e.getMessage());
            t.rollback();
            throw e;
        }
     } 
    
    public Contrato getContratoActivo (String cedula){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(Contrato.class,"c");
            crit.createAlias("c.empleado", "e");
            Criterion empleado = Restrictions.eq("e.cedulaIdentidad", cedula);
            Criterion estado = Restrictions.eq("c.estado","Activo");
            LogicalExpression ANDexp = Restrictions.and(empleado, estado);
            Contrato c = (Contrato) crit.add(ANDexp).uniqueResult();
            return c;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    } 
     
    public Empleado getEmpleado (String cedula){
        s.flush();
        s.clear();
        try{
            Criteria crit = s.createCriteria(Empleado.class).add(Restrictions.eq("cedulaIdentidad", cedula));
            Empleado e = (Empleado) crit.list().get(0);
            return e;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"get empleado: " +e.getMessage());
            s.getTransaction().rollback();
            return null;
        }
    }
     
    public List<Empleado> BuscarEmpleados(String txt_busqueda) {
        s.flush();
        s.clear();
        Criterion cedula = Restrictions.like("cedulaIdentidad","%"+txt_busqueda+"%");
        Criterion pnombre = Restrictions.like("primerNombre","%"+txt_busqueda+"%");
        Criterion snombre = Restrictions.like("segundoNombre","%"+txt_busqueda+"%");
        Criterion papellido = Restrictions.like("primerApellido","%"+txt_busqueda+"%");
        Criterion sapellido = Restrictions.like("segundoApellido","%"+txt_busqueda+"%");
        Criterion direccion = Restrictions.like("direccion","%"+txt_busqueda+"%");
        Criterion telefono = Restrictions.like("telefono","%"+txt_busqueda+"%");
        Criterion correo = Restrictions.like("correo","%"+txt_busqueda+"%");
        Criterion estadocivil = Restrictions.like("estadoCivil","%"+txt_busqueda+"%");
        Criterion escolaridad = Restrictions.like("gradoEscolaridad","%"+txt_busqueda+"%");
        Disjunction exp = Restrictions.or(cedula,pnombre,snombre,papellido,sapellido,direccion,telefono,correo,estadocivil,escolaridad);
        Criteria crit = s.createCriteria(Empleado.class).add(exp);
        List<Empleado> empleados = crit.list();
        return empleados;
    }
}
