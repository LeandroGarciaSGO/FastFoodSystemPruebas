package Datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Leandro
 */
public class Facturacion {
    private Statement sentencia;
    private ResultSet rsDatos;
    private PreparedStatement psPrepSencencias;
    
    private int numFactura;
    private Pedido datospedido;
    private Cliente datoscliente;
    private float importe;
    private float tarifaDeEnvio;
    private boolean estado;
    
    public Facturacion(){
        this.datoscliente = null;
        this.datoscliente = null;        
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

    public Pedido getDatospedido() {
        return datospedido;
    }

    public void setDatospedido(Pedido datospedido) {
        this.datospedido = datospedido;
    }

    public Cliente getDatoscliente() {
        return datoscliente;
    }

    public void setDatoscliente(Cliente datoscliente) {
        this.datoscliente = datoscliente;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public float getTarifaDeEnvio() {
        return tarifaDeEnvio;
    }

    public void setTarifaDeEnvio(float tarifaDeEnvio) {
        this.tarifaDeEnvio = tarifaDeEnvio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    public int obtenerSiguienteId() throws ClassNotFoundException, SQLException {        
        Connection conex = Conexion.Cadena();
        String ConsultaSQL = "SELECT (MAX(numFactura) )AS 'ID' FROM factura";
        sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rsDatos = sentencia.executeQuery(ConsultaSQL);
        if (rsDatos.first()) {
            int id = rsDatos.getInt("ID") + 1;
            numFactura = id;
            return id;
        } else {
            numFactura = 1;
            return 1;
        }
    }
 
    public String obtenerFechaActual() throws ClassNotFoundException, SQLException {
        String fecha = new String();
        Connection conex = Conexion.Cadena();
        String ConsultaSQL = "SELECT CURDATE() AS 'fechaActual'";
        sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rsDatos = sentencia.executeQuery(ConsultaSQL);
        Date fe = new Date(0);
        if (rsDatos.first()) {
            fe = rsDatos.getDate("fechaActual");
            fecha = String.valueOf(fe);
        }
        return fecha;
    }
    
    public void insertar() throws ClassNotFoundException{
         try {
            Connection cn = Conexion.Cadena();
            // preparo la sentencia el parametro RETURN_GENERATED_KEYS debe ser especificado explicitamente
            // para poder obtener el ID del campo autoincrement
            psPrepSencencias = cn.prepareStatement("INSERT INTO factura (idPedido,importe,tarifaDeEnvio,fecha,nombreCliente,domicilioEnvio,idCadete,pagoAlCadete,estado) VALUES (?,?,?,CURDATE(),?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            // cargo parametros
            psPrepSencencias.setInt(1, datospedido.getIdPedido());
            psPrepSencencias.setFloat(2, importe);
            psPrepSencencias.setFloat(3, tarifaDeEnvio);
            psPrepSencencias.setString(4,datoscliente.getNombre() + datoscliente.getApellido());
            psPrepSencencias.setString(5, datospedido.getLugarDeEnvio());
            psPrepSencencias.setInt(6,datospedido.getIdCadete());
            psPrepSencencias.setBoolean(7, false);
            psPrepSencencias.setBoolean(8, true);
            //ejecuto sentencia
            psPrepSencencias.executeUpdate();
            //obtengo el id del registro recien insertado
            rsDatos = psPrepSencencias.getGeneratedKeys();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public void insertarDetalle() throws SQLException, ClassNotFoundException {
         //for (int i = 0; i < listaDetalles.size(); i++) {
              Connection cn = Conexion.Cadena();
            // preparo la sentencia el parametro RETURN_GENERATED_KEYS debe ser especificado explicitamente
            // para poder obtener el ID del campo autoincrement
            psPrepSencencias = cn.prepareStatement("INSERT INTO detalleFactura (numFactura,numLinea,detalleLinea,cantidad,precioUnitario) VALUES (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            // cargo parametros
            psPrepSencencias.setInt(1, numFactura);
            psPrepSencencias.setInt(2, datospedido.getDetalle().getNumLinea());
            psPrepSencencias.setString(3, datospedido.getDetalle().getDatoscomida().getDescripcion());
            psPrepSencencias.setInt(4,datospedido.getDetalle().getCantidad());
            psPrepSencencias.setFloat(5, datospedido.getDetalle().getDatoscomida().getPrecio());
         
            //ejecuto sentencia
            psPrepSencencias.executeUpdate();
            //obtengo el id del registro recien insertado
            rsDatos = psPrepSencencias.getGeneratedKeys();
         //}
    }

    public ResultSet obtenerFactura(int id) throws ClassNotFoundException{
        try {
            Connection conex = Conexion.Cadena();            
            String ConsultaSQL = "SELECT * FROM factura WHERE numFactura = " + id; 
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return rsDatos;       
    }

    public void anular(int numFactura) throws ClassNotFoundException, SQLException {
        Connection cn = Conexion.Cadena();
        psPrepSencencias = cn.prepareStatement("UPDATE factura SET estado = ? WHERE numFactura = ?" ,PreparedStatement.RETURN_GENERATED_KEYS);
        psPrepSencencias.setBoolean(1, false);
        psPrepSencencias.setInt(2, numFactura);
        psPrepSencencias.executeUpdate();
    }
    
   
}
