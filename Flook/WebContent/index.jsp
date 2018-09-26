<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Flook</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2 class="text-center">Flook</h2>
			<p class="lead text-center">A sua página de pesquisa de curso</p>
			<hr class="my-4">
			<div class="container">
				<div class="input-group text-center">
					<input id="inpCurso" type="text" class="form-control" placeholder="Pesquise um curso aqui ...">
					<div class="input-group-append" id="button-addon4">
						<button id="btnCurso" class="btn btn-blue" type="button"></button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid container-advantages pt-4 pb-3">
		<div class="container">
			<div class="row">
				<div class="text-center col-md-4">
					<img src="images/livro.png" alt="">
					<h2>Cursos</h2>
					<p>84 Cursos cadastrados</p>
				</div>
				<div class="text-center col-md-4">
					<img src="images/avaliacao.png" alt="">
					<h2>Avaliação</h2>
					<p>38 Perguntas respondidas</p>
				</div>
				<div class="text-center col-md-4">
					<img src="images/forum.png" alt="">
					<h2>Fórum</h2>
					<p>56 perguntas criadas</p>
				</div>
			</div>
		</div>
	</div>
	<div class="container image-howWorks" id="howWork">
		<div class="card col-md-7">
			<div class="card-body">
				<h3 class="card-title-1">Procure um curso</h3>
				<hr class="my-2">
				<p>Os cursos já cadastrados na nossa plataforma são ideais para pessoas que estão buscando conhecer mais sobre determinada carreira , em apenas algum clicks você pode pesquisar um curso.</p>
			</div>
		</div>
		<div class="card col-md-7">
			<div class="card-body">
				<h3 class="card-title-2">Leia e avalie</h3>
				<hr class="my-2">
				<p>Em nossa página nós nos importamos com sua classificação, os cursos possuem um sistema de avaliação que mostra de forma interativa os cursos com maior numero de joinhas.</p>
			</div>
		</div>
		<div class="card col-md-7">
			<div class="card-body">
				<h3 class="card-title-3">Participe do fórum</h3>
				<hr class="my-2">
				<p>O forum de discussão é um lugar para solucionar as suas dúvidas, basicamente, possuem duas divisões a primeira faz a divisão por curso. A segunda, uma divisão desse em tópicos.</p>
			</div>
		</div>
	</div>
	<div class="container text-center">
		<hr class="my-5">
		<p>Flook conta com o patrocínio de empresas que fazem a diferença</p>
		<div class="row">
			<div class="col-md-6 pt-2 pb-2">
				<a href="https://www.fiap.com.br/" target="_blank"><img
					src="images/Patrocinadores/logo-fiap.png" alt="Fiap" width="160px" height="60px"></a>
			</div>
			<div class="col-md-6 pt-2 pb-2">
				<a href="https://www.ibm.com/br-pt/" target="_blank"><img
					src="images/Patrocinadores/logo-ibm.png" alt="IBM" width="160px" height="60px"></a>
			</div>
		</div>
	</div>
	<%@ include file="chatbot.jsp"%>
	<%@ include file="footer.jsp"%>
</body>
</html>