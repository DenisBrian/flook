package br.com.flook.beans;

public class InstituicaoCurso {
	private boolean bolsa;
	private Instituicao instituicao;
	private Curso curso;
	private float valor;
	private float duracao;
	private float mec;
	private String tipoCurso;
	
	public InstituicaoCurso() {
		super();
	}

	public InstituicaoCurso(float valor, boolean bolsa, Instituicao instituicao, Curso curso, float mec, float duracao,String tipoCurso) {
		super();
		setValor(valor);
		setBolsa(bolsa);
		setInstituicao(instituicao);
		setCurso(curso);
		setMec(mec);
		setDuracao(duracao);
		setTipoCurso(tipoCurso);
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
	
	public void setAll(float valor, boolean bolsa, Instituicao instituicao, Curso curso, float mec, float duracao, String tipoCurso) {
		setValor(valor);
		setBolsa(bolsa);
		setInstituicao(instituicao);
		setCurso(curso);
		setMec(mec);
		setDuracao(duracao);
		setTipoCurso(tipoCurso);
	}
	
	public String getAll() {
		return "Valor: " + getValor()  + "\n"+
				"Possui bolsa: " + getBolsa() + "\n"+
				"Instituição: " + getInstituicao().getAll() + "\n"+
				"Curso: " + getCurso().getAll() + "\n"+
				"Duracao: " + getDuracao() + "\n"+
				"Tipo de Curso: " + getTipoCurso() + "\n"+
				"Nota MEC: " + getMec();
	}

}
