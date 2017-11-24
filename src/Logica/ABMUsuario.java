/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalez
 */
public class ABMUsuario {
    public boolean modificarUsuario(Usuario U) throws ClassNotFoundException, SQLException {
        ResultSet NU;
        NU = U.consultaUsuario(U.getNombreUsuario());

        if (NU.first()) {
            if (NU.getBoolean("estado")) {
                if (U.getIdUsuario()== NU.getInt("idUsuario")) {
                    U.modificar();
                    System.out.println("\nEXISTE + ACTIVO + ID 1\n");
                    return true;
                } else {
                    System.out.println("\nEXISTE + ACTIVO 1\n");
                    return false;
                }
            } else {
                U.setIdUsuario(NU.getInt("idUsuario"));
                U.setEstado(true);
                U.modificar();
                System.out.println("\nEXISTE 1\n");
                return true;
            }
        } else {
            System.out.println("\nNADA 1\n");
            U.agregarNuevoUsuario();
            return true;
        }
    }

    public boolean nuevoUsuario(Usuario U) throws ClassNotFoundException, SQLException {
        ResultSet NU;
        NU = U.consultaUsuarioId(U.getIdUsuario());

        if (NU.first()) {
            if (NU.getBoolean("estado")) {
                if (U.getIdUsuario()== NU.getInt("idUsuario")) {
                    boolean a;
                    a = modificarUsuario(U);
                    System.out.println("\nEXISTE + ACTIVO + ID + ??? 2\n");
                    return !a;
                } else {
                    System.out.println("\nEXISTE + ACTIVO 2\n");
                    return false;
                }
            } else {
                U.modificar();
                System.out.println("\nEXISTE 2\n");
                return false;
            }
        } else {
            System.out.println("\nNADA 2\n");
            U.agregarNuevoUsuario();
            return false;
        }
    }

    public Usuario buscarUsuario(String nombUsu) throws ClassNotFoundException, SQLException {
        ResultSet datosUsuario;
        Usuario miUsuario = new Usuario();
        datosUsuario = miUsuario.consultaUsuario(nombUsu);
        try {
            boolean primerUsuario = datosUsuario.first();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesLogueo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (datosUsuario.first()) {
            miUsuario.setIdUsuario(datosUsuario.getInt("idUsuario"));
            miUsuario.setNombreUsuario(datosUsuario.getString("nombreUsuario"));
            miUsuario.setNombreYApellido(datosUsuario.getString("nombreYApellido"));
            miUsuario.setContraseña(datosUsuario.getString("contraseña"));
            miUsuario.setTipoDocumento(datosUsuario.getString("tipoDocumento"));
            miUsuario.setNumDocumento(datosUsuario.getInt("numDocumento"));
            miUsuario.setTipoUsuario(datosUsuario.getInt("tipoUsuario"));
            miUsuario.setEstado(datosUsuario.getBoolean("estado"));
            if (miUsuario.isEstado()) {
                return miUsuario;
            } else {
                return null;
            }
        }
        return null;
    }

//    public Usuario buscarUsuarioId(int idUsuario) throws ClassNotFoundException, SQLException {
//        ResultSet datosUsuario;
//        Usuario miUsuario = new Usuario();
//        datosUsuario = miUsuario.consultaUsuarioId(idUsuario);
//        try {
//            boolean primeraUsuario = datosUsuario.first();
//        } catch (SQLException ex) {
//            Logger.getLogger(OperacionesLogueo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (datosUsuario.first()) {
//            miUsuario.setNombreUsuario(datosUsuario.getString("nombreUsuario"));
//            miUsuario.set(datosComida.getFloat("Precio"));
//            //miComida.setTipo(datosComida.getString("Tipo"));
//            //miComida.setEstado(datosComida.getBoolean("Estado"));
//            //System.out.println(miComida.getIdComida());
//            return miComida;
//        }
//        return null;
//    }

}
