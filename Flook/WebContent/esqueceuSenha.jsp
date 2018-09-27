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
	<div class="d-flex justify-content-center ">
		<div class="card " style="width: 30em;">
			<h5 class="card-header text-center">Recuperar conta</h5>
			<div class="card-body">
				<p class="text-center">Um e-mail de recuperação de senha será
					enviado para o seu e-mail inserido no campo acima</p>
				<hr class="my-3">
				<form>
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email"
							placeholder="Ex: DenisSilveira@gmail.com" tabindex="1">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-standard">Enviar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>