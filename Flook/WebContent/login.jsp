<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flook</title>
<%@ include file="header.jsp"%>
</head>
<body class="background-blue">
	<div class="d-flex justify-content-center">
		<div class="card " style="width: 30em;">
			<h5 class="card-header text-center">Já possui uma conta?</h5>
			<div class="card-body">
				<form id="formLogin" class="p-3" action="usuarioServlet"
					method="post">
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email"
							placeholder="Ex: flook@flook.com" tabindex="1">
					</div>
					<div class="form-group">
						<label for="password">Senha</label> <input type="password"
							class="form-control" id="password" name="senha" tabindex="2">
					</div>
					<input name="acao" value="logar" type="hidden">
					<div class="text-center">
						<button type="submit" class="btn btn-standard">Entrar</button>
						<div class="mt-3">
							<a href="./cadastrar.jsp">Não possui conta?</a> <span>-</span> <a
								href="./esqueceuSenha.jsp">Esqueci a senha</a>
						</div>
					</div>
				</form>

				<c:if test="${ invalido == 's' }">
					<div class="alert alert-warning" role="alert">E-mail ou Senha
						não foi localizado!!</div>
				</c:if>
				<c:if test="${ cadastro == 's' }">
					<div class="alert alert-success" role="alert">Cadastro realizado com sucesso !!</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>