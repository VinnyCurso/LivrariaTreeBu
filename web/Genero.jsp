<%-- 
    Document   : Genero
    Created on : 02/11/2017, 16:47:27
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
        <title>Formulario Genero</title>
    </head>
    <body>
        <div class="container">
        <h1>Formulario Genero</h1>
        </div>
        <div class="container">
            <fieldset>
                <legend>Informe neste formulario, as informações necessarios para cadastro do Genero</legend>
                <form name="formGenero" method="post" action="GeneroServlet">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" id="codigo" class="form-control" value="<c:out value="${genero.codigo}"/>"> <br/>
                    </div>
                    
                    <div class="form-group">
                        <label>Nome :</label>
                        <input type="text" name="nome" id="nome" class="form-control" required="true" value="<c:out value="${genero.nome}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Descriçao :</label>
                        <input type="text" name="descricao" id="descricao" class="form-control" required="true" value="<c:out value="${genero.descricao}"/>"> <br/>
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
