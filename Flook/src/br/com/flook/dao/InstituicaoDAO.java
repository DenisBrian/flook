package br.com.flook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.flook.beans.Instituicao;
import br.com.flook.conexao.Conexao;
import br.com.flook.dao.EnderecoDAO;

public class InstituicaoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public InstituicaoDAO() throws Exception {
		con = Conexao.conectar();
	}

	public int gravar(Instituicao obj) throws Exception {
		String _sql = "INSERT INTO T_FLO_INSTITUICAO(NM_INSTITUICAO,DS_TIPO_INSTITUICAO,DS_INSTITUICAO,IMG_INSTITUICAO) VALUES (?,?,?,?)";

		ps = con.prepareStatement(_sql, new String[] { "CD_INSTITUICAO" });

		ps.setString(1, obj.getNome());
		ps.setString(2, obj.getTipo());
		ps.setString(3, obj.getDescricao());
		ps.setString(4, obj.getLogo());

		int affectedRows = ps.executeUpdate();

		int cod = 0;
		if (affectedRows > 0) {
			rs = ps.getGeneratedKeys();

			if (rs.next())
				cod = rs.getInt(1);

		}

		return cod;
	}

	public boolean gravar(int instituicao, int endereco) throws Exception {
		String _sql = "INSERT INTO T_FLO_INSTITUICAO_UNIDADE(CD_INSTITUICAO,CD_ENDERECO) VALUES (?,?)";

		ps = con.prepareStatement(_sql);
		ps.setInt(1, instituicao);
		ps.setInt(2, endereco);

		return ps.execute();
	}

	public Instituicao obter(int cod) throws Exception {
		String _sql = "SELECT\r\n" + "    CD_INSTITUICAO,\r\n" + "    NM_INSTITUICAO,\r\n"
				+ "    DS_TIPO_INSTITUICAO,\r\n" + "    DS_INSTITUICAO,\r\n" + "    IMG_INSTITUICAO\r\n"
				+ "FROM T_FLO_INSTITUICAO \r\n" + "WHERE CD_INSTITUICAO = 1;";

		ps = con.prepareStatement(_sql);

		rs = ps.executeQuery();
		
		Instituicao obj = new Instituicao();
		
		if(rs.next()) {
			obj.setCodigo(rs.getInt("CD_INSTITUICAO"));
			obj.setNome(rs.getString("NM_INSTITUICAO"));
			obj.setTipo(rs.getString("DS_TIPO_INSTITUICAO"));
			obj.setDescricao(rs.getString("DS_INSTITUICAO"));
			obj.setLogo(rs.getString("IMG_INSTITUICAO"));	
			
			EnderecoDAO dao = new EnderecoDAO(con);
			obj.setEndereco(dao.obterPorInstituicao(cod));
		}	

		return obj;
	}

	public void fechar() throws Exception {
		con.close();
	}
}
