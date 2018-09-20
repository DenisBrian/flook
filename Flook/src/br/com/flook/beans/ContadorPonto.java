package br.com.flook.beans;
import java.util.Calendar;

public class ContadorPonto {
	private int codigo;
	private EsquemaPonto esquemaPonto;
	private Premiacao premiacao;
	private Usuario usuario;
	private Calendar dataContagem;
	private boolean pontoAdicionado;
	
	
	public ContadorPonto() {
		super();
	}
	
	public ContadorPonto(int codigo, EsquemaPonto esquemaPonto, Premiacao premiacao, Usuario usuario,
			Calendar dataContagem, boolean pontoAdicionado) {
		super();
		setCodigo(codigo);
		setEsquemaPonto(esquemaPonto);
		setPremiacao(premiacao);
		setUsuario(usuario);
		setDataContagem(dataContagem);
		setPontoAdicionado(pontoAdicionado);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public EsquemaPonto getEsquemaPonto() {
		return esquemaPonto;
	}
	public void setEsquemaPonto(EsquemaPonto esquemaPonto) {
		this.esquemaPonto = esquemaPonto;
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
	public Calendar getDataContagem() {
		return dataContagem;
	}
	public void setDataContagem(Calendar dataContagem) {
		this.dataContagem = dataContagem;
	}
	public boolean getPontoAdicionado() {
		return pontoAdicionado;
	}
	public void setPontoAdicionado(boolean pontoAdicionado) {
		this.pontoAdicionado = pontoAdicionado;
	}
	
	public void setAll(int codigo, EsquemaPonto esquemaPonto, Premiacao premiacao, Usuario usuario,
			Calendar dataContagem, boolean pontoAdicionado) {
		setCodigo(codigo);
		setEsquemaPonto(esquemaPonto);
		setPremiacao(premiacao);
		setUsuario(usuario);
		setDataContagem(dataContagem);
		setPontoAdicionado(pontoAdicionado);
	}
	
	public String getAll() {
		return "Código: " + getCodigo() + "\n"+
				"Esquema dos pontos: " + getEsquemaPonto().getAll() + "\n"+
				"Premiação: " +  getPremiacao().getAll() + "\n"+
				"Usuário: " + getUsuario().getAll() + "\n"+
				"Data contagem: " + getDataContagem() + "\n"+
				"Pontos adicionados: " + getPontoAdicionado();
	}
}
