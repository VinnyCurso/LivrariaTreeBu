<%-- 
    Document   : StatusLogado
    Created on : 18/11/2017, 22:56:27
    Author     : vinicius caetano
--%>

<%@tag body-content="empty"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test = "${sessaoUsuario != null}">
            ${sessaoUsuario}   
    </c:when>
    
    <c:otherwise>
        N�o Logado
    </c:otherwise>
</c:choose>