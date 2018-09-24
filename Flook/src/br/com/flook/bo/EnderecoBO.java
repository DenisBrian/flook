package br.com.flook.bo;

import br.com.flook.beans.Endereco;
import br.com.flook.dao.EnderecoDAO;

public class EnderecoBO {
	
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
