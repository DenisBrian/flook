package br.com.flook.beans;

public class Catalogo {
	private int codigo;
	private String descricao;
	
	public Catalogo(int codigo, String descricao) {
		super();
		setCodigo(codigo);
		setDescricao(descricao);
	}
		
	public Catalogo() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {		
		this.descricao = descricao;
	}
	
	public void setAll(int codigo, String descricao) {
		setCodigo(codigo);
		setDescricao(descricao);
	}
	
	public String getAll() {
		return "Codigo: " + getCodigo() + "\n"+
				"Descrição: " + getDescricao();
	}
		
	
	
}
