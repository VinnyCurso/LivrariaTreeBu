/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.model;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author vinicius caetano
 */
public class AutorTest {
    
    public AutorTest() {
    }

    /**
     * Test of getCodigo method, of class Autor.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Autor instance = new Autor();
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class Autor.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        Autor instance = new Autor();
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Autor.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Autor instance = new Autor();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Autor.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Autor instance = new Autor();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNacionalidade method, of class Autor.
     */
    @Test
    public void testGetNacionalidade() {
        System.out.println("getNacionalidade");
        Autor instance = new Autor();
        String expResult = "";
        String result = instance.getNacionalidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNacionalidade method, of class Autor.
     */
    @Test
    public void testSetNacionalidade() {
        System.out.println("setNacionalidade");
        String nacionalidade = "";
        Autor instance = new Autor();
        instance.setNacionalidade(nacionalidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataNascimento method, of class Autor.
     */
    @Test
    public void testGetDataNascimento() {
        System.out.println("getDataNascimento");
        Autor instance = new Autor();
        Date expResult = null;
        Date result = instance.getDataNascimento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataNascimento method, of class Autor.
     */
    @Test
    public void testSetDataNascimento() {
        System.out.println("setDataNascimento");
        Date dataNascimento = null;
        Autor instance = new Autor();
        instance.setDataNascimento(dataNascimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isStatus method, of class Autor.
     */
    @Test
    public void testIsStatus() {
        System.out.println("isStatus");
        Autor instance = new Autor();
        boolean expResult = false;
        boolean result = instance.isStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Autor.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        boolean status = false;
        Autor instance = new Autor();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class Autor.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Autor instance = new Autor();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescricao method, of class Autor.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        Autor instance = new Autor();
        instance.setDescricao(descricao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Autor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Autor instance = new Autor();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
