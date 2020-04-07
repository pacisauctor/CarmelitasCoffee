/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.ventas;

import com.carmelitascoffee.pojo.PersonaContacto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author darce
 */
public class CNuevaPersonaContacto {

    private Session s;

    public CNuevaPersonaContacto(Session s) {
        this.s = s;

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

    public int AgregarNPersonaContacto(PersonaContacto personacontacto) {
        int id = 0;
        iniciarSesion();
        id = (int) s.save(personacontacto);
        terminarSesion();
        return id;
    }

    public List cargarFiltros(String filtro) {
        if (!filtro.equals("")) {
            Criterion nombres, apellidos, telefono, correo, dirección;

            nombres = Restrictions.like("nombres", "%" + filtro + "%");
            apellidos = Restrictions.like("apellidos", "%" + filtro + "%");
            telefono = Restrictions.like("telefono", "%" + filtro + "%");
            correo = Restrictions.like("correo", "%" + filtro + "%");
            dirección = Restrictions.like("direccion", "%" + filtro + "%");

            Disjunction disjunction = Restrictions.or(nombres, apellidos, telefono, correo, dirección);
            Criteria crit = s.createCriteria(PersonaContacto.class).add(disjunction);

            return crit.list();
        } else {
            return null;
        }
    }
}
