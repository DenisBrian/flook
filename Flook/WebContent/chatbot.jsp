<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:if test="${ usuarioId > 0 }">
	<nav class="chatbot">
		<ul>
			<li><a class="chat-back"><i class="fas fa-comments"></i></a></li>
		</ul>
	</nav>
	<div id="live-chat">
		<header class="clearfix">
			<a class="chat-close">x</a>
			<h4>Luis</h4>
		</header>
		<div class="chat">
			<div id="chatHistory" class="chat-history">
				<c:forEach items="${ items }" var="item">
					<c:if test="${ item.key != ''}">
						<hr class="my-1">
						<div class="chat-message mt-3 mb-3 clearfix">
							<img src="images/user.png" alt="" width="32" height="32">
							<div class="chat-message-content clearfix">
								<h5>${ usuario.nome }</h5>
								<p>${ item.key }</p>
							</div>
						</div>
					</c:if>
					<hr class="my-1">
					<div class="chat-message mt-3 mb-3 clearfix">
						<img src="images/bot.png" alt="" width="32" height="32">
						<div class="chat-message-content clearfix">
							<h5>Luis</h5>
							${ item.value }
						</div>
					</div>
				</c:forEach>
			</div>
			<form id="formChatbot" class="p-3" action="botServlet" method="post">
				<fieldset>
					<input id="inpChatbot" name="pergunta" type="text"
						placeholder="Digite a sua mensagem…" autocomplete="off" autofocus>
					<input id="idStart" name="start" value="${ start }" type="hidden">
				</fieldset>
			</form>
		</div>
	</div>
</c:if>
