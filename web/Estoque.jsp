<%-- 
    Document   : Estoque
    Created on : 02/11/2017, 16:46:09
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
        <title>Formulario Estoque</title>
    </head>
    <body>
        <div class="container">
        <h1>Formulario Estoque</h1>
        </div>
        <div class="container">
            <fieldset>
                <legend>Informe neste formulario, as informações necessarios para cadastro do Estoque</legend>
                <form name="formEstoque" method="post" action="EstoqueServlet">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" id="codigo" class="form-control" value="<c:out value="${estoque.codigo}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Descrição Produto :</label>
                        <input type="text" name="descProduto" id="descProduto" class="form-control" required="true" value="<c:out value="${estoque.descproduto}"/>"> <br/>
                    </div>
                    
                    <div class="form-group">
                        <label>Quantidade :</label>
                        <input type="number" name="quantidade" id="quantidade" class="form-control" required="true" value="<c:out value="${estoque.quantidade}"/>"> <br/>
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
