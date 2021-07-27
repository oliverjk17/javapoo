/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author OLIVER
 */
public class Empleado extends Persona{
    public String nit;
    public String codigo_empleado;
    public String puesto;
    
    public Empleado() {
    }

   
  public Empleado( String nombre, String apellido,String codigo_empleado, String puesto,String direccion, String telefono, String nit, String fecha_nacimiento) {
        super(nombre, apellido, direccion, telefono, nit, fecha_nacimiento);
        this.nit = nit;
    }

   

    public String getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(String codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
     public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
  
  @Override
    public void agregar()
    {
        
        System.out.println("Nit: "+getNit());
        System.out.println("Nombres: " + getNombre());
        System.out.println("Apellidos: "+ getApellido());
        System.out.println("Direccion: "+ getDireccion());
        System.out.println("Telefono: "+ getTelefono());
        System.out.println("Fecha de nacimiento: "+ getFecha_nacimiento());
        System.out.println("C/E: "+getCodigo_empleado());
        System.out.println("puesto: "+getPuesto());
        System.out.println("_____________________");
    }
    @Override
    public void modificar()
    {
        System.out.println("C/E: "+getCodigo_empleado());
        System.out.println("puesto: "+getPuesto());
        System.out.println("Nit: "+getNit());
        System.out.println("Nombres: " + getNombre());
        System.out.println("Apellidos: "+ getApellido());
        System.out.println("Direccion: "+ getDireccion());
        System.out.println("Telefono: "+ getTelefono());
        System.out.println("Fecha de nacimiento: "+ getFecha_nacimiento());
        System.out.println("Metodo modificar");
    }
    public void eliminar()
    {
        System.out.println("metodo eliminar");
    }
};
    
    
