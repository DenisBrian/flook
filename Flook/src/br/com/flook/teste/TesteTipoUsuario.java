package br.com.flook.teste;

import br.com.flook.beans.TipoUsuario;
import br.com.flook.bo.TipoUsuarioBO;
import br.com.flook.excecao.Excecao;

public class TesteTipoUsuario {

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
		TipoUsuario obj = new TipoUsuario();
		obj.setTipo("TESTE TIPO");
		
		int codigo = TipoUsuarioBO.novoTipoUsuario(obj);
		
		if (codigo > 0)
			System.out.println("O tipo de usuário foi cadastrado com sucesso, o código gerado foi: " + codigo);
		else
			System.out.println("O tipo de usuário não foi cadastrado");
		
	}
	
	private static void obterPorCodigo() throws Exception {
		TipoUsuario obj = TipoUsuarioBO.obterPorCodigo(1);
		System.out.println(obj.getAll());
	}

}
