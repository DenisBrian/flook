package br.com.flook.bo;

import java.util.List;

import br.com.flook.beans.Curso;
import br.com.flook.dao.CursoDAO;

/**
* Responável por todas as Regras de negócio e padronizações do Curso
* 1°) O nome não pode conter mais que 40 caracteres
* @author DENIS BRIAN CANOLA
* @author FELIPE HONÓRIO CAMARGO
* @author RAFAEL MACHADO CARDOSO
* @author MATHEUS APRIGIO DA SILVA
* @author JEFFREY RODRIGUES INNOCENCIO
* @version 1.0
* @since 1.0
* @see br.com.flook.beans.Curso
* @see br.com.flook.dao.CursoDAO
*/
public class CursoBO {
	/**
	 * Este método ira validar e repassar o objeto Curso para a classe CursoDAO
	 * @param curso Este parâmetro representa um objeto Curso do Beans.
	 * @return O método retorna um numero com o codigo do Curso.
	 * @throws Exception Tratado a exceção checked SQLException
	 * @author DENIS BRIAN CANOLA
	 */
	public static int novoCurso(Curso curso) throws Exception {
		
		if(curso.getNome().length() > 40)
			return 0;	
		
		if((CatalogoBO.obterPorCodigo(curso.getCatalogo().getCodigo())).getCodigo() == 0)
			return 0;
		
		curso.setNome(curso.getNome().toUpperCase());
		
		CursoDAO dao = new CursoDAO();
		int cod = dao.gravar(curso);
		
		dao.fechar();
		return cod;
	}
	
	/**
	 * Este método ira buscar os objetos Curso pelo nome.
	 * @param nome Este parâmetro representa o nome do curso.
	 * @return O método retorna os Cursos desejados
	 * @throws Exception Tratado a exeção checked SQLException
	 * @author DENIS BRIAN CANOLA
	 */
	public static List<Curso> obterCursosPorNome(String nome) throws Exception{
		CursoDAO dao = new CursoDAO();
		List<Curso> cursos = dao.obter(nome);
		dao.fechar();
		return cursos;
	}
	
	/**
	 * Este método ira buscar o objeto Curso por seu codigo
	 * @param codigo Este parâmetro representa o codigo do curso.
	 * @return O método retorna o Curso desejado.
	 * @throws Exception Tratado a exeção checked SQLException
	 * @author DENIS BRIAN CANOLA
	 */
	public static Curso obterCursoPorCodigo(int codigo) throws Exception{
		CursoDAO dao = new CursoDAO();
		Curso curso = dao.obter(codigo);
		dao.fechar();
		return curso;
	}
}
