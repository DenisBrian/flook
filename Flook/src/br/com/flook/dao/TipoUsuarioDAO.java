package br.com.flook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.flook.beans.TipoUsuario;
import br.com.flook.conexao.Conexao;

/**
 * Classe responsável por manipular a tabela T_FLO_TIPO_USUARIO
 * 
 * @author Denis Brian Canola
 * @version 1.0
 * @since 1.0
 * @see br.com.flook.beans.TipoUsuario
 * @see br.com.flook.bo.TipoUsuarioBO
 */
public class TipoUsuarioDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * Construtor responsável por abrir a conexão
	 * 
	 * @throws Exception
	 *             Exceção checked SQLException
	 * @author Denis Brian Canola
	 */
	public TipoUsuarioDAO() throws Exception {
		con = Conexao.conectar();
	}

	/**
	 * Adiciona uma tupla na tabela T_FLO_TIPO_USUARIO
	 * 
	 * @param obj
	 *            Este parâmetro representa um objeto TipoUsuario beans
	 * @return retorna um Int com codigo do TipoUsuario
	 * @throws Exception
	 *             Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public int gravar(TipoUsuario obj) throws Exception {
		String _sql = "INSERT INTO T_FLO_TIPO_USUARIO (DS_TIPO_USUARIO) VALUES (?)";

		ps = con.prepareStatement(_sql, new String[] { "CD_TIPO_USUARIO" });
		ps.setString(1, obj.getTipo());

		int affectedRows = ps.executeUpdate();
		int cod = 0;

		if (affectedRows > 0) {
			rs = ps.getGeneratedKeys();

			if (rs.next())
				cod = rs.getInt(1);
		}

		return cod;
	}

	/**
	 * Busca uma tupla na tabela T_FLO_TIPO_USUARIO pelo codigo
	 * 
	 * @param cod
	 *            Este parâmetro refere-se ao codigo da Instituicao
	 * @return retorna o objeto Instituicao se encontrado
	 * @throws Exception
	 *             Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public TipoUsuario obter(int cod) throws Exception {
		String _sql = "SELECT CD_TIPO_USUARIO, DS_TIPO_USUARIO FROM T_FLO_TIPO_USUARIO WHERE CD_TIPO_USUARIO = ?";

		ps = con.prepareStatement(_sql);
		ps.setInt(1, cod);

		rs = ps.executeQuery();

		TipoUsuario obj = new TipoUsuario();

		if (rs.next()) {
			obj.setCodigo(rs.getInt("CD_TIPO_USUARIO"));
			obj.setTipo(rs.getString("DS_TIPO_USUARIO"));
		}

		return obj;
	}

	/**
	 * Metodo que faz o fechamento da conexão com o banco de dados.
	 * 
	 * @throws Exception
	 *             Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public void fechar() throws Exception {
		con.close();
	}

	public Boolean deletar(int cod) throws Exception {
		String _sql = "DELETE T_FLO_TIPO_USUARIO WHERE CD_TIPO_USUARIO = ?";
		ps = con.prepareStatement(_sql);
		ps.setInt(1, cod);

		int affectedRows = ps.executeUpdate();
		
		return affectedRows > 0;
	}

	public Boolean alterar(TipoUsuario obj) throws Exception {
		String _sql = "UPDATE T_FLO_TIPO_USUARIO SET DS_TIPO_USUARIO = ? WHERE CD_TIPO_USUARIO = ?";
		ps = con.prepareStatement(_sql);

		ps.setString(1, obj.getTipo());
		ps.setInt(2, obj.getCodigo());

		int affectedRows = ps.executeUpdate();
		
		return affectedRows > 0;
	}

}
