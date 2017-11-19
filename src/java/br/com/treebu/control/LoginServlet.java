/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;

import br.com.treebu.dao.LoginAutenticacaoDao;
import br.com.treebu.model.LoginAutenticacao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius caetano
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginAutenticacaoDao loginDAO;
    
  
public LoginServlet() throws SQLException{
    super();
    loginDAO = new LoginAutenticacaoDao();
}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
 
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
        
        LoginAutenticacao loginE = new LoginAutenticacao();
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String status = "";
       
            if(loginDAO.validarLogin(email, senha)){
                HttpSession sessao = request.getSession();
                sessao.setAttribute("sessaoUsuario", email);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                
            }else{
                request.setAttribute("mensagem", "Usuario/senha invalidos");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Erro"+ex.getMessage());
        }
       
}

}
