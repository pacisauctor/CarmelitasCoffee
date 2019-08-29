/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.ajustes;

import com.carmelitascoffee.pojo.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author darce
 */
public class CAdministrarUsuarios {

    Session s;

    public CAdministrarUsuarios(Session s) {
        this.s = s;
    }
    
    public List getUsuarios()
    {
        Criteria crit = s.createCriteria(Usuario.class);
        return crit.list();
    }

}
