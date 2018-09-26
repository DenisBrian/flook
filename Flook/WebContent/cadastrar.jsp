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
			<h5 class="card-header text-center">Ainda não possui uma conta?</h5>
			<div class="card-body">
    <form>
        <div class="form-group">
          <label for="name">Nome</label>
          <input type="text" class="form-control" id="name" placeholder="Ex: João" tabindex="1" name="nome">
          <div class="invalid-feedback"> O nome não dever conter número e caracteres especiais.</div>
        </div>
        <div class="form-group">
          <label for="age">Data Nascimento</label>
          <input type="text" class="form-control" id="age" data-mask="00/00/0000" placeholder="02/06/2000" tabindex="2" name="data">
          <div class="invalid-feedback">Informe uma data válida</div>
        </div>
        <div class="form-group">
          <label for="email">Email</label>
          <input type="email" class="form-control" id="email" placeholder="Ex: Flook@gmail.com" tabindex="3" name="email">
          <div class="invalid-feedback">E-mail no formato inválido.Um e-mail deve ter um @.</div>
        </div>
        <div class="form-group">
          <label for="password">Senha</label>
          <input type="password" class="form-control" id="password" tabindex="3" name="senha">
          <div class="invalid-feedback">A senha deve possuir no mínimo 6 dígitos.</div>
        </div>
        <div class="form-group">
          <label for="conPassword">Confirmar Senha</label>
          <input type="password" class="form-control" id="conPassword" tabindex="4" name="confirmar senha">
          <div class="invalid-feedback"> As senhas inseridas são diferentes. Por favor, insira as senhas corretamente.</div>
        </div>
        <div class="form-group">
          <select id="escolaridade"class="form-control" tabindex="5" name="escolaridade">
            <option value="" selected disabled>Grau de escolaridade</option>
            <option value="Ensino Médio Incompleto" >Ensino Médio Incompleto</option>
            <option value="Ensino Médio Completo" >Ensino Médio Completo</option>
            <option value="Ensino Superior Incompleto" >Ensino Superior Incompleto</option>
            <option value="Ensino Superior Completo" >Ensino Superior Completo</option>
            <option value="Outro" >Outro</option>
          </select>
          <div class="invalid-feedback"> Escolha um nível de ensino.</div>
        </div>
        <div class="text-center">
          <button type="button" class="btn btn-standard btn-cadastro">Cadastrar</button>
          <div class="mt-3">
            <a href="contato.html">Está tendo problemas?</a>
          </div>
      </form>
        <div class="text-center">
          <button type="submit" class="btn btn-standard">Cadastrar</button>
          <div class="mt-3">
            <a href="contato.html">Está tendo problemas?</a>
          </div>
          </div>
      </form>
			</div>
		</div>
		</div>
</body>
</html>