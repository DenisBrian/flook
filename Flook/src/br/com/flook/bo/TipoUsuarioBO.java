package br.com.flook.bo;

import br.com.flook.beans.TipoUsuario;
import br.com.flook.dao.TipoUsuarioDAO;

public class TipoUsuarioBO {
	
	public static TipoUsuario obterPorCodigo(int cod) throws Exception{
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		TipoUsuario obj = dao.obter(cod);		
		dao.fechar();		
		return obj;
	}
	public static int novoTipoUsuario(TipoUsuario obj) throws Exception{		
		if(obj.getTipo().length() == 0 || obj.getTipo().length() > 120)
			return 0;	
		
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		int cod = dao.gravar(obj);
		dao.fechar();
		return cod;
	}

}
