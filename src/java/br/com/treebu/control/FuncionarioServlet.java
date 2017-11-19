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
    private static String Formulario = "/Funcionario.jsp";
    private static String List_Funcionario = "/ListaClientes.jsp";
    private static String List_Endereco = "/ListaEnderecos.jsp";
    private FuncionarioDao funcionarioDAO;
    private EnderecoDao enderecoDAO;

    public FuncionarioServlet() throws SQLException {
        super();
        enderecoDAO = new EnderecoDao();
        funcionarioDAO = new FuncionarioDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            funcionarioDAO.Deletar(codigo);
        }
        if (action.equalsIgnoreCase("edit")) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Funcionario funcionario = funcionarioDAO.ConsultarPorCodigo(codigo);

            request.setAttribute("funcionario", funcionario);

        } else if (action.equalsIgnoreCase("ListaEnderecos")) {
            forward = List_Endereco;
            request.setAttribute("enderecoList", enderecoDAO.Listar());
        }

        RequestDispatcher view = request.getRequestDispatcher(Formulario);
        request.setAttribute("funcionanrioList", funcionarioDAO.Listar()); //ConsultarTodos
        request.setAttribute("enderecoList", enderecoDAO.Listar());//Listar(action)
        view.forward(request, response);
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
            Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datenascimento"));
            funcionario.setDataNascimento(dataNascimento);
        } catch (ParseException e) {
            e.getMessage();
        }

        funcionario.getEndereco().setCodigo(Integer.parseInt(request.getParameter("codigo_endereco")));

        try {
            Date dataAdmissao = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateadmissao"));
            funcionario.setDataAdmissao(dataAdmissao);
        } catch (ParseException e) {
            e.getMessage();
        }
        
        funcionario.setCtps(request.getParameter("ctps"));

        String codigo = request.getParameter("codigo");

        if (codigo == null || codigo.isEmpty()) {
            funcionarioDAO.Cadastrar(funcionario);
        } else {
            funcionario.setCodigo(Integer.parseInt(codigo));
            funcionarioDAO.Atualizar(funcionario);
        }
        RequestDispatcher view = request.getRequestDispatcher(Formulario);
        request.setAttribute("funcionarioList", funcionarioDAO.Listar());
        view.forward(request, response);
    }

}
