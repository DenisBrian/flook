package br.com.flook.beans;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Usuario {
	private int codigo;
	private TipoUsuario tipoUsuario;
	private String email;
	private String senha;
	private Calendar dataNascimento;
	private int pontoAcumulado;
	private String imagem;
	private String nome;

	public Usuario() {
		super();
	}
	public Usuario(int codigo, TipoUsuario tipoUsuario, String email, String senha, Calendar dataNascimento,
			int pontoAcumulado, String imagem,String nome) {
		super();
		setCodigo(codigo);
		setTipoUsuario(tipoUsuario);
		setEmail(email);
		setSenha(senha);
		setDataNascimento(dataNascimento);
		setPontoAcumulado(pontoAcumulado);
		setImagem(imagem);
		setNome(nome);
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
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setAll(int codigo, TipoUsuario tipoUsuario, String email, String senha, Calendar dataNascimento,
			int pontoAcumulado, String imagem, String nome) {
		setCodigo(codigo);
		setTipoUsuario(tipoUsuario);
		setEmail(email);
		setSenha(senha);
		setDataNascimento(dataNascimento);
		setPontoAcumulado(pontoAcumulado);
		setImagem(imagem);
		setNome(nome);
	}
	
	public String getAll() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		String data = "";
		
		if(getDataNascimento() != null)
			data = sdf.format(getDataNascimento().getTime());		
		
		String tipo = "";
		if(getTipoUsuario() != null)
			tipo = getTipoUsuario().getAll();
			
		return "Codigo: " + getCodigo()  + "\n" +
				"Tipo de Usu�rio: " + tipo  + "\n"+
	           "Email: " + getEmail() + "\n" +
			   "Senha: " + getSenha() + "\n" +
	           "Data Nascimento: " + data + "\n" +
	           "Imagem: " + getImagem() + "\n" +
	           "Pontos acumulados: " + getPontoAcumulado() +
	           "Nome: " + getNome();
	}
}
