<%-- 
    Document   : Pedido
    Created on : 02/11/2017, 16:48:33
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Estilo.css" rel="stylesheet" type="text/css"/>
        <jsp:include page = "source/HeadBootstrap.jsp" />
        <title>Formulario Pedido</title>
    </head>
    <body>
        <div class="container">
            <header id="cabecalho">
                <hgroup>
                    <h1>Formulario Pedido</h1>
                </hgroup>
            </header>
       
<section id="corpo">
    <article id="noticiaPrincipal">
        <header id="cabecalhoArtigo">
    <h3>TreeBu > &nbsp; Solicitacao Pedido</h3>
    <h1> Informe neste formulario, as informações necessarios para cadastro do Pedido</h1>
    <h2>por Vinicius Caetano</h2>
    <h3 class="direita">Atualizado em 05/Novembro/2017</h3>
        </header>
        </div>
        <div class="container">
            <fieldset>
                <legend>Treebu Pedidos</legend>
                <form method="POST" action='PedidoServlet' name="formPedido">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" id="codigo" class="form-control" value="<c:out value="${pedido.codigo}"/>"> <br/>
                    </div>
                    
                     <div class="form-group">
                        <label>Cliente :</label>
                        <select class="form-control" name="codcliente">
                            <c:forEach items="${clienteList}" var="cliente">
                                <option value="<c:out value="${cliente.codigo}"/>" 
                                ${cliente.codigo ==  pedido.cliente.codigo ? 'selected' : ''}>
                                <c:out value="${cliente.email}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Valor Total :</label>
                        <input type="text" name="valorTotal" id="valorTotal" class="form-control" required="true" value="<c:out value="${pedido.valortotal}"/>"> <br/>
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
                    <hr>    <hr>   
                    <!-- Tabela de informações -->
                    
        <div class="container">
            <fieldset>
              <legend>Informações da tabela</legend>
              
               <div class="table-responsive">          
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Codigo Cliente</th>
                            <th>Valor Total</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pedidoList}" var="pedido">
                            <tr>
                                <td><c:out value="${pedido.codigo}"/> </td>
                                <td><c:out value="${pedido.cliente.email}"/> </td>
                                <td><c:out value="${pedido.valortotal}"/> </td>


                                <td>
                                    <a class="btn btn-warning" href="PedidoServlet?action=edit&codigo=<c:out value="${pedido.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Alterar/Atualizar os Dados">
                                        <span class="glyphicon glyphicon-edit"></span> Atualizar</a>
                                </td>

                                <td>
                                    <a class="btn btn-danger" href="PedidoServlet?action=delete&codigo=<c:out value="${pedido.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Excluir/Deletar os Dados">
                                        <span class="glyphicon-remove-circle"></span> Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="PedidoServlet?action=insert">
                <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
                
            </fieldset>
        </div>
    <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
