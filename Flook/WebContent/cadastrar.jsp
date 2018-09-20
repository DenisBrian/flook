<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="UTF-8">
<title>Procurar Curso - Flook</title>
<%@ include file="header.jsp"%>
</head>
<body class="background-blue">
	<div class="d-flex justify-content-center">
		<div class="card " style="width: 30em;">
			<h5 class="card-header text-center">Ainda não possui uma conta?</h5>
			<div class="card-body">
				<form>
					<div class="form-group">
						<label for="name">Nome</label> <input type="text"
							class="form-control" id="name" placeholder="Ex: João"
							tabindex="1">
					</div>
					<div class="form-group">
						<label for="age">Data Nascimento</label> <input type="text"
							class="form-control" id="age" data-mask="00/00/0000"
							placeholder="02/06/2000" tabindex="2">
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" placeholder="Ex: Flook@gmail.com"
							tabindex="3">
					</div>
					<div class="form-group">
						<label for="password">Senha</label> <input type="password"
							class="form-control" id="password" tabindex="3">
					</div>
					<div class="form-group">
						<label for="conPassword">Confirmar Senha</label> <input
							type="password" class="form-control" id="conPassword"
							tabindex="4">
					</div>
					<div class="form-group">
						<select class="form-control" tabindex="5">
							<option>Grau de escolaridade</option>
							<option>Ensino Médio Incompleto</option>
							<option>Ensino Médio Completo</option>
							<option>Ensino Superior Incompleto</option>
							<option>Ensino Superior Completo</option>
							<option>Outro</option>
						</select>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-standard">Cadastrar</button>
						<div class="mt-3">
							<a href="contato.html">Está tendo problemas?</a>
						</div>
				</form>
			</div>
		</div>
</body>
</html>