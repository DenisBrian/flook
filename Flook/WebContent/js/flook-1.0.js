$(document).ready(function() {

	$('.btn-backTop').click(function(event) {
		event.preventDefault();
		$('html, body').animate({
			scrollTop : 0
		}, 300);
	});

	$('.chatbot').click(function() {
		$('.chatbot').css('visibility', 'hidden');
		$('#live-chat').css('visibility', 'visible')
	});

	$('.chat-close').click(function() {
		$('.chatbot').css('visibility', 'visible');
		$('#live-chat').css('visibility', 'hidden')
	});
	
	$("#btnEntrar").click(function(){
		window.location = "./login.jsp";
	});
	
	$("#btnCurso").click(function(){
		let curso = $("#inpCurso").val();
		
		if(curso.length == 0){
			alert("Necessário digitar o nome de um curso");
			return;
		}
		
		window.location = "./cursoServlet?acao=procurar&param=" + curso;
	});
	
});
