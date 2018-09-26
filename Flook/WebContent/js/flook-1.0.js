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
	
	var classInput = "is-invalid";

	// Regexs
	function EmailValidation(emailAddress) {
	  var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	  return regex.test(emailAddress);
	}

	function NameValidation(name) {
	  var regex = /^[a-zA-Z ]{2,30}$/;
	  return regex.test(name);
	}

	function PasswordValidation(pass) {
	  var regex =  /^[a-zA-Z0-9.\-_$@*!]{6,30}$/;
	  return regex.test(pass);
	}

	var classField = function(field, css,remove){
	  if(remove){
	    $(field).removeClass(css);
	  }
	  else {
	    $(field).addClass(css);
	  }
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
	
	$('#btnCadastrar').click(function() {
		  var result = true;
		  var userName = $('#name');
		  var name = NameValidation(userName.val().trim());
		  if (name == false) {
		    classField(userName, classInput, false);
		    result = false;
		  }else {
		    classField(userName, classInput, true);
		  }

		  var emailAdress = $('#email');
		  var email = EmailValidation(emailAdress.val().trim());
		  if (email == false) {
		    classField(emailAdress, classInput, false);
		    result = false;
		  }else {
		    classField(emailAdress, classInput, true);
		  }


		  var userPass = $('#password');
		  var confPass = $('#conPassword');
		  var pass = PasswordValidation(userPass.val());
		  if (pass == false) {
		    classField(userPass, classInput, false);
		    result = false;
		  }else {
		    classField(userPass, classInput, true);
		  }

		  if (userPass.val() !== confPass.val()) {
		    classField(confPass, classInput, false);
		    result = false;
		  }else {
		    classField(confPass, classInput, true);
		  }

		  var date = $('#age');
		  if (date.val() == "") {
		    classField(date, classInput, false);
		    result = false;
		  }else {
		    classField(date, classInput, true);
		  }
		  
		  if(result)
			  $("#formUsrCadastro").submit();
		  
		});

});
