/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OLIVER
 */
public class Cliente extends Persona{
    private int id;
    public String nit;
    
    Conexion cn;

    public Cliente() {
    }

    public Cliente(int id,String nit,String nombre, String apellido, String direccion, String telefono,  String fecha_nacimiento) {
        super(nit,nombre, apellido, direccion, telefono,  fecha_nacimiento);
        this.nit=nit;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn = new Conexion();
        cn.abrir_conexion();
        String query;
        query = "Select id_clientes as id,nit,nombres,apellidos,dirrecion,telefono,fecha_nacimiento from clientes;";
        ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);
        
        String encabezado []= {"id","nit","nombres","apellidos","direccion","telefono","nacimiento"};
        tabla.setColumnIdentifiers(encabezado);
        
        String datos[]=new String[7];
        
        while(consulta.next()){
        datos[0]= consulta.getString("id");
        datos[1]= consulta.getString("nit");
        datos[2]= consulta.getString("nombres");
        datos[3]= consulta.getString("apellidos");
        datos[4]= consulta.getString("dirrecion");
        datos[5]= consulta.getString("telefono");
        datos[6]= consulta.getString("fecha_nacimiento");
        tabla.addRow(datos);
        }
        cn.cerrar_conxion();
        
        
    }catch(SQLException ex){
         cn.cerrar_conxion();
        System.out.println("error:"+ ex.getMessage());
    }
    return tabla;
    }
    
    
    
    @Override
    public void agregar()
    {
     try{
         PreparedStatement parametro;
         String query ="INSERT INTO clientes (nit,nombres,apellidos,dirrecion,telefono,fecha_nacimiento) VALUES (?,?,?,?,?,?)";
          cn= new Conexion ();
          cn.abrir_conexion();
          parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
          parametro.setString(1,getNit());
          parametro.setString(2,getNombre());
          parametro.setString(3,getApellido());
          parametro.setString(4,getDireccion());
          parametro.setString(5,getTelefono());
          parametro.setString(6,getFecha_nacimiento());
          
          int executar = parametro.executeUpdate();
          cn.cerrar_conxion();
          JOptionPane.showMessageDialog(null,Integer.toString(executar) + "Registro ingresado","agregar",JOptionPane.INFORMATION_MESSAGE);
          
          
     }catch(Exception ex){
        System.out.println("error..."+ ex.getMessage());
     }
    }
    
    @Override
    public void actualizar()
    {
          try{
         PreparedStatement parametro;
         String query ="update clientes set nit= ?,nombres= ?,apellidos= ?,dirrecion= ?,telefono= ?,fecha_nacimiento= ? " + "where id_clientes = ?";
          cn= new Conexion ();
          cn.abrir_conexion();
          parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
          parametro.setString(1,getNit());
          parametro.setString(2,getNombre());
          parametro.setString(3,getApellido());
          parametro.setString(4,getDireccion());
          parametro.setString(5,getTelefono());
          parametro.setString(6,getFecha_nacimiento());
          parametro.setInt(7,getId());
          
          int executar = parametro.executeUpdate();
          cn.cerrar_conxion();
          JOptionPane.showMessageDialog(null,Integer.toString(executar) + "Registro actualizado","actualizar",JOptionPane.INFORMATION_MESSAGE);
          
          
     }catch(Exception ex){
        System.out.println("error..."+ ex.getMessage());
     }
    }
    
    @Override
    public void eliminar(){
    try{
         PreparedStatement parametro;
         String query ="delete from clientes where id_clientes =?";
          cn= new Conexion ();
          cn.abrir_conexion();
          parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
         
          parametro.setInt(1,getId());
          
          int executar = parametro.executeUpdate();
          cn.cerrar_conxion();
          JOptionPane.showMessageDialog(null,Integer.toString(executar) + "Registro eliminado","eliminar",JOptionPane.INFORMATION_MESSAGE);
          
         
     }catch(Exception ex){
        System.out.println("error..."+ ex.getMessage());
     }}
    
    
    
    
}
   