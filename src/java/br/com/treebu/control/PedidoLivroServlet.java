/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.control;

import br.com.treebu.dao.ClienteDao;
import br.com.treebu.dao.LivroDao;
import br.com.treebu.dao.PedidoDao;
import br.com.treebu.dao.PedidoLivroDao;
import br.com.treebu.model.Cliente;
import br.com.treebu.model.Livro;
import br.com.treebu.model.Pedido;
import br.com.treebu.model.PedidoLivro;
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
public class PedidoLivroServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String formularioPL = "/PedidoLivro.jsp";
    private static String Lista_PedidosLivros = "/ListaPedidoLivros.jsp";
    private PedidoLivroDao PLDao;
    private ClienteDao clienteDAO;
    private PedidoDao pedidoDAO;
    private LivroDao livroDAO;

    public PedidoLivroServlet() throws SQLException {
        super();
        PLDao = new PedidoLivroDao();
        pedidoDAO = new PedidoDao();
        clienteDAO = new ClienteDao();
        livroDAO = new LivroDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String codpedido = request.getParameter("codpedido");
                
        if (action.equalsIgnoreCase("remover")){
            try {
                int cdpedido = Integer.parseInt(codpedido);
                int codlivro = Integer.parseInt(request.getParameter("codlivro"));
                PLDao.Deletar(cdpedido, codlivro);
                Pedido p = pedidoDAO.ConsultarPorCodigo(cdpedido);
                PedidoLivro pl = new PedidoLivro();
                pl.setPedido(p);
                request.setAttribute("pl", pl);
            } catch (SQLException ex) {
                Logger.getLogger(PedidoLivroServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        if(!(codpedido == null || codpedido.isEmpty())){
            request.setAttribute("plList", PLDao.ListarPorPedido(Integer.parseInt(codpedido)));
        }
        RequestDispatcher view = request.getRequestDispatcher(formularioPL);
        request.setAttribute("clienteList", clienteDAO.Listar());
        request.setAttribute("livroList", livroDAO.Listar());
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object attribute = request.getAttribute("objeto");
        if(request.getParameter("botao").equalsIgnoreCase("Novo")){
            RequestDispatcher view = request.getRequestDispatcher(formularioPL);
            request.setAttribute("clienteList", clienteDAO.Listar());
            request.setAttribute("livroList", livroDAO.Listar());
            view.forward(request, response);
        }
        if(request.getParameter("botao").equalsIgnoreCase("Salvar")){
            Pedido pedido = new Pedido();
            Pedido p = new Pedido();
            pedido.setCliente(new Cliente());

            pedido.setValorTotal(Double.parseDouble(request.getParameter("valortotal")));

            pedido.getCliente().setCodigo(Integer.parseInt(request.getParameter("codcliente")));

            String codigo = request.getParameter("codigo");

            if(codigo == null || codigo.isEmpty())
            {
  
                p = pedidoDAO.Cadastrar(pedido);
            }
            else
            {
                try {
                    p = pedidoDAO.ConsultarPorCodigo(Integer.parseInt(codigo));
                } catch (SQLException ex) {
                    Logger.getLogger(PedidoLivroServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            PedidoLivro pl = new PedidoLivro();
            pl.setPedido(p);
            pl.setLivro(new Livro());

            pl.getPedido().setCodigo(p.getCodigo());
            pl.getLivro().setCodigo(Integer.parseInt(request.getParameter("codlivro")));
            pl.setQuantidadeLivro(Integer.parseInt(request.getParameter("quantidadelivro")));
            pl.setValorUnitario(Double.parseDouble(request.getParameter("valorunitario")));
            
            PLDao.Cadastrar(pl);

            pl.setQuantidadeLivro(0);
            pl.setValorUnitario(0.0);
            
            RequestDispatcher view = request.getRequestDispatcher(formularioPL);
            request.setAttribute("pl", pl); 
            request.setAttribute("plList", PLDao.ListarPorPedido(pl.getPedido().getCodigo()));
            request.setAttribute("clienteList", clienteDAO.Listar());
            request.setAttribute("livroList", livroDAO.Listar());
            view.forward(request, response);
        }
        if(request.getParameter("botao").equalsIgnoreCase("Pesquisar")){
            String numero = request.getParameter("numero");

            if(!(numero == null || numero.isEmpty()))
            {
                RequestDispatcher view = request.getRequestDispatcher(formularioPL);
                request.setAttribute("plList", PLDao.ListarPorPedido(Integer.parseInt(numero)));
                request.setAttribute("clienteList", clienteDAO.Listar());
                request.setAttribute("livroList", livroDAO.Listar());
                view.forward(request, response);
            }
        }
    }
    private Pedido pedido;
}
