/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;

import br.com.treebu.dao.EnderecoDao;
import br.com.treebu.dao.FuncionarioDao;
import br.com.treebu.model.Endereco;
import br.com.treebu.model.Funcionario;
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
public class FuncionarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String FormularioFuncionario = "/Funcionario.jsp";
    private static String List_Funcionario = "/ListaFuncionarios.jsp";
    private FuncionarioDao funcionarioDAO;
    private EnderecoDao enderecoDAO;

    public FuncionarioServlet() throws SQLException {
        super();
        enderecoDAO = new EnderecoDao();
        funcionarioDAO = new FuncionarioDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String forward = "";
        String action = request.getParameter("action");
       

        if (action.equalsIgnoreCase("remover")){
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            funcionarioDAO.Deletar(codigo);
        } 
        if (action.equalsIgnoreCase("alterar")){
            try {
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                Funcionario funcionario = funcionarioDAO.ConsultarPorCodigo(codigo);
                
                 
                request.setAttribute("funcionario", funcionario);
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        RequestDispatcher view = request.getRequestDispatcher(List_Funcionario);
        request.setAttribute("funcionarioList", funcionarioDAO.Listar());
        request.setAttribute("enderecoList", enderecoDAO.Listar());
        view.forward(request, response);
        
        //Outra Forma
        
//        if (action.equalsIgnoreCase("delete")) {
//
//            int codigo = Integer.parseInt(request.getParameter("codigo"));
//            clinteDAO.Deletar(codigo);
//            forward = List_Clientes;
//            request.setAttribute("clienteList", clinteDAO.Listar());
//
//        } else if (action.equalsIgnoreCase("edit")) {
//            forward = FormularioCliente;
//            int codigo = Integer.parseInt(request.getParameter("codigo"));
//
//            Cliente cliente = clinteDAO.ConsultarPorCodigo(codigo);
//            request.setAttribute("cliente", cliente);
//        } else if (action.equalsIgnoreCase("ListaClientes")) {
//            forward = List_Clientes;
//            request.setAttribute("clienteList", clinteDAO.Listar());
//            request.setAttribute("enderecoList", enderecoDAO.Listar());
//        } else {
//            forward = FormularioCliente;
//        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        Funcionario funcionario = new Funcionario();
        funcionario.setEndereco(new Endereco());
       
         funcionario.setEmail(request.getParameter("email"));
         funcionario.setSenha(request.getParameter("senha"));
         funcionario.setNome(request.getParameter("nome"));
         funcionario.setTelefone(request.getParameter("telefone"));
         funcionario.setCpf(request.getParameter("cpf"));
         
         try {
            Date dataNascimento = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dataNascimento"));
            funcionario.setDataNascimento(dataNascimento);
        } catch (ParseException e) {
            e.getMessage();
        }
         
        funcionario.getEndereco().setCodigo(Integer.parseInt(request.getParameter("codendereco")));
        
        try {
            Date dataAdmissao = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dataAdmissao"));
            funcionario.setDataNascimento(dataAdmissao);
        } catch (ParseException e) {
            e.getMessage();
        }
        
        String codigo = request.getParameter("codigo");
        
        if(codigo == null || codigo.isEmpty())
        {
            funcionarioDAO.Cadastrar(funcionario);
        }
        else
        {
            funcionario.setCodigo(Integer.parseInt(codigo));
            funcionarioDAO.Atualizar(funcionario);
        }
        RequestDispatcher view = request.getRequestDispatcher(List_Funcionario);
        request.setAttribute("funcionarioList", funcionarioDAO.Listar());
        view.forward(request, response);
    }

}
