/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.personal;

import com.carmelitascoffee.pojo.Contrato;
import com.carmelitascoffee.pojo.Empleado;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author darce
 */
public class CAgregarEmpleado {

    Session s;

    public CAgregarEmpleado(Session s) {
        this.s = s;
    }

    public void addEmpleadoYContrato(Empleado empleado, Contrato contrato) {
        s.beginTransaction();
        s.save(empleado);
        s.getTransaction().commit();
        s.beginTransaction();
        contrato.setEmpleado(buscarEmpleado(empleado));
        s.save(contrato);
        s.getTransaction().commit();
    }

    private Empleado buscarEmpleado(Empleado empleado) {
        String cedula = empleado.getCedulaIdentidad();
        Criteria crit = s.createCriteria(Empleado.class).add(Restrictions.eq("cedulaIdentidad", cedula));
        empleado = (Empleado) crit.list().get(0);
        return empleado;
    }

}
