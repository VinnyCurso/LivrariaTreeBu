/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;


import br.com.treebu.dao.EnderecoDao;
import br.com.treebu.model.Endereco;
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
public class EnderecoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String Formulario = "/Endereco.jsp";
    private static String List_Enderecos = "/ListaEnderecos.jsp";
    private EnderecoDao enderecoDAO;

    public EnderecoServlet() throws SQLException {
        super();
        enderecoDAO = new EnderecoDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            enderecoDAO.Deletar(codigo);
            forward = List_Enderecos;
            request.setAttribute("enderecoList", enderecoDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = Formulario;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Endereco endereco = enderecoDAO.ConsultarPorCodigo(codigo);
            request.setAttribute("endereco", endereco);
        } else if (action.equalsIgnoreCase("ListaEnderecos")) {
            forward = List_Enderecos;
            request.setAttribute("enderecoList", enderecoDAO.Listar());
        } else {
            forward = Formulario;
        }
       
        
        //OutroModeloGet
//        RequestDispatcher view = request.getRequestDispatcher(forward);
//        view.forward(request, response);
//        
//         if (action.equalsIgnoreCase("remover")){
//            int codigo = Integer.parseInt(request.getParameter("codigo"));
//            enderecoDAO.Deletar(codigo);
//        } 
//        if (action.equalsIgnoreCase("alterar")){
//            int codigo = Integer.parseInt(request.getParameter("codigo"));
//            Endereco endereco = enderecoDAO.ConsultarPorCodigo(codigo);
//            request.setAttribute("endereco", endereco); 
//        }
//        
//        RequestDispatcher view = request.getRequestDispatcher(List_Enderecos);
//        request.setAttribute("enderecoList", enderecoDAO.Listar());
//        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Endereco endereco = new Endereco();

        endereco.setLogradouro(request.getParameter("logradouro"));
        endereco.setComplemento(request.getParameter("complemento"));
        endereco.setBairro(request.getParameter("bairro"));
        endereco.setCidade(request.getParameter("cidade"));
        endereco.setEstado(request.getParameter("estado"));
        endereco.setCep(request.getParameter("cep"));
      
        String codigo = request.getParameter("codigo");
        
        if (codigo == null || codigo.isEmpty()) {

            enderecoDAO.Cadastrar(endereco);
        } else {

            endereco.setCodigo(Integer.parseInt(codigo));
            enderecoDAO.Atualizar(endereco);
        }
        RequestDispatcher view = request.getRequestDispatcher(List_Enderecos);
        request.setAttribute("enderecoList", enderecoDAO.Listar());
        view.forward(request, response);
    }

}
