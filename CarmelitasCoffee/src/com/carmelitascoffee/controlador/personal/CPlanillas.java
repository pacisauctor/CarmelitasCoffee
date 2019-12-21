/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.personal;

import com.carmelitascoffee.pojo.EmpleadoPlanilla;
import com.carmelitascoffee.pojo.Planilla;
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
public class CPlanillas {

    private final Session s;

    public CPlanillas(Session s) {
        this.s = s;
    }

    public List MostrarEmpleadoPlanillas(String numeroPlanilla) {
        s.flush();
        s.clear();
        try {
            Criteria crit = s.createCriteria(EmpleadoPlanilla.class, "ep");
            crit.createAlias("ep.planilla", "p");
            crit.createAlias("ep.empleado", "e");
            ProjectionList projs = Projections.projectionList();
            projs.add(Projections.property("e.cedulaIdentidad"));
            projs.add(Projections.property("e.primerNombre"));
            projs.add(Projections.property("e.primerApellido"));
            projs.add(Projections.property("p.numeroPlanilla"));
            projs.add(Projections.property("ep.salario"));
            projs.add(Projections.property("ep.fechaRecibido"));
            crit.setProjection(projs);
            Criterion planilla = Restrictions.eq("p.numeroPlanilla", numeroPlanilla);
            List ep = crit.add(planilla).list();
            
            return ep;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public List<Planilla> MostrarPlanillas() {
        s.flush();
        s.clear();
        Criteria crit = s.createCriteria(Planilla.class);
        List<Planilla> planillas = crit.list();
        return planillas;
    }
}
