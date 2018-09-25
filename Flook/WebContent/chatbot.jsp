<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="chatbot">
	<ul>
		<li><a class="chat-back"><i class="fas fa-comments"></i></a></li>
	</ul>
</nav>
<div id="live-chat">
	<header class="clearfix">
		<a class="chat-close">x</a>
		<h4>Flook Bot</h4>
	</header>
	<div class="chat">
<<<<<<< HEAD
		<div id="chatHistory" class="chat-history">
			<c:forEach items="${ items }" var="item">
				<hr class="my-1">
				<div class="chat-message mt-3 mb-3 clearfix">
					<img src="images/user.png" alt="" width="32" height="32">
					<div class="chat-message-content clearfix">
						<h5>Usuario</h5>
						<p>${ item.key }</p>
					</div>
=======
		<div class="chat-history">
			<div class="chat-message mt-3 mb-3 clearfix">
				<img src="images/bot.png" alt="" width="32" height="32">
				<div class="chat-message-content clearfix">
					<h5>Flook Bot</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Error, explicabo quasi ratione odio dolorum harum.</p>
>>>>>>> branch 'master' of https://github.com/DenisBrian/flook.git
				</div>
				<hr class="my-1">
				<div class="chat-message mt-3 mb-3 clearfix">
					<img src="images/user.png" alt="" width="32" height="32">
					<div class="chat-message-content clearfix">
						<h5>Sr. Robot</h5>
						${ item.value }
					</div>
				</div>
			</c:forEach>

		</div>
		<form id="formChatbot" class="p-3" action="botServlet" method="post">
			<fieldset>
				<input id="inpChatbot" name="pergunta" type="text"
					placeholder="Digite a sua mensagem…" autocomplete="off" autofocus>
				<input type="hidden">
			</fieldset>
		</form>
	</div>
</div>