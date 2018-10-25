package br.com.flook.teste;

import br.com.flook.excecao.Excecao;

import java.util.List;

import br.com.flook.beans.Catalogo;
import br.com.flook.beans.Curso;
import br.com.flook.bo.CursoBO;

public class TesteCurso {

	public static void main(String[] args) {
		try {

			char tipo = 'C';

			switch (tipo) {
			case 'C':
				cadastrar();
				break;
			case 'O':
				obterPorCodigo();
				break;
			case 'T':
				obterCursos();
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
		Curso obj = new Curso();
		obj.setNome("Curso Teste");
		obj.setCatalogo(new Catalogo(1, ""));
		int codigo = CursoBO.novoCurso(obj);

		if (codigo > 0)
			System.out.println("O curso foi cadastrado com sucesso, o c�digo gerado foi: " + codigo);
		else
			System.out.println("O curso n�o foi cadastrado");
	}

	private static void obterPorCodigo() throws Exception {
		Curso obj = CursoBO.obterCursoPorCodigo(1);
		System.out.println(obj.getAll());
	}

	private static void obterCursos() throws Exception {
		List<Curso> objs = CursoBO.obterCursosPorNome("ANALISE");
		for (Curso obj : objs) {
			System.out.println(obj.getAll());
		}

	}
	
	public static void alterar() throws Exception{
		Curso obj = new Curso();
		obj.setCodigo(9);
		obj.setNome("Nome Alterado");
		
		Boolean result = CursoBO.alterarCurso(obj);
		
		if(result)
			System.out.println("O curso foi alterado com sucesso");
		else 
			System.out.println("O curso não foi alterado");
	}
	
	private static void deletar() throws Exception{
		Boolean result = CursoBO.deletarCurso(9);
		
		if(result)
			System.out.println("O curso foi deletado com sucesso");
		else 
			System.out.println("O curso não foi deletado");
	}
	
}
