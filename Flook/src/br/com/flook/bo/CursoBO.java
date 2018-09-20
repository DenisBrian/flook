package br.com.flook.bo;

import java.util.List;

import br.com.flook.beans.Curso;
import br.com.flook.dao.CursoDAO;

/**
* Respon�vel por todas as Regras de neg�cio e padroniza��es do Curso
* 1�) O nome n�o pode conter mais que 40 caracteres
* @author DENIS BRIAN CANOLA
* @author FELIPE
* @author RAFAEL
* @author MATHEUS
* @author JEFFREY
* @version 1.0
* @since 1.0
* @see br.com.flook.beans.Curso
* @see br.com.flook.dao.CursoDAO
*/
public class CursoBO {
	
	public static int novoCurso(Curso curso) throws Exception {
		
		// valida��o
		if(curso.getNome().length() > 40)
			return 0;	
		
		// padroniza��o
		curso.setNome(curso.getNome().toUpperCase());
		
		CursoDAO dao = new CursoDAO();
		int cod = dao.gravar(curso);
		
		dao.fechar();
		return cod;
	}

	public static List<Curso> obterCursosPorNome(String nome) throws Exception{
		CursoDAO dao = new CursoDAO();
		List<Curso> cursos = dao.obter(nome);
		dao.fechar();
		return cursos;
	}

	public static Curso obterCursoPorCodigo(int codigo) throws Exception{
		CursoDAO dao = new CursoDAO();
		Curso curso = dao.obter(codigo);
		dao.fechar();
		return curso;
	}
}
