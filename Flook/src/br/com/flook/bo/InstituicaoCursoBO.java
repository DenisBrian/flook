package br.com.flook.bo;

import java.util.List;

import br.com.flook.beans.InstituicaoCurso;
import br.com.flook.dao.InstituicaoCursoDAO;

public class InstituicaoCursoBO {
	
	public static List<InstituicaoCurso> obterPorNomeDeCurso(String nome) throws Exception{
		
		if(nome.length() == 0)
			return null;
		
		nome = nome.toUpperCase().trim();
		
		InstituicaoCursoDAO dao = new InstituicaoCursoDAO();
		List<InstituicaoCurso> ics = dao.obter(nome);
		dao.fechar();
		return ics;
	}
}
