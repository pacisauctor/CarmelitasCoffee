package pojo;
// Generated 08-02-2019 12:56:10 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * FacturaInsumo generated by hbm2java
 */
public class FacturaInsumo  implements java.io.Serializable {


     private Integer idFacturaInsumo;
     private Empleado empleado;
     private Proveedor proveedor;
     private String numeroFactura;
     private Date fechaOrden;
     private Date fechaRecibido;
     private Set pagoInsumos = new HashSet(0);
     private Set detalleFacturaInsumos = new HashSet(0);

    public FacturaInsumo() {
    }

	
    public FacturaInsumo(Empleado empleado, Proveedor proveedor) {
        this.empleado = empleado;
        this.proveedor = proveedor;
    }
    public FacturaInsumo(Empleado empleado, Proveedor proveedor, String numeroFactura, Date fechaOrden, Date fechaRecibido, Set pagoInsumos, Set detalleFacturaInsumos) {
       this.empleado = empleado;
       this.proveedor = proveedor;
       this.numeroFactura = numeroFactura;
       this.fechaOrden = fechaOrden;
       this.fechaRecibido = fechaRecibido;
       this.pagoInsumos = pagoInsumos;
       this.detalleFacturaInsumos = detalleFacturaInsumos;
    }
   
    public Integer getIdFacturaInsumo() {
        return this.idFacturaInsumo;
    }
    
    public void setIdFacturaInsumo(Integer idFacturaInsumo) {
        this.idFacturaInsumo = idFacturaInsumo;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public String getNumeroFactura() {
        return this.numeroFactura;
    }
    
    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }
    public Date getFechaOrden() {
        return this.fechaOrden;
    }
    
    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }
    public Date getFechaRecibido() {
        return this.fechaRecibido;
    }
    
    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }
    public Set getPagoInsumos() {
        return this.pagoInsumos;
    }
    
    public void setPagoInsumos(Set pagoInsumos) {
        this.pagoInsumos = pagoInsumos;
    }
    public Set getDetalleFacturaInsumos() {
        return this.detalleFacturaInsumos;
    }
    
    public void setDetalleFacturaInsumos(Set detalleFacturaInsumos) {
        this.detalleFacturaInsumos = detalleFacturaInsumos;
    }




}


