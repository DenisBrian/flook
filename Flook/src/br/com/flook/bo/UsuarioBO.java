package br.com.flook.bo;

import java.util.regex.Pattern;

import br.com.flook.beans.Usuario;
import br.com.flook.dao.UsuarioDAO;

public class UsuarioBO {
	
	public static int novoUsuario(Usuario obj) throws Exception {
		
		if(obj.getEmail().length() == 0 || obj.getEmail().length() > 50)
			return 0;
		
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if(!p.matcher(obj.getEmail()).find())
			return 0;		
		
		if(obj.getSenha().length() == 0 || obj.getSenha().length() > 20)
			return 0;
		
		if(obj.getImagem().length() > 255)
			return 0;
		
		if((TipoUsuarioBO.obterPorCodigo(obj.getTipoUsuario().getCodigo())).getCodigo() == 0)
			return 0;
		
		
		UsuarioDAO dao = new UsuarioDAO();
		int cod = dao.gravar(obj);
		dao.fechar();
		return cod;
	}
	
	public static Usuario obterPorCodigo(int cod) throws Exception{
		UsuarioDAO dao = new UsuarioDAO();
		Usuario obj = dao.obter(cod);
		dao.fechar();
		return obj;
	}
}
