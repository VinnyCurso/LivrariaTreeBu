<%-- 
    Document   : ListaEnderecos
    Created on : 30/10/2017, 17:59:11
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enderecos</title>
        <link rel="icon" href="imagem/TreeBu.jpeg">
        <script src="js/ListEndereco.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <jsp:include page = "source/HeadBootstrap.jsp" />
    </head>
    <body>
        <h1>Relatorio Enderecos</h1>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2>Listando Relatorio Enderecos</h2>
                    <p> Segue abaixo a lista de dados dos Enderecos</p>                                                                                 
                    <div class="table-responsive">          
                        <table id="mytable" class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Logradouro</th>
                                    <th>Complemento</th>
                                    <th>Bairro</th>
                                    <th>Cidade</th>
                                    <th>Estado</th>
                                    <th>CEP</th>
                                    <th colspan=2>Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${enderecoList}" var="endereco">
                                    <tr>
                                        <td><c:out value="${endereco.codigo}"/> </td>
                                        <td><c:out value="${endereco.logradouro}"/> </td>
                                        <td><c:out value="${endereco.complemento}"/> </td>
                                        <td><c:out value="${endereco.bairro}"/> </td>
                                        <td><c:out value="${endereco.cidade}"/> </td>
                                        <td><c:out value="${endereco.estado}"/> </td>
                                        <td><c:out value="${endereco.cep}"/> </td>
                                        <td>
                                            <p data-placement="top" 
                                               data-toggle="tooltip" 
                                               title="Edit">
                                                <button class="btn btn-primary btn-xs" 
                                                        data-title="Edit" 
                                                        data-toggle="modal" 
                                                        data-target="#edit" >

                                                    <span class="glyphicon glyphicon-pencil"></span>
                                                </button>
                                            </p>
                                        </td>
                                        <td>
                                            <p data-placement="top" 
                                               data-toggle="tooltip" 
                                               title="Delete">
                                                <button class="btn btn-danger btn-xs"
                                                        data-title="Delete" 
                                                        data-toggle="modal" 
                                                        data-target="#delete">
                                                    <span class="glyphicon glyphicon-trash"></span>
                                                </button>
                                            </p>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="EnderecoServlet?action=insert">
                        <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
                </div>
            </div>
        </div>

        <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                        <h4 class="modal-title custom_align" id="Heading">Edite seu detalhe</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <input class="form-control " type="text" >
                        </div>
                        <div class="form-group">

                            <input class="form-control " type="text">
                        </div>
                        <div class="form-group">
                            <textarea rows="2" class="form-control"></textarea>
                        </div>
                    </div>
                    <div class="modal-footer ">
                        <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>
                    </div>
                </div>
                <!-- /.modal-content --> 
            </div>
            <!-- /.modal-dialog --> 
        </div>

        <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                        <h4 class="modal-title custom_align" id="Heading">Excluir Detalhe</h4>
                    </div>
                    <div class="modal-body">

                        <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Tem certeza de que deseja excluir este registro?</div>

                    </div>
                    <div class="modal-footer ">
                        <button type="button" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Sim</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Nao</button>
                    </div>
                </div>
                <!-- /.modal-content --> 
            </div>
            <!-- /.modal-dialog --> 
        </div>
        <jsp:include page = "source/Footer2.jsp" />
    </body>
</html>
