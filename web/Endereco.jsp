<%-- 
    Document   : Endereco
    Created on : 30/10/2017, 16:59:54
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="icon" href="imagem/TreeBu.jpeg">
        <jsp:include page = "source/HeadBootstrap.jsp" />
        <title>Formulario Endereco</title>
    </head>
    <body>
        <h1>Formulario Endereco</h1>
        <div class="container">
            <fieldset>
                <legend>Formulario Endereco</legend>
                <form name="formEndereco" method="Post" action="EnderecoServlet">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" id="codigo" class="form-control" placeholder="000" readonly="readonly" value="<c:out value="${endereco.codigo}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Logradouro :</label>
                        <input type="text" name="logradouro" id="logradouro" class="form-control" required="true"  placeholder="logradouro" value="<c:out value="${endereco.logradouro}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Complemento :</label>
                        <input type="text" name="complemento" id="complemento" class="form-control" required="true"  placeholder="complemento" value="<c:out value="${endereco.complemento}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Bairro :</label>
                        <input type="text" name="bairro" id="bairro" class="form-control" required="true"  placeholder="bairro" value="<c:out value="${endereco.bairro}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Cidade :</label>
                        <input type="text" name="cidade" id="cidade" class="form-control" required="true"  placeholder="cidade" value="<c:out value="${endereco.cidade}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Estado :</label>
                        <input type="text" name="estado" id="estado" class="form-control" required="true"  placeholder="estado" value="<c:out value="${endereco.estado}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label> Cep :</label>
                        <input type="text" name="cep" id="cep" class="form-control" required="true"  placeholder="cep" value="<c:out value="${endereco.cep}"/>"> <br/>
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
