/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Cliente;
import Datos.DetallePedido;
import Datos.Pedido;
import Datos.Zona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Mariano
 */

public class OperacionesPedido {
    public int nuevoPedido(Pedido P) throws ClassNotFoundException, SQLException{
        return P.insertarPedido();
    }
    
    public void modificarPedido(Pedido P) throws ClassNotFoundException{
        P.modificarPedido();
    }
    
    public Pedido buscarPedido(int idPedido) throws ClassNotFoundException, SQLException{
        ResultSet datosPedido;
        Pedido P = new Pedido();
        datosPedido = P.consultaPedido(idPedido);
        
        try {
            boolean primerpedido = datosPedido.first();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesLogueo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (datosPedido.first()) {
            P.setIdPedido(datosPedido.getInt("idPedido"));
            P.setEstado(datosPedido.getInt("estado"));
            P.setFecha(datosPedido.getDate("fecha"));
            P.setHora(datosPedido.getTime("hora"));
            P.setLugarDeEnvio(datosPedido.getString("lugarDeEnvio"));
            P.setZona(datosPedido.getInt("zona"));
            if (P.getEstado() == 1) {
                return P;
            }
            else
            {
                return null;
            }
        }
        return null;
    }
    
    public void nuevoDetallePedido(ArrayList<DetallePedido> DP) throws ClassNotFoundException{
        for(int i = 0; i<DP.size(); i++){
            DetallePedido detP = new DetallePedido();
            detP.setIdPedido(DP.get(i).getIdPedido());
            detP.setNumLinea(DP.get(i).getNumLinea());
            detP.setIdComida(DP.get(i).getIdComida());
            detP.setCantidad(DP.get(i).getCantidad());
            detP.insertarDetallePedido();
        }
    }
    
    public ArrayList<DetallePedido> buscarDetallePedido(int idPedido) throws ClassNotFoundException, SQLException{
        ResultSet datosDetalleP;
        DetallePedido DP1 = new DetallePedido();
        ArrayList<DetallePedido> listaDetallePedido = new ArrayList<DetallePedido>();
        datosDetalleP = DP1.consultaDetallePedido(idPedido);
        while(datosDetalleP.next()) {
            DetallePedido DP2 = new DetallePedido();
            DP2.setIdComida(datosDetalleP.getInt("idComida"));
            DP2.setCantidad(datosDetalleP.getInt("cantidad"));
            listaDetallePedido.add(DP2);
        }
        return listaDetallePedido;
    }
    
    public ArrayList<Zona> buscarZona() throws ClassNotFoundException, SQLException{
        ResultSet datosZona;
        ArrayList<Zona> listaZonas = new ArrayList<Zona>();
        Zona z1 = new Zona();
        datosZona = z1.consultaZona();
        while(datosZona.next()){
            Zona z2 = new Zona();
            z2.setIdZona(datosZona.getInt("idZona"));
            z2.setDescripcion(datosZona.getString("descripcion"));
            z2.setPrecio(datosZona.getFloat("precio"));
            listaZonas.add(z2);
        }
        return listaZonas;
    }
    
    public void eliminarDetallePedido(int idPedido) throws ClassNotFoundException{
        DetallePedido DP = new DetallePedido();
        DP.eliminarDetallePedido(idPedido);  
    }
    
    public void cargarTabla(JTable tabla, String idPedido, String telefono, int p) throws ClassNotFoundException, SQLException{
        ResultSet datosTabla;
        ResultSet PidCliente;
        DefaultTableModel modelo;
        Pedido P = new Pedido();
        Cliente C = new Cliente();
        OperacionesCliente ABMC = new OperacionesCliente();
        String []titulo = {"Código","Teléfono del Cliente","Nombre Cliente","Fecha","Hora"};
        modelo = new DefaultTableModel(null,titulo);
        String []datos = new String[5];
        datosTabla = P.consultaCargarTabla(idPedido);
        switch (p) {
            case 0:
                while(datosTabla.next()){
                    datos[0] = String.valueOf(datosTabla.getInt("idPedido"));
                    datos[3] = String.valueOf(datosTabla.getDate("fecha"));
                    datos[4] = String.valueOf(datosTabla.getTime("hora"));
                    C = ABMC.buscarClienteConId(datosTabla.getInt("idCliente"));
                    datos[1] = String.valueOf(C.getTelefono());
                    datos[2] = C.getNombre() + " " + C.getApellido();
                    modelo.addRow(datos);
                }       break;
            case 1:
                datosTabla = P.consultaCargarTabla(idPedido);
                while(datosTabla.next()){
                    datos[0] = String.valueOf(datosTabla.getInt("idPedido"));
                    datos[3] = String.valueOf(datosTabla.getDate("fecha"));
                    datos[4] = String.valueOf(datosTabla.getTime("hora"));
                    C = ABMC.buscarClienteConId(datosTabla.getInt("idCliente"));
                    datos[1] = String.valueOf(C.getTelefono());
                    datos[2] = C.getNombre() + " " +C.getApellido();
                    modelo.addRow(datos);
                }   break;
            default:
                datosTabla = C.obtenerClienteFiltrado(telefono);
                while(datosTabla.next()){
                    datos[1] = String.valueOf(datosTabla.getLong("telefono"));
                    datos[2] = datosTabla.getString("nombre") + " " + datosTabla.getString("apellido");
                    PidCliente = P.consultaPedidoIdCliente(datosTabla.getInt("idCliente"));
                    if(PidCliente.first()){
                        datos[0] = String.valueOf(PidCliente.getInt("idPedido"));
                        datos[3] = String.valueOf(PidCliente.getDate("fecha"));
                        datos[4] = String.valueOf(PidCliente.getTime("hora"));
                        modelo.addRow(datos);
                    }
                }   break;       
        }
        tabla.setModel(modelo);
    }
}
