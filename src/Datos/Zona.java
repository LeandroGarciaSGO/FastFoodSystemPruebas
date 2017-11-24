/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariano
 */
public class Zona {
    private Statement sentencia;
    private ResultSet rsDatos;
    private PreparedStatement psPrepSencencias;
    
    private int idZona;
    private String descripcion;
    private float precio;

    public Zona() {
        this.descripcion = "";
        this.precio = 0;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
        public ResultSet consultaZona() throws ClassNotFoundException{
        try {
            Connection conex = Conexion.Cadena();         
            String ConsultaSQL = "SELECT * FROM zona";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return rsDatos;       
    }
        
        public ResultSet consultaZonaPorId(int id) throws ClassNotFoundException{
        try {
            Connection conex = Conexion.Cadena();         
            String ConsultaSQL = "SELECT * FROM zona WHERE idZona = " + id;
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return rsDatos;       
    }

    public ResultSet consultarTodasLasZonas() throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();         
            String ConsultaSQL = "SELECT * FROM zona";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return rsDatos; 
    }

    public int obtenerSiguienteId() throws ClassNotFoundException, SQLException {
         Connection conex = Conexion.Cadena();
        String ConsultaSQL = "SELECT (MAX(idZona) )AS 'ID' FROM zona";
        sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rsDatos = sentencia.executeQuery(ConsultaSQL);
        if (rsDatos.first()) {
            int id = rsDatos.getInt("ID") + 1;
            //numFactura = id;
            return id;
        } else {
            //numFactura = 1;
            return 1;
        }
    }

    public void eliminar(int id) throws ClassNotFoundException, SQLException {
         Connection conex = Conexion.Cadena();
         psPrepSencencias = conex.prepareStatement("UPDATE zona SET estado = FALSE where idZona = " + id,PreparedStatement.RETURN_GENERATED_KEYS);
       psPrepSencencias.executeUpdate();
    }

    public void insertar() throws ClassNotFoundException {
        try {
            Connection cn = Conexion.Cadena();
            // preparo la sentencia el parametro RETURN_GENERATED_KEYS debe ser especificado explicitamente
            // para poder obtener el ID del campo autoincrement
            psPrepSencencias = cn.prepareStatement("INSERT INTO zona (descripcion,precio,estado) VALUES (?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
            // cargo parametros
            psPrepSencencias.setString(1, descripcion);
            psPrepSencencias.setFloat(2, precio);
            psPrepSencencias.setBoolean(3, true);
            //ejecuto sentencia
            psPrepSencencias.executeUpdate();
            //obtengo el id del registro recien insertado
            rsDatos = psPrepSencencias.getGeneratedKeys();
            rsDatos.first();
            //idCliente = rsDatos.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet buscarZona() throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();            
            String ConsultaSQL = "SELECT * FROM zona WHERE idZona = '" + idZona + "' and estado = true"; 
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return rsDatos;   
    }

    public void actualizar() throws ClassNotFoundException {
        try {      
            Connection cn = Conexion.Cadena();
            // preparo la sentencia el parametro RETURN_GENERATED_KEYS debe ser especificado explicitamente
            // para poder obtener el ID del campo autoincrement
            psPrepSencencias = cn.prepareStatement("UPDATE zona SET descripcion = ? , precio = ? , estado = ? WHERE idZona = ?",PreparedStatement.RETURN_GENERATED_KEYS);
            // cargo parametros
            psPrepSencencias.setString(1, descripcion);
            psPrepSencencias.setFloat(2, precio);
            psPrepSencencias.setBoolean(3, true);
            psPrepSencencias.setInt(4, idZona);
            //ejecuto sentencia
            psPrepSencencias.executeUpdate();
            //obtengo el id del registro recien insertado
           
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ResultSet buscarZonaDes() throws ClassNotFoundException {
       try {
            Connection conex = Conexion.Cadena();            
            String ConsultaSQL = "SELECT * FROM zona WHERE descripcion = '" + descripcion + "' and estado = true"; 
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return rsDatos;   
    }
    
    
}