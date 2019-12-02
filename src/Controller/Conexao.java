package Controller;

import java.sql.DriverManager;

import View.TelaDialago;

import java.sql.Connection;

public class Conexao {
	public static Connection getConexao() {
		String servidor = "localhost";
		String banco = "dbMercado";
		String user = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String path = "jdbc:mysql://"+servidor+"/"+banco;
			Connection con = DriverManager.getConnection(path,user,password);
			return con;
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}
		return null;
	}
	
	
	public static void fecharConexao(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (Exception e) {
				new TelaDialago(0, "Erro: "+e.getMessage());
			}
		}
	}
}
