<%-- 
    Document   : ListaIdiomas
    Created on : 02/11/2017, 16:48:01
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem Idiomas</title>
        <script src="js/ListEndereco.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <jsp:include page = "source/HeadBootstrap.jsp" />
    </head>
    <body>
        <h1>Listagem Idiomas</h1>

        <div class="container">
            <h2>Listagem Idiomas</h2>
            <p> Segue abaixo a listagem Idiomas</p>                                                                                 
            <div class="table-responsive">          
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Descrição</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${idiomaList}" var="idioma">
                            <tr>
                                <td><c:out value="${idioma.codigo}"/> </td>
                                <td><c:out value="${idioma.descricao}"/> </td>


                                <td>
                                    <a class="btn btn-warning" href="IdiomaServlet?action=edit&codigo=<c:out value="${idioma.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Alterar/Atualizar os Dados">
                                        <span class="glyphicon glyphicon-edit"></span> Atualizar</a>
                                </td>

                                <td>
                                    <a class="btn btn-danger" href="IdiomaServlet?action=delete&codigo=<c:out value="${idioma.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Excluir/Deletar os Dados">
                                        <span class="glyphicon-remove-circle"></span> Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <jsp:include page = "source/Paginacao.jsp" />
            </div>

            <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="IdiomaServlet?action=insert">
                <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
        <jsp:include page = "source/ModelTabela.jsp" />
        <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
