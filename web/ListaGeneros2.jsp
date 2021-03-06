<%-- 
    Document   : ListaGeneros2
    Created on : 04/11/2017, 15:28:30
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Listagem Generos</title>
        <jsp:include page = "source/HeadBootstrap.jsp" />
    </head>
    <body>
       <div class="container">
            <h2>Listando Generos</h2>
            <p> Segue abaixo a lista de dados Generos</p>                                                                                 
            <div class="table-responsive">          
                <table class="table table-striped">
                    <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Descricao</th>
                    <th colspan=2>Ação</th>
                </tr>
            </thead>
 <tbody>
                       
            <c:forEach items="${generoList}" var="genero">
                <tr>
                    <td><c:out value="${genero.codigo}"/> </td>
                    <td><c:out value="${genero.descricao}"/> </td>
                    
                    <td><a class="btn btn-warning"  href="GeneroServlet?action=edit&codigo=<c:out value="${genero.codigo}"/>"
                                       data-toggle="tooltip"  title="Clique para Alterar/Atualizar os Dados"> 
                                        <span class="glyphicon glyphicon-edit"></span> Atualizar
                    </a>
                    </td>


                                <td><a class="btn btn-danger" href="GeneroServlet?action=delete&codigo=<c:out value="${genero.codigo}"/>"
                                       data-toggle="tooltip"  title="Clique para Excluir/Deletar os Dados">
                                        <span class="glyphicon-remove-circle"></span> Excluir
                                </a>
                                </td>        

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a class="btn btn-primary"  data-toggle="tooltip"  title="Clique adicionar nova Informação" 
              href="GeneroServlet?action=insert"> <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
    </body>
</html>
