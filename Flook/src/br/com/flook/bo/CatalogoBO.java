package br.com.flook.bo;

import br.com.flook.beans.Catalogo;
import br.com.flook.dao.CatalogoDAO;
/**
* Responável por todas as Regras de negócio e padronizações do CatalogoBO
* 1°) A quantidades de caracteres da descrição não pode ser igual a 0
* 2°) A quantidades de caracteres da descrição não pode ser maior que 50
* @author DENIS BRIAN CANOLA
* @author FELIPE HONÓRIO CAMARGO
* @author RAFAEL MACHADO CARDOSO
* @author MATHEUS APRIGIO DA SILVA
* @author JEFFREY RODRIGUES INNOCENCIO
* @version 1.0
* @since 1.0
* @see br.com.flook.beans.Catalogo
* @see br.com.flook.dao.CatalogoDAO
*/
public class CatalogoBO {
	/**
	 * Este método ira validar e repassar o objeto Catalogo para a classe CatalogoDAO
	 * @param obj Este parâmetro representa um objeto Catalogo do Beans.
	 * @return O método retorna um numero com o codigo do Curso.
	 * @throws Exception Tratado a exceção checked SQLExceptio
	 * @author DENIS BRIAN CANOLA
	 */
	public static int novoCatalogo(Catalogo obj) throws Exception{
		
		if(obj.getDescricao().length() == 0)
			return 0;
			
		if(obj.getDescricao().length() > 50)
			return 0;
		
		CatalogoDAO dao = new CatalogoDAO();
		int cod = dao.gravar(obj);
		dao.fechar();
		
		return cod;
	}
	/**
	 * Este método ira pesquisar o Catalogo pelo codigo
	 * @param cod Este parâmetro representa o codigo do objeto Catalogo 
	 * @return O método retorna os Catalogo encontrados
	 * @throws Exception Tratado a exceção checked SQLExceptio
	 * @author DENIS BRIAN CANOLA
	 */
	public static Catalogo obterPorCodigo(int cod) throws Exception{		
		CatalogoDAO dao = new CatalogoDAO();
		Catalogo obj = dao.obter(cod);
		dao.fechar();
		return obj;
	}

}
