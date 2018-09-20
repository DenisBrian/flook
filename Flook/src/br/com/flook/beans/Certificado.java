package br.com.flook.beans;

import java.util.Calendar;

public class Certificado {
	private Usuario usuario;
	private Instituicao instituicao;
	private Curso curso;
	private String certificado;
	private Calendar data;

	public Certificado() {
		super();
	}

	public Certificado(Usuario usuario, Instituicao instituicao, Curso curso, String certificado, Calendar data) {
		super();
		setUsuario(usuario);
		setInstituicao(instituicao);
		setCurso(curso);
		setCertificado(certificado);
		setData(data);
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Instituicao getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public void setAll(Usuario usuario, Instituicao instituicao, Curso curso, String certificado, Calendar data) {
		setUsuario(usuario);
		setInstituicao(instituicao);
		setCurso(curso);
		setCertificado(certificado);
		setData(data);
	}

	public String getAll() {
		return "Usuario: " + usuario.getAll()  + "\n"+
				"Instituição: " + instituicao.getAll()  + "\n"+
				"Curso: " + getCurso().getAll() + "\n"+
				"Certificado: " + certificado + "\n"+
				"Data do certificado: " + getData();
	}

}
