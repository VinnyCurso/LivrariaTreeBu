<%-- 
    Document   : ListaAutores
    Created on : 02/11/2017, 16:45:12
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem Autores</title>
        <script src="js/ListEndereco.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <jsp:include page = "source/HeadBootstrap.jsp" />
    </head>
    <body>
        <h1>Listagem Autores</h1>

        <div class="container">
            <h2>Listagem Autores</h2>
            <p> Segue abaixo a listagem Autores</p>                                                                                 
            <div class="table-responsive">          
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Nome</th>
                            <th>Nacionalidade</th>
                             <th>Data Nascimento</th>
                             <th>Status</th>
                              <th>Descrição</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${autorList}" var="autor">
                            <tr>
                                <td><c:out value="${autor.codigo}"/> </td>
                                <td><c:out value="${autor.nome}"/> </td>
                                <td><c:out value="${autor.nacionalidade}"/> </td>
                                <td><c:out value="${autor.datenascimento}"/> </td>
                                <td><c:out value="${autor.status}"/> </td>
                                <td><c:out value="${autor.descricao}"/> </td>


                                <td>
                                    <a class="btn btn-warning" href="AutorServlet?action=edit&codigo=<c:out value="${autor.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Alterar/Atualizar os Dados">
                                        <span class="glyphicon glyphicon-edit"></span> Atualizar</a>
                                </td>

                                <td>
                                    <a class="btn btn-danger" href="AutorServlet?action=delete&codigo=<c:out value="${autor.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Excluir/Deletar os Dados">
                                        <span class="glyphicon-remove-circle"></span> Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <jsp:include page = "source/Paginacao.jsp" />
            </div>

            <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="AutorServlet?action=insert">
                <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
          <jsp:include page = "source/ModelTabela.jsp" />
           <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
