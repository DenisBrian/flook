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
			<h3>FIAP - Análise e Desenvolvimento de Sistemas</h3>
			<hr class="my-4">
		</div>
		<div class="row">
			<div class="col-md-2 text-center">
				<img class="college-image2" src="./images/Faculdade/logo-fiap.jpg"
					alt="">
			</div>
			<div class="col-md-10">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-9">
							<div class="container-fluid">
								<div class="row">
									<iframe  class="mb-5" width="806" height="353" src="https://www.youtube.com/embed/ptu5-4hpmWQ" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
								</div>
								<div class="row">
									<h5>Descrição:</h5>
									<p>Tecnologia em Análise e Desenvolvimento de Sistemas é um
										curso hands-on, em que você aprende a solucionar problemas
										reais. Um curso que também conta com a participação de grandes
										players do mercado de TI, por meio do programa de parcerias
										estratégicas da FIAP. Você vai criar aplicações WEB e Mobile
										para impactar a vida das pessoas. Aprender ou aprofundar seus
										conhecimentos em Modelagem de Sistemas, Suporte à Área de
										Negócios, Geração de Informação (para tomada de decisões),
										Criação de Aplicações sob Medida, Integração de Sistemas. E
										também colocar em prática novas tecnologias como Big Data,
										Internet das Coisas, Cloud Computing e Mobilidade.</p>
								</div>
								<div class="row">
									<h5>Plano de Carreira</h5>
									<p>is simply dummy text of the printing and typesetting
										industry. Lorem Ipsum has been the industry's standard dummy
										text ever since the 1500s, when an unknown printer took a
										galley of type and scrambled it to make a type specimen book.
									</p>
								</div>

							</div>
						</div>
						<div class="col-md-3 mt-3">
							<p>
								Nota Mec: <span>9,0</span>
							</p>
							<hr class="my-1">
							<p>Tempo de curso: 4 Semestres</p>
							<hr class="my-1">
							<p>Tipo de curso: Técnologo</p>
							<hr class="my-1">
							<p>Possui bolsa: Sim</p>
							<hr class="my-1">
							<a href=""><i class="far fa-thumbs-up"></i></a><span>184</span> <a
								href=""><i class="far fa-thumbs-down"></i></a><span>48</span>
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
