<%-- 
    Document   : ListaClientes
    Created on : 02/11/2017, 16:45:28
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem Clientes</title>
        <script src="js/ListEndereco.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <jsp:include page = "source/HeadBootstrap.jsp" />
    </head>
    <body>
        <h1>Listagem Clientes</h1>

        <div class="container">
            <h2>Listagem Clientes</h2>
            <p> Segue abaixo a listagem Clientes</p>                                                                                 
            <div class="table-responsive">          
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Email</th>
                            <th>Senha</th>
                            <th>Nome</th>
                            <th>Telefone</th>
                            <th>CPF</th>
                            <th>Data Nascimento</th>
                            <th>Codigo Endereço</th>
                            <th>Data Cadastro</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${clienteList}" var="cliente">
                            <tr>
                                <td><c:out value="${cliente.codigo}"/> </td>
                                <td><c:out value="${cliente.email}"/> </td>
                                <td><c:out value="${cliente.senha}"/> </td>
                                <td><c:out value="${cliente.nome}"/> </td>
                                <td><c:out value="${cliente.telefone}"/> </td>
                                <td><c:out value="${cliente.cpf}"/> </td>
                                <td><c:out value="${cliente.datenascimento}"/> </td>
                                <td><c:out value="${cliente.endereco.logradouro}"/> </td>
                                <td><c:out value="${cliente.datecadatro}"/> </td>


                                <td>
                                    <a class="btn btn-warning" href="ClienteServlet?action=edit&codigo=<c:out value="${cliente.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Alterar/Atualizar os Dados">
                                        <span class="glyphicon glyphicon-edit"></span> Atualizar</a>
                                </td>

                                <td>
                                    <a class="btn btn-danger" href="ClienteServlet?action=delete&codigo=<c:out value="${cliente.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Excluir/Deletar os Dados">
                                        <span class="glyphicon-remove-circle"></span> Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                 <jsp:include page = "source/Paginacao.jsp" />
            </div>

            <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="ClienteServlet?action=insert">
                <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
          <jsp:include page = "source/ModelTabela.jsp" />
           <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
