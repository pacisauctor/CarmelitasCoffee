/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.controlador.inicio;

import com.carmelitascoffee.reportes.OrdEmpl;
import com.carmelitascoffee.reportes.OrdenesPorEmpleado;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author darce
 */
public class CEscritorio {

    Session s;

    public CEscritorio(Session s) {
        this.s = s;
    }

    public void cargarReporteOrdPorEmpleado(OrdenesPorEmpleado DataSource) {
        try {
            List list = s.createSQLQuery(""
                    + "select \n"
                    + "	concat(e.primer_nombre, \" \", e.segundo_nombre) as nombre_empleado, \n"
                    + "    count(o.id_orden) as numero_ordenes \n"
                    + " from empleado e inner join orden o on o.id_empleado = e.id_empleado \n"
                    + " group by nombre_empleado;").list();
            Iterator itera = list.iterator();
            while (itera.hasNext()) {
                Object[] next = (Object[]) itera.next();
                String nombre = next[0] +"";
                BigInteger numero = (BigInteger) next[1];
                long n = numero.longValue();
                DataSource.addOrdEmpl(new OrdEmpl(nombre, numero.longValue()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
