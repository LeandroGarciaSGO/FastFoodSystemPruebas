/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author pablo
 */
public class Prueba {
    boolean validarCampoContraseña2(String contra) {
        if (contra.length() >= 8) {
            if (contra.length() <= 50) {
                if (contra.matches("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,50}$")) {
                    return true;
                } else {
                    System.out.println("ERROR: El Campo \"Contraseña\" Debe Contener Al Menos Una Letra Mayuscula, Una Letra Minuscula, Un Numero y Un Caracter Especial");
                    return false;
                }
            } else {
                System.out.println("ERROR: El Campo \"Contraseña\" No Debe Contener Mas de 50 Caracteres");
                return false;
            }
        } else {
            System.out.println("ERROR: El Campo \"Contraseña\" Debe Tener Como Minimo 8 Caracteres");
            return false;
        }
    }
    
        boolean validarCampos2(String tel, String nomb, String ape, String dom){
        try{
            Long.parseLong(tel);
            if(nomb.length() <= 0){
                 System.out.println("ERROR: El Nombre No Debe Ser Vacio");
                return false;
            }
            if(ape.length() <= 0){
                 System.out.println("ERROR: El Apellido No Debe Ser Vacio");
                return false;
            }
            if(dom.length() <= 0){
                 System.out.println("ERROR: El Domicilio No Debe Ser Vacio");
                return false;
            }
            return true;
        }
        catch(NumberFormatException e){
             System.out.println("ERROR: El Telefono Debe Ser Numerico");
            return false;
        }
        
    }
    
}
