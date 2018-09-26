package br.com.flook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.flook.beans.Catalogo;
import br.com.flook.conexao.Conexao;
/**
 * Classe responsável por manipular a tabela T_FLO_CATALOGO.
 * @author DENIS BRIAN CANOLA
 * @version 1.0
 * @since 1.0
 * @see br.com.fiap.beans.Catalogo
 * @see br.com.fiap.bo.CatalogoBO
 */
public class CatalogoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	 * Construtor responsável por abrir a conexão
	 * @throws Exception Exceção checked SQLException
	 * @author DENIS BRIAN CANOLA
	 */
	public CatalogoDAO() throws Exception{
		con = Conexao.conectar();
	}
	
	/**
	 * Adiciona uma tuba na tabela T_FLO_CATALOGO
	 * @param obj Este parâmetro recebe um objeto Catalogo beans
	 * @return retorna um Int com codigo do curso
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public int gravar(Catalogo obj) throws Exception{	
		String _sql = "INSERT INTO T_FLO_CATALOGO (DS_CATALOGO) VALUES (?)";
		
		ps = con.prepareStatement(_sql,new String[]{"CD_CATALOGO"});
		ps.setString(1, obj.getDescricao());		
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
	 * Busca uma tuba na tabela T_FLO_CATALOGO
	 * @param cod Este parâmetro refere-se ao Id do objeto Catalogo beans
	 * @return retorna o objeto Catalogo beans
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
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

	/**
	 * Metodo que faz o fechamento da conexão com o banco de dados.
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public void fechar() throws Exception{
		con.close();
	}
}
