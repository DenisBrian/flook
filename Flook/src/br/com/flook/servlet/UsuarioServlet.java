package br.com.flook.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.flook.beans.Usuario;
import br.com.flook.bo.InstituicaoCursoBO;
import br.com.flook.bo.UsuarioBO;
import br.com.flook.excecao.Excecao;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao").toString();
		String retorno = "";
		
		switch (acao) {
		case "procurar":
			cadastrar(request);
			retorno = "cadastrar.jsp";
			break;
		case "logar":
			retorno = logar(request);
			break;
		case "reenviar":
			reenviarSenha(request);
			retorno = "esqueceuSenha.jsp";
			break;
		case "perfil":
			visualizarPerfil(request);
			retorno = "perfil.jsp";
			break;
		case "deslogar":
			visualizarPerfil(request);
			retorno = "perfil.jsp";
			break;
		default:
			break;
		}
		
		request.getRequestDispatcher(retorno).forward(request, response);
	}
	
	
	public void cadastrar(HttpServletRequest request) {
		
	}
	
	public String logar(HttpServletRequest request) {
		String email = request.getParameter("email").toString();
		String senha = request.getParameter("senha").toString();
		HttpSession session = request.getSession();
		
		String page = "";
		try {	
			Usuario obj = UsuarioBO.obterPorLogin(email, senha);
			
			if(obj.getCodigo() > 0)
			{
				page = "perfil.jsp";
				session.setAttribute("usuarioId", obj.getCodigo());
			}else {
				page = "login.jsp";
				request.setAttribute("invalido", "s");
			}
		}
		catch(Exception e) {
			request.setAttribute("erro",Excecao.tratarExcecao(e));
		}
		
		return page;
	}
	
	public void reenviarSenha(HttpServletRequest request) {
		
	}

	public void visualizarPerfil(HttpServletRequest request) {
		
	}

	public void deslogar(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
