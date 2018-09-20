package br.com.flook.beans;

public class Topico {
	private int codigo;
	private Usuario usuario;
	private Curso curso;
	private String titulo;
	private String duvida;
	private boolean solucionado;
	
	public Topico() {
		super();
	}
	
	public Topico(int codigo, Usuario usuario, Curso curso, String titulo, String duvida, boolean solucionado) {
		super();
		setCodigo(codigo);
		setUsuario(usuario);
		setCurso(curso);
		setTitulo(titulo);
		setDuvida(duvida);
		setSolucionado(solucionado);
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDuvida() {
		return duvida;
	}
	public void setDuvida(String duvida) {
		this.duvida = duvida;
	}
	public boolean getSolucionado() {
		return solucionado;
	}
	public void setSolucionado(boolean solucionado) {
		this.solucionado = solucionado;
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setAll(int codigo,Usuario usuario, Curso curso, String titulo, String duvida, boolean solucionado) {
		setCodigo(codigo);
		setUsuario(usuario);
		setCurso(curso);
		setTitulo(titulo);
		setDuvida(duvida);
		setSolucionado(solucionado);
	}
	
	public String getAll() {
		return "Codigo: " + getCodigo() + "\n"+
				"Usuário: " + getUsuario().getAll() + "\n"+
				"Curso: " + getCurso().getAll() + "\n"+
				"Título: " + getTitulo()  + "\n"+
				"Pergunta: " + getDuvida() + "\n"+
				"Solucionado: " + getSolucionado();
	}

}
