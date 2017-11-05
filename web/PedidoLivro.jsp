<%-- 
    Document   : PedidoLivro
    Created on : 02/11/2017, 16:48:53
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
        <title>Formulario PedidoLivro</title>
    </head>
    <body>
        <div class="container">
        <h1>Formulario PedidoLivro</h1>
        </div>
        <div class="container">
            <fieldset>
                <legend>Informe neste formulario, as informações necessarios para cadastro do PedidoLivro</legend>
                <form name="formPedidoLivro" method="post" action="PedidoLivroServlet">
                   
                     <div class="form-group">
                        <label>Pedido :</label>
                        <select class="form-control" name="codpedido">
                            <c:forEach items="${pedidoList}" var="pedido">
                                <option value="<c:out value="${pedido.codigo}"/>" 
                                ${pedido.codigo ==  pedidolivro.pedido.codigo ? 'selected' : ''}>
                                <c:out value="${pedido.valortotal}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    
                     <div class="form-group">
                        <label>Livro :</label>
                        <select class="form-control" name="codlivro">
                            <c:forEach items="${livroList}" var="livro">
                                <option value="<c:out value="${livro.codigo}"/>" 
                                ${livro.codigo ==  pedidolivro.livro.codigo ? 'selected' : ''}>
                                <c:out value="${livro.nome}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Quantidade Livro :</label>
                        <input type="number" name="quantidadeLivro" id="quantidadeLivro" class="form-control" required="true" value="<c:out value="${pedidolivro.quantidadelivro}"/>"> <br/>
                    </div>
                    
                    <div class="form-group">
                        <label>Valor Unitario :</label>
                        <input type="text" name="valorUnitario" id="valorUnitario" class="form-control" required="true" value="<c:out value="${pedidolivro.valorunitario}"/>"> <br/>
                    </div>

                    <button class="btn btn-large btn btn-info" type="reset" value="Limpar"
                            data-toggle="tooltip"  title="Clique para Limpar Campos">
                        <span class=" glyphicon glyphicon-erase"></span>
                        Limpar
                    </button>

                    <button class="btn btn-large btn btn-success" data-toggle="tooltip" type="submit" 
                            title="Clique para Salvar" value="Salvar">
                        <span class=" glyphicon glyphicon-send"></span>
                        Salvar
                    </button>

                </form>
            </fieldset>
        </div>
     <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
