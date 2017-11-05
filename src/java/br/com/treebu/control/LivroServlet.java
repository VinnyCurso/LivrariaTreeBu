/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;

import br.com.treebu.dao.AutorDao;
import br.com.treebu.dao.EditoraDao;
import br.com.treebu.dao.GeneroDao;
import br.com.treebu.dao.IdiomaDao;
import br.com.treebu.dao.LivroDao;
import br.com.treebu.model.Autor;
import br.com.treebu.model.Editora;
import br.com.treebu.model.Genero;
import br.com.treebu.model.Idioma;
import br.com.treebu.model.Livro;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinicius caetano
 */
public class LivroServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String Formulario = "/Livro.jsp";
    private static String List_Livro = "/ListaLivros.jsp";
    private LivroDao livroDAO;
    private AutorDao autorDAO;
    private EditoraDao editoraDAO;
    private GeneroDao generoDAO;
    private IdiomaDao idiomaDAO;

    public LivroServlet() throws SQLException {
        super();
        livroDAO = new LivroDao();
        autorDAO = new AutorDao();
        editoraDAO = new EditoraDao();
        generoDAO = new GeneroDao();
        idiomaDAO = new IdiomaDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            livroDAO.Deletar(codigo);
            forward = List_Livro;
            request.setAttribute("livroList", livroDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            try {
                forward = Formulario;
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                
                Livro livro = livroDAO.ConsultarPorCodigo(codigo);
                request.setAttribute("livro", livro);
            } catch (SQLException ex) {
                Logger.getLogger(LivroServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equalsIgnoreCase("ListaLivros")) {
            forward = List_Livro;
            request.setAttribute("livroList", livroDAO.Listar());
            request.setAttribute("editoraList", editoraDAO.Listar());
            request.setAttribute("autorList", autorDAO.Listar());
            request.setAttribute("generoList", generoDAO.Listar());
            request.setAttribute("idiomaList", idiomaDAO.Listar());
        } else {
            forward = Formulario;
        }

//        RequestDispatcher view = request.getRequestDispatcher(List_Livro);
//        request.setAttribute("livroList", livroDAO.Listar());
//        request.setAttribute("editoraList", editoraDAO.Listar());
//        request.setAttribute("autorList", autorDAO.Listar());
//        request.setAttribute("generoList", generoDAO.Listar());
//        request.setAttribute("idiomaList", idiomaDAO.Listar());
//        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Livro livro = new Livro();

        livro.setEditora(new Editora());
        livro.getEditora().setCodigo(Integer.parseInt(request.getParameter("codeditora")));
        livro.setAutor(new Autor());
        livro.getAutor().setCodigo(Integer.parseInt(request.getParameter("codautor")));
        livro.setGenero(new Genero());
        livro.getGenero().setCodigo(Integer.parseInt(request.getParameter("codgenero")));
        livro.setIdioma(new Idioma());
        livro.getIdioma().setCodigo(Integer.parseInt(request.getParameter("codidioma")));

        try {
            Date dataPublicacao = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dataPublicacao"));
            livro.setDataPublicacao(dataPublicacao);
        } catch (ParseException e) {
            e.getMessage();
        }

        livro.setNome(request.getParameter("nome"));
        livro.setDescricao(request.getParameter("descricao"));
        livro.setNumeroPaginas(Integer.parseInt(request.getParameter("numeroPaginas")));
        livro.setPreco(Double.parseDouble(request.getParameter("preco")));
        livro.setAvaliacao(Integer.parseInt(request.getParameter("avaliacao")));
        livro.setIsbn(request.getParameter("isbn"));
        livro.setCapa(Byte.parseByte(request.getParameter("capa")));

        String codigo = request.getParameter("codigo");

        if (codigo == null || codigo.isEmpty()) {

            livroDAO.Cadastrar(livro);
        } else {

            livro.setCodigo(Integer.parseInt(codigo));
            livroDAO.Atualizar(livro);
        }
        RequestDispatcher view = request.getRequestDispatcher(List_Livro);
        request.setAttribute("livroList", livroDAO.Listar());
        view.forward(request, response);
    }

}
