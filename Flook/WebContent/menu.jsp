<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<nav class="navbar navbar-expand-sm navbar-light bg-light justify-content-end ">
    <div class="container">
      <a class="navbar-brand" href="./index.jsp">FLOOK</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse flex-grow-0" id="navbarSupportedContent">
        <ul class="navbar-nav ">
          <li class="nav-item"><a class="nav-link" href="./index.jsp#howWork">COMO FUNCIONA</a></li>
          <li class="nav-item"><a class="nav-link" href="./homeTopico.jsp">FÓRUM</a></li>
          <li class="nav-item"><a class="nav-link" href="./contato.jsp">CONTATO</a></li>
          <c:if test="${ usuarioId > 0 }">
             <li class="nav-item"><a class="nav-link" href="./perfil.jsp">PERFIL</a></li>
          </c:if>
        </ul>
        <c:choose>
        	<c:when test="${ usuarioId > 0 }"><button class="btn btn-logout" type="button"><a href="./usuarioServlet?acao=deslogar">SAIR</a></button></c:when>
        	<c:otherwise><button class="btn btn-standard" type="button"><a href="./login.jsp">ENTRAR</a></button></c:otherwise>
        </c:choose>
        
      </div>
    </div>
  </nav>