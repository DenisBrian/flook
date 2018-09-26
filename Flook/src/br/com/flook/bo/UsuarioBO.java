package br.com.flook.bo;

import java.util.regex.Pattern;

import br.com.flook.beans.Usuario;
import br.com.flook.dao.UsuarioDAO;

/**
 * Responsavel por todas as regras de negócios e padronizações do Usuario 1°) A
 * quantidades de caracteres do email não pode ser igual a 0 e não pode ser
 * maior que 50 2°) O email ter que ser valido 3°) A quantidades de caracteres
 * da senha não pode ser igual a 0 e não pode ser maior que 20 4°) A quantidades
 * de caracteres da imagem não pode ser maior que 255 5°) A quantidades de
 * caracteres do codigo não pode ser igual a 0
 * 
 * @author FELIPE HONÓRIO CAMARGO
 * @author DENIS BRIAN CANOLA
 * @author RAFAEL MACHADO CARDOSO
 * @author MATHEUS APRIGIO DA SILVA
 * @author JEFFREY RODRIGUES INNOCENCIO
 * @version 1.0
 * @since 1.0
 * @see br.com.flook.beans.Usuario
 * @see br.com.flook.dao.UsuarioDAO
 */
public class UsuarioBO {

	/**
	 * Este método ira validar e repassar o objeto Usuario para a classe UsuarioDAO
	 * 
	 * @param obj
	 *            Este parâmetro representa um objeto Usuario do Beans.
	 * @return O método retorna um codigo
	 * @throws Exception
	 *             Tratado a exceção checked SQLException
	 * @author DENIS BRIAN CANOLA
	 */
	public static int novoUsuario(Usuario obj) throws Exception {
		
		if(obj.getNome().length() > 100)
			return 0;
		
		if (obj.getEmail().length() == 0 || obj.getEmail().length() > 50)
			return 0;

		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if (!p.matcher(obj.getEmail()).find())
			return 0;

		if (obj.getSenha().length() == 0 || obj.getSenha().length() > 20)
			return 0;

		if (obj.getImagem().length() > 255)
			return 0;

		if ((TipoUsuarioBO.obterPorCodigo(obj.getTipoUsuario().getCodigo())).getCodigo() == 0)
			return 0;

		UsuarioDAO dao = new UsuarioDAO();
		int cod = dao.gravar(obj);
		dao.fechar();
		return cod;
	}

	/**
	 * Este método ira buscar o Usuario pelo seu codigo
	 * 
	 * @param cod
	 *            Este parâmetro representa o codigo do Usuario
	 * @return O método retorna um objeto Usuario se encontrado
	 * @throws Exception
	 *             Tratado a exceção checked SQLException
	 * @author DENIS BRIAN CANOLA
	 */
	public static Usuario obterPorCodigo(int cod) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario obj = dao.obter(cod);
		dao.fechar();
		return obj;
	}

	public static Usuario obterPorLogin(String email, String senha) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario obj = dao.obter(email, senha);
		dao.fechar();
		return obj;
	}
}
