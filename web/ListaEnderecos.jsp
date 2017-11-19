<%-- 
    Document   : ListaEnderecos
    Created on : 30/10/2017, 17:59:11
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page = "source/HeadBootstrap.jsp" />
        <title>Relatorio Enderecos</title>
        <link rel="icon" href="imagem/TreeBu.jpeg">
    </head>
    <body>
        <h1>Relatorio Enderecos</h1>

        <div class="container">
            <h2>Listando Relatorio Enderecos</h2>
            <p> Segue abaixo a lista de dados dos generos</p>                                                                                 
            <div class="table-responsive">          
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Logradouro</th>
                            <th>Complemento</th>
                            <th>Bairro</th>
                            <th>Cidade</th>
                            <th>Estado</th>
                            <th>CEP</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${enderecoList}" var="endereco">
                            <tr>
                               <td><c:out value="${endereco.codigo}"/> </td>
                               <td><c:out value="${endereco.logradouro}"/> </td>
                               <td><c:out value="${endereco.complemento}"/> </td>
                               <td><c:out value="${endereco.bairro}"/> </td>
                               <td><c:out value="${endereco.cidade}"/> </td>
                               <td><c:out value="${endereco.estado}"/> </td>
                                <td><c:out value="${endereco.cep}"/> </td>

                                <td>
                                    <a class="btn btn-warning" href="EnderecoServlet?action=edit&codigo=<c:out value="${endereco.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Alterar/Atualizar os Dados">
                                        <span class="glyphicon glyphicon-edit"></span> Atualizar</a>
                                </td>

                                <td>
                                    <a class="btn btn-danger" href="EnderecoServlet?action=delete&codigo=<c:out value="${endereco.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Excluir/Deletar os Dados">
                                        <span class="glyphicon-remove-circle"></span> Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="EnderecoServlet?action=insert">
                <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
         <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
