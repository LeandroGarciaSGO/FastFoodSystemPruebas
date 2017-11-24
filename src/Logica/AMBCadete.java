/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.Cadete;
import Datos.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luji
 */
public class AMBCadete {
    
//    public boolean modificarCadete(Cadete C) throws ClassNotFoundException, SQLException {
//        ResultSet NC;
//        NC = C.consultaCadete(C.getNumDocumento());
//        if(NC.first()){
//            if(NC.getBoolean("estado"))
//            {
//               C.modificar();
//                    return true;
//               
//            }
//            //else
//            //{
//              //  C.modificar();
//               // return true;
//            //}
//        }
//        else
//        {
//            //C.insertar();
//            return false;
//        }
//        return false;
//    }
    
    
       public Cadete buscarCadeteConId(int id) throws ClassNotFoundException, SQLException {
        ResultSet datosCadete;
        Cadete miCadete = new Cadete();
        datosCadete = miCadete.consultaCadeteConId(id);
        
      
        if (datosCadete.first()) {
            miCadete.setIdCadete(datosCadete.getInt("idCadete"));
            miCadete.setNombre(datosCadete.getString("nombre"));
            miCadete.setApellido(datosCadete.getString("apellido"));
            miCadete.setDomicilio(datosCadete.getString("domicilio"));
            miCadete.setTelefono(datosCadete.getLong("telefono"));
            miCadete.setTipoDocumento(datosCadete.getString("TipoDocumento"));
            miCadete.setNumDocumento(datosCadete.getInt("numDocumento"));
            miCadete.setEstado(datosCadete.getBoolean("estado"));
            System.out.print(miCadete.getApellido());
            if (miCadete.isEstado()) {
                return miCadete;
            }
            else
            {
                return null;
            }
        }
        return null;
    }
    
    
    public Cadete buscarCadete(int numDocumento) throws ClassNotFoundException, SQLException {
        ResultSet datosCadete;
        Cadete miCadete = new Cadete();
        datosCadete = miCadete.consultaCadete(numDocumento);
        


        //MUESTRA LOS DATOS DEL CADETE SELECCIONADO
        if (datosCadete.first()) {
            miCadete.setIdCadete(datosCadete.getInt("idCadete"));
            miCadete.setNombre(datosCadete.getString("nombre"));
            miCadete.setApellido(datosCadete.getString("apellido"));
            miCadete.setDomicilio(datosCadete.getString("domicilio"));
            miCadete.setTelefono(datosCadete.getLong("telefono"));
            miCadete.setTipoDocumento(datosCadete.getString("TipoDocumento"));
            miCadete.setNumDocumento(datosCadete.getInt("numDocumento"));
            miCadete.setEstado(datosCadete.getBoolean("estado"));
            System.out.print(miCadete.getApellido());
            if (miCadete.isEstado()) {
                return miCadete;
            }
            else
            {
                return null;
            }
        }
        return null;
    }
    
    public ArrayList<Cadete> listaCadetes() throws ClassNotFoundException, SQLException{
        ResultSet datosCadete;
        Cadete miCadete = new Cadete();
        ArrayList<Cadete> listaCadete = new ArrayList<Cadete>();
        datosCadete = miCadete.obtenerCadete();
        while(datosCadete.next()){
            Cadete miCadeteLista = new Cadete();
            miCadeteLista.setIdCadete(datosCadete.getInt("idCadete"));
            miCadeteLista.setNombre(datosCadete.getString("nombre"));
            listaCadete.add(miCadeteLista);
        }
        return listaCadete;
    }
    
    
    
        public static int obtenerSiguienteId(){
    return 1;
}
 public int nuevoCadete(Cadete C) throws ClassNotFoundException, SQLException{
    ResultSet NC;
    NC = C.consultaCadete(C.getNumDocumento());
    
    if(NC.first()){
        return 1;
    }else{
        C.agregarNuevoCadete();
        return 0;
    }
}
 
 public int esNueva (Cadete C) throws ClassNotFoundException, SQLException {
        ResultSet NC;
        NC = C.consultaCadete(C.getNumDocumento());

        if (NC.first()) {
            if (NC.getBoolean("estado")) {
                return 1;
            } else {
                //C.agregarNuevoCadete();
                return 0;
            }
        } else {
           // C.agregarNuevoCadete();
            return 0;
        }
    }
 
 
 
 public int nuevaCadet(Cadete C) throws ClassNotFoundException, SQLException {
        ResultSet NC;
        NC = C.consultaCadete(C.getNumDocumento());

        if (NC.first()) {
            if (NC.getBoolean("estado")) {
                return 1;
            } else {
                C.agregarNuevoCadete();
                return 0;
            }
        } else {
            C.agregarNuevoCadete();
            return 0;
        }
    }
 
 public Cadete consultaCadeteEstado(int idCadete) throws SQLException, ClassNotFoundException{
     ResultSet datosCadete;
     Cadete miCadete = new Cadete();
     datosCadete = miCadete.consultaEstado(idCadete);
     try {
         boolean primercadete = datosCadete.first();
     } catch (SQLException ex) {
         Logger.getLogger(OperacionesLogueo.class.getName()).log(Level.SEVERE, null, ex);
     }
     if (datosCadete.first()) {
         miCadete.setIdCadete(datosCadete.getInt("idCadete"));
         miCadete.setEstado(datosCadete.getBoolean("estado"));
         if (miCadete.isEstado()) {
             return miCadete;
         }
         else{
             return null;
         }
     }
     return null;
 }
}
