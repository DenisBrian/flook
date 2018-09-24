<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="UTF-8">
<title>Flook</title>
<%@ include file="header.jsp"%>
</head>  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
  <title>Flook</title>
</head>
<body>
 <%@ include file="menu.jsp"%>
  <div class="container-fluid pt-3 pb-3 bannerForum">
    <div class="container">
      <h4>Fórum</h4>
    </div>
  </div>
  <div class="container pt-3 ">
    <h4 class="pt-2">Como posicionar elementos com CSS</h4>
    <hr class="my-3">
    <p><img src="./images/user.png" alt="" width="35px" height="35px" class="mr-4">Criado por: <span>Thais Araújo</span> <span>(25.00 pontos)</span></p>
    <p class="question">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
  </div>
  <div class="container-fluid mt-5 pt-3 pb-3 bannerForum">
    <div class="container">
      <h4><span>2 </span>Respostas</h4>
    </div>
  </div>
  <div class="container pt-3">
    <div class="pt-3 pb-3">
      <p><img src="./images/user.png" alt="" width="35px" height="35px" class="mr-4"><span>Matheus Silva</span> <span>(431.00 pontos)</span><img src="./images/correct.png" class="ml-3 mr-3"alt="" height="30" width="30"></p>
      <p class="question">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor!
        incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      </div>
      <hr class="my-3">
      <div class="pt-3 pb-3">
        <p><img src="./images/user.png" alt="" width="35px" height="35px" class="mr-4"><span>Matheus Silva</span> <span>(431.00 pontos)</span></p>
        <p class="question">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor!
          incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
        <hr class="my-3">
          <div class="input-group answer mb-5 mt-1">
            <form class="" action="index.html" method="post">
                <label for="answer">Envie a sua resposta:</label>
                <textarea class="mb-2"id="answer"name="name" rows="8" cols="80"></textarea>
                <button class="btn btn-standard" type="submit">Enviar</button>
              </form>
            </div>
          </div>
	<%@ include file="chatbot.jsp"%>
      </body>
      </html>
