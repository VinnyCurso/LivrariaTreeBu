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
public class EstoqueTest {
    
    public EstoqueTest() {
    }

    /**
     * Test of getCodigo method, of class Estoque.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Estoque instance = new Estoque();
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class Estoque.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        Estoque instance = new Estoque();
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescProduto method, of class Estoque.
     */
    @Test
    public void testGetDescProduto() {
        System.out.println("getDescProduto");
        Estoque instance = new Estoque();
        String expResult = "";
        String result = instance.getDescProduto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescProduto method, of class Estoque.
     */
    @Test
    public void testSetDescProduto() {
        System.out.println("setDescProduto");
        String descProduto = "";
        Estoque instance = new Estoque();
        instance.setDescProduto(descProduto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantidade method, of class Estoque.
     */
    @Test
    public void testGetQuantidade() {
        System.out.println("getQuantidade");
        Estoque instance = new Estoque();
        int expResult = 0;
        int result = instance.getQuantidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantidade method, of class Estoque.
     */
    @Test
    public void testSetQuantidade() {
        System.out.println("setQuantidade");
        int quantidade = 0;
        Estoque instance = new Estoque();
        instance.setQuantidade(quantidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Estoque.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Estoque instance = new Estoque();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
