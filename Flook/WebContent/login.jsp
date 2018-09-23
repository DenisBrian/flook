<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="UTF-8">
<title>Flook</title>
<%@ include file="header.jsp"%>
</head>
<body class="background-blue">
	<div class="d-flex justify-content-center">
		<div class="card " style="width: 30em;">
			<h5 class="card-header text-center">Já possui uma conta?</h5>
			<div class="card-body">
				<form>
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email"
							placeholder="Ex: flook@flook.com" tabindex="1">
					</div>
					<div class="form-group">
						<label for="password">Senha</label> <input type="password"
							class="form-control" id="password" tabindex="2">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-standard">Entrar</button>
						<div class="mt-3">
							<a href="./cadastrar.jsp">Não possui conta?</a> <span>-</span> <a
								href="./esqueceuSenha.jsp">Esqueci a senha</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>