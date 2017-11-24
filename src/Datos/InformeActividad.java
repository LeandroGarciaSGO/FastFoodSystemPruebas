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
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Leandro
 */
public class InformeActividad {
    
    private Statement sentencia;
    private ResultSet rsDatos;
    private PreparedStatement psPrepSencencias;
    
    private int idTransaccion;
    private String fecha;
    private String hora;
    private int idUsuario;
    private String descripcion;
    private String tabla;
    private int idEntidad;

    public InformeActividad() {
        this.sentencia = null;
        this.rsDatos = null;
        this.psPrepSencencias = null;
        this.idTransaccion = 0;
        this.fecha = "";
        this.hora = "";
        this.idUsuario = 0;
        this.descripcion = "";
        this.tabla = "";
        this.idEntidad = 0;
    }
    
    
    
//    public ResultSet obtenerTodasActividades2(Date i,Date f) throws ClassNotFoundException, SQLException {
//        Connection conex = Conexion.Cadena();
//        String formato = "yyyy/MM/dd";
//        SimpleDateFormat sdf = new SimpleDateFormat(formato);
//        System.out.println("FECHA" + i);
//        String h = String.valueOf(sdf.format(i));
//        String ConsultaSQL = "SELECT * FROM transacciones where fecha = '" + h + "'";
//        sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        rsDatos = sentencia.executeQuery(ConsultaSQL);
//        return rsDatos;
//    }
    
    public ResultSet obtenerTodasActividades(String i,String f) throws ClassNotFoundException, SQLException {
        Connection conex = Conexion.Cadena();
        String ConsultaSQL = "SELECT * FROM transacciones where fecha >= '" + i + "' AND fecha <= '" + "f'";
        sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rsDatos = sentencia.executeQuery(ConsultaSQL);
        return rsDatos;
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

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

   

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }
    
    
    
}
