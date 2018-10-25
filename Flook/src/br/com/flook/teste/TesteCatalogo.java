package br.com.flook.teste;

import br.com.flook.beans.Catalogo;
import br.com.flook.beans.TipoUsuario;
import br.com.flook.bo.CatalogoBO;
import br.com.flook.bo.TipoUsuarioBO;
import br.com.flook.excecao.Excecao;

public class TesteCatalogo {

	public static void main(String[] args) {
		try {

			char tipo = 'O';

			switch (tipo) {
			case 'C':
				cadastrar();
				break;
			case 'O':
				obterPorCodigo();
				break;
			case 'A':
				alterar();
				break;
			case 'D':
				deletar();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		} finally {
			try {
				System.out.println("Processo finalizado");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(Excecao.tratarExcecao(e));
			}
		}
	}
	
	private static void cadastrar() throws Exception{
		Catalogo obj = new Catalogo();
		obj.setDescricao("TESTE CATALOGO");
		int codigo = CatalogoBO.novoCatalogo(obj);
		
		if (codigo > 0)
			System.out.println("O catalogo foi cadastrado com sucesso, o c�digo gerado foi: " + codigo);
		else
			System.out.println("O catalogo n�o foi cadastrado");
	}
	private static void obterPorCodigo() throws Exception{
		Catalogo obj = CatalogoBO.obterPorCodigo(21);
		System.out.println(obj.getAll());
	}
	
	private static void alterar() throws Exception{
		Catalogo obj = new Catalogo();
		obj.setCodigo(21);
		obj.setDescricao("DESCRICAO ALTERADA");
		
		Boolean result = CatalogoBO.alterarCatalogo(obj);
		
		if (result)
			System.out.println("O catalogo foi alterado com sucesso");
		else
			System.out.println("O catalogo n�o foi alterado");
	}
	
	private static void deletar() throws Exception{
		Boolean result = CatalogoBO.deletarCatalogo(21);
		
		if (result)
			System.out.println("O catalogo foi deletado com sucesso");
		else
			System.out.println("O catalogo n�o foi deletado");
	}
}
