/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;


import br.com.treebu.dao.EditoraDao;
import br.com.treebu.dao.EnderecoDao;
import br.com.treebu.model.Editora;
import br.com.treebu.model.Endereco;
import java.io.IOException;
import java.sql.SQLException;
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
public class EditoraServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String Formulario = "/Editora.jsp";
    private static String List_Editoras = "/ListaEditoras.jsp";
    private EditoraDao editoraDAO;
    private EnderecoDao enderecoDAO;

    public EditoraServlet() throws SQLException {
        super();
        editoraDAO = new EditoraDao();
        enderecoDAO = new EnderecoDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            editoraDAO.Deletar(codigo);
            forward = List_Editoras;
            request.setAttribute("editoraList", editoraDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            try {
                forward = Formulario;
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                
                Editora editora = editoraDAO.ConsultarPorCodigo(codigo);
                request.setAttribute("editora", editora);
            } catch (SQLException ex) {
                Logger.getLogger(EditoraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equalsIgnoreCase("ListaEditoras")) {
            forward = List_Editoras;
            request.setAttribute("editoraList", editoraDAO.Listar());
            request.setAttribute("enderecoList", enderecoDAO.Listar());
        } else {
            forward = Formulario;
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Editora editora = new Editora();
        editora.setEndereco(new Endereco());

        editora.setRazaoSocial(request.getParameter("razaoSocial"));
        editora.setCnpj(request.getParameter("cnpj"));
        editora.getEndereco().setCodigo(Integer.parseInt(request.getParameter("codendereco")));
        editora.setTelefone(request.getParameter("telefone"));
        editora.setEmail(request.getParameter("email"));
        editora.setRepresentante(request.getParameter("representante"));
      
        String codigo = request.getParameter("codigo");
        
        if (codigo == null || codigo.isEmpty()) {

            editoraDAO.Cadastrar(editora);
        } else {

            editora.setCodigo(Integer.parseInt(codigo));
            editoraDAO.Atualizar(editora);
        }
        RequestDispatcher view = request.getRequestDispatcher(List_Editoras);
        request.setAttribute("editoraList", editoraDAO.Listar());
       
        view.forward(request, response);
    }


}
