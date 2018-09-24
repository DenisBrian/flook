package br.com.flook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.flook.beans.TipoUsuario;
import br.com.flook.conexao.Conexao;

public class TipoUsuarioDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public TipoUsuarioDAO() throws Exception{
		con = Conexao.conectar();
	}
	
	public int gravar(TipoUsuario obj) throws Exception{
		String _sql = "INSERT INTO T_FLO_TIPO_USUARIO (DS_TIPO_USUARIO) VALUES (?)";
		
		ps = con.prepareStatement(_sql, new String[]{"CD_TIPO_USUARIO"});
		ps.setString(1, obj.getTipo());
		
		int affectedRows = ps.executeUpdate();
		int cod = 0;
		
		if(affectedRows > 0) {
			rs = ps.getGeneratedKeys();
			
			if(rs.next())
				cod = rs.getInt(1);			
		}
		
		return cod;
	}
	
	public TipoUsuario obter(int cod) throws Exception{
		String _sql = "SELECT CD_TIPO_USUARIO, DS_TIPO_USUARIO FROM T_FLO_TIPO_USUARIO WHERE CD_TIPO_USUARIO = ?";
		
		ps = con.prepareStatement(_sql);
		ps.setInt(1, cod);
		
		rs = ps.executeQuery();
		
		TipoUsuario obj = new TipoUsuario();
		
		if(rs.next()) {
			obj.setCodigo(rs.getInt("CD_TIPO_USUARIO"));
			obj.setTipo(rs.getString("DS_TIPO_USUARIO"));
		}
		
		return obj;
	}

	public void fechar() throws Exception{
		con.close();
	}
}
