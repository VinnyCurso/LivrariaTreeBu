<%@tag body-content="empty"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean class="java.util.Date" id="dataatual"/>
<fmt:formatDate value="${dataatual}" pattern="dd/MM/yyy" type="date" />