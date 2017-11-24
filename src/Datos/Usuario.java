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
public class Usuario {

    private Statement sentencia;
    private ResultSet rsDatos;
    private PreparedStatement psPrepSencencias;

    private int idUsuario;
    private String nombreUsuario;
    private String nombreYApellido;
    private String contraseña;
    private String tipoDocumento;
    private int numDocumento;
    private int tipoUsuario;
    private boolean estado;

    public Usuario() {
        this.sentencia = null;
        this.rsDatos = null;
        this.psPrepSencencias = null;
        this.idUsuario = 0;
        this.nombreUsuario = "";
        this.nombreYApellido = "";
        this.contraseña = "";
        this.tipoDocumento = "";
        this.numDocumento = 0;
        this.tipoUsuario = 0;
        this.estado = false;
    }

    public Usuario(int id, String nombreUsu, String nombApe, String tipoDocu, int docu, int tipoUsu) {
        this.idUsuario = id;
        this.nombreUsuario = nombreUsu;
        this.nombreYApellido = nombApe;
        //this.contraseña = contra;
        this.tipoDocumento = tipoDocu;
        this.numDocumento = docu;
        this.tipoUsuario = tipoUsu;
        this.estado = false;
        this.sentencia = null;
        this.rsDatos = null;
        this.psPrepSencencias = null;
    }

    



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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public ResultSet buscarUsuario(String nomb) throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT * FROM usuario WHERE nombreUsuario = '" + nomb + "'";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsDatos;
    }

    public String encriptarClave(String cont) throws ClassNotFoundException, SQLException {
        String ConsultaSQL;
        try {
            Connection conex = Conexion.Cadena();
            ConsultaSQL = "SELECT MD5('" + cont + "') as 'clave'";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rsDatos.first()) {
            //System.out.print(rsDatos.getString(1));
            return rsDatos.getString("clave");
        } else {
            return cont;
        }
    }

    public ResultSet consultaUsuario(String nombUsu) throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT * FROM usuario WHERE nombreUsuario = '" + nombUsu + "'";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsDatos;
    }

    public ResultSet consultarTodosLosUsuarios() throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT * FROM usuario WHERE estado = 1";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsDatos;
    }

//    public ResultSet consultaTipoDocu() throws ClassNotFoundException {
//        try {
//            Connection conex = Conexion.Cadena();
//            String ConsultaSQL = "SELECT tipoDocumento FROM usuario";
//            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rsDatos = sentencia.executeQuery(ConsultaSQL);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rsDatos;
//    }

//    public ResultSet consultaTipoUsuario() throws ClassNotFoundException {
//        try {
//            Connection conex = Conexion.Cadena();
//            String ConsultaSQL = "SELECT tipoUsuario FROM usuario";
//            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rsDatos = sentencia.executeQuery(ConsultaSQL);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rsDatos;
//    }

//public ResultSet consultaUsuarioId(int idUsuario) throws ClassNotFoundException {
//        try {
//            Connection conex = Conexion.Cadena();
//            String ConsultaSQL = "SELECT descripcion,precio FROM usuario WHERE idUsuario= '" + idUsuario + "'";
//            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rsDatos = sentencia.executeQuery(ConsultaSQL);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rsDatos;
//    }
    public ResultSet consultaUsuarioId(int idUsuario) throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT * FROM usuario WHERE idUsuario = '" + idUsuario + "'";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsDatos;
    }

    public int obtenerSiguienteId() throws ClassNotFoundException, SQLException {
        Connection conex = Conexion.Cadena();
        String ConsultaSQL = "SELECT (MAX(idUsuario) )AS 'ID' FROM usuario";
        sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rsDatos = sentencia.executeQuery(ConsultaSQL);

        if (rsDatos.first()) {
            int id = rsDatos.getInt("ID") + 1;
            return id;
        } else {
            return 1;
        }
    }

    public void agregarNuevoUsuario() throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            psPrepSencencias = conex.prepareStatement("insert into usuario (nombreUsuario, nombreYApellido, contraseña, tipoDocumento, numDocumento, tipoUsuario, estado) values (?, ?, MD5(?), ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            psPrepSencencias.setString(1, nombreUsuario);
            psPrepSencencias.setString(2, nombreYApellido);
            psPrepSencencias.setString(3, contraseña);
            psPrepSencencias.setString(4, tipoDocumento);
            psPrepSencencias.setInt(5, numDocumento);
            psPrepSencencias.setInt(6, tipoUsuario);
            psPrepSencencias.setBoolean(7, true);

            psPrepSencencias.executeUpdate();

            rsDatos = psPrepSencencias.getGeneratedKeys();
            rsDatos.first();
            idUsuario = rsDatos.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(int id) throws ClassNotFoundException {
        try {

            Connection cn = Conexion.Cadena();
            // preparo la sentencia el parametro RETURN_GENERATED_KEYS debe ser especificado explicitamente
            // para poder obtener el ID del campo autoincrement
            psPrepSencencias = cn.prepareStatement("UPDATE usuario SET estado = ? WHERE idUsuario = ?", PreparedStatement.RETURN_GENERATED_KEYS);
            // cargo parametros
            psPrepSencencias.setBoolean(1, false);
            psPrepSencencias.setInt(2, id);
            //ejecuto sentencia
            psPrepSencencias.executeUpdate();
            //obtengo el id del registro recien insertado

        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public boolean modificar() throws ClassNotFoundException {
        try {      
            Connection cn = Conexion.Cadena();
            // preparo la sentencia el parametro RETURN_GENERATED_KEYS debe ser especificado explicitamente
            // para poder obtener el ID del campo autoincrement
            psPrepSencencias = cn.prepareStatement("UPDATE usuario SET nombreUsuario = ? , nombreYApellido = ?, contraseña = MD5(?) ,tipoDocumento = ?, numDocumento = ? ,tipoUsuario = ?,estado = ? WHERE idUsuario = ?",PreparedStatement.RETURN_GENERATED_KEYS);
            // cargo parametros
            psPrepSencencias.setString(1, nombreUsuario);
            psPrepSencencias.setString(2, nombreYApellido);
            psPrepSencencias.setString(3, contraseña);
            
            psPrepSencencias.setString(4, tipoDocumento);
             psPrepSencencias.setInt(5, numDocumento);
              psPrepSencencias.setInt(6, tipoUsuario);
            psPrepSencencias.setBoolean(7, estado);
            psPrepSencencias.setInt(8, idUsuario);
            //ejecuto sentencia
            psPrepSencencias.executeUpdate();
            //obtengo el id del registro recien insertado
           
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
