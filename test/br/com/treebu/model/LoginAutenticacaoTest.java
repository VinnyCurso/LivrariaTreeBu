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
public class LoginAutenticacaoTest {
    
    public LoginAutenticacaoTest() {
    }

    /**
     * Test of getCodigo method, of class LoginAutenticacao.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        LoginAutenticacao instance = new LoginAutenticacao();
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class LoginAutenticacao.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        LoginAutenticacao instance = new LoginAutenticacao();
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class LoginAutenticacao.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        LoginAutenticacao instance = new LoginAutenticacao();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class LoginAutenticacao.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        LoginAutenticacao instance = new LoginAutenticacao();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSenha method, of class LoginAutenticacao.
     */
    @Test
    public void testGetSenha() {
        System.out.println("getSenha");
        LoginAutenticacao instance = new LoginAutenticacao();
        String expResult = "";
        String result = instance.getSenha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSenha method, of class LoginAutenticacao.
     */
    @Test
    public void testSetSenha() {
        System.out.println("setSenha");
        String senha = "";
        LoginAutenticacao instance = new LoginAutenticacao();
        instance.setSenha(senha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataAutenticacao method, of class LoginAutenticacao.
     */
    @Test
    public void testGetDataAutenticacao() {
        System.out.println("getDataAutenticacao");
        LoginAutenticacao instance = new LoginAutenticacao();
        Date expResult = null;
        Date result = instance.getDataAutenticacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataAutenticacao method, of class LoginAutenticacao.
     */
    @Test
    public void testSetDataAutenticacao() {
        System.out.println("setDataAutenticacao");
        Date dataAutenticacao = null;
        LoginAutenticacao instance = new LoginAutenticacao();
        instance.setDataAutenticacao(dataAutenticacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class LoginAutenticacao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LoginAutenticacao instance = new LoginAutenticacao();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
