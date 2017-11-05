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
        <title>Formulario Endereco</title>
        <link rel="icon" href="imagem/TreeBu.jpeg">
        <link href="css/Endereco.css" rel="stylesheet" type="text/css"/>
        <script src="js/Endereco.js" type="text/javascript"></script>
        <jsp:include page = "source/HeadBootstrap.jsp" />
    </head>
    <body>
        <h1>Formulario Endereco</h1>

        <div class="container">
            <br><br>
            <div class="row">
                <div class="col-sm-8">
                    <form role="form" method="post" action="EnderecoServlet">
                        <div class="form-group float-label-control">
                            <label for="">Codigo</label>
                            <input type="number" name="codigo" id="codigo" class="form-control" value="<c:out value="${endereco.codigo}"/>"> 
                        </div>
                        <div class="form-group float-label-control">
                            <label for="">Logradouro</label>
                            <input type="text" name="nome" id="nome" class="form-control" required="true" value="<c:out value="${endereco.logradouro}"/>">
                        </div>

                        <div class="form-group float-label-control">
                            <label for="">Complemento</label>
                            <input type="text" name="complemento" id="complemento" class="form-control" required="true" value="<c:out value="${endereco.complemento}"/>">
                        </div>

                        <div class="form-group float-label-control">
                            <label for="">Bairro</label>
                            <input type="text" name="bairro" id="bairro" class="form-control" required="true" value="<c:out value="${endereco.bairro}"/>">
                        </div>

                        <div class="form-group float-label-control">
                            <label for="">Cidade</label>
                            <input type="text" name="cidade" id="cidade" class="form-control" required="true" value="<c:out value="${endereco.cidade}"/>">
                        </div>

                        <div class="form-group float-label-control">
                            <label for="">Estado</label>
                            <input type="text" name="estado" id="estado" class="form-control" required="true" value="<c:out value="${endereco.estado}"/>">
                        </div>

                        <div class="form-group float-label-control">
                            <label for="">CEP</label>
                            <input type="text" name="cep" id="cep" class="form-control" required="true" value="<c:out value="${endereco.cep}"/>">
                        </div>
                         <jsp:include page = "source/Voltar.jsp" />
                    <button type="reset" value="Limpar">Limpar</button>
                    <button type="submit"  value="Salvar">Salvar</button>
                    </form>
                       
                </div>
            </div>
        </div>
          <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
