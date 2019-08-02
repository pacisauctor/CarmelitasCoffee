package pojo;
// Generated 08-02-2019 12:56:10 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private Integer idProducto;
     private String descripcion;
     private BigDecimal precio;
     private Integer cantidadEnInventario;
     private Set detalleOrdenProductos = new HashSet(0);

    public Producto() {
    }

    public Producto(String descripcion, BigDecimal precio, Integer cantidadEnInventario, Set detalleOrdenProductos) {
       this.descripcion = descripcion;
       this.precio = precio;
       this.cantidadEnInventario = cantidadEnInventario;
       this.detalleOrdenProductos = detalleOrdenProductos;
    }
   
    public Integer getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(Integer idProducto) {
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


