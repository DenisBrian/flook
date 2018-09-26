package br.com.flook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.flook.beans.TipoUsuario;
import br.com.flook.beans.Usuario;
import br.com.flook.conexao.Conexao;
/**
 * Classe responsável por manipular a tabela T_FLO_USUARIO
 * @author Denis Brian Canola
 * @version 1.0
 * @since 1.0
 * @see br.com.flook.beans.Usuario
 * @see br.com.flook.bo.UsuarioBO
 */
public class UsuarioDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	* Construtor responsável por abrir a conexão
	* @throws Exception Exceção checked SQLException
	* @author Denis Brian Canola
	*/
	public UsuarioDAO() throws Exception{
		con = Conexao.conectar();
	}
	/**
	 * Adiciona uma tuba na tabela T_FLO_USUARIO
	 * @param obj Este parâmetro representa um objeto Usuario beans
	 * @return retorna um Int com codigo do Usuario
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public int gravar(Usuario obj) throws Exception{
		String _sql = "INSERT INTO T_FLO_USUARIO(CD_TIPO_USUARIO,TX_EMAIL,TX_SENHA,DT_NASCIMENTO,QT_PONTO,IMG_USUARIO) VALUES (?,?,?,?,?,?)";
		
		ps = con.prepareStatement(_sql, new String[] {"CD_USUARIO"});
		ps.setInt(1, obj.getTipoUsuario().getCodigo());
		ps.setString(2, obj.getEmail());
		ps.setString(3, obj.getSenha());
		ps.setDate(4, new java.sql.Date(obj.getDataNascimento().getTimeInMillis()));
		ps.setInt(5, obj.getPontoAcumulado());
		ps.setString(6, obj.getImagem());
		
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
	 * Adiciona uma tuba na tabela T_FLO_USUARIO
	 * @param cod Este parâmetro é o codigo do Usuario
	 * @return retorna um objeto Usuario se encontrado
	 * @throws Exception Exceção checked SQLExption
	 * @author DENIS BRIAN CANOLA
	 */
	public Usuario obter(int cod) throws Exception {
		String _sql = "SELECT \r\n" + 
				"    T2.CD_TIPO_USUARIO,\r\n" + 
				"    T2.DS_TIPO_USUARIO,\r\n" + 
				"    T1.CD_USUARIO,\r\n" + 
				"    T1.TX_EMAIL,\r\n" + 
				"    T1.TX_SENHA,\r\n" + 
				"    T1.DT_NASCIMENTO,\r\n" + 
				"    T1.QT_PONTO,\r\n" + 
				"    T1.IMG_USUARIO\r\n" + 
				"FROM T_FLO_USUARIO T1\r\n" + 
				"INNER JOIN T_FLO_TIPO_USUARIO T2 ON T1.CD_TIPO_USUARIO = T2.CD_TIPO_USUARIO\r\n" + 
				"WHERE CD_USUARIO = ?";
		
		ps = con.prepareStatement(_sql);
		ps.setInt(1, cod);
		
		rs = ps.executeQuery();
		
		Usuario obj = new Usuario();
		if(rs.next()) {
			obj.setCodigo(rs.getInt("CD_USUARIO"));
			obj.setEmail(rs.getString("TX_EMAIL"));			
			obj.setSenha(rs.getString("TX_SENHA"));
			
			Calendar dt = new GregorianCalendar();
			dt.setTime(rs.getDate("DT_NASCIMENTO"));
			obj.setDataNascimento(dt);
			
			obj.setPontoAcumulado(rs.getInt("QT_PONTO"));
			obj.setImagem(rs.getString("IMG_USUARIO"));
			obj.setTipoUsuario(new TipoUsuario(rs.getInt("CD_TIPO_USUARIO"),rs.getString("DS_TIPO_USUARIO")));
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
