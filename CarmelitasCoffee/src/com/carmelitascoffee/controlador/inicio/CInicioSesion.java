/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.inicio;

import com.carmelitascoffee.controlador.HibernateUtil;
import com.carmelitascoffee.pojo.Empleado;
import com.carmelitascoffee.pojo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author darce
 */
public class CInicioSesion {

    private final Session s;

    public CInicioSesion(Session s) {
        this.s = s;
    }

    public boolean validarUsuario(String nombre, String clave) {

        Criteria crit = s.createCriteria(Usuario.class).add(Restrictions.eq("nombre", nombre));
        if (crit.list().isEmpty()) {
            return false;
        } else {
            Usuario usuario = (Usuario) crit.list().get(0);
            return usuario.getClaveAcceso().equals(clave);
        }

    }

    public String getRol(String nombre) {

        Criteria crit = s.createCriteria(Usuario.class).add(Restrictions.eq("nombre", nombre));
        Usuario usuario = (Usuario) crit.list().get(0);

        return usuario.getRol();
    }

    public int getIdUsuario(String nombre) {
        Criteria crit = s.createCriteria(Usuario.class).add(Restrictions.eq("nombre", nombre));
        Usuario usuario = (Usuario) crit.list().get(0);
        Empleado empleado = usuario.getEmpleado();
        return empleado.getIdEmpleado();
    }
}
