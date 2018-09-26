package br.com.flook.beans;

public class InstituicaoCurso {
	private Curso curso;
	private Instituicao instituicao;
	private float mec;
	private float duracao;
	private String tipoCurso;
	private boolean bolsa;
	private float valor;
	private int like;
	private int dislike;
	private String video;
	private String descricao;
	private String planoCarreira;

	
	
	public InstituicaoCurso() {
		super();
	}

	public InstituicaoCurso(Curso curso, Instituicao instituicao, float mec, float duracao, String tipoCurso,
			boolean bolsa, float valor, int like, int dislike, String video, String descricao, String planoCarreira) {
		super();
		setCurso(curso);
		setInstituicao(instituicao);
		setMec(mec);
		setDuracao(duracao);
		setTipoCurso(tipoCurso);
		setBolsa(bolsa);
		setValor(valor);
		setLike(like);
		setDislike(dislike);
		setVideo(video);
		setDescricao(descricao);
		setPlanoCarreira(planoCarreira);
	}
		
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public boolean getBolsa() {
		return bolsa;
	}
	public void setBolsa(boolean bolsa) {
		this.bolsa = bolsa;
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
	public float getMec() {
		return mec;
	}
	public void setMec(float mec) {
		this.mec = mec;
	}
	
	public float getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}
	
	public String getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}
	
	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPlanoCarreira() {
		return planoCarreira;
	}

	public void setPlanoCarreira(String planoCarreira) {
		this.planoCarreira = planoCarreira;
	}
	
	
	public String getAll() {
		return "Valor: " + getValor()  + "\n"+
				"Possui bolsa: " + getBolsa() + "\n"+
				"Institui��o: " + getInstituicao().getAll() + "\n"+
				"Curso: " + getCurso().getAll() + "\n"+
				"Duracao: " + getDuracao() + "\n"+
				"Tipo de Curso: " + getTipoCurso() + "\n"+
				"Nota MEC: " + getMec();
	}

}
