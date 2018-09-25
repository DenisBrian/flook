$(document).ready(function() {

	// METHODS
	var showChat = function(open) {
		if (open) {
			sessionStorage.setItem("janela", "aberta");
			$('.chatbot').css('visibility', 'hidden');
			$('#live-chat').css('visibility', 'visible');
			$("#inpChatbot").focus();
			$('#chatHistory').scrollTop($('#chatHistory')[0].scrollHeight);
		} else {
			sessionStorage.setItem("janela", "fechada");
			$('.chatbot').css('visibility', 'visible');
			$('#live-chat').css('visibility', 'hidden');
		}
	}
	var clickOptionBot = function(value){
		$("#inpChatbot").val(value.toString());
		$("#formChatbot").submit();
	}
	// EVENTS
	
	$('.chat-option').click(function(event){
		clickOptionBot(event.target.innerText);
	});
	
	$('.btn-backTop').click(function(event) {
		event.preventDefault();
		$('html, body').animate({
			scrollTop : 0
		}, 300);
	});

	$('.chatbot').click(function() {
		showChat(true);
		$("#formChatbot").submit();
	});

	$('.chat-close').click(function() {
		showChat(false);
		$("#idStart").val("");
	});

	$("#btnEntrar").click(function() {
		window.location = "./login.jsp";
	});

	$("#btnCurso").click(function() {
		let curso = $("#inpCurso").val();

		if (curso.length == 0) {
			alert("Necessário digitar o nome de um curso");
			return;
		}

		window.location = "./cursoServlet?acao=procurar&param=" + curso;
	});

	$("#inpChatbot").keyup(function(e) {
		if (e.value.length == 0)
			return false;

		if (e.keyCod == 13)
			$("#formChatbot").submit();

	});

	if (sessionStorage.getItem("janela") == "aberta") {
		showChat(true);
	}
});
