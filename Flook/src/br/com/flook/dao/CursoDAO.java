package br.com.flook.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.flook.beans.Catalogo;
import br.com.flook.beans.Curso;
import br.com.flook.conexao.Conexao;

/**
 * Classe responsável por manipular a tabela T_FLO_CURSO
 * @author Denis Brian Canola
 * @see br.com.flook.beans.Curso
 * @see br.com.flook.bo.CursoBO
 */
public class CursoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * Construtor responsável por abrir a conexão
	 * @throws Exception Exceção checked SQLException
	 * @author Denis Brian Canola
	 */
	public CursoDAO() throws Exception{
		con = Conexao.conectar();
	}
	public int gravar(Curso obj) throws Exception{	
		String _sql = "INSERT INTO T_FLO_CURSO (CD_CATALOGO,NM_CURSO) VALUES (?,?);"
				    + "SELECT SQ_T_FLO_CURSO.CURRVAL AS CD_CURSO FROM DUAL";
		
		ps = con.prepareStatement(_sql);
		ps.setInt(1, obj.getCatalogo().getCodigo());
		ps.setString(2, obj.getNome());
		
		rs = ps.executeQuery(_sql);
		
		int cod = 0;
		
		if(rs.next()) {
			rs.getInt("CD_CURSO");
		}
		
		return cod;
	}	
	public Curso obter(int cod) throws Exception{
		String _sql = "SELECT T1.CD_CURSO, T1.NM_CURSO, T2.CD_CATALOGO, T2.DS_CATALOGO "
				    + "FROM T_FLO_CURSO T1 "
				    + "INNER JOIN T_FLO_CATALOGO T2 ON T1.CD_CURSO = T2.CD_CATALOGO "
				    + "WHERE COD_CURSO = ?";
		
		ps = con.prepareStatement(_sql);
		ps.setInt(1, cod);	
		rs = ps.executeQuery();
		
		Curso obj = new Curso();
		if(rs.next()) {
			obj.setCodigo(rs.getInt("CD_CURSO"));
			obj.setNome(rs.getString("NM_CURSO"));		
			obj.setCatalogo(new Catalogo(rs.getInt("CD_CATALOGO"), rs.getString("DS_CATALOGO")));	
		}
		
		return obj;
	}
	public List<Curso> obter(String nome) throws Exception{
		String _sql = "SELECT T1.CD_CURSO, T1.NM_CURSO, T2.CD_CATALOGO, T2.DS_CATALOGO " + 
					  "FROM T_FLO_CURSO T1 INNER JOIN T_FLO_CATALOGO T2 ON T1.CD_CATALOGO = T2.CD_CATALOGO " + 
				      "WHERE T1.NM_CURSO LIKE ?";
			    
		ps = con.prepareStatement(_sql);
		ps.setString(1, "%" + nome + "%");
		rs = ps.executeQuery();
		
		List<Curso> cursos = new ArrayList<Curso>();
		while(rs.next()) {
			Curso obj = new Curso();
			obj.setCodigo(rs.getInt("CD_CURSO"));
			obj.setNome(rs.getString("NM_CURSO"));
			obj.setCatalogo(new Catalogo(rs.getInt("CD_CATALOGO"), rs.getString("DS_CATALOGO")));
			cursos.add(obj);
		}	
		return cursos;
	}

	public void fechar() throws Exception {
		con.close();
	}
}
