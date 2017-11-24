/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Cliente;
import Datos.Facturacion;
import Datos.InformeActividad;
import Datos.Pedido;
import Datos.Zona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Leandro
 */
public class OperacionesAdicionales {
    
    public ArrayList<InformeActividad> obtenerActividades(String ini,String fin) throws ClassNotFoundException, SQLException {
        ResultSet informe;
        InformeActividad I = new InformeActividad();

        //Facturacion factura = new Facturacion();
        ArrayList<InformeActividad> inf = new ArrayList<InformeActividad>();
        informe = I.obtenerTodasActividades(ini,fin);
        while (informe.next()) {
            I = new InformeActividad();
            I.setIdTransaccion(informe.getInt("idTransaccion"));
            I.setFecha(String.valueOf(informe.getDate("fecha")));
            I.setHora(String.valueOf(informe.getTime("hora")));
            I.setIdUsuario(informe.getInt("idUsuario"));
            I.setDescripcion(informe.getString("descripcion"));
            I.setIdEntidad(informe.getInt("idEntidad"));
            I.setTabla(informe.getString("tabla"));
            inf.add(I);
            System.out.println(informe.getInt("idTransaccion"));
            System.out.println(String.valueOf(informe.getDate("fecha")));
            System.out.println(String.valueOf(informe.getTime("hora")));
            System.out.println(informe.getInt("idUsuario"));
            System.out.println(informe.getString("descripcion"));
            System.out.println(informe.getInt("idEntidad"));
            System.out.println(informe.getString("tabla"));
        }
        return inf;
    }

    public boolean modificarZona(Zona U) throws SQLException, ClassNotFoundException {
        ResultSet r = U.buscarZona();
        ResultSet r2 = U.buscarZonaDes();
        if (r.first() && r2.first()) {
            if (r.getInt("idZona") == r2.getInt("idZona") && r.getBoolean("estado")) {
                U.actualizar();
                return true;
            } else {
                if (r.getBoolean("estado") == false) {
                    U.actualizar();
                    return true;
                } else {
                    
                    return false;
                }
            }
        }
        if(!r2.first()){
                        U.actualizar();
                        return true;}
        return false;
//        if(r.first() && r.getBoolean("estado")){
//            U.actualizar();          
//            return true;
//        }else{
//            if(r.first()){
//                U.actualizar(); 
//                return true;
//            }
//        }
//        return false;
    }

    public boolean nuevaZona(Zona U) throws ClassNotFoundException, SQLException {
        ResultSet r = U.buscarZonaDes();
        if(r.first()){
            return true;
        }else{
        U.insertar();
        return false;
        }
    }
    
}
