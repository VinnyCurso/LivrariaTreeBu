<%-- 
    Document   : RelatorioPedidoLivros
    Created on : 02/11/2017, 16:49:07
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio Pedido Livros</title>
        <script src="js/ListEndereco.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <jsp:include page = "source/HeadBootstrap.jsp" />
    </head>
    <body>
        <h1>Relatorio Pedido Livros</h1>

        <div class="container">
            <h2>Relatorio Pedido Livros</h2>
            <p> Segue abaixo a Relatorio Pedido Livros</p>                                                                                 
            <div class="table-responsive">          
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Codigo Pedido</th>
                            <th>Codigo Livro</th>
                            <th>Quantidade Livro</th>
                            <th>Valor Unitario</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pedidolivroList}" var="pedidolivro">
                            <tr>
                                <td><c:out value="${pedidolivro.pedido}"/> </td>
                                <td><c:out value="${pedidolivro.livro}"/> </td>
                                <td><c:out value="${pedidolivro.quantidade}"/> </td>
                                <td><c:out value="${pedidolivro.valorunitario}"/> </td>


                                <td>
                                    <a class="btn btn-warning" href="PedidoLivroServlet?action=edit&codigo=<c:out value="${pedidolivro.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Alterar/Atualizar os Dados">
                                        <span class="glyphicon glyphicon-edit"></span> Atualizar</a>
                                </td>

                                <td>
                                    <a class="btn btn-danger" href="PedidoLivroServlet?action=delete&codigo=<c:out value="${pedidolivro.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Excluir/Deletar os Dados">
                                        <span class="glyphicon-remove-circle"></span> Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <jsp:include page = "source/Paginacao.jsp" />
            </div>

            <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="PedidoLivroServlet?action=insert">
                <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
        <jsp:include page = "source/ModelTabela.jsp" />
        <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
