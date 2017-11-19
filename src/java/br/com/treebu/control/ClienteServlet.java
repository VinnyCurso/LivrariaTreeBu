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
    private static String Formulario = "/Cliente.jsp";
    private static String List_Clientes = "/ListaClientes.jsp";
    private static String List_Endereco = "/ListaEnderecos.jsp";
    private ClienteDao clienteDAO;
    private EnderecoDao enderecoDAO;

    public ClienteServlet() throws SQLException {
        super();
        enderecoDAO = new EnderecoDao();
        clienteDAO = new ClienteDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            clienteDAO.Deletar(codigo);
            
        }
        if (action.equalsIgnoreCase("edit")) {
            
            int codigo = Integer.parseInt(request.getParameter("codigo")); 
            Cliente cliente = clienteDAO.ConsultarPorCodigo(codigo);
            request.setAttribute("cliente", cliente);
            
        } else if (action.equalsIgnoreCase("ListaEnderecos")) {
            forward = List_Endereco;
            request.setAttribute("enderecoList", enderecoDAO.Listar());
        }
        
//            else if (action.equalsIgnoreCase("ListaClientes")) {
//            forward = List_Clientes;
//            request.setAttribute("clienteList", clienteDAO.Listar());
//            }
        

        RequestDispatcher view = request.getRequestDispatcher(Formulario); //
        request.setAttribute("clienteList", clienteDAO.Listar()); //ConsultarTodos
        request.setAttribute("enderecoList", enderecoDAO.Listar());//Listar(action)
        view.forward(request, response);
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
            Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datenascimento"));
            cliente.setDataNascimento(dataNascimento);
        } catch (ParseException e) {
            e.getMessage();
        }

        cliente.getEndereco().setCodigo(Integer.parseInt(request.getParameter("codigo_endereco")));

        try {
            Date dataCadastro = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datecadastro"));
            cliente.setDataCadastro(dataCadastro);
        } catch (ParseException e) {
            e.getMessage();
        }

        String codigo = request.getParameter("codigo");

        if (codigo == null || codigo.isEmpty()) {
            clienteDAO.Cadastrar(cliente);
        } else {
            cliente.setCodigo(Integer.parseInt(codigo));
            clienteDAO.Atualizar(cliente);
        }
        RequestDispatcher view = request.getRequestDispatcher(Formulario);//Formulario
        request.setAttribute("clienteList", clienteDAO.Listar());
        view.forward(request, response);
    }

}
