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
 * @author Leandro
 */
public class Cadete {
    private Statement sentencia;
    private ResultSet rsDatos;
    private PreparedStatement psPrepSencencias;
    
    private int idCadete;
    private String nombre;
    private String apellido;
    private String domicilio;
    private long telefono;
    private String tipoDocumento;
    private int numDocumento;
    private boolean estado;

    public Statement getSentencia() {
        return sentencia;
    }

    public void setSentencia(Statement sentencia) {
        this.sentencia = sentencia;
    }

    public ResultSet getRsDatos() {
        return rsDatos;
    }

    public void setRsDatos(ResultSet rsDatos) {
        this.rsDatos = rsDatos;
    }

    public PreparedStatement getPsPrepSencencias() {
        return psPrepSencencias;
    }

    public void setPsPrepSencencias(PreparedStatement psPrepSencencias) {
        this.psPrepSencencias = psPrepSencencias;
    }

    public int getIdCadete() {
        return idCadete;
    }

    public void setIdCadete(int idCadete) {
        this.idCadete = idCadete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cadete() {
        this.idCadete = 0;
        this.nombre = "";
        this.apellido = "";
        this.domicilio = "";
        this.telefono = 0;
        this.tipoDocumento = "";
        this.numDocumento = 0;
        this.estado = false;
    }
    
    public Cadete(int id, int numDoc, String nomb, String ape, long tel , String dom, String tipo ){
        this.idCadete = id;
        this.nombre = nomb;
        this.apellido = ape;
        this.domicilio = dom;
        this.telefono = tel;
        this.tipoDocumento= tipo;
        this.numDocumento = numDoc;
        this.estado = false;
    }

    
    
    
public ResultSet consultaCadete2(int dni,int cod) throws ClassNotFoundException{
        try {
            Connection conex = Conexion.Cadena();            
            String ConsultaSQL = "SELECT * FROM cadete WHERE numDocumento = '" + dni + "' AND idCadete != " + cod; 
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return rsDatos;       
    } 

public ResultSet consultaCadete(int dni) throws ClassNotFoundException{
        try {
            Connection conex = Conexion.Cadena();            
            String ConsultaSQL = "SELECT * FROM cadete WHERE numDocumento = '" + dni + "' and estado = 1"; 
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return rsDatos;       
    }

public ResultSet consultaEstado(int idCadete) throws ClassNotFoundException{
    try {
        Connection conex = Conexion.Cadena();
        String ConsultaSQL = "SELECT idCadete, estado FROM cadete WHERE idCadete = '"+ idCadete+"' AND estado = true";
        sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rsDatos = sentencia.executeQuery(ConsultaSQL);
    } catch (SQLException ex) {
        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rsDatos;
}

public ResultSet obtenerCadete() throws ClassNotFoundException{
    try {
        Connection conex = Conexion.Cadena();
        String ConsultaSQL = "SELECT idCadete, nombre FROM cadete WHERE estado = true";
        sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rsDatos = sentencia.executeQuery(ConsultaSQL);
    } catch (SQLException ex) {
        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rsDatos;
}
public ResultSet consultarTodoLosCadetes() throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT * FROM cadete WHERE estado = '"+1+"' ";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsDatos;
    }

public ResultSet consultaCadeteConId(int cod) throws ClassNotFoundException{
        try {
            Connection conex = Conexion.Cadena();            
            String ConsultaSQL = "SELECT * FROM cadete WHERE idCadete = " + cod; 
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return rsDatos;       
    }
public ResultSet cargar() throws ClassNotFoundException{
    try{
        Connection conex = Conexion.Cadena();
                                String ConsultaSQL = "UPDATE cadete SET nombre = '"+getNombre()+"' ,"
                                        + " apellido = '"+getApellido()+"' , "
                                        + "domicilio =  '"+getDomicilio()+"' ,"
                                        + " telefono =  '"+getTelefono()+"' , "
                                        + "tipoDocumento ='"+getTipoDocumento()+"' , "
                                        + "numDocumento =  '"+getNumDocumento()+"' "
                                        + " WHERE idCadete = '"+getIdCadete()+"' ";
                                
                                sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                sentencia.executeUpdate(ConsultaSQL);

}catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);

}
        return rsDatos;

}
public int obtenerSiguienteId() throws ClassNotFoundException, SQLException {

        Connection conex = Conexion.Cadena();
        String ConsultaSQL = "SELECT (MAX(idCadete) )AS 'ID' FROM cadete";
        sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rsDatos = sentencia.executeQuery(ConsultaSQL);

        if (rsDatos.first()) {
            int id = rsDatos.getInt("ID") + 1;
            return id;
        } else {
            return 1;
        }
    }

 public int eliminardni(int dni) throws SQLException {
try {
            Connection cn = Conexion.Cadena();
            // preparo la sentencia el parametro RETURN_GENERATED_KEYS debe ser especificado explicitamente
            // para poder obtener el ID del campo autoincrement
            psPrepSencencias = cn.prepareStatement("UPDATE Cadete SET estado=? where numDocumento=?");
            
            psPrepSencencias.setBoolean(1, estado);
            psPrepSencencias.setString(2, Integer.toString(dni));

            //ejecuto sentencia
            dni = psPrepSencencias.executeUpdate();
            //obtengo el id del registro recien insertado
            // rsDatos.first();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cadete.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dni;
}


public void agregarNuevoCadete() throws ClassNotFoundException{
    try {
            Connection conex = Conexion.Cadena();            
            psPrepSencencias = conex.prepareStatement("insert into cadete (nombre, apellido, domicilio, telefono, tipoDocumento, numDocumento, estado) values (?, ?, ?, ?, ?, ?, ? )",PreparedStatement.RETURN_GENERATED_KEYS); 
            psPrepSencencias.setString(1, nombre);
            psPrepSencencias.setString(2, apellido);
            psPrepSencencias.setString(3, domicilio);
            psPrepSencencias.setLong(4, telefono);
            psPrepSencencias.setString(5, tipoDocumento);
            psPrepSencencias.setInt(6, numDocumento);
            psPrepSencencias.setBoolean(7, true);
            psPrepSencencias.executeUpdate();
            
            rsDatos = psPrepSencencias.getGeneratedKeys();
            rsDatos.first();
            idCadete = rsDatos.getInt(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }


    
}
