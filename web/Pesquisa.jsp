<%-- 
    Document   : Pesquisa
    Created on : 17/11/2017, 12:20:28
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
        <title>Pesquisa </title>
    </head>
    <body>
        <h1>Pesquisa Inteligente</h1>
    </body>
    
     <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" id="codigo" class="form-control" value="<c:out value="${pesquisa.codigo}"/>"> <br/>
                    </div>
                    
    
    
    
    <div class="form-group">
                    <label>Status :</label><br />
                    <input type="radio" name="gosto" value="V" ${pesquisa.status == valorStatus ? 'checked' : ''}/>Muitas Paginas
                    <input type="radio" name="naogosto" value="F" ${pesquisa.status != valorStatus ? 'checked' : ''}/>Poucas Paginas
                    </div>
</html>
