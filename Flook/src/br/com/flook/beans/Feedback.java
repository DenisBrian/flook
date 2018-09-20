package br.com.flook.beans;

public class Feedback {
	private int codigo;
	private String descricao;
	private int nota;
	private int like;
	private int deslike;
	private Usuario usuario;
	private Instituicao instituicao;
	private Curso curso;
	
	public Feedback() {
		super();
	}

	public Feedback(int codigo, String descricao, int nota, int like, int deslike, Usuario usuario,
			Instituicao instituicao, Curso curso) {
		super();
		setCodigo(codigo);
		setDescricao(descricao);
		setNota(nota);
		setLike(like);
		setDeslike(deslike);
		setUsuario(usuario);
		setInstituicao(instituicao);
		setCurso(curso);
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
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getDeslike() {
		return deslike;
	}
	public void setDeslike(int deslike) {
		this.deslike = deslike;
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
	
	public void setAll(int codigo, String descricao, int nota, int like, int deslike, Usuario usuario,
			Instituicao instituicao, Curso curso) {
		
		setCodigo(codigo);
		setDescricao(descricao);
		setNota(nota);
		setLike(like);
		setDeslike(deslike);
		setUsuario(usuario);
		setInstituicao(instituicao);
		setCurso(curso);
	}
	
	public String getAll() {
		return "Codigo: " + getCodigo() + "\n"+
				"Coment�rio: " + getDescricao() + "\n"+
				"Nota: " + getNota() + "\n"+
				"N�mero de Likes: " + getLike() + "\n"+
				"N�mero de Deslikes: " + getDeslike() + "\n"+
				"Usu�rio: " + getUsuario().getAll() + "\n"+
				"Institui��o: " + getInstituicao().getAll() + "\n"+
				"Curso: " + getCurso().getAll();
	}
	
}
