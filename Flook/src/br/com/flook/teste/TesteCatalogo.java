package br.com.flook.teste;

import br.com.flook.beans.Catalogo;
import br.com.flook.bo.CatalogoBO;
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
			System.out.println("O catalogo foi cadastrado com sucesso, o código gerado foi: " + codigo);
		else
			System.out.println("O catalogo não foi cadastrado");
	}
	private static void obterPorCodigo() throws Exception{
		Catalogo obj = CatalogoBO.obterPorCodigo(1);
		System.out.println(obj.getAll());
	}	
}
