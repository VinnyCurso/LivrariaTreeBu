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
public class PedidoTest {
    
    public PedidoTest() {
    }

    /**
     * Test of getCodigo method, of class Pedido.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Pedido instance = new Pedido();
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class Pedido.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        Pedido instance = new Pedido();
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class Pedido.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        Pedido instance = new Pedido();
        Cliente expResult = null;
        Cliente result = instance.getCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCliente method, of class Pedido.
     */
    @Test
    public void testSetCliente() {
        System.out.println("setCliente");
        Cliente cliente = null;
        Pedido instance = new Pedido();
        instance.setCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorTotal method, of class Pedido.
     */
    @Test
    public void testGetValorTotal() {
        System.out.println("getValorTotal");
        Pedido instance = new Pedido();
        Double expResult = null;
        Double result = instance.getValorTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorTotal method, of class Pedido.
     */
    @Test
    public void testSetValorTotal() {
        System.out.println("setValorTotal");
        Double valorTotal = null;
        Pedido instance = new Pedido();
        instance.setValorTotal(valorTotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Pedido.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Pedido instance = new Pedido();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
