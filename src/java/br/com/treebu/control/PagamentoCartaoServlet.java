/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;


import br.com.treebu.dao.PagamentoCartaoDao;
import br.com.treebu.model.PagamentoCartao;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinicius caetano
 */
public class PagamentoCartaoServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;
    private static String Formulario = "/PagamentoCartao.jsp";
    private static String List_PgtCartao = "/ListaPagamentoCartao.jsp";
    private PagamentoCartaoDao pgtCartaoDAO;

    public PagamentoCartaoServlet() throws SQLException {
        super();
        pgtCartaoDAO = new PagamentoCartaoDao();
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            pgtCartaoDAO.Deletar(codigo);
            forward = List_PgtCartao;
            request.setAttribute("generoList", pgtCartaoDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = Formulario;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            PagamentoCartao pgtcartao = pgtCartaoDAO.ConsultarPorCodigo(codigo);
            request.setAttribute("pgtcartao", pgtcartao);
        } else if (action.equalsIgnoreCase("ListaPagamentoCartao")) {
            forward = List_PgtCartao;
            request.setAttribute("pgtCartaoList", pgtCartaoDAO.Listar());
        } else {
            forward = Formulario;
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PagamentoCartao pgtCartao = new PagamentoCartao();

        pgtCartao.setNomeTitular(request.getParameter("bnometitular"));
        pgtCartao.setNumerosCartao(Long.parseLong(request.getParameter("bnumerocartao")));
       try {
            Date dataValidade;
            dataValidade = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datevalidade"));
            pgtCartao.setDataValidade(dataValidade);
        } catch (ParseException e) {
            e.getMessage();
        }
        pgtCartao.setCodSeguranca(Integer.parseInt(request.getParameter("codseguranca")));
        pgtCartao.setQtdParcelas(Integer.parseInt(request.getParameter("bqtdparcelas")));
       
      
        String id = request.getParameter("id");
        
        if (id == null || id.isEmpty()) {

            pgtCartaoDAO.Cadastrar(pgtCartao);
        } else {

            pgtCartao.setId(Integer.parseInt(id));
            pgtCartaoDAO.Atualizar(pgtCartao);
        }
        RequestDispatcher view = request.getRequestDispatcher(List_PgtCartao);
        request.setAttribute("pgtCartaoList", pgtCartaoDAO.Listar());
        view.forward(request, response);
    }

    }

    
