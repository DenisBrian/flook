package br.com.flook.beans;
import java.util.List;

public class Instituicao {
	private int codigo;
	private String nome;
	private String tipo;
	private String logo;
	private List<Endereco> endereco;
	private String descricao;
	
	public Instituicao() {
		super();
	}

	public Instituicao(int codigo, String nome, String tipo,String logo, List<Endereco> endereco, String descricao) {
		super();
		setCodigo(codigo);
		setNome(nome);
		setTipo(tipo);
		setLogo(logo);
		setEndereco(endereco);
		setDescricao(descricao);
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {	
		this.tipo = tipo;
	}
	public List<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setAll(int codigo, String nome, String tipo,String logo, List<Endereco> endereco, String descricao) {
		
		setCodigo(codigo);
		setNome(nome);
		setTipo(tipo);
		setLogo(logo);
		setEndereco(endereco);
		setDescricao(descricao);
	}
	
	public String getAll() {
		
		String result = "Codigo: " + getCodigo() + "\n"+
				"Nome da instituição: " + getNome()  + "\n"+
				"Tipo da instituição: " + getTipo() + "\n"+
				"Descricao: " + getDescricao() + "\n"+
				"Logo: " + getLogo() + "\n";
		
		for(Endereco end : getEndereco()) {
			result = result + "Endereço: " + end.getAll() + "\n";
		}
		
		return result; 
		
	}
}
