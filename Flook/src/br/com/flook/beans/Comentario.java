package br.com.flook.beans;

public class Comentario {
	private int codigo;
	private Topico topico;
	private Usuario usuario;
	private boolean solucao;
	private String resposta;
	
	
	public Comentario() {
		super();
	}
	
	public Comentario(int codigo, Topico topico,Usuario usuario, boolean solucao, String resposta) {
		super();
		setCodigo(codigo);
		setUsuario(usuario);
		setTopico(topico);
		setSolucao(solucao);
		setResposta(resposta);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Topico getTopico() {
		return topico;
	}
	public void setTopico(Topico topico) {
		this.topico = topico;
	}
	public boolean getSolucao() {
		return solucao;
	}
	public void setSolucao(boolean solucao) {
		this.solucao = solucao;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setAll(int codigo, Topico topico,Usuario usuario, boolean solucao, String resposta) {
		setCodigo(codigo);
		setUsuario(usuario);
		setTopico(topico);
		setSolucao(solucao);
		setResposta(resposta);
	}
	
	public String getAll() {
		return "Codigo: " + getCodigo() + "\n"+
				"Topico: " + getTopico().getAll() + "\n"+
				"Usuário: " + getUsuario().getAll() + "\n"+
				"Solução: " + getSolucao() + "\n"+
				"Resposta: " +  getResposta();
	}
}
