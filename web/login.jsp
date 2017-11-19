<%-- 
    Document   : login
    Created on : 09/11/2017, 01:52:52
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tagsTreebu" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <jsp:include page = "source/HeadBootstrap.jsp" />
          <link href="css/login.css" rel="stylesheet" type="text/css"/>
          <script src="js/login.js" type="text/javascript"></script>
        <title>Login</title>
    </head>
    <body>
        
         <div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="imagem/TreeBu.jpeg" />
            <p id="profile-name" class="profile-name-card"></p>
            <!--<form class="form-signin" action="Home.jsp">-->
            <form class="form-signin"  method="POST" action="LoginServlet" name="formAutenticacao">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email..." required autofocus>
                <input type="password" name="senha" id="inputPassword" class="form-control" placeholder="Senha..." required>
                <!--
                 <div>
                     <label><tagsTreebu:MsgLogin/></label>
                </div> -->
               
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Acessar</button>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="reset">Limpar</button>
            </form>
            <p><tagsTreebu:statusAutenticacao/></p><br><br>
            
             <h4>Se você ainda não possui cadastro.</h4>
            <h4><a href="ClienteServlet?action=insert">Cadastre-se</a></h4>
        </div>
    </div>
         <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
