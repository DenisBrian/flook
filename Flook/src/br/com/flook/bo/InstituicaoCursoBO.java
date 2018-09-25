package br.com.flook.bo;

import java.util.List;

import br.com.flook.beans.InstituicaoCurso;
import br.com.flook.dao.InstituicaoCursoDAO;
/**
 * Responsavel por todas as regras de negócios e padronizações da InstituiçãoCurso
 * 1°) A quantidades de caracteres do nome não pode ser igual a 0
 * @author FELIPE HONÓRIO CAMARGO
 * @author DENIS BRIAN CANOLA
 * @author RAFAEL MACHADO CARDOSO
 * @author MATHEUS APRIGIO DA SILVA
 * @author JEFFREY RODRIGUES INNOCENCIO
 * @version 1.0
 * @since 1.0
 * @see br.com.flook.dao.InstituicaoCursoDAO
 */
public class InstituicaoCursoBO {
	/**
	 * Este método ira buscar as a instutuição pelo nome do Curso.
	 * @param nome Este parâmetro representa o nome do objeto Curso Beans.
	 * @return O método retorna uma lista com as Instituições encontradas
	 * @throws Exception Tratado a exceção checked SQLExceptio
	 * @author DENIS BRIAN CANOLA
	 */
	public static List<InstituicaoCurso> obterPorNomeDeCurso(String nome) throws Exception{
		
		if(nome.length() == 0)
			return null;
		
		nome = nome.toUpperCase().trim();
		
		InstituicaoCursoDAO dao = new InstituicaoCursoDAO();
		List<InstituicaoCurso> ics = dao.obter(nome);
		dao.fechar();
		return ics;
	}
}
