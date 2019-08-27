/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.ventas;

import com.carmelitascoffee.pojo.Cliente;
import com.carmelitascoffee.pojo.PersonaContacto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author darce
 */
public class CNuevoCliente {

    Session s;

    public CNuevoCliente(Session s) {
        this.s = s;
    }

    public boolean agregarCliente(Cliente cliente) {
        try {
            Transaction transaction = s.beginTransaction();
            s.save(cliente);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public PersonaContacto getPersonaContacto(int idPersonaContacto) {
        PersonaContacto pc = (PersonaContacto) s.get(PersonaContacto.class, idPersonaContacto);
        return pc;
    }

    public int siguienteIdCliente() {
        Query q = s.createSQLQuery("SELECT count(*) from cliente;");
        List l = q.list();
        return 1 + Integer.parseInt(l.get(0) + "");
    }

}
