<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Flook</title>
<%@ include file="header.jsp"%>
</head>
<body class="background-blue">
	<div class="d-flex justify-content-center">
		<div class="card " style="width: 30em;">
			<h5 class="card-header text-center">Ainda não possui uma conta?</h5>
			<div class="card-body">
				<form id="formUsrCadastro" action="usuarioServlet" method="post">
					<div class="form-group">
						<label for="name">Nome</label> <input type="text"
							class="form-control" id="name" placeholder="Ex: João"
							tabindex="1" name="nome">
						<div class="invalid-feedback">O nome não dever conter número
							e caracteres especiais.</div>
					</div>
					<div class="form-group">
						<label for="age">Data Nascimento</label> <input type="text"
							class="form-control" id="age" data-mask="00/00/0000"
							placeholder="02/06/2000" tabindex="2" name="data">
						<div class="invalid-feedback">Informe uma data válida</div>
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" placeholder="Ex: Flook@gmail.com"
							tabindex="3" name="email">
						<div class="invalid-feedback">E-mail no formato inválido.Um
							e-mail deve ter um @.</div>
					</div>
					<div class="form-group">
						<label for="password">Senha</label> <input type="password"
							class="form-control" id="password" tabindex="3" name="senha">
						<div class="invalid-feedback">A senha deve possuir no mínimo
							6 dígitos.</div>
					</div>
					<div class="form-group">
						<label for="conPassword">Confirmar Senha</label> <input
							type="password" class="form-control" id="conPassword"
							tabindex="4" name="confirmar senha">
						<div class="invalid-feedback">As senhas inseridas são
							diferentes. Por favor, insira as senhas corretamente.</div>
					</div>
					<input name="acao" value="cadastrar" type="hidden">
					<div class="text-center">
						<button type="button" id="btnCadastrar" class="btn btn-standard btn-cadastro">Cadastrar</button>
						<div class="mt-3">
							<a href="contato.jsp">Está tendo problemas?</a>
						</div>
				</form>
				<c:if test="${ invalido == 's' }">
					<div class="alert alert-warning" role="alert">Não foi possível cadastrar !!</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>