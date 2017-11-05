<%-- 
    Document   : Recomendacao
    Created on : 02/11/2017, 16:49:20
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario X</title>
    </head>
    <body>
        <h1>Formulario X</h1>
        <div class="container">
            <fieldset>
                <legend>Formulario X</legend>
                <form name="formX" method="post" action="XServlet">

                    <div>
                        <label>Codigo :</label>
                        <input type="number" name="codigo" value="<c:out value="${x.codigo}"/>"> <br/>
                    </div>

                    <div>
                        <label>Nome :</label>
                        <input type="text" name="nome" required="true" value="<c:out value="${x.nome}"/>"> <br/>
                    </div>

                    <jsp:include page = "source/Voltar.jsp" />
                    <button type="reset" value="Limpar">Limpar</button>
                    <button type="submit"  value="Salvar">Salvar</button>

                </form>
            </fieldset>
        </div>
                     <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
