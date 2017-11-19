<%-- 
    Document   : Footer2
    Created on : 02/11/2017, 18:47:14
    Author     : vinicius caetano
--%>

<%@taglib tagdir="/WEB-INF/tags/" prefix="tagsTreebu" %>

 <style>
/* Add a dark background color to the footer */
footer {
    background-color: #2d2d30;
    color: #f5f5f5;
    padding: 32px;
}

footer a {
    color: #f5f5f5;
}

footer a:hover {
    color: #777;
    text-decoration: none;
}
</style>

<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="Topo">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p>© 2017 TreeBu.com All rights reserved <a href="https://www.treebu.com.br" data-toggle="tooltip" title="Visite Livraria TreeBU">www.treebu.com.br</a></p>
  <p>Data : <tagsTreebu:dataHoje/> </p><label>Usuario :<tagsTreebu:StatusLogado/></label>
</footer>

<script>
$(document).ready(function(){
    // Initialize Tooltip
    $('[data-toggle="tooltip"]').tooltip();
});
</script> 
