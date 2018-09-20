package br.com.flook.beans;

public class Vencedor {
	
	private Premiacao premiacao;
	private Usuario usuario;
	
	public Vencedor() {
		super();
	}

	public Vencedor(Premiacao premiacao, Usuario usuario) {
		super();
		setPremiacao(premiacao);
		setUsuario(usuario);
	}

	public Premiacao getPremiacao() {
		return premiacao;
	}
	public void setPremiacao(Premiacao premiacao) {
		this.premiacao = premiacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setAll(Premiacao premiacao, Usuario usuario) {
		setPremiacao(premiacao);
		setUsuario(usuario);
	}
	
	public String getAll() {
		return "Premiação: " + getPremiacao().getAll()  + "\n"+
				"Usuário: " + getUsuario().getAll();
	}
}

