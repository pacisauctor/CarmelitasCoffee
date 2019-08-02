package pojo;
// Generated 08-02-2019 12:56:10 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer idCliente;
     private PersonaContacto personaContacto;
     private String numeroRuc;
     private String nombres;
     private String apellidos;
     private String telefono;
     private String correo;
     private String direccion;
     private Set ordens = new HashSet(0);

    public Cliente() {
    }

	
    public Cliente(PersonaContacto personaContacto, String numeroRuc) {
        this.personaContacto = personaContacto;
        this.numeroRuc = numeroRuc;
    }
    public Cliente(PersonaContacto personaContacto, String numeroRuc, String nombres, String apellidos, String telefono, String correo, String direccion, Set ordens) {
       this.personaContacto = personaContacto;
       this.numeroRuc = numeroRuc;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.telefono = telefono;
       this.correo = correo;
       this.direccion = direccion;
       this.ordens = ordens;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public PersonaContacto getPersonaContacto() {
        return this.personaContacto;
    }
    
    public void setPersonaContacto(PersonaContacto personaContacto) {
        this.personaContacto = personaContacto;
    }
    public String getNumeroRuc() {
        return this.numeroRuc;
    }
    
    public void setNumeroRuc(String numeroRuc) {
        this.numeroRuc = numeroRuc;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Set getOrdens() {
        return this.ordens;
    }
    
    public void setOrdens(Set ordens) {
        this.ordens = ordens;
    }




}


