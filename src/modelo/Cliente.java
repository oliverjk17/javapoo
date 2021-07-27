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
public class Cliente extends Persona{
    public String nit;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String direccion, String telefono, String nit, String fecha_nacimiento) {
        super(nombre, apellido, direccion, telefono, nit, fecha_nacimiento);
        this.nit=nit;
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
        System.out.println("_____________________");
    }
    @Override
    public void modificar()
    {
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
