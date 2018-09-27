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
  <div class="container">
    <div class="input-group text-center mt-5">
      <input type="text" class="form-control" placeholder="Procure um curso aqui ..." >
      <div class="input-group-append" id="button-addon4">
        <button class="btn btn-blue" type="button"></button>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 ranking">
        <div class="card">
          <div class="card-body">
            <h5 class="text-center"><img src="./images/trophy.png" width="40px" height="40px" class="mr-3">Ranking</h5>
            <hr class="my-1 mb-3">
            <div class="ranking-person mt-1 mb-1">
              <h6 class="gold">Felipe</h6>
              <p><img src="./images/user.png" width="25px" height="25px" class="mr-3">xx,xx pontos</p>
            </div>
            <div class="ranking-person mt-1 mb-1">
              <h6 class="silver">Felipe</h6>
              <p><img src="./images/user.png" width="25px" height="25px" class="mr-3">xx,xx pontos</p>
            </div>
            <div class="ranking-person mt-1 mb-1">
              <h6 class="copper">Felipe</h6>
              <p><img src="./images/user.png" width="25px" height="25px" class="mr-3">xx,xx pontos</p>
            </div>
            <div class="ranking-person mt-1 mb-1">
              <h6 class="participation">Felipe</h6>
              <p><img src="./images/user.png" width="25px" height="25px" class="mr-3">xx,xx pontos</p>
            </div>
            <div class="ranking-person mt-1 mb-1">
              <h6 class="participation">Felipe</h6>
              <p><img src="./images/user.png" width="25px" height="25px" class="mr-3">xx,xx pontos</p>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-6">
        <div class="card recentTopics">
          <div class="card-body">
            <h5 class="text-center"><img src="./images/interrogation-icon.png" width="40px" height="40px" class="mr-3">Tópicos mais recentes</h5>
            <hr class="my-1 mb-3">
            <p> <a href=""><span class="mr-5">2 resposta(s)</span>Como faço para alinhar um item com CSS?</a></p>
            <p><a href=""><span class="mr-5">5 resposta(s)</span>Tranformação de medidas</a></p>
            <p><a href=""><span class="mr-5">0 resposta(s)</span>Uso dos "Porque"</a></p>
            <p><a href=""><span class="mr-5">0 resposta(s)</span>Como o câncer afeta o corpo</a></p>
            <p><a href=""><span class="mr-5">4 resposta(s)</span>Sombra no Photoshop</a></p>
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
