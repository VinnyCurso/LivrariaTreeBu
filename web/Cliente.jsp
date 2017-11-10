<%-- 
    Document   : Cliente
    Created on : 02/11/2017, 16:45:20
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
        <script src="js/verificaSenha.js" type="text/javascript"></script>
        <title>Formulário Cliente</title>
    </head>
    <body>
        <div class="container">
        <h1>Formulário Cliente</h1>
        </div>
        <div class="container">
            <fieldset>
                <legend>Informe neste formulário, as informações necessárias para cadastro do Cliente</legend>
                <form name="formCliente" method="post" action="ClienteServlet">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" id="codigo" class="form-control" value="<c:out value="${cliente.codigo}"/>"> <br/>
                    </div>
                    
                     <div class="form-group">
                        <label>Email :</label>
                        <input type="email" name="email" id="email" class="form-control" required="true" value="<c:out value="${cliente.email}"/>"> <br/>
                    </div>
                    
                     <div class="form-group">
                        <label>Senha :</label>
                        <input type="password" name="senha" id="senha" class="form-control" required="true" value="<c:out value="${cliente.senha}"/>"> <br/>
                    </div>
                    
                     <div class="form-group">
                        <label>Confirmar Senha :</label>
                        <input type="password" name="confirmarsenha" class="form-control" required="true" oninput="validarSenha(this)"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Nome :</label>
                        <input type="text" name="nome" id="nome" class="form-control" required="true" value="<c:out value="${cliente.nome}"/>"> <br/>
                    </div>
                    
                    <div class="form-group">
                        <label>Telefone :</label>
                        <input type="text" name="telefone" id="telefone" class="form-control" required="true" value="<c:out value="${cliente.telefone}"/>"> <br/>
                    </div>
                    
                    <div class="form-group">
                        <label>CPF :</label>
                        <input type="text" name="cpf" id="cpf" class="form-control" required="true" value="<c:out value="${cliente.cpf}"/>"> <br/>
                    </div>
                    

                    <div class="form-group">
                        <label>Data Nascimento :</label>
                        <input type="date" name="datenascimento" id="datenascimento" class="form-control" required="true" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${cliente.datenascimento}" />" /> <br /> 
                    </div>
                    
                    <div class="form-group">
                        <label>Endereco :</label>
                        <select class="form-control" name="codendereco">
                            <c:forEach items="${enderecoList}" var="endereco">
                                <option value="<c:out value="${endereco.codigo}"/>" 
                                ${endereco.codigo ==  cliente.endereco.codigo ? 'selected' : ''}>
                                <c:out value="${endereco.logradouro}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label>Data Cadastro :</label>
                        <input type="date" name="datecadastro" id="datecadastro" class="form-control" required="true" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${cliente.datecadastro}" />" /> <br /> 
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
