package br.com.flook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.flook.beans.Certificado;
import br.com.flook.beans.Curso;
import br.com.flook.beans.Instituicao;
import br.com.flook.conexao.Conexao;

public class CertificadoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public CertificadoDAO() throws Exception {
		con = Conexao.conectar();
	}

	public boolean gravar(Certificado obj) throws Exception {
		String _sql = "INSERT INTO T_FLO_CERTIFICADO (CD_USUARIO,CD_INSTITUICAO,CD_CURSO,IMG_CERTIFICADO,DT_CONCLUSAO) VALUES (?,?,?,?,?);";

		ps = con.prepareStatement(_sql);
		ps.setInt(1, obj.getUsuario().getCodigo());
		ps.setInt(2, obj.getInstituicao().getCodigo());
		ps.setInt(3, obj.getCurso().getCodigo());
		ps.setString(4, obj.getCertificado());
		ps.setDate(5, new java.sql.Date(obj.getData().getTimeInMillis()));
	 
		return ps.execute();
	}

	public List<Certificado> obterPorUsuario(int cod) throws Exception {
		String _sql = "SELECT\r\n" + 
				"    T1.DT_CONCLUSAO,\r\n" + 
				"    T1.IMG_CERTIFICADO,\r\n" + 
				"    T3.NM_CURSO,\r\n" + 
				"    T4.IMG_INSTITUICAO,\r\n" + 
				"    T4.NM_INSTITUICAO\r\n" + 
				"FROM T_FLO_CERTIFICADO T1\r\n" + 
				"INNER JOIN T_FLO_USUARIO T2 ON T1.CD_USUARIO = T2.CD_USUARIO\r\n" + 
				"INNER JOIN T_FLO_CURSO T3 ON T1.CD_CURSO = T3.CD_CURSO\r\n" + 
				"INNER JOIN T_FLO_INSTITUICAO T4 ON T1.CD_INSTITUICAO = T4.CD_INSTITUICAO\r\n" + 
				"WHERE T1.CD_USUARIO = ?" ;

		ps = con.prepareStatement(_sql);
		ps.setInt(1, cod);
		rs = ps.executeQuery();	
		
		List<Certificado> objs = new ArrayList<Certificado>();
		
		while(rs.next()) {
			Certificado obj = new Certificado();
			
			Calendar dtConclusao = new GregorianCalendar();
			dtConclusao.setTime(rs.getDate("DT_CONCLUSAO"));		
			obj.setData(dtConclusao);
			
			obj.setCertificado(rs.getString("IMG_CERTIFICADO"));
			
			Curso curso = new Curso();
			curso.setNome(rs.getString("NM_CURSO"));
			
			obj.setCurso(curso);
			
			Instituicao ins = new Instituicao();
			ins.setLogo(rs.getString("IMG_INSTITUICAO"));
			ins.setNome(rs.getString("NM_INSTITUICAO"));
			
			obj.setInstituicao(ins);
			
			objs.add(obj);			
		}		

		return objs;
	}
	
	public void fechar() throws Exception{
		con.close();
	}
}
