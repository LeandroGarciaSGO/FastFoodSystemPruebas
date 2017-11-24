/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Cliente;
import Datos.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro
 */
public class OperacionesLogueo {

    public Usuario autenticar(String nom, String cont) throws ClassNotFoundException, SQLException {
        ResultSet datosUsuario;
        Usuario miUsuario = new Usuario();
        datosUsuario = miUsuario.buscarUsuario(nom);
        Usuario resultado = null;
//        try {
//            boolean aa = datosUsuario.first();
//        } catch (SQLException ex) {
//            Logger.getLogger(OperacionesLogueo.class.getName()).log(Level.SEVERE, null, ex);
//        }
        if (datosUsuario.first()) {
            String clave = datosUsuario.getString("contraseña");
            //String paswd = datosUsuario.getString("pass");
            boolean estado = datosUsuario.getBoolean("estado");
            int tipoUsuario = datosUsuario.getInt("tipoUsuario");
            System.out.print(estado);            
            
            if (estado) {
                String c = miUsuario.encriptarClave(cont);
                if (clave.equals(c)) {
                    resultado = new Usuario();
                    resultado.setNombreUsuario(datosUsuario.getString("nombreUsuario"));
                    resultado.setEstado(true);
                    resultado.setIdUsuario(datosUsuario.getInt("idUsuario"));
                    resultado.setTipoUsuario(datosUsuario.getInt("tipoUsuario"));
                }
            }
        }
        return resultado;
    }
    
    
//    public Usuario autenticar2(String nom, String cont) throws ClassNotFoundException, SQLException {
//        ResultSet datosUsuario;
//        Usuario miUsuario = new Usuario();
//        //datosUsuario = miUsuario.buscarUsuario(nom, "12345");
//        Usuario resultado = null;
//        try {
//            boolean aa = datosUsuario.first();
//        } catch (SQLException ex) {
//            Logger.getLogger(OperacionesLogueo.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //if (datosUsuario.first()) {
//            String clave = datosUsuario.getString("contraseña");
//            String paswd = datosUsuario.getString("pass");
//            boolean estado = datosUsuario.getBoolean("estado");
//            int tipoUsuario = datosUsuario.getInt("tipoUsuario");
//            System.out.print(estado);
//            MessageDigest msgd;
//            
//            if (estado) {
//                //String c = miUsuario.buscarUsuarioMD5(cont);
//                if (clave.equals(paswd)) {
//                    resultado = new Usuario();
//                    resultado.setNombreUsuario(datosUsuario.getString("nombreUsuario"));
//                    resultado.setEstado(true);
//                    resultado.setIdUsuario(datosUsuario.getInt("idUsuario"));
//                    resultado.setTipoUsuario(datosUsuario.getInt("tipoUsuario"));
//                }
//            }
//        }
//        return resultado;
//    }

}
