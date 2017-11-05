<%-- 
    Document   : ListaLivros
    Created on : 02/11/2017, 16:48:19
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem Livros</title>
        <script src="js/ListEndereco.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <jsp:include page = "source/HeadBootstrap.jsp" />
    </head>
    <body>
        <h1>Listagem Livros</h1>

        <div class="container">
            <h2>Listagem Livros</h2>
            <p> Segue abaixo a listagem Livros</p>                                                                                 
            <div class="table-responsive">          
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Codigo Editora</th>
                            <th>Codigo Autor</th>
                            <th>Codigo Genero</th>
                            <th>Codigo Idioma</th>
                            <th>Data Publicação</th>
                            <th>Nome</th>
                            <th>Descrição</th>
                            <th>Numero de Paginas</th>
                            <th>Preço</th>
                            <th>Avaliação</th>
                            <th>ISBN</th>
                            <th>Capa</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${livroList}" var="livro">
                            <tr>
                                <td><c:out value="${livro.codigo}"/> </td>
                                <td><c:out value="${livro.editora.razaosocial}"/> </td>
                                <td><c:out value="${livro.autor.autor}"/> </td>
                                <td><c:out value="${livro.genero.descricao}"/> </td>
                                <td><c:out value="${livro.idioma.descricao}"/> </td>
                                <td><c:out value="${livro.datepublicacao}"/> </td>
                                <td><c:out value="${livro.nome}"/> </td>
                                <td><c:out value="${livro.descricao}"/> </td>
                                <td><c:out value="${livro.numeropaginas}"/> </td>
                                <td><c:out value="${livro.preco}"/> </td>
                                <td><c:out value="${livro.avaliacao}"/> </td>
                                <td><c:out value="${livro.isbn}"/> </td>
                                <td><c:out value="${livro.codigo}"/> </td>
                                <td><c:out value="${livro.capa}"/> </td>



                                <td>
                                    <a class="btn btn-warning" href="LivroServlet?action=edit&codigo=<c:out value="${livro.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Alterar/Atualizar os Dados">
                                        <span class="glyphicon glyphicon-edit"></span> Atualizar</a>
                                </td>

                                <td>
                                    <a class="btn btn-danger" href="LivroServlet?action=delete&codigo=<c:out value="${livro.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Excluir/Deletar os Dados">
                                        <span class="glyphicon-remove-circle"></span> Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <jsp:include page = "source/Paginacao.jsp" />
            </div>

            <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="LivroServlet?action=insert">
                <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
        <jsp:include page = "source/ModelTabela.jsp" />
        <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
