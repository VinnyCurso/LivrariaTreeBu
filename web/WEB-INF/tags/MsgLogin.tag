<%-- 
    Document   : MsgLogin
    Created on : 18/11/2017, 22:57:05
    Author     : vinicius caetano
--%>

<%@tag body-content="empty"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test = "${mensagem != null}">
            ${mensagem}   
    </c:when>
    
    <c:otherwise>
        Entre com o seu Usuario/Senha
    </c:otherwise>
</c:choose>