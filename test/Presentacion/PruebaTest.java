/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pablo
 */
public class PruebaTest {
    
    public PruebaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validarCampoContraseña2 method, of class Prueba.
     */
    @Test
    public void testValidarCampoContraseña2Prueba1() {
        System.out.println("Contraseña vacia");
        String contra = "";
        Prueba instance = new Prueba();
        boolean expResult = false;
        boolean result = instance.validarCampoContraseña2(contra);
        assertEquals(expResult, result);
        if (result==expResult){
            System.out.println("Incorrecto");
        }else{
            System.out.println("Correcto");
        }
    }
    
    @Test
        public void testValidarCampoContraseña2Prueba2() {
        System.out.println("Contraseña sin caracter especial");
        String contra = "123AAAaaa";
        Prueba instance = new Prueba();
        boolean expResult = false;
        boolean result = instance.validarCampoContraseña2(contra);
        assertEquals(expResult, result);
        if (result==expResult){
            System.out.println("Incorrecto");
        }else{
            System.out.println("Correcto");
        }
    }
    
    @Test
    public void testValidarCampoContraseña2Prueba3() {
        System.out.println("Contraseña valida");
        String contra = "12345Aa!";
        Prueba instance = new Prueba();
        boolean expResult = true;
        boolean result = instance.validarCampoContraseña2(contra);
        assertEquals(expResult, result);
        if (result==expResult){
            System.out.println("Correcto");
        }else{
            System.out.println("Incorrecto");
        }
    }
    
    @Test
    public void testValidarCampoContraseña2Prueba4() {
        System.out.println("Contraseña mayor a 50 caracteres");
        String contra = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        Prueba instance = new Prueba();
        boolean expResult = false;
        boolean result = instance.validarCampoContraseña2(contra);
        assertEquals(expResult, result);
        if (result==expResult){
            System.out.println("Incorrecto");
        }else{
            System.out.println("Correcto");
        }
    }

    /**
     * Test of validarCampos2 method, of class Prueba.
     */   
    @Test
    public void testValidarCampos2Prueba1() {
        System.out.println("Telefono vacio");
        String tel = "";
        String nomb = "Alejandra";
        String ape = "Toledo";
        String dom = "Juan Felipe Ibarra 595";
        Prueba instance = new Prueba();
        boolean expResult = false;
        boolean result = instance.validarCampos2(tel, nomb, ape, dom);
        assertEquals(expResult, result);
        if (result==expResult){
            System.out.println("Incorrecto");
        }else{
            System.out.println("Correcto");
        }

    }
    
    @Test
    public void testValidarCampos2Prueba2() {
        System.out.println("nombre vacio");
        String tel = "4226262";
        String nomb = "";
        String ape = "Toledo";
        String dom = "Juan Felipe Ibarra 595";
        Prueba instance = new Prueba();
        boolean expResult = false;
        boolean result = instance.validarCampos2(tel, nomb, ape, dom);
        assertEquals(expResult, result);
        if (result==expResult){
            System.out.println("Incorrecto");
        }else{
            System.out.println("Correcto");
        }

    }
    
    @Test
    public void testValidarCampos2Prueba3() {
        System.out.println("apellido vacio");
        String tel = "4226262";
        String nomb = "Alejandra";
        String ape = "";
        String dom = "Juan Felipe Ibarra 595";
        Prueba instance = new Prueba();
        boolean expResult = false;
        boolean result = instance.validarCampos2(tel, nomb, ape, dom);
        assertEquals(expResult, result);
        if (result==expResult){
            System.out.println("Incorrecto");
        }else{
            System.out.println("Correcto");
        }

    }
    
    @Test
    public void testValidarCampos2Prueba4() {
        System.out.println("domicilio vacio");
        String tel = "4226262";
        String nomb = "Alejandra";
        String ape = "Toledo";
        String dom = "";
        Prueba instance = new Prueba();
        boolean expResult = false;
        boolean result = instance.validarCampos2(tel, nomb, ape, dom);
        assertEquals(expResult, result);
        if (result==expResult){
            System.out.println("Incorrecto");
        }else{
            System.out.println("Correcto");
        }

    }
    
    @Test
    public void testValidarCampos2Prueba5() {
        System.out.println("cliente correcto");
        String tel = "4226262";
        String nomb = "Alejandra";
        String ape = "Gonzalez";
        String dom = "Juan Felipe Ibarra 595";
        Prueba instance = new Prueba();
        boolean expResult = true;
        boolean result = instance.validarCampos2(tel, nomb, ape, dom);
        assertEquals(expResult, result);
        if (result==expResult){
            System.out.println("Correcto");
        }else{
            System.out.println("Incorrecto");
        }

    }
    
}
