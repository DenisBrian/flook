package br.com.flook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.flook.beans.Endereco;
import br.com.flook.conexao.Conexao;
/**
 * Classe responsável por manipular a tabela T_FLO_ENDERECO
 * @author Denis Brian Canola
 * @version 1.0
 * @since 1.0
 * @see br.com.flook.beans.Endereco
 * @see br.com.flook.bo.EnderecoBO
 */
public class EnderecoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * Construtor responsável por abrir a conexão
	 * @throws Exception Exceção checked SQLException
	 * @author Denis Brian Canola
	 */
	public EnderecoDAO() throws Exception{
		con = Conexao.conectar();
	}
	
	public EnderecoDAO(Connection _con) throws Exception{
		con = _con;
	}
	
	/**
	 * Adiciona uma tuba na tabela T_FLO_ENDERECO
	 * @param obj Este parâmetro representa um objeto Endereco beans
	 * @return retorna um Int com codigo 0
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public int gravar(Endereco obj) throws Exception{
		String _sql = "INSERT INTO T_FLO_ENDERECO (NM_BAIRRO, NR_CEP, NM_CIDADE, NM_COMPLEMENTO, SG_ESTADO, DS_LOGRADOURO, NR_ENDERECO) VALUES(?,?,?,?,?,?,?)";
		
		ps = con.prepareStatement(_sql, new String[] {"CD_ENDERECO"});
		ps.setString(1, obj.getBairro());
		ps.setString(2, obj.getCep());
		ps.setString(3, obj.getCidade());
		ps.setString(4, obj.getComplemento());
		ps.setString(5, obj.getEstado());
		ps.setString(6, obj.getLogradouro());
		ps.setString(7, obj.getNumero());
		
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
	 * Busca uma tuba na tabela T_FLO_ENDERECO pelo código
	 * @param cod Este parâmetro refere-se ao Id do objeto Endereco beans
	 * @return retorna o objeto Endereco beans se encontrado
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public Endereco obter(int cod) throws Exception {
		String _sql = "SELECT\r\n" + 
				"    CD_ENDERECO,\r\n" + 
				"    NM_BAIRRO,\r\n" + 
				"    NR_CEP,\r\n" + 
				"    NM_CIDADE,\r\n" + 
				"    NM_COMPLEMENTO,\r\n" + 
				"    SG_ESTADO,\r\n" + 
				"    DS_LOGRADOURO,\r\n" + 
				"    NR_ENDERECO\r\n" + 
				"FROM T_FLO_ENDERECO WHERE CD_ENDERECO = ?";
		
		ps = con.prepareStatement(_sql);
		ps.setInt(1, cod);
		rs = ps.executeQuery();
		
		Endereco obj = new Endereco();
		if(rs.next()) {
			obj.setCodigo(rs.getInt("CD_ENDERECO"));
			obj.setBairro(rs.getString("NM_BAIRRO"));
			obj.setCep(rs.getString("NR_CEP"));
			obj.setCidade(rs.getString("NM_CIDADE"));
			obj.setComplemento(rs.getString("NM_COMPLEMENTO"));
			obj.setEstado(rs.getString("SG_ESTADO"));
			obj.setLogradouro(rs.getString("DS_LOGRADOURO"));
			obj.setNumero(rs.getString("NR_ENDERECO"));
		}
		
		return obj;
	}

	/**
	 * Busca uma tuba na tabela T_FLO_ENDERECO pela Intituicao
	 * @param cod Este parâmetro refere-se ao atributo codigo do objeto Intituicao beans
	 * @return retorna uma lista com os objetos Endereco encontrados.
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public List<Endereco> obterPorInstituicao(int cod) throws Exception{
		String _sql = "SELECT\r\n" + 
				"    CD_ENDERECO,\r\n" + 
				"    DS_LOGRADOURO,\r\n" + 
				"    NR_ENDERECO,\r\n" + 
				"    NM_COMPLEMENTO,\r\n" + 
				"    NM_BAIRRO,\r\n" + 
				"    NM_CIDADE,\r\n" + 
				"    SG_ESTADO,\r\n" + 
				"    NR_CEP\r\n" + 
				"FROM T_FLO_INSTITUICAO_UNIDADE T1\r\n" + 
				"INNER JOIN T_FLO_ENDERECO T2 ON T1.CD_ENDERECO = T2.CD_ENDERECO\r\n" + 
				"WHERE T1.CD_INSTITUICAO = ?";
		
		ps = con.prepareStatement(_sql);
		
		ps.setInt(1, cod);
		
		rs = ps.executeQuery();
		
		List<Endereco> ends = new ArrayList<Endereco>();
		while(rs.next()) {
			Endereco end = new Endereco();				
			end.setCodigo(rs.getInt("CD_ENDERECO"));
			end.setBairro(rs.getString("NM_BAIRRO"));
			end.setCep(rs.getString("NR_CEP"));
			end.setCidade(rs.getString("NM_CIDADE"));
			end.setComplemento(rs.getString("NM_COMPLEMENTO"));
			end.setEstado(rs.getString("SG_ESTADO"));
			end.setLogradouro(rs.getString("DS_LOGRADOURO"));
			end.setNumero(rs.getString("NR_ENDERECO"));				
			ends.add(end);
		}
		
		return ends;	
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
