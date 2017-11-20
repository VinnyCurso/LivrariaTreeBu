<%-- 
    Document   : Livro
    Created on : 02/11/2017, 16:48:10
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
        <title>Formulario Livro</title>
    </head>
    <body>
        <div class="container">
        <h1>Formulario Livro</h1>
        </div>
        <div class="container">
            <fieldset>
                <legend>Informe neste formulario, as informações necessarios para cadastro do Livro</legend>
                <form name="formLivro" method="post" action="LivroServlet">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" id="codigo" readonly="readonly" class="form-control" value="<c:out value="${livro.codigo}"/>"> <br/>
                    </div>
                    
                    <div class="form-group"> 
                        <label>Capa :</label>
                        <input type="file" name="capa" id="capa" required="true" class="form-control" value="<c:out value="${livro.capa}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Nome :</label>
                        <input type="text" name="nome" id="nome" class="form-control" required="true" value="<c:out value="${livro.nome}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Descricao :</label>
                        <input type="text" name="descricao" id="descricao" class="form-control" required="true" value="<c:out value="${livro.descricao}"/>"> <br/>
                    </div>
                    
                    <div class="form-group">
                        <label>Data Publicação :</label>
                        <input type="date" name="datepublicacao" id="datepublicacao" class="form-control" required="true" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${livro.datepublicacao}" />" /> <br /> 
                    </div>


                    <div class="form-group">
                        <label>Numero de Paginas :</label>
                        <input type="number" name="numeroPaginas" id="numeroPaginas" class="form-control" required="true" value="<c:out value="${livro.numeropaginas}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Preço Unitário:</label>
                        <input type="text" name="preco" id="preco" class="form-control"  required="true" value="<c:out value="${livro.preco}"/>"> <br/>  
                    </div>
                        
                    <!--<div class="form-group">
                        <label>Avaliação :</label>
                        <input type="number" name="avaliacao" id="avaliacao" class="form-control" required="true" value="<c:out value="${livro.avaliacao}"/>"> <br/>
                    </div>-->

                    <div class="form-group">
                        <label>ISBN :</label>
                        <input type="text" name="isbn" id="isbn" required="true" class="form-control" value="<c:out value="${livro.isbn}"/>"> <br/>
                    </div>
                    
                    <div class="form-group">
                        <label>Editora :</label>
                        <select class="form-control" name="codeditora">
                            <c:forEach items="${editoraList}" var="editora">
                                <option value="<c:out value="${editora.codigo}"/>" 
                                        ${editora.codigo ==  livro.editora.codigo ? 'selected' : ''}>
                                    <c:out value="${editora.razaosocial}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Autor :</label>
                        <select class="form-control" name="codautor">
                            <c:forEach items="${autorList}" var="autor">
                                <option value="<c:out value="${autor.codigo}"/>" 
                                        ${autor.codigo ==  livro.autor.codigo ? 'selected' : ''}>
                                    <c:out value="${autor.nome}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Genero :</label>
                        <select class="form-control" name="codgenero">
                            <c:forEach items="${generoList}" var="genero">
                                <option value="<c:out value="${genero.codigo}"/>" 
                                        ${genero.codigo ==  livro.genero.codigo ? 'selected' : ''}>
                                    <c:out value="${genero.descricao}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Idioma :</label>
                        <select class="form-control" name="codidioma">
                            <c:forEach items="${idiomaList}" var="idioma">
                                <option value="<c:out value="${idioma.codigo}"/>" 
                                        ${idioma.codigo ==  livro.idioma.codigo ? 'selected' : ''}>
                                    <c:out value="${idioma.descricao}"/>
                                </option>
                            </c:forEach>
                        </select>
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
