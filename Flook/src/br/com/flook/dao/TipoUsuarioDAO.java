package br.com.flook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.flook.conexao.Conexao;

public class TipoUsuarioDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public TipoUsuarioDAO() throws Exception{
		con = Conexao.conectar();
	}
}
