package br.com.flook.beans;

public class Endereco {
	private int codigo;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
		
	public Endereco() {
		super();
	}
	public Endereco(int codigo, String logradouro, String numero,String complemento, 
			String bairro, String cidade, String estado, String cep) {
		super();
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getAll() {
		return "Codigo: " + getCodigo() + "\n"+
				"Logradouro: " + getLogradouro()  + "\n"+
				"Complemento: " + getComplemento() + "\n"+
				"Bairro: " + getBairro() + "\n"+
				"Cidade: " + getCidade() + "\n"+
				"Estado: " + getEstado() + "\n"+
				"Cep: " + getCep() ;
	}
	
}
