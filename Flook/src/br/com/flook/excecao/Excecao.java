package br.com.flook.excecao;

public class Excecao extends Exception{
	
	public static String tratarExcecao(Exception e) {
		if(e.getClass().getName().equals("java.lang.NumberFormatException")){
			return "Número inválido!!!";
		}else if(e.getClass().getName().equals("java.sql.SQLException")) {
			return "Erro ao conectar no banco";
		}else {
		return 	"Ocorreu uma falha!";
		}
	}
	
}
