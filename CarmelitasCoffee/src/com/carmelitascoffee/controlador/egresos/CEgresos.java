/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.egresos;

import com.carmelitascoffee.controlador.HibernateUtil;
import com.carmelitascoffee.pojo.Deposito;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
/**
 *
 * @author darce
 */
public class CEgresos {

    private final Session s;
    
     public CEgresos(Session s) {
        this.s = s;
    }

    public List<Deposito> MostrarDepositos() {
        Criteria crit = s.createCriteria(Deposito.class);
        List<Deposito> depositos = crit.list();
        return depositos;
    }
   
}
