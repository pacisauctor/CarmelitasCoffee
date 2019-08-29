/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.reportes;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author darce
 */
public class OrdenesPorEmpleado implements JRDataSource {

    private List<OrdEmpl> lista = new ArrayList<OrdEmpl>();
    private int indiceFact = -1;

    @Override
    public boolean next() throws JRException {
        return ++indiceFact < lista.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        if ("nombre_empleado".equals(jrf.getName())) {
            valor = lista.get(indiceFact).getNombre();
        }
        if ("numero_ordenes".equals(jrf.getName())) {
            valor = lista.get(indiceFact).getCantOrdenes();
        }
        return valor;
    }

    public void addOrdEmpl(OrdEmpl oe) {
        this.lista.add(oe);
    }

    public void Limpiar() {
        if (indiceFact == -1) {
            indiceFact = -1;
        } else {
            indiceFact -= 1;
        }
    }
}
