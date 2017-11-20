<%-- 
    Document   : Editora
    Created on : 02/11/2017, 16:45:38
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
        <title>Formulario Editora</title>
    </head>
    <body>
        <div class="container">
        <h1>Formulario Editora</h1>
        </div>
        <div class="container">
            <fieldset>
                <legend>Informe neste formulario, as informações necessarios para cadastro da Editora</legend>
                <form name="formEditora" method="post" action="EditoraServlet">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" id="codigo" class="form-control" value="<c:out value="${editora.codigo}"/>"> <br/>
                    </div>
                    
                    <div class="form-group">
                        <label>Nome :</label>
                        <input type="text" name="nome" id="nome" class="form-control" required="true" value="<c:out value="${editora.nome}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Razao Social :</label>
                        <input type="text" name="razaoSocial" id="razaoSocial" class="form-control" required="true" value="<c:out value="${editora.razaosocial}"/>"> <br/>
                    </div>
                    
                    <div class="form-group">
                        <label>Cnpj :</label>
                        <input type="text" name="cnpj" id="cnpj"  class="form-control" required="true" value="<c:out value="${editora.cnpj}"/>"> <br/>
                    </div>
                    
                    <div class="form-group">
                        <label>Endereco :</label>
                        <select class="form-control" name="codendereco">
                            <c:forEach items="${enderecoList}" var="endereco">
                                <option value="<c:out value="${endereco.codigo}"/>" 
                                ${endereco.codigo ==  editora.endereco.codigo ? 'selected' : ''}>
                                <c:out value="${endereco.logradouro}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label>Telefone :</label>
                        <input type="text" name="telefone" id="telefone" class="form-control" required="true" value="<c:out value="${editora.telefone}"/>"> <br/>
                    </div>
                    
                    <div class="form-group">
                        <label>Email :</label>
                        <input type="text" name="email" id="email" class="form-control" required="true" value="<c:out value="${editora.email}"/>"> <br/>
                    </div>
                    
                     <div class="form-group">
                        <label>Reresentante :</label>
                        <input type="text" name="representante" id="representante" class="form-control" required="true" value="<c:out value="${editora.representante}"/>"> <br/>
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
