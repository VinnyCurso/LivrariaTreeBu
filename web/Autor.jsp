<%-- 
    Document   : Autor
    Created on : 02/11/2017, 16:44:51
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
        <title>Formulario Autor</title>
    </head>
    <body>
        <div class="container">
        <h1>Formulario Autor</h1>
        </div>
        <div class="container">
            <fieldset>
                <legend>Informe neste formulario, as informações necessarias para cadastro do Autor</legend>
                <form name="formAutor" method="post" action="AutorServlet">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" id="codigo" class="form-control" value="<c:out value="${autor.codigo}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Nome :</label>
                        <input type="text" name="nome" id="nome" class="form-control" required="true" value="<c:out value="${autor.nome}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Nacionalidade :</label>
                        <input type="text" name="nacionalidade" id="nacionalidade" class="form-control" required="true" value="<c:out value="${autor.nacionalidade}"/>"> <br/>
                    </div>
                    
                      <div class="form-group">
                        <label>Data Nascimento :</label>
                        <input type="date" name="datenascimento" id="datenascimento" class="form-control" required="true" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${autor.datenascimento}" />" /> <br /> 
                    </div>

                    <div class="form-group">
                        <label>Status :</label>
                        <input type="text" name="status" id="status" class="form-control" required="true" value="<c:out value="${autor.status}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Descricao :</label>
                        <input type="text" name="descricao" id="descricao" class="form-control" required="true" value="<c:out value="${autor.descricao}"/>"> <br/>
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
                <br>
            </fieldset>
        </div>
        <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
