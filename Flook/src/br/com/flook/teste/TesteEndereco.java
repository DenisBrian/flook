package br.com.flook.teste;


import br.com.flook.beans.Endereco;
import br.com.flook.bo.EnderecoBO;
import br.com.flook.excecao.Excecao;

public class TesteEndereco {

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
		Endereco obj = new Endereco();
		obj.setBairro("CID PATRIARCA");
		obj.setCep("03555000");
		obj.setCidade("SAO PAULO");
		obj.setComplemento("CASA");
		obj.setEstado("SP");
		obj.setLogradouro("RUA MAZAGÃO");
		obj.setNumero("430");
		
		int codigo = EnderecoBO.novoEndereco(obj);
		
		if (codigo > 0)
			System.out.println("O endereco foi cadastrado com sucesso, o c�digo gerado foi: " + codigo);
		else
			System.out.println("O endereco n�o foi cadastrado");
		
	}
	
	private static void obterPorCodigo() throws Exception {
		Endereco obj = EnderecoBO.obterEndereco(22);
		System.out.println(obj.getAll());
	}

	private static void alterar() throws Exception{
		Endereco obj = new Endereco();
		obj.setCodigo(22);
		
		obj.setBairro("CID PATRIARCA");
		obj.setCep("03555000");
		obj.setCidade("SAO PAULO");
		obj.setComplemento("CASA");
		obj.setEstado("SP");
		obj.setLogradouro("LOGRADOURO ALTERADO");
		obj.setNumero("430");
		
		Boolean result = EnderecoBO.alterarEndereco(obj);
		
		if (result)
			System.out.println("O endereco foi alterado com sucesso");
		else
			System.out.println("O endereco n�o foi alterado");
	}
	
	private static void deletar() throws Exception{
		Boolean result = EnderecoBO.deletarEndereco(22);
		
		if (result)
			System.out.println("O endereco foi deletado com sucesso");
		else
			System.out.println("O endereco n�o foi deletado");
	}

}
