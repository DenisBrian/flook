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
		<div class="container-course text-center">
			<a class="pr-4" href="procurarCurso.jsp"><img
				src="./images/back.png" width="17" height="17" alt="">Voltar</a>
			<h3>${ ic.instituicao.nome } - ${ ic.curso.nome  }</h3>
			<hr class="my-4">
		</div>
		<div class="row">
			<div class="col-md-2 text-center">
				<img class="college-image2" src="./images/${ ic.instituicao.logo }"
					alt="">
			</div>
			<div class="col-md-10">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-9">
							<div class="container-fluid">
								<div class="row">
									<iframe  class="mb-5" width="806" height="353" src="${ ic.video }" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
								</div>
								<div class="row">
									<h5>Descrição:</h5>
									<p>${ ic.descricao }</p>
								</div>
								<div class="row">
									<h5>Plano de Carreira</h5>
									<p>${ ic.planoCarreira }</p>
								</div>

							</div>
						</div>
						<div class="col-md-3 mt-3">
							<p>
								Nota Mec: <span>${ ic.mec }</span>
							</p>
							<hr class="my-1">
							<p>Tempo de curso: ${ ic.duracao } anos</p>
							<hr class="my-1">
							<p>Tipo de curso: ${ ic.tipoCurso }</p>
							<hr class="my-1">
							<a href=""><i class="far fa-thumbs-up"></i></a><span>${ ic.like }</span> <a
								href=""><i class="far fa-thumbs-down"></i></a><span>${ ic.dislike }</span>
							<button class="btn btn-standard" type="button" name="button">
								<a href="criarPergunta.jsp">Abrir Tópico</a>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container text-center">
		<hr class="my-5">
		<p class="footer-text">© 2018 Copyright: Flook.com</p>
	</div>
	<%@ include file="chatbot.jsp"%>
</body>
</html>
