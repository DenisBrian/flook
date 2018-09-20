package br.com.flook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.flook.beans.Catalogo;
import br.com.flook.conexao.Conexao;

public class CatalogoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public CatalogoDAO() throws Exception{
		con = Conexao.conectar();
	}
	
	public int gravar(Catalogo obj) throws Exception{	
		String _sql = "INSERT INTO T_FLO_CATALOGO (DS_CATALOGO) VALUES (?);"
				    + "SELECT SQ_T_FLO_CATALOGO.CURRVAL AS CD_CATALOGO FROM DUAL;";
		
		ps = con.prepareStatement(_sql);
		ps.setString(1, obj.getDescricao());		
		rs = ps.executeQuery(_sql);
		
		int cod = 0;
		
		if(rs.next()) {
			rs.getInt("CD_CATALOGO");
		}
		
		return cod;
	}	
	public Catalogo obter(int cod) throws Exception{
		String _sql = "SELECT CD_CATALOGO, DS_CATALOGO FROM T_FLO_CATALOGO WHERE CD_CATALOGO = ?";
		
		ps = con.prepareStatement(_sql);
		ps.setInt(1, cod);	
		rs = ps.executeQuery();
		
		Catalogo obj = new Catalogo();

		if(rs.next()) {
			obj.setCodigo(rs.getInt("CD_CATALOGO"));
			obj.setDescricao(rs.getString("DS_CATALOGO"));
		}
		
		return obj;
	}
	
}
