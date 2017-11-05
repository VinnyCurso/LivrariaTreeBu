/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author vinicius caetano
 */
public class IdiomaTest {
    
    public IdiomaTest() {
    }

    /**
     * Test of getCodigo method, of class Idioma.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Idioma instance = new Idioma();
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class Idioma.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        Idioma instance = new Idioma();
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class Idioma.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Idioma instance = new Idioma();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescricao method, of class Idioma.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        Idioma instance = new Idioma();
        instance.setDescricao(descricao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Idioma.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Idioma instance = new Idioma();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
