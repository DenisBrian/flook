package br.com.flook.beans;

public class Curso {
	private int codigo;
	private Catalogo catalogo;
	private String nome;
	
	public Curso() {
		super();
	}

	public Curso(int codigo, Catalogo catalogo, String nome) {
		super();
		setCodigo(codigo);
		setCatalogo(catalogo);
		setNome(nome);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {	
		this.nome = nome;
	}
	public Catalogo getCatalogo() {
		return catalogo;
	}
	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}
	
	public void setAll(int codigo,Catalogo catalogo, String nome) {
		
		setCodigo(codigo);
		setCatalogo(catalogo);
		setNome(nome);

	}
	
	public String getAll() {
		return "Codigo: " + getCodigo()  + "\n"+
				"Nome do Curso: " + getNome() + "\n"+
				"Catalogo: " + getCatalogo().getAll();
	}
	
}


