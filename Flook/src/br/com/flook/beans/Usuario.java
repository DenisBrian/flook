package br.com.flook.beans;

import java.util.Calendar;

public class Usuario {
	private int codigo;
	private TipoUsuario tipoUsuario;
	private String email;
	private String senha;
	private Calendar dataNascimento;
	private int pontoAcumulado;
	private String imagem;

	public Usuario() {
		super();
	}
	public Usuario(int codigo, TipoUsuario tipoUsuario, String email, String senha, Calendar dataNascimento,
			int pontoAcumulado, String imagem) {
		super();
		setCodigo(codigo);
		setTipoUsuario(tipoUsuario);
		setEmail(email);
		setSenha(senha);
		setDataNascimento(dataNascimento);
		setPontoAcumulado(pontoAcumulado);
		setImagem(imagem);
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getPontoAcumulado() {
		return pontoAcumulado;
	}
	public void setPontoAcumulado(int pontoAcumulado) {
		this.pontoAcumulado = pontoAcumulado;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public void setAll(int codigo, TipoUsuario tipoUsuario, String email, String senha, Calendar dataNascimento,
			int pontoAcumulado, String imagem) {
		setCodigo(codigo);
		setTipoUsuario(tipoUsuario);
		setEmail(email);
		setSenha(senha);
		setDataNascimento(dataNascimento);
		setPontoAcumulado(pontoAcumulado);
		setImagem(imagem);
	}
	
	public String getAll() {
		return "Codigo: " + getCodigo()  + "\n" +
				"Tipo de Usuário: " + getTipoUsuario().getAll()  + "\n"+
	           "Email: " + getEmail() + "\n" +
			   "Senha: " + getSenha() + "\n" +
	           "Data Nascimento: " + getDataNascimento() + "\n" +
	           "Imagem: " + getImagem() + "\n" +
	           "Pontos acumulados: " + getPontoAcumulado() ;
	}
}
