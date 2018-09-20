package br.com.flook.beans;

public class EsquemaPonto {
	private int codigo;
	private String descricao;
	private int quantidadePonto;
	
	public EsquemaPonto() {
		super();
	}

	public EsquemaPonto(int codigo, String descricao, int quantidadePonto) {
		super();
		setCodigo(codigo);
		setDescricao(descricao);
		setQuantidadePonto(quantidadePonto);
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
	public int getQuantidadePonto() {
		return quantidadePonto;
	}
	public void setQuantidadePonto(int quantidadePonto) {
		this.quantidadePonto = quantidadePonto;
	}
	
	public void setAll(int codigo, String descricao, int quantidadePonto) {
		setCodigo(codigo);
		setDescricao(descricao);
		setQuantidadePonto(quantidadePonto);
	}
	
	public String getAll() {
		return "Codigo: " + getCodigo()  + "\n"+
				"Descricao: " + getDescricao() + "\n"+
				"Quantidade de pontos: " + getQuantidadePonto();
	}
}
