/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelitascoffee.reportes;

/**
 *
 * @author darce
 */
public class OrdEmpl {

    String nombre;
    Long cantOrdenes;

    public OrdEmpl(String nombre, Long cantOrdenes) {
        this.nombre = nombre;
        this.cantOrdenes = cantOrdenes;
    }

    public OrdEmpl() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantOrdenes() {
        return cantOrdenes;
    }

    public void setCantOrdenes(Long cantOrdenes) {
        this.cantOrdenes = cantOrdenes;
    }

}
