package br.com.flook.bo;

import br.com.flook.beans.Catalogo;
import br.com.flook.dao.CatalogoDAO;

public class CatalogoBO {
	
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
	public static Catalogo obterPorCodigo(int cod) throws Exception{		
		CatalogoDAO dao = new CatalogoDAO();
		Catalogo obj = dao.obter(cod);
		dao.fechar();
		return obj;
	}

}
