package br.com.flook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.flook.beans.Certificado;
import br.com.flook.conexao.Conexao;

public class CertificadoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public CertificadoDAO() throws Exception{
		con = Conexao.conectar();
	}
	
	public boolean gravar(Certificado obj) throws Exception{	
		String _sql = "INSERT INTO T_FLO_CERTIFICADO (CD_USUARIO,CD_INSTITUICAO,CD_CURSO,IMG_CERTIFICADO,DT_CONCLUSAO) VALUES (?,?,?,?,?);";
		
		ps = con.prepareStatement(_sql);
		ps.setInt(1, obj.getUsuario().getCodigo());
		ps.setInt(2, obj.getInstituicao().getCodigo());
		ps.setInt(3, obj.getCurso().getCodigo());
		ps.setString(4, obj.getCertificado());
		ps.setDate(5, new java.sql.Date(obj.getData().getTimeInMillis()));
		
		boolean result = ps.execute(_sql);
		return result;
	}	
	
}
