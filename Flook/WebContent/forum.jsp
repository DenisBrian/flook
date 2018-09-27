<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flook</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
  <div class="container container-course">
    <div class="input-group text-center mb-5">
      <input type="text" class="form-control" placeholder="Pesquise por um tópico aqui" >
      <div class="input-group-append" id="button-addon4">
        <button class="btn btn-blue" type="button"></button>
      </div>
    </div>
    <hr class="my-3">
  <div class="card">
    <div class="card-body">
      <div class="row">
        <div class="col-md-2 mb-1 text-center" >
          <p class="text-center"><img src="./images/user.png" class="mt-4 " alt="" width="50" height="50">
          <h6>Matheus Aprigio</h6>
          <p>(<span>423,422 </span>pontos)</p>
        </div>
        <div class="col-md-6">
          <h5><a href="">A pergunta fica aqui</a></h5>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat</p>
        </div>
        <div class="col-md-2">
          <p class="mt-5 text-center"><a href=""><span>21</span> Respostas</a></p>
        </div>
        <div class="col-md-2">
          <p class="text-center"><img src="./images/correct.png" class="mt-5" width="50" height="50"  alt=""></p>
        </div>
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-body">
      <div class="row">
        <div class="col-md-2 mb-1 text-center" >
          <p class="text-center"><img src="./images/user.png" class="mt-4 " alt="" width="50" height="50">
          <h6 >Jair Bolsonaro</h6>
          <p>(<span>13,00 </span>pontos)</p>
          </p>
        </div>
        <div class="col-md-6">
          <h5><a href="">Lula Ladrão?</a></h5>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat</p>
        </div>
        <div class="col-md-2">
          <p class="mt-5 text-center"><a href=""><span>13</span> Respostas</a></p>
        </div>
        <div class="col-md-2">
          <p class="text-center"><img src="./images/error.png" class="mt-5" width="50" height="50"  alt=""></p>
        </div>
      </div>
    </div>
  </div>
  </div>
  <div class="container text-center">
    <hr class="my-5">
    <p class="footer-text"> © 2018 Copyright: Flook.com</p>
  </div>
	<%@ include file="chatbot.jsp"%>
</body>
</html>
