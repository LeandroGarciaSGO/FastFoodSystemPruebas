/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Transaccion;
import Datos.Usuario;

/**
 *
 * @author Leandro
 */
public class OperacionesTransacciones {
    
    public String obtenerDescripcion(int codigo){
        String res = "";
        switch(codigo){
            case 1: res = "Ingreso al Sistema"; break;
            case 2: res = "Alta de Cliente"; break;
            case 3: res = "Modificacion de Cliente"; break;
            case 4: res = "Baja de Cliente"; break;
            case 5: res = "Alta de Comida"; break;
            case 6: res = "Modificacion de Comida"; break;
            case 7: res = "Baja de Comida"; break;            
            case 8: res = "Alta de Cadete"; break;
            case 9: res = "Modificacion de Cadete"; break;
            case 10: res = "Baja de Cadete"; break;
            case 11: res = "Alta de Usuario"; break;
            case 12: res = "Baja de Usuario"; break;
            case 13: res = "Modificacion de Usuario"; break;
            case 14: res = "Registro de un Pedido"; break;
            case 15: res = "Cancelacion de un Pedido"; break;
            case 16: res = "Modificacion de un Pedido"; break;
            case 17: res = "Factura Generada"; break;
            case 18: res = "Factura Anulada"; break;
            case 19: res = "Se Inicio Elaboracion de Pedido"; break;
            case 20: res = "Se Termino el Pedido"; break;
            case 21: res = "Se Envio al Cliente el Pedido"; break;
            case 22: res = "Registo de una Zona"; break;
            case 23: res = "Modificacion de una Zona"; break;
            case 24: res = "Eliminacion de una Zona"; break; 
        }
        return res;
    }
    
    public String obtenerEntidad(int codigo){
        String res = "";
        switch(codigo){
            case 1: res = "Cliente"; break;
            case 2: res = "Usuario"; break;
            case 3: res = "Comida"; break;
            case 4: res = "Cadete"; break;
            case 5: res = "Pedido"; break;
            case 6: res = "Factura"; break;
            case 7: res = "Zona"; break;
        }
        return res;       
    }

    public void registrarTransaccion(int accion,int entidad,int codigo, Usuario datosUsuario) throws ClassNotFoundException {
        String mensaje = obtenerDescripcion(accion);
        String ent = obtenerEntidad(entidad);
        Transaccion T = new Transaccion();
        T.insertar(mensaje,ent,codigo,datosUsuario.getIdUsuario());
    }
    
    
    
    
}
