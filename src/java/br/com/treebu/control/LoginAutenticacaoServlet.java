/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;

import br.com.treebu.dao.ClienteDao;
import br.com.treebu.dao.LoginAutenticacaoDao;
import br.com.treebu.model.Cliente;
import br.com.treebu.model.LoginAutenticacao;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author vinicius caetano
 */
public class LoginAutenticacaoServlet extends HttpServlet {

   
   private static final long serialVersionUID = 1L;
    private static String Formulario = "/Login.jsp";
    private static String Relatorio_Login = "/RelatorioLogin.jsp";
    private LoginAutenticacaoDao loginDAO;

    public LoginAutenticacaoServlet() throws SQLException {
        super();
        loginDAO = new LoginAutenticacaoDao();
    }
    
       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String status = "";
        
        Cliente cliente = new Cliente();
     
        
        cliente.setEmail(email);
        cliente.setSenha(senha);
        RequestDispatcher rd = null;
        ClienteDao userDAO = new ClienteDao();
        
        
         if (userDAO.validarAutenticacao(cliente)) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("sessaoUsuario", email);
            rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("mensagem", "Usuario ou Senha Invalidos");
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            loginDAO.Deletar(codigo);
            forward = Relatorio_Login;
            request.setAttribute("loginList", loginDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = Formulario;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            LoginAutenticacao login = loginDAO.ConsultarPorCodigo(codigo);
            request.setAttribute("login", login);
        } else if (action.equalsIgnoreCase("RelatorioLogin")) {
            forward = Relatorio_Login;
            request.setAttribute("loginList", loginDAO.Listar());
        } else {
            forward = Formulario;
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LoginAutenticacao login = new LoginAutenticacao();

        login.setEmail(request.getParameter("email"));
        login.setSenha(request.getParameter("senha"));
        try {
            Date dataAutenticacao = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataAutenticacao"));
            login.setDataAutenticacao(dataAutenticacao);
        } catch (ParseException e) {
            e.getMessage();
        }
      
        String codigo = request.getParameter("codigo");
        
        if (codigo == null || codigo.isEmpty()) {

            loginDAO.Cadastrar(login);
        } else {

            login.setCodigo(Integer.parseInt(codigo));
            loginDAO.Atualizar(login);
        }
        RequestDispatcher view = request.getRequestDispatcher(Relatorio_Login);
        request.setAttribute("loginList", loginDAO.Listar());
        view.forward(request, response);
    }



}
