package br.com.flook.teste;

import java.util.GregorianCalendar;

import br.com.flook.beans.TipoUsuario;
import br.com.flook.beans.Usuario;
import br.com.flook.bo.UsuarioBO;
import br.com.flook.excecao.Excecao;

public class TesteUsuario {

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

	private static void cadastrar() throws Exception {
		Usuario obj = new Usuario();
		obj.setDataNascimento(new GregorianCalendar(2018, 8, 24));
		obj.setEmail("teste@teste.com.br");
		obj.setImagem("/Usuario/user.png");
		obj.setPontoAcumulado(0);
		obj.setSenha("123");
		obj.setTipoUsuario(new TipoUsuario(1, ""));
		int codigo = UsuarioBO.novoUsuario(obj);

		if (codigo > 0)
			System.out.println("O usuario foi cadastrado com sucesso, o código gerado foi: " + codigo);
		else
			System.out.println("O usuario não foi cadastrado");

	}

	private static void obterPorCodigo() throws Exception {
		Usuario obj = UsuarioBO.obterPorCodigo(2);
		System.out.println(obj.getAll());
	}

}
