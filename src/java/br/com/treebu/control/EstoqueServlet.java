/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;

import br.com.treebu.dao.EstoqueDao;
import br.com.treebu.model.Estoque;
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
public class EstoqueServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String Formulario = "/Estoque.jsp";
    private static String List_Estoque = "/ListaEstoque.jsp";
    private EstoqueDao estoqueDAO;

    public EstoqueServlet() throws SQLException {
        super();
        estoqueDAO = new EstoqueDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            estoqueDAO.Deletar(codigo);
            forward = List_Estoque;
            request.setAttribute("estoqueList", estoqueDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = Formulario;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Estoque estoque = estoqueDAO.ConsultarPorCodigo(codigo);
            request.setAttribute("estoque", estoque);
        } else if (action.equalsIgnoreCase("ListaEstoque")) {
            forward = List_Estoque;
            request.setAttribute("estoqueList", estoqueDAO.Listar());
        } else {
            forward = Formulario;
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Estoque estoque = new Estoque();

        estoque.setDescProduto(request.getParameter("descProduto"));
        estoque.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
      
        String codigo = request.getParameter("codigo");
        
        if (codigo == null || codigo.isEmpty()) {

            estoqueDAO.Cadastrar(estoque);
        } else {

            estoque.setCodigo(Integer.parseInt(codigo));
            estoqueDAO.Atualizar(estoque);
        }
        RequestDispatcher view = request.getRequestDispatcher(List_Estoque);
        request.setAttribute("estoqueList", estoqueDAO.Listar());
        view.forward(request, response);
    }

}
