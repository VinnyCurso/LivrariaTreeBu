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
public class PedidoLivroTest {
    
    public PedidoLivroTest() {
    }

    /**
     * Test of getPedido method, of class PedidoLivro.
     */
    @Test
    public void testGetPedido() {
        System.out.println("getPedido");
        PedidoLivro instance = new PedidoLivro();
        Pedido expResult = null;
        Pedido result = instance.getPedido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPedido method, of class PedidoLivro.
     */
    @Test
    public void testSetPedido() {
        System.out.println("setPedido");
        Pedido pedido = null;
        PedidoLivro instance = new PedidoLivro();
        instance.setPedido(pedido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLivro method, of class PedidoLivro.
     */
    @Test
    public void testGetLivro() {
        System.out.println("getLivro");
        PedidoLivro instance = new PedidoLivro();
        Livro expResult = null;
        Livro result = instance.getLivro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLivro method, of class PedidoLivro.
     */
    @Test
    public void testSetLivro() {
        System.out.println("setLivro");
        Livro livro = null;
        PedidoLivro instance = new PedidoLivro();
        instance.setLivro(livro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantidadeLivro method, of class PedidoLivro.
     */
    @Test
    public void testGetQuantidadeLivro() {
        System.out.println("getQuantidadeLivro");
        PedidoLivro instance = new PedidoLivro();
        int expResult = 0;
        int result = instance.getQuantidadeLivro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantidadeLivro method, of class PedidoLivro.
     */
    @Test
    public void testSetQuantidadeLivro() {
        System.out.println("setQuantidadeLivro");
        int quantidadeLivro = 0;
        PedidoLivro instance = new PedidoLivro();
        instance.setQuantidadeLivro(quantidadeLivro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorUnitario method, of class PedidoLivro.
     */
    @Test
    public void testGetValorUnitario() {
        System.out.println("getValorUnitario");
        PedidoLivro instance = new PedidoLivro();
        Double expResult = null;
        Double result = instance.getValorUnitario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorUnitario method, of class PedidoLivro.
     */
    @Test
    public void testSetValorUnitario() {
        System.out.println("setValorUnitario");
        Double valorUnitario = null;
        PedidoLivro instance = new PedidoLivro();
        instance.setValorUnitario(valorUnitario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class PedidoLivro.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PedidoLivro instance = new PedidoLivro();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
