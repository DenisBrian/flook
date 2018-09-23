<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="UTF-8">
<title>Flook</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
  <div class="container">
    <form class="formQuestion mt-5">
      <img src="../images/user.png" alt="" width="40" height="40">
      <h6 class="">Matheus Aprigio <span>(XX,XX pontos)</span></h6>
      <div class="form-group mt-4">
        <label for="curse">Curso Selecionado:</label>
        <input id="curse" class="form-control"type="text" name="" value="" placeholder="AnÃ¡lise e Desenvolvimento de Sistemas" disabled>
      </div>
      <div class="form-group mt-4">
        <label for="title">TÃ­tulo</label>
        <input type="text" class="form-control" id="title" placeholder="Descreva a pergunta em poucas palavras ..." tabindex="1">
      </div>
      <div class="form-group mt-4">
        <label for="question">Pergunta:</label>
        <textarea id="question" name="name" rows="8" cols="80"></textarea>
      </div>
      <button class="btn btn-standard"type="button" name="button">Enviar</button>
    </form>
  </div>
  <div class="container text-center">
    <hr class="my-5">
    <p class="footer-text"> Â© 2018 Copyright: Flook.com</p>
  </div>
  	<%@ include file="chatbot.jsp"%>
</body>
</html>
