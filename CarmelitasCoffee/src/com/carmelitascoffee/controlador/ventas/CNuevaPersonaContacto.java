/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.ventas;
import com.carmelitascoffee.controlador.HibernateUtil;
import com.carmelitascoffee.pojo.PersonaContacto;
import com.carmelitascoffee.pojo.PersonaContacto;
import com.carmelitascoffee.vista.ventas.NuevaPersonaContacto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

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
     
    }
    


