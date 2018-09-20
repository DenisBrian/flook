<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="UTF-8">
<title>Contato - Flook</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="col-md-5 mt-5 mb-5 mx-auto">
		<h5 class="text-center">Entre em contato conosco que
			responderemos em breve!</h5>
		<form>
			<div class="form-group">
				<label for="email">E-mail</label> <input type="email"
					class="form-control" id="email">
			</div>
			<div class="form-group">
				<label>Tipo Mensagem</label> <select class="form-control">
					<option>Opção</option>
					<option>Dúvida</option>
					<option>Relatar Bug</option>
					<option>Reclamação</option>
					<option>Sugestão</option>
					<option>Outro(s)</option>
				</select>
				<div class="form-group green-border-focus">
					<label for="mensagem">Mensagem</label>
					<textarea class="form-control" id="mensagem" rows="3"
						style="resize: none"></textarea>
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-standard">Enviar</button>
				</div>
			</div>
		</form>
	</div>
	<div class="mt-4 mb-4">
		<div class="container">
			<hr class="my-4">
			<div class="row">
				<div class="text-center col-12 col-sm-12 col-md-4">
					<img src="images/pin.png" alt="" width="60px">
					<h4>Localização</h4>
					<p>R. Olimpíadas, 186 - Vila Olimpia, São Paulo - SP, 04551-000</p>
				</div>
				<div class="text-center col-12 col-sm-12 col-md-4">
					<img src="images/telefone.png" alt="" width="60px">
					<h4>Contato</h4>
					<p>Fone:(11)99639-2183</p>
					<p>flook@gmail.com.br</p>
				</div>
				<div class="text-center col-12 col-sm-12 col-md-4">
					<img src="images/carta.png" alt="" width="60px">
					<h4>Redes Sociais</h4>
					<a href="#"><i class="fab fa-facebook" style="color: #2d2d2d"></i></a>
					<a href="#"><i class="fab fa-linkedin" style="color: #2d2d2d"></i></a>
					<a href="#"><i class="fab fa-google-plus-square"
						style="color: #2d2d2d"></i></a>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>