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
  <div class="container-fluid background-blue">
    <div class="container">
      <div class="text-center">
        <a><i class="fas fa-camera  mr-2 camera-icon mx-auto" data-toggle="modal" data-target=".profileImage"></i></a>
        <img  class="rounded-circle mx-auto"src="./images/user.png" alt="" width="110" height="110">
        <a href=""><h5 class="name mt-4">  <i class="fas fa-pencil-alt pencil-icon mr-2"></i></a>${ usuario.nome }</h5>
      </div>
    </div>
  </div>
  <div class="container m-5 mx-auto">
    <div class="row">
      <div class="text-center col-md-4 mb-5">
        <h5 class="mb-4"><i class="fas fa-wrench tool-icon"></i>Opções</h5>
        <ul class="list-group list-group-flush">
          <li class="list-group-item"><i class="fas fa-key key-icone mr-2"></i><a href="resetSenha.html">Alterar Senha</a></li>
          <li class="list-group-item"><i class="fas fa-book certificado-icone mr-2"></i><a  data-toggle="modal" data-target=".certificado" class="btn-certificado">Certificado</a></li>
        </ul>
      </div>
      <div class="col-md-4 mb-5">
        <h5 class="text-center text-center mb-1"><i class="far fa-clipboard fa4"></i>Pontuação</h5>
        <ul class="list-group list-group-flush">
          <li class="list-group-item mt-3 text-center">
            Atualmente você possui <span class="points">${ usuario.pontoAcumulado }</span> pontos!</li>
            <li class="list-group-item text-center">
              Posição no ranking:<span class="position"> 1000</span> </li>
            </ul>
          </div>
          <div class="text-center col-md-4 mb-5">
            <h5 class="text-center mb-4"><i class="fas fa-star fa5"></i>Favoritos</h5>
            <ul class="list-group list-group-flush">
              <li class="list-group-item"><a href="">Análise e Desenvolvimento de Sistemas</a></li>
              <li class="list-group-item"><a href="">Medicina</a></li>
              <li class="list-group-item"><a href="">Letras</a></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="container text-center">
        <hr class="my-4">
        <p class="footer-text"> © 2018 Copyright: Flook.com</p>
      </div>
      <div class="modal fade certificado" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg">
          <div class="modal-content p-3">
            <div class="container">
              <h5>Alterar certificado</h5>
              <hr class="my-3">
              <img class="mx-auto d-block mt-4 mb-4"src="./images/certificado.png" alt="" width="350px" height="350px">
              <input name="myFile" type="file">
              <div class="mt-4">
                <button type="button" name="button" class="btn btn-danger mr-2" data-dismiss="modal">Cancelar</button>
                <button type="button" name="button" class="btn btn-success">Salvar</button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="modal profileImage fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg">
          <div class="modal-content p-3">
            <div class="container">
              <h5>Alterar foto</h5>
              <hr class="my-3">
              <img class="mx-auto d-block mt-4 mb-4"src="./images/user.png" alt="">
              <input name="myFile" type="file">
              <div class="mt-4">
                <button type="button" name="button" class="btn btn-danger mr-2"  data-dismiss="modal"
                >Cancelar</button>
                <button type="button" name="button" class="btn btn-success">Salvar</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </body>
    </html>
