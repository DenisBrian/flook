package br.com.flook.bo;

import br.com.flook.beans.Endereco;
import br.com.flook.dao.EnderecoDAO;
/**
* Responável por todas as Regras de negócio e padronizações do Endereco
* 1°) A quantidades de caracteres do logradouro não pode ser maior que 50
* 2°) A quantidades de caracteres do numero não pode ser maior que 20
* 3°) A quantidades de caracteres do complemento não pode ser maior que 200
* 4°) A quantidades de caracteres do bairro não pode ser maior que 120
* 5°) A quantidades de caracteres da cidade não pode ser maior que 120
* 6°) A quantidades de caracteres do estado não pode ser maior que 2
* 7°) A quantidades de caracteres do cep não pode ser igual a 0 e não pode ser maior que 8
* @author DENIS BRIAN CANOLA
* @author FELIPE HONÓRIO CAMARGO
* @author RAFAEL MACHADO CARDOSO
* @author MATHEUS APRIGIO DA SILVA
* @author JEFFREY RODRIGUES INNOCENCIO
* @version 1.0
* @since 1.0
* @see br.com.flook.beans.Endereco
* @see br.com.flook.dao.EnderecoDAO
*/
public class EnderecoBO {
	
	/**
	 * Este método ira validar e repassar o objeto Endereco para a classe EnderecoDAO
	 * @param obj Este parâmetro representa um objeto Endereco do Beans.
	 * @return O método retorna um codigo 0
	 * @throws Exception Tratado a exceção checked SQLExceptio
	 * @author DENIS BRIAN CANOLA
	 */
	public static int novoEndereco(Endereco obj) throws Exception{
		
		if(obj.getLogradouro().length() > 50)
			return 0;
		
		if(obj.getNumero().length() > 20)
			return 0;
		
		if(obj.getComplemento().length() > 200)
			return 0;
		
		if(obj.getBairro().length() > 120)
			return 0;
		
		if(obj.getCidade().length() > 120)
			return 0;
		
		if(obj.getEstado().length() > 2)
			return 0;
		
		if(obj.getCep().length() == 0 || obj.getCep().length() > 8)
			return 0;
		
		EnderecoDAO dao = new EnderecoDAO();
		int codigo = dao.gravar(obj);
		dao.fechar();
		return codigo;
	}

}
