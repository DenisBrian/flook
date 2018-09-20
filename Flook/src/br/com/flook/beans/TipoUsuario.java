package br.com.flook.beans;

public class TipoUsuario {
	private int codigo;
	private String tipo;
		
	public TipoUsuario() {
		super();
	}
	public TipoUsuario(int codigo, String tipo) {
		super();
		setCodigo(codigo);
		setTipo(tipo);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setAll(int codigo, String tipo) {
		
		setCodigo(codigo);
		setTipo(tipo);
	}
	
	public String getAll() {
		return "Codigo: " + getCodigo() + "\n"+
				"Tipo de usuário: " + getTipo();
	}

}
