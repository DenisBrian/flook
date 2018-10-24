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
		TipoUsuario obj = new TipoUsuario();
		obj.setTipo("TESTE TIPO");
		
		int codigo = TipoUsuarioBO.novoTipoUsuario(obj);
		
		if (codigo > 0)
			System.out.println("O tipo de usu�rio foi cadastrado com sucesso, o c�digo gerado foi: " + codigo);
		else
			System.out.println("O tipo de usu�rio n�o foi cadastrado");
		
	}
	
	private static void obterPorCodigo() throws Exception {
		TipoUsuario obj = TipoUsuarioBO.obterPorCodigo(21);
		System.out.println(obj.getAll());
	}

	private static void alterar() throws Exception{
		TipoUsuario obj = new TipoUsuario();
		obj.setCodigo(21);
		obj.setTipo("TIPO ALTERADO");
		
		Boolean result = TipoUsuarioBO.alterarTipoUsuario(obj);
		
		if (result)
			System.out.println("O tipo de usu�rio foi alterado com sucesso");
		else
			System.out.println("O tipo de usu�rio n�o foi alterado");
	}
	
	private static void deletar() throws Exception{
		Boolean result = TipoUsuarioBO.deletarTipoUsuario(21);
		
		if (result)
			System.out.println("O tipo de usu�rio foi deletado com sucesso");
		else
			System.out.println("O tipo de usu�rio n�o foi deletado");
	}
}
