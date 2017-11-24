package Datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro
 */
public class Comida {

    private Statement sentencia;
    private ResultSet rsDatos;
    private PreparedStatement psPrepSencencias;

    private int idComida;
    private String descripcion;
    private float precio;
    private int tipo;
    private boolean estado;

    public Comida() {
        this.idComida = 0;
        this.descripcion = "";
        this.precio = 0;
        this.tipo = 0;
        this.estado = false;
    }

    public Comida(int id, String desc, float pre, int tipo) {
        this.idComida = id;
        this.descripcion = desc;
        this.precio = pre;
        this.tipo = tipo;
        this.estado = false;
    }

    public Statement getSentencia() {
        return sentencia;
    }

    public ResultSet getRsDatos() {
        return rsDatos;
    }

    public PreparedStatement getPsPrepSencencias() {
        return psPrepSencencias;
    }

    public int getIdComida() {
        return idComida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public int getTipo() {
        return tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setSentencia(Statement sentencia) {
        this.sentencia = sentencia;
    }

    public void setRsDatos(ResultSet rsDatos) {
        this.rsDatos = rsDatos;
    }

    public void setPsPrepSencencias(PreparedStatement psPrepSencencias) {
        this.psPrepSencencias = psPrepSencencias;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ResultSet consultaComida(String desc) throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT * FROM comida WHERE descripcion = '" + desc + "'";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsDatos;
    }

    public ResultSet consultarTodasLasComidas() throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT * FROM comida WHERE estado = 1";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsDatos;
    }

    public ResultSet consultaTipoComida() throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT descripcion FROM tipoComida";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsDatos;
    }

    public ResultSet consultaComidaId(int idComida) throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT descripcion,precio FROM comida WHERE idComida = '" + idComida + "'";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsDatos;
    }
    
        public ResultSet consultaComidaId2(int idComida) throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT * FROM comida WHERE idComida = '" + idComida + "'";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsDatos;
    }

    public int obtenerSiguienteId() throws ClassNotFoundException, SQLException {
        Connection conex = Conexion.Cadena();
        String ConsultaSQL = "SELECT (MAX(idComida) )AS 'ID' FROM comida";
        sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rsDatos = sentencia.executeQuery(ConsultaSQL);

        if (rsDatos.first()) {
            int id = rsDatos.getInt("ID") + 1;
            return id;
        } else {
            return 1;
        }
    }

    public void agregarNuevaComida() throws ClassNotFoundException {
        try {
            Connection conex = Conexion.Cadena();
            psPrepSencencias = conex.prepareStatement("insert into comida (descripcion, precio, tipo, estado) values (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            psPrepSencencias.setString(1, descripcion);
            psPrepSencencias.setFloat(2, precio);
            psPrepSencencias.setInt(3, tipo);
            psPrepSencencias.setBoolean(4, true);

            psPrepSencencias.executeUpdate();

            rsDatos = psPrepSencencias.getGeneratedKeys();
            rsDatos.first();
            idComida = rsDatos.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(int cod) throws ClassNotFoundException {
        try {

            Connection cn = Conexion.Cadena();
            // preparo la sentencia el parametro RETURN_GENERATED_KEYS debe ser especificado explicitamente
            // para poder obtener el ID del campo autoincrement
            psPrepSencencias = cn.prepareStatement("UPDATE comida SET estado = ? WHERE idComida = ?", PreparedStatement.RETURN_GENERATED_KEYS);
            // cargo parametros
            psPrepSencencias.setBoolean(1, false);
            psPrepSencencias.setInt(2, cod);
            //ejecuto sentencia
            psPrepSencencias.executeUpdate();
            //obtengo el id del registro recien insertado

        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Comida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean modificar() throws ClassNotFoundException {
        try {
            System.out.println(tipo);
            Connection cn = Conexion.Cadena();
            // preparo la sentencia el parametro RETURN_GENERATED_KEYS debe ser especificado explicitamente
            // para poder obtener el ID del campo autoincrement
            psPrepSencencias = cn.prepareStatement("UPDATE comida SET descripcion = ? , precio = ? , tipo = ? , estado = ? WHERE idComida = ?", PreparedStatement.RETURN_GENERATED_KEYS);
            // cargo parametros
            psPrepSencencias.setString(1, descripcion);
            psPrepSencencias.setFloat(2, precio);
            psPrepSencencias.setInt(3, tipo);
            psPrepSencencias.setBoolean(4, true);
            psPrepSencencias.setInt(5, idComida);
            //ejecuto sentencia
            psPrepSencencias.executeUpdate();
            //obtengo el id del registro recien insertado
        } catch (SQLException ex) {
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Comida.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
