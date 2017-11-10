<%-- 
    Document   : statusAutenticacao
    Created on : 09/11/2017, 02:15:12
    Author     : vinicius caetano
--%>

<%@tag body-content="empty"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${mensagem != null}">
        ${mensagem}
         </c:when>
        <c:otherwise>
           Digite o Usuario e Senha 
        </c:otherwise>
   
</c:choose>