package pojo;
// Generated 08-02-2019 12:56:10 PM by Hibernate Tools 4.3.1



/**
 * PagoEmpleado generated by hbm2java
 */
public class PagoEmpleado  implements java.io.Serializable {


     private Integer idPagoEmpleado;
     private Deposito deposito;
     private EmpleadoPlanilla empleadoPlanilla;
     private String modoPago;
     private String descripcion;

    public PagoEmpleado() {
    }

	
    public PagoEmpleado(Deposito deposito, EmpleadoPlanilla empleadoPlanilla) {
        this.deposito = deposito;
        this.empleadoPlanilla = empleadoPlanilla;
    }
    public PagoEmpleado(Deposito deposito, EmpleadoPlanilla empleadoPlanilla, String modoPago, String descripcion) {
       this.deposito = deposito;
       this.empleadoPlanilla = empleadoPlanilla;
       this.modoPago = modoPago;
       this.descripcion = descripcion;
    }
   
    public Integer getIdPagoEmpleado() {
        return this.idPagoEmpleado;
    }
    
    public void setIdPagoEmpleado(Integer idPagoEmpleado) {
        this.idPagoEmpleado = idPagoEmpleado;
    }
    public Deposito getDeposito() {
        return this.deposito;
    }
    
    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }
    public EmpleadoPlanilla getEmpleadoPlanilla() {
        return this.empleadoPlanilla;
    }
    
    public void setEmpleadoPlanilla(EmpleadoPlanilla empleadoPlanilla) {
        this.empleadoPlanilla = empleadoPlanilla;
    }
    public String getModoPago() {
        return this.modoPago;
    }
    
    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


