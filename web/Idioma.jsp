<%-- 
    Document   : Idioma
    Created on : 02/11/2017, 16:47:53
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
        <title>Formulario Idioma</title>
    </head>
    <body>
        <div class="container">
        <h1>Formulario Idioma</h1>
        </div>
        <div class="container">
            <fieldset>
                <legend>Informe neste formulario, as informações necessarios para cadastro do Idioma</legend>
                <form name="formIdioma" method="post" action="IdiomaServlet">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" id="codigo" class="form-control" value="<c:out value="${idioma.descricao}"/>"> <br/>
                    </div>

                    <div>
                        <label>Descricao :</label>
                        <input type="text" name="descricao" id="descricao" class="form-control" required="true" value="<c:out value="${idioma.descricao}"/>"> <br/>
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
