package br.com.flook.bo;

import br.com.flook.beans.Endereco;
import br.com.flook.beans.Instituicao;
import br.com.flook.dao.InstituicaoDAO;

public class InstituicaoBO {

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
	public static Instituicao obterPorCodigo(int cod) throws Exception {
		InstituicaoDAO dao = new InstituicaoDAO();
		Instituicao obj = dao.obter(cod);
		dao.fechar();
		return obj;
	}
}
