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
            Criterion primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, correo, dirección;

            primerNombre = Restrictions.like("primerNombre", "%" + filtro + "%");
            segundoNombre = Restrictions.like("segundoNombre", "%" + filtro + "%");
            primerApellido = Restrictions.like("primerApellido", "%" + filtro + "%");
            segundoApellido = Restrictions.like("segundoApellido", "%" + filtro + "%");
            telefono = Restrictions.like("telefono", "%" + filtro + "%");
            correo = Restrictions.like("correo", "%" + filtro + "%");
            dirección = Restrictions.like("direccion", "%" + filtro + "%");

            Disjunction disjunction = Restrictions.or(primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, correo, dirección);
            Criteria crit = s.createCriteria(PersonaContacto.class).add(disjunction);

            return crit.list();
        } else {
            return s.createCriteria(PersonaContacto.class).list();
        }
    }

}
