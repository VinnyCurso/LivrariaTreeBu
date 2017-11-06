/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;

import br.com.treebu.dao.ClienteDao;
import br.com.treebu.dao.EnderecoDao;
import br.com.treebu.model.Cliente;
import br.com.treebu.model.Endereco;
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
public class ClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String FormularioCliente = "/Cliente.jsp";
    private static String List_Clientes = "/ListaClientes.jsp";
    private ClienteDao clinteDAO;
    private EnderecoDao enderecoDAO;

    public ClienteServlet() throws SQLException {
        super();
        enderecoDAO = new EnderecoDao();
        clinteDAO = new ClienteDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("remover")) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            clinteDAO.Deletar(codigo);
        }
        if (action.equalsIgnoreCase("alterar")) {
            try {
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                Cliente cliente = clinteDAO.ConsultarPorCodigo(codigo);
                
                request.setAttribute("cliente", cliente);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(List_Clientes);
        request.setAttribute("clienteList", clinteDAO.Listar());
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

        Cliente cliente = new Cliente();
        cliente.setEndereco(new Endereco());

        cliente.setEmail(request.getParameter("email"));
        cliente.setSenha(request.getParameter("senha"));
        cliente.setNome(request.getParameter("nome"));
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setCpf(request.getParameter("cpf"));

        try {
            Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataNascimento"));
            cliente.setDataNascimento(dataNascimento);
        } catch (ParseException e) {
            e.getMessage();
        }

        cliente.getEndereco().setCodigo(Integer.parseInt(request.getParameter("codendereco")));

        try {
            Date dataCadastro = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataCadastro"));
            cliente.setDataNascimento(dataCadastro);
        } catch (ParseException e) {
            e.getMessage();
        }

        String codigo = request.getParameter("codigo");

        if (codigo == null || codigo.isEmpty()) {
            clinteDAO.Cadastrar(cliente);
        } else {
            cliente.setCodigo(Integer.parseInt(codigo));
            clinteDAO.Atualizar(cliente);
        }
        RequestDispatcher view = request.getRequestDispatcher(List_Clientes);
        request.setAttribute("clienteList", clinteDAO.Listar());
        view.forward(request, response);
    }

}
