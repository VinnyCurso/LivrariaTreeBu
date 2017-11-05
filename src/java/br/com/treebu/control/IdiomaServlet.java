/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;

import br.com.treebu.dao.IdiomaDao;
import br.com.treebu.model.Idioma;
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
public class IdiomaServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;
    private static String Formulario = "/Idioma.jsp";
    private static String List_Idiomas = "/ListaIdiomas.jsp";
    private IdiomaDao idiomaDAO;

    public IdiomaServlet() throws SQLException {
        super();
        idiomaDAO = new IdiomaDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            idiomaDAO.Deletar(codigo);
            forward = List_Idiomas;
            request.setAttribute("idiomaList", idiomaDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = Formulario;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Idioma idioma = idiomaDAO.ConsultarPorCodigo(codigo);
            request.setAttribute("idioma", idioma);
        } else if (action.equalsIgnoreCase("ListaIdiomas")) {
            forward = List_Idiomas;
            request.setAttribute("idiomaList", idiomaDAO.Listar());
        } else {
            forward = Formulario;
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Idioma idioma = new Idioma();

        idioma.setDescricao(request.getParameter("descricao"));
      
        String codigo = request.getParameter("codigo");
        
        if (codigo == null || codigo.isEmpty()) {

            idiomaDAO.Cadastrar(idioma);
        } else {

            idioma.setCodigo(Integer.parseInt(codigo));
            idiomaDAO.Atualizar(idioma);
        }
        RequestDispatcher view = request.getRequestDispatcher(List_Idiomas);
        request.setAttribute("idiomaList", idiomaDAO.Listar());
        view.forward(request, response);
    }


}
