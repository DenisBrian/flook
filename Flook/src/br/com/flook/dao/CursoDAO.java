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
 * @version 1.0
 * @since 1.0
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
	
	/**
	 * Adiciona uma tupla na tabela T_FLO_CURSO
	 * @param obj Este parâmetro representa um objeto Curso beans
	 * @return retorna um Int com codigo do Curso
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public int gravar(Curso obj) throws Exception{	
		String _sql = "INSERT INTO T_FLO_CURSO (CD_CATALOGO,NM_CURSO) VALUES (?,?)";
		
		ps = con.prepareStatement(_sql,new String[]{"CD_CURSO"});
		ps.setInt(1, obj.getCatalogo().getCodigo());
		ps.setString(2, obj.getNome());
		
		int affectedRows = ps.executeUpdate();
		
		int cod = 0;
		
		if(affectedRows > 0) {
			rs = ps.getGeneratedKeys();
			
			if(rs.next())
				cod = rs.getInt(1);
			
		}
		
		return cod;
	}	
	
	/**
	 * Busca uma tupla na tabela T_FLO_CURSO pelo código
	 * @param cod Este parâmetro refere-se ao Id do objeto Curso beans
	 * @return retorna o objeto Curso beans
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public Curso obter(int cod) throws Exception{
		String _sql = "SELECT T1.CD_CURSO, T1.NM_CURSO, T2.CD_CATALOGO, T2.DS_CATALOGO "
				    + "FROM T_FLO_CURSO T1 "
				    + "INNER JOIN T_FLO_CATALOGO T2 ON T1.CD_CURSO = T2.CD_CATALOGO "
				    + "WHERE CD_CURSO = ?";
		
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
	
	/**
	 * Busca uma tupla na tabela T_FLO_CURSO pelo atributo nome 
	 * @param nome Este parâmetro refere-se ao atributo nome do objeto Curso beans
	 * @return retorna uma lista com os Curso encontrados.
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
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

	/**
	 * Metodo que faz o fechamento da conexão com o banco de dados.
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public void fechar() throws Exception {
		con.close();
	}
}
