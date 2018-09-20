package br.com.flook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.flook.beans.Curso;
import br.com.flook.beans.Instituicao;
import br.com.flook.beans.InstituicaoCurso;
import br.com.flook.conexao.Conexao;

public class InstituicaoCursoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public InstituicaoCursoDAO() throws Exception{
		con = Conexao.conectar();
	}
	
	public List<InstituicaoCurso> obter(String nome) throws Exception{
		String _sql = "SELECT \r\n" + 
				"    T3.IMG_INSTITUICAO,\r\n" + 
				"    T3.DS_INSTITUICAO,\r\n" + 
				"    T3.CD_INSTITUICAO,\r\n" + 
				"    T2.CD_CURSO,    \r\n" + 
				"    T1.NR_NOTA_MEC,\r\n" + 
				"    T1.TP_CURSO,\r\n" + 
				"    T1.DS_TIPO_CURSO\r\n" + 
				"FROM T_FLO_INSTITUICAO_CURSO T1\r\n" + 
				"INNER JOIN T_FLO_CURSO T2 ON T1.CD_CURSO = T2.CD_CURSO\r\n" + 
				"INNER JOIN T_FLO_INSTITUICAO T3 ON T1.CD_INSTITUICAO = T3.CD_INSTITUICAO\r\n" + 
				"WHERE T2.NM_CURSO LIKE ?";
			    
		ps = con.prepareStatement(_sql);
		ps.setString(1, "%" + nome + "%");
		rs = ps.executeQuery();
		
		List<InstituicaoCurso> ics = new ArrayList<InstituicaoCurso>();
		
		while(rs.next()) {
			InstituicaoCurso ic = new InstituicaoCurso();
			
			Instituicao ins = new Instituicao();
			ins.setLogo(rs.getString("IMG_INSTITUICAO"));
			ins.setDescricao(rs.getString("DS_INSTITUICAO"));
			ins.setCodigo(rs.getInt("CD_INSTITUICAO"));
			
			Curso curso = new Curso();
			curso.setCodigo(rs.getInt("CD_CURSO"));
			
			ic.setInstituicao(ins);
			ic.setCurso(curso);
			
			ic.setMec(rs.getFloat("NR_NOTA_MEC"));
			ic.setDuracao(rs.getFloat("TP_CURSO"));
			ic.setTipoCurso(rs.getString("DS_TIPO_CURSO"));
			ics.add(ic);
		}	
		return ics;
	}

	public void fechar() throws Exception {
		con.close();
	}
}
