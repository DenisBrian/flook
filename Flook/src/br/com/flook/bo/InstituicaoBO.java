package br.com.flook.bo;

import br.com.flook.beans.Endereco;
import br.com.flook.beans.Instituicao;
import br.com.flook.dao.InstituicaoDAO;
/**
* Responável por todas as Regras de negócio e padronizações da Instituicao
* 1°) A quantidades de caracteres do nome não pode ser igual a 0 e não pode ser maior que 30
* 2°) A quantidades de caracteres do tipo não pode ser maior que 7
* 3°) A quantidades de caracteres da descricao não pode ser maior que 234
* 4°) A quantidades de caracteres do logo não pode ser maior que 255
* @author DENIS BRIAN CANOLA
* @author FELIPE HONÓRIO CAMARGO
* @author RAFAEL MACHADO CARDOSO
* @author MATHEUS APRIGIO DA SILVA
* @author JEFFREY RODRIGUES INNOCENCIO
* @version 1.0
* @since 1.0
* @see br.com.flook.beans.Instituicao
* @see br.com.flook.dao.InstituicaoDAO
*/
public class InstituicaoBO {
	/**
	 * Este método ira validar e repassar o objeto Instituicao para a classe InstituicaoDAO
	 * @param obj Este parâmetro representa um objeto Instituicao do Beans.
	 * @return O método retorna um codigo 0
	 * @throws Exception Tratado a exceção checked SQLExceptio
	 * @author DENIS BRIAN CANOLA
	 */
	public static int novaInstituicao(Instituicao obj) throws Exception {

		if(obj.getNome().length() == 0 || obj.getNome().length() > 30)
			return 0;
		
		if(obj.getTipo().length() > 7)
			return 0;
		
		if(obj.getDescricao().length() > 234)
			return 0;
		
		if(obj.getLogo().length() > 255)
			return 0;
		
		
		InstituicaoDAO dao = new InstituicaoDAO();
		int instituicao = dao.gravar(obj);

		if (instituicao > 0) {
			for (Endereco end : obj.getEndereco()) {
				int endereco = EnderecoBO.novoEndereco(end);

				if (endereco > 0)
					dao.gravar(instituicao, endereco);
			}
		}

		dao.fechar();
		return instituicao;
	}
	/**
	 * Este método ira validar e repassar o objeto Instituicao para a classe InstituicaoDAO
	 * @param obj Este parâmetro representa um objeto Instituicao do Beans.
	 * @return O método retorna um codigo 0
	 * @throws Exception Tratado a exceção checked SQLExceptio
	 * @author DENIS BRIAN CANOLA
	 */
	public static Instituicao obterPorCodigo(int cod) throws Exception {
		InstituicaoDAO dao = new InstituicaoDAO();
		Instituicao obj = dao.obter(cod);
		dao.fechar();
		return obj;
	}
}
