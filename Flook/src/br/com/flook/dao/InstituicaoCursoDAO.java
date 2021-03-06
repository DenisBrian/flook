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
/**
 * Classe responsável por manipular a tabela T_FLO_INSTITUICAO_CURSO
 * @author Denis Brian Canola
 * @version 1.0
 * @since 1.0
 * @see br.com.flook.beans.InstituicaoCurso
 * @see br.com.flook.bo.InstituicaoCursoBO
 */
public class InstituicaoCursoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	* Construtor responsável por abrir a conexão
	* @throws Exception Exceção checked SQLException
	* @author Denis Brian Canola
	*/
	public InstituicaoCursoDAO() throws Exception{
		con = Conexao.conectar();
	}
	/**
	 * Busca uma tupla na tabela T_FLO_INSTITUICAO_CURSO pelo nome do Curso
	 * @param nome Este parâmetro refere-se ao nome do Curso
	 * @return retorna uma lista de objetosInstituicaoCurso se encontrado
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public List<InstituicaoCurso> obter(String nome) throws Exception{
		String _sql = "SELECT " + 
				"    T2.CD_CURSO,  " + 
				"    T3.CD_INSTITUICAO," +
				"    T1.NR_NOTA_MEC," + 
				"    T1.TP_CURSO," + 
				"    T1.DS_TIPO_CURSO," +
				"    T3.IMG_INSTITUICAO," + 
				"    T3.DS_INSTITUICAO" +
				" FROM T_FLO_INSTITUICAO_CURSO T1 " + 
				" INNER JOIN T_FLO_CURSO T2 ON T1.CD_CURSO = T2.CD_CURSO " + 
				" INNER JOIN T_FLO_INSTITUICAO T3 ON T1.CD_INSTITUICAO = T3.CD_INSTITUICAO " + 
				" WHERE T2.NM_CURSO LIKE ?";
			    
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
	/**
	 * Busca uma tupla na tabela T_FLO_INSTITUICAO_CURSO pelo codigo da Instituicao e o codigo do Curso
	 * @param codInstituicao Este parâmetro refere-se ao codigo da Instituição
	 * @param codCurso Este parâmetro refere-se ao codigo do Curso
	 * @return retorna um objeto
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public InstituicaoCurso obter(int codInstituicao, int codCurso) throws Exception{
		String _sql = "SELECT\r\n" + 
				"    T3.NM_INSTITUICAO,\r\n" + 
				"    t3.img_instituicao,\r\n" + 
				"    T2.NM_CURSO,\r\n" + 
				"    T1.NR_NOTA_MEC,\r\n" + 
				"    T1.TP_CURSO,\r\n" + 
				"    T1.DS_TIPO_CURSO,\r\n" + 
				"    T1.NR_LIKE,\r\n" + 
				"    T1.NR_DISLIKE,\r\n" + 
				"    T1.VIDEO,\r\n" + 
				"    T1.DS_CURSO,\r\n" + 
				"    T1.DS_PLANO_CARREIRA\r\n" + 
				" FROM T_FLO_INSTITUICAO_CURSO T1\r\n" + 
				" INNER JOIN T_FLO_CURSO T2 ON T1.CD_CURSO = T2.CD_CURSO\r\n" + 
				" INNER JOIN T_FLO_INSTITUICAO T3 ON T1.CD_INSTITUICAO = T3.CD_INSTITUICAO\r\n" + 
				" WHERE T1.CD_INSTITUICAO = ? AND T1.CD_CURSO = ?";
			    
		ps = con.prepareStatement(_sql);
		ps.setInt(1, codInstituicao);
		ps.setInt(2, codCurso);
		rs = ps.executeQuery();
		
		InstituicaoCurso ic = new InstituicaoCurso();
		
		if(rs.next()) {
			
			Instituicao ins = new Instituicao();
			ins.setLogo(rs.getString("IMG_INSTITUICAO"));
			ins.setNome(rs.getString("NM_INSTITUICAO"));
			
			Curso curso = new Curso();
			curso.setNome(rs.getString("NM_CURSO"));
			
			ic.setInstituicao(ins);
			ic.setCurso(curso);
			
			ic.setMec(rs.getFloat("NR_NOTA_MEC"));
			ic.setDuracao(rs.getFloat("TP_CURSO"));
			ic.setTipoCurso(rs.getString("DS_TIPO_CURSO"));
			ic.setLike(rs.getInt("NR_LIKE"));
			ic.setDislike(rs.getInt("NR_DISLIKE"));
			ic.setVideo(rs.getString("VIDEO"));
			ic.setDescricao(rs.getString("DS_CURSO"));
			ic.setPlanoCarreira(rs.getString("DS_PLANO_CARREIRA"));
			
		}	
		return ic;
	}
	
	/**
	 * Metodo que faz o fechamento da conexão com o banco de dados.
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public void fechar() throws Exception {
		con.close();
	}
}
