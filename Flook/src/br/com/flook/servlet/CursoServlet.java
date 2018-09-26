package br.com.flook.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flook.bo.CursoBO;
import br.com.flook.bo.InstituicaoCursoBO;
import br.com.flook.excecao.Excecao;

/**
 * Servlet implementation class CursoServlet
 */
@WebServlet("/cursoServlet")
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CursoServlet() {
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
		case "procurar":
			procurarCursos(request);
			retorno = "procurarCurso.jsp";
			break;
		case "carregar":
			carregarCurso(request);
			retorno = "curso.jsp";
		default:
			break;
		}
		
		request.getRequestDispatcher(retorno).forward(request, response);
	}

	public void procurarCursos(HttpServletRequest request) {
		try {	
			String param = request.getParameter("param").toString();
			request.setAttribute("lista", InstituicaoCursoBO.obterPorNomeDeCurso(param));
		}
		catch(Exception e) {
			request.setAttribute("erro",Excecao.tratarExcecao(e));
		}
	}

	public void carregarCurso(HttpServletRequest request) {
		try {	
			int codIns = Integer.parseInt(request.getParameter("f").toString());
			int codCurso = Integer.parseInt(request.getParameter("c").toString());
			
			request.setAttribute("ic", InstituicaoCursoBO.obterPorInstituicaoCurso(codIns,codCurso));
			
		}
		catch(Exception e) {
			request.setAttribute("erro",Excecao.tratarExcecao(e));
		}
	}

}
