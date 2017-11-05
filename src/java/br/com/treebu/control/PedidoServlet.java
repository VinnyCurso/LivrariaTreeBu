/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;

import br.com.treebu.dao.ClienteDao;
import br.com.treebu.dao.PedidoDao;
import br.com.treebu.model.Cliente;
import br.com.treebu.model.Pedido;
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
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius caetano
 */
public class PedidoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String FORMULARIO = "/Pedido.jsp";
     private static String ListPedidos = "/ListaPedidos.jsp";
    private ClienteDao clienteDAO;
    private PedidoDao pedidoDAO;

    public PedidoServlet() throws SQLException {
        super();
        pedidoDAO = new PedidoDao();
        clienteDAO = new ClienteDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            pedidoDAO.Deletar(codigo);
            forward = ListPedidos;
            request.setAttribute("pedidoList", pedidoDAO.Listar());
        } 
        if (action.equalsIgnoreCase("edit")){
           
            try {
                forward = FORMULARIO;
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                Pedido pedido = pedidoDAO.ConsultarPorCodigo(codigo);
                
                request.setAttribute("pedido", pedido);  
            } catch (SQLException ex) {
                Logger.getLogger(PedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
         else if (action.equalsIgnoreCase("ListaPedidos")) {
            
            forward = ListPedidos;
           request.setAttribute("ClienteList", clienteDAO.Listar());
            
        }
        
         else {
            
            forward = FORMULARIO;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        request.setAttribute("pedidoList", pedidoDAO.Listar());
        request.setAttribute("ClienteList", clienteDAO.Listar());
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente());
        
         pedido.getCliente().setCodigo(Integer.parseInt(request.getParameter("codcliente")));
         pedido.setValorTotal(Double.parseDouble(request.getParameter("valortotal")));
       
        String codigo = request.getParameter("codigo");
        
        if(codigo == null || codigo.isEmpty())
        {
            pedidoDAO.Cadastrar(pedido);
        }
        else
        {
            pedido.setCodigo(Integer.parseInt(codigo));
            pedidoDAO.Atualizar(pedido);
        }
        RequestDispatcher view = request.getRequestDispatcher(FORMULARIO);
        request.setAttribute("pedidoList", pedidoDAO.Listar());
        view.forward(request, response);
    }
}
