package com.carmelitascoffee.pojo;
// Generated 08-28-2019 08:03:01 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * EmpleadoPlanilla generated by hbm2java
 */
public class EmpleadoPlanilla  implements java.io.Serializable {


     private int idEmpleadoPlanilla;
     private Empleado empleado;
     private Planilla planilla;
     private BigDecimal salario;
     private Date fechaRecibido;
     private Set pagoEmpleados = new HashSet(0);

    public EmpleadoPlanilla() {
    }

	
    public EmpleadoPlanilla(int idEmpleadoPlanilla) {
        this.idEmpleadoPlanilla = idEmpleadoPlanilla;
    }
    public EmpleadoPlanilla(int idEmpleadoPlanilla, Empleado empleado, Planilla planilla, BigDecimal salario, Date fechaRecibido, Set pagoEmpleados) {
       this.idEmpleadoPlanilla = idEmpleadoPlanilla;
       this.empleado = empleado;
       this.planilla = planilla;
       this.salario = salario;
       this.fechaRecibido = fechaRecibido;
       this.pagoEmpleados = pagoEmpleados;
    }
   
    public int getIdEmpleadoPlanilla() {
        return this.idEmpleadoPlanilla;
    }
    
    public void setIdEmpleadoPlanilla(int idEmpleadoPlanilla) {
        this.idEmpleadoPlanilla = idEmpleadoPlanilla;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Planilla getPlanilla() {
        return this.planilla;
    }
    
    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }
    public BigDecimal getSalario() {
        return this.salario;
    }
    
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    public Date getFechaRecibido() {
        return this.fechaRecibido;
    }
    
    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }
    public Set getPagoEmpleados() {
        return this.pagoEmpleados;
    }
    
    public void setPagoEmpleados(Set pagoEmpleados) {
        this.pagoEmpleados = pagoEmpleados;
    }




}

