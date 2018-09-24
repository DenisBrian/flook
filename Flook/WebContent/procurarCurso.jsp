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
	  <div class="container container-course">
		<div class="input-group text-center mb-5">
			<input id="inpCurso" type="text" class="form-control"
				placeholder="Pesquise um curso aqui ...">
			<div class="input-group-append" id="button-addon4">
				<button id="btnCurso" class="btn btn-blue" type="button"></button>
			</div>
		</div>
		<hr class="my-3">
		<c:forEach items="${ lista }" var="c">
			<div class="card">
				<div class="row">
					<div class="col-md-2 text-center">
						<img class="college-image" src="images${ c.instituicao.logo }"
							alt="">
					</div>
					<div class="col-md-8">
						<div class="row course-content">
							<div class="col-md-8">
								<p>${ c.instituicao.descricao }</p>
							</div>
							<div class="col-md-4">
								<p>
									Nota Mec: <span>${ c.mec }</span>
								</p>
								<p>Tempo de curso: ${ c.duracao } Ano(s)</p>
								<p>Tipo de curso: ${ c.tipoCurso }</p>
							</div>
							<div class="col-md-8">
								<a
									href="cursoServlet?acao=carregar&c=${ c.curso.codigo }&f=${ c.instituicao.codigo }"
									class="btn-seeMore">Ver mais</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
    <hr class="my-3">
    <div class="card">
      <div class="row">
        <div class="col-md-2 text-center">
          <img class="college-image"src="./images/logo-usp.png" alt="">
        </div>
        <div class="col-md-8">
          <div class="row course-content">
            <div class="col-md-8">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat...</p>
            </div>
            <div class="col-md-4">
              <p>Nota Mec: <span>X,X</span></p>
              <p>Tempo de curso: X Semestres</p>
              <p>Tipo de curso: Lorem ipsum</p>
            </div>
            <div class="col-md-8">
              <a href="#" class="btn-seeMore">Ver mais</a>
              <i class="fas fa-star favorite-icon" title="Favoritar"></i>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="row">
        <div class="col-md-2 text-center">
          <img class="college-image"src="./images/logo-fiap.jpg" alt="">
        </div>
        <div class="col-md-8">
          <div class="row course-content">
            <div class="col-md-8">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat...</p>
            </div>
            <div class="col-md-4">
              <p>Nota Mec: <span>X,X</span></p>
              <p>Tempo de curso: X Semestres</p>
              <p>Tipo de curso: Lorem ipsum</p>
            </div>
            <div class="col-md-8">
              <a href="#" class="btn-seeMore">Ver mais</a>
              <i class="fas fa-star favorite-icon" title="Favoritar"></i>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="row">
        <div class="col-md-2 text-center">
          <img class="college-image"src="./images/logo-unip.jpg" alt="">
        </div>
        <div class="col-md-8">
          <div class="row course-content">
            <div class="col-md-8">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat...</p>
            </div>
            <div class="col-md-4">
              <p>Nota Mec: <span>X,X</span></p>
              <p>Tempo de curso: X Semestres</p>
              <p>Tipo de curso: Lorem ipsum</p>
            </div>
            <div class="col-md-12">
              <a href="#" class="btn-seeMore">Ver mais</a>
              <i class="fas fa-star favorite-icon" title="Favoritar"></i>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="row">
        <div class="col-md-2 text-center">
          <img class="college-image"src="./images/logo-usp.png" alt="">
        </div>
        <div class="col-md-8">
          <div class="row course-content">
            <div class="col-md-8">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat...</p>
            </div>
            <div class="col-md-4">
              <p>Nota Mec: <span>X,X</span></p>
              <p>Tempo de curso: X Semestres</p>
              <p>Tipo de curso: Lorem ipsum</p>
            </div>
            <div class="col-md-8">
              <a href="#" class="btn-seeMore">Ver mais</a>
              <i class="fas fa-star favorite-icon " title="Favoritar"></i>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="row">
        <div class="col-md-2 text-center">
          <img class="college-image"src="./images/logo-fiap.jpg" alt="">
        </div>
        <div class="col-md-8">
          <div class="row course-content">
            <div class="col-md-8">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat...</p>
            </div>
            <div class="col-md-4">
              <p>Nota Mec: <span>X,X</span></p>
              <p>Tempo de curso: X Semestres</p>
              <p>Tipo de curso: Lorem ipsum</p>
            </div>
            <div class="col-md-8">
              <a href="#" class="btn-seeMore">Ver mais</a>
              <i class="fas fa-star favorite-icon" title="Favoritar"></i>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="row">
        <div class="col-md-2 text-center">
          <img class="college-image"src="../images/logo-unip.jpg" alt="">
        </div>
        <div class="col-md-8">
          <div class="row course-content">
            <div class="col-md-8">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat...</p>
            </div>
            <div class="col-md-4">
              <p>Nota Mec: <span>X,X</span></p>
              <p>Tempo de curso: X Semestres</p>
              <p>Tipo de curso: Lorem ipsum</p>
            </div>
            <div class="col-md-12">
              <a href="#" class="btn-seeMore">Ver mais</a>
              <i class="fas fa-star favorite-icon" title="Favoritar"></i>
            </div>
          </div>
        </div>
      </div>
    </div>
	</div>
	<%@ include file="chatbot.jsp"%>
	<%@ include file="footer.jsp"%>
</body>
</html>