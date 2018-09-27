package br.com.flook.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.flook.beans.TipoUsuario;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao").toString();
		String retorno = "";

		switch (acao) {
		case "cadastrar":
			retorno = cadastrar(request);
			break;
		case "logar":
			retorno = login(request);
			break;
		case "deslogar":
			logout(request);
			retorno = "index.jsp";
			break;
		default:
			break;
		}

		request.getRequestDispatcher(retorno).forward(request, response);
	}

	public String cadastrar(HttpServletRequest request) {
		String result = "";
		
		try {
			String nome = request.getParameter("nome");
			String data = request.getParameter("data");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(data));

			Usuario obj = new Usuario();
			obj.setNome(nome);
			obj.setEmail(email);
			obj.setSenha(senha);
			obj.setImagem("");
			obj.setPontoAcumulado(0);
			obj.setTipoUsuario(new TipoUsuario(2, ""));
			obj.setDataNascimento(c);
			
			if (UsuarioBO.novoUsuario(obj) > 0) {
				result = "login.jsp";
				request.setAttribute("cadastro", "s");
			} else {
				result = "cadastrar.jsp";
				request.setAttribute("invalido", "s");
			}
		} catch (Exception e) {
			request.setAttribute("erro", Excecao.tratarExcecao(e));
			result = "erro.jsp";
		}

		return result;
	}

	public String login(HttpServletRequest request) {
		String email = request.getParameter("email").toString();
		String senha = request.getParameter("senha").toString();
		HttpSession session = request.getSession();

		String page = "";
		try {
			Usuario obj = UsuarioBO.obterPorLogin(email, senha);

			if (obj.getCodigo() > 0) {
				page = "perfil.jsp";
				session.setAttribute("usuarioId", obj.getCodigo());
				session.setAttribute("usuario", obj);
			} else {
				page = "login.jsp";
				request.setAttribute("invalido", "s");
			}
		} catch (Exception e) {
			request.setAttribute("erro", Excecao.tratarExcecao(e));
			page = "erro.jsp";
		}

		return page;
	}

	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
