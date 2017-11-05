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
public class LivroTest {
    
    public LivroTest() {
    }

    /**
     * Test of getCodigo method, of class Livro.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Livro instance = new Livro();
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class Livro.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        Livro instance = new Livro();
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEditora method, of class Livro.
     */
    @Test
    public void testGetEditora() {
        System.out.println("getEditora");
        Livro instance = new Livro();
        Editora expResult = null;
        Editora result = instance.getEditora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEditora method, of class Livro.
     */
    @Test
    public void testSetEditora() {
        System.out.println("setEditora");
        Editora editora = null;
        Livro instance = new Livro();
        instance.setEditora(editora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAutor method, of class Livro.
     */
    @Test
    public void testGetAutor() {
        System.out.println("getAutor");
        Livro instance = new Livro();
        Autor expResult = null;
        Autor result = instance.getAutor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAutor method, of class Livro.
     */
    @Test
    public void testSetAutor() {
        System.out.println("setAutor");
        Autor autor = null;
        Livro instance = new Livro();
        instance.setAutor(autor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGenero method, of class Livro.
     */
    @Test
    public void testGetGenero() {
        System.out.println("getGenero");
        Livro instance = new Livro();
        Genero expResult = null;
        Genero result = instance.getGenero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGenero method, of class Livro.
     */
    @Test
    public void testSetGenero() {
        System.out.println("setGenero");
        Genero genero = null;
        Livro instance = new Livro();
        instance.setGenero(genero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdioma method, of class Livro.
     */
    @Test
    public void testGetIdioma() {
        System.out.println("getIdioma");
        Livro instance = new Livro();
        Idioma expResult = null;
        Idioma result = instance.getIdioma();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdioma method, of class Livro.
     */
    @Test
    public void testSetIdioma() {
        System.out.println("setIdioma");
        Idioma idioma = null;
        Livro instance = new Livro();
        instance.setIdioma(idioma);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataPublicacao method, of class Livro.
     */
    @Test
    public void testGetDataPublicacao() {
        System.out.println("getDataPublicacao");
        Livro instance = new Livro();
        Date expResult = null;
        Date result = instance.getDataPublicacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataPublicacao method, of class Livro.
     */
    @Test
    public void testSetDataPublicacao() {
        System.out.println("setDataPublicacao");
        Date dataPublicacao = null;
        Livro instance = new Livro();
        instance.setDataPublicacao(dataPublicacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Livro.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Livro instance = new Livro();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Livro.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Livro instance = new Livro();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class Livro.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Livro instance = new Livro();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescricao method, of class Livro.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        Livro instance = new Livro();
        instance.setDescricao(descricao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeroPaginas method, of class Livro.
     */
    @Test
    public void testGetNumeroPaginas() {
        System.out.println("getNumeroPaginas");
        Livro instance = new Livro();
        int expResult = 0;
        int result = instance.getNumeroPaginas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroPaginas method, of class Livro.
     */
    @Test
    public void testSetNumeroPaginas() {
        System.out.println("setNumeroPaginas");
        int numeroPaginas = 0;
        Livro instance = new Livro();
        instance.setNumeroPaginas(numeroPaginas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreco method, of class Livro.
     */
    @Test
    public void testGetPreco() {
        System.out.println("getPreco");
        Livro instance = new Livro();
        Double expResult = null;
        Double result = instance.getPreco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPreco method, of class Livro.
     */
    @Test
    public void testSetPreco() {
        System.out.println("setPreco");
        Double preco = null;
        Livro instance = new Livro();
        instance.setPreco(preco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvaliacao method, of class Livro.
     */
    @Test
    public void testGetAvaliacao() {
        System.out.println("getAvaliacao");
        Livro instance = new Livro();
        int expResult = 0;
        int result = instance.getAvaliacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvaliacao method, of class Livro.
     */
    @Test
    public void testSetAvaliacao() {
        System.out.println("setAvaliacao");
        int avaliacao = 0;
        Livro instance = new Livro();
        instance.setAvaliacao(avaliacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsbn method, of class Livro.
     */
    @Test
    public void testGetIsbn() {
        System.out.println("getIsbn");
        Livro instance = new Livro();
        String expResult = "";
        String result = instance.getIsbn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsbn method, of class Livro.
     */
    @Test
    public void testSetIsbn() {
        System.out.println("setIsbn");
        String isbn = "";
        Livro instance = new Livro();
        instance.setIsbn(isbn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCapa method, of class Livro.
     */
    @Test
    public void testGetCapa() {
        System.out.println("getCapa");
        Livro instance = new Livro();
        Byte expResult = null;
        Byte result = instance.getCapa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCapa method, of class Livro.
     */
    @Test
    public void testSetCapa() {
        System.out.println("setCapa");
        Byte capa = null;
        Livro instance = new Livro();
        instance.setCapa(capa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Livro.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Livro instance = new Livro();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
