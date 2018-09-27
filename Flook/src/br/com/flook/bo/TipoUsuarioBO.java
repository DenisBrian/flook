package br.com.flook.bo;

import br.com.flook.beans.TipoUsuario;
import br.com.flook.dao.TipoUsuarioDAO;
/**
 * Responsavel por todas as regras de negócios e padronizações do TipoUsuario
 * 1°) A quantidades de caracteres do tipo não pode ser igual a 0 e não pode ser maior que 100
 * @author FELIPE HONÓRIO CAMARGO
 * @author DENIS BRIAN CANOLA
 * @author RAFAEL MACHADO CARDOSO
 * @author MATHEUS APRIGIO DA SILVA
 * @author JEFFREY RODRIGUES INNOCENCIO
 * @version 1.0
 * @since 1.0
 * @see br.com.flook.beans.TipoUsuario
 * @see br.com.flook.dao.TipoUsuarioDAO
 */
public class TipoUsuarioBO {
	/**
	 * Este método ira pegar o tipo de usuario pelo codigo
	 * @param cod Este parâmetro representa o codigo do TipoUsuario
	 * @return O método retorna um objeto se encontrado
	 * @throws Exception Tratado a exceção checked SQLException
	 * @author DENIS BRIAN CANOLA
	 */
	public static TipoUsuario obterPorCodigo(int cod) throws Exception{
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		TipoUsuario obj = dao.obter(cod);		
		dao.fechar();		
		return obj;
	}
	
	/**
	 * Este método ira validar e repassar o objeto TipoUsuario para a classe TipoUsuarioDAO
	 * @param obj Este parâmetro representa um objeto TipoUsuario do Beans.
	 * @return O método retorna um codigo
	 * @throws Exception Tratado a exceção checked SQLException
	 * @author DENIS BRIAN CANOLA
	 */
	public static int novoTipoUsuario(TipoUsuario obj) throws Exception{		
		if(obj.getTipo().length() == 0 || obj.getTipo().length() > 120)
			return 0;	
		
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		int cod = dao.gravar(obj);
		dao.fechar();
		return cod;
	}

}
