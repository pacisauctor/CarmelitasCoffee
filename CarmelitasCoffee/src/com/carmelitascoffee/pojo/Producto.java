package com.carmelitascoffee.pojo;
// Generated 08-05-2019 01:35:41 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private int idProducto;
     private String descripcion;
     private BigDecimal precio;
     private Integer cantidadEnInventario;
     private Set detalleOrdenProductos = new HashSet(0);

    public Producto() {
    }

	
    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }
    public Producto(int idProducto, String descripcion, BigDecimal precio, Integer cantidadEnInventario, Set detalleOrdenProductos) {
       this.idProducto = idProducto;
       this.descripcion = descripcion;
       this.precio = precio;
       this.cantidadEnInventario = cantidadEnInventario;
       this.detalleOrdenProductos = detalleOrdenProductos;
    }

    public Producto(BigDecimal precio, String descripcion, int cantidadEnInventario) {
       this.precio = precio;
       this.descripcion = descripcion;
       this.cantidadEnInventario = cantidadEnInventario;
    }
   
    public int getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public Integer getCantidadEnInventario() {
        return this.cantidadEnInventario;
    }
    
    public void setCantidadEnInventario(Integer cantidadEnInventario) {
        this.cantidadEnInventario = cantidadEnInventario;
    }
    public Set getDetalleOrdenProductos() {
        return this.detalleOrdenProductos;
    }
    
    public void setDetalleOrdenProductos(Set detalleOrdenProductos) {
        this.detalleOrdenProductos = detalleOrdenProductos;
    }




}


