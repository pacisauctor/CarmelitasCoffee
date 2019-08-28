/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.ventas;

import com.carmelitascoffee.pojo.Cliente;
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
public class CClienteVista {

    Session s;

    public CClienteVista(Session s) {
        this.s = s;
    }

    public List cargarFiltros(String filtro) {
        if (filtro.isEmpty()) {
            Criteria lista = s.createCriteria(Cliente.class);
            return lista.list();
        } else {
            Criterion numeroRUC, nombres, apellidos, telefono, correo, direccion;
            numeroRUC = Restrictions.like("numeroRuc", "%" + filtro + "%");
            nombres = Restrictions.like("nombres", "%" + filtro + "%");
            apellidos = Restrictions.like("apellidos", "%" + filtro + "%");
            telefono = Restrictions.like("telefono", "%" + filtro + "%");
            correo = Restrictions.like("correo", "%" + filtro + "%");
            direccion = Restrictions.like("direccion", "%" + filtro + "%");

            Disjunction d = Restrictions.or(numeroRUC, nombres, apellidos, telefono, correo, direccion);
            Criteria lista = s.createCriteria(Cliente.class).add(d);
            return lista.list();
        }
    }

}
