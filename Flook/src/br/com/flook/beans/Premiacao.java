package br.com.flook.beans;
import java.util.Calendar;

public class Premiacao {
	private int codigo;
	private Calendar dataInicio;
	private Calendar dataFim;
	
	public Premiacao() {
		super();
	}

	public Premiacao(int codigo, Calendar dataInicio, Calendar dataFim) {
		super();
		setCodigo(codigo);
		setDataInicio(dataInicio);
		setDataFim(dataFim);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Calendar getDataFim() {
		return dataFim;
	}
	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	
	public void setAll(int codigo, Calendar dataInicio, Calendar dataFim) {

		setCodigo(codigo);
		setDataInicio(dataInicio);
		setDataFim(dataFim);
	}
	
	public String getAll() {
		return "Codigo: " + getCodigo() + "\n"+
				"Data Início: " + getDataInicio()  + "\n"+
				"Data Fim: " + getDataFim();
	}
	
}
