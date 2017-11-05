/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;

import br.com.treebu.dao.GeneroDao;
import br.com.treebu.model.Genero;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinicius caetano
 */
public class GeneroServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String Formulario = "/Genero.jsp";
    private static String List_Generos = "/ListaGeneros2.jsp";
    private GeneroDao generoDAO;

    public GeneroServlet() throws SQLException {
        super();
        generoDAO = new GeneroDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            generoDAO.Deletar(codigo);
            forward = List_Generos;
            request.setAttribute("generoList", generoDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = Formulario;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Genero genero = generoDAO.ConsultarPorCodigo(codigo);
            request.setAttribute("genero", genero);
        } else if (action.equalsIgnoreCase("ListaGeneros2")) {
            forward = List_Generos;
            request.setAttribute("generoList", generoDAO.Listar());
        } else {
            forward = Formulario;
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Genero genero = new Genero();

        genero.setDescricao(request.getParameter("descricao"));
      
        String codigo = request.getParameter("codigo");
        
        if (codigo == null || codigo.isEmpty()) {

            generoDAO.Cadastrar(genero);
        } else {

            genero.setCodigo(Integer.parseInt(codigo));
            generoDAO.Atualizar(genero);
        }
        RequestDispatcher view = request.getRequestDispatcher(List_Generos);
        request.setAttribute("generoList", generoDAO.Listar());
        view.forward(request, response);
    }


}
