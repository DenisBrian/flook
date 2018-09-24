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
		<div class="chat-history">
			<div class="chat-message mt-3 mb-3 clearfix">
				<img src="images/bot.png" alt="" width="32" height="32">
				<div class="chat-message-content clearfix">
					<h5>Flook Bot</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Error, explicabo quasi ratione odio dolorum harum.</p>
				</div>
			</div>
			<hr class="my-1">
			<div class="chat-message mt-3 mb-3 clearfix">
				<img src="images/user.png" alt="" width="32" height="32">
				<div class="chat-message-content clearfix">
					<h5>Thais Araújo</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Error, explicabo quasi ratione odio dolorum harum.</p>
				</div>
			</div>
		</div>
		<form class="p-3" action="#" method="post">
			<fieldset>
				<input type="text" placeholder="Digite a sua mensagem…" autofocus>
				<input type="hidden">
			</fieldset>
		</form>
	</div>
</div>