package br.com.flook.teste;

import javax.swing.JOptionPane;
import br.com.flook.excecao.Excecao;
import br.com.flook.beans.Curso;
import br.com.flook.bo.CursoBO;

public class TesteCurso {

	public static void main(String[] args) {
		try {
			char tipo = JOptionPane.showInputDialog("Digite a letra correspondente a operação do Teste"
												    + " (C = Cadastrar | A = Alterar | S = Selecionar) ").charAt(0);
			if(tipo == 'C') {
				Cadastrar();
			}
			else if(tipo == 'A')
			{
				Atualizar();
			}
			else if(tipo == 'S') {
				Selecionar();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(Excecao.tratarExcecao(e));
			}
		}

	}
	
	private static void Cadastrar() throws Exception {
		Curso obj = new Curso();
		obj.setNome(JOptionPane.showInputDialog("Digite o nome do Curso: "));
		int codigo = CursoBO.novoCurso(obj);		
		System.out.println("O curso foi cadastrado com sucesso, o código gerado foi: " + codigo);
	}
	private static void Atualizar() {
		
	}
	private static void Selecionar() {
		
	}

}
