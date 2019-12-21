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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author darce
 */
public class CPersonaContactoVista {

    Session s;

    public CPersonaContactoVista(Session s) {
        this.s = s;
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
