package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Controller.Conexao;
import View.TelaDialago;

public abstract class CaixaDAO {
	public static boolean inserir(CaixaModel caixaModel) {
		Connection con =  null;
		try {
			con = Conexao.getConexao();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO tbCaixa(nome, email, senha) VALUES (?,?,?)");
			stmt.setString(1, caixaModel.getNome());
			stmt.setString(2, caixaModel.getEmail());
			stmt.setString(3, caixaModel.getSenha());
			stmt.execute();			
			return true;
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}finally {
			Conexao.fecharConexao(con);
		}
		return false;
	}
	
	public static boolean update(CaixaModel caixa) {
		Connection con =  null;
		PreparedStatement stmt;
		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement("UPDATE tbCaixa SET nome = ? , email = ?, senha = ?  WHERE id = ?");
			stmt.setString(1, caixa.getNome());
			stmt.setString(2, caixa.getEmail());
			stmt.setString(3, caixa.getSenha());
			stmt.setInt(4, caixa.getId());
			stmt.execute();
			return true;
		} catch (Exception e) {
			new TelaDialago(0, "Código inválido!");
		}finally {
			Conexao.fecharConexao(con);
		}
		return false;
	}
	
	public static boolean deletar(int id) {
		Connection con = null;
		try {
			con = Conexao.getConexao();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbCaixa WHERE id = "+id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				stmt = con.prepareStatement("DELETE FROM tbCaixa WHERE id = "+id);
				stmt.execute();			
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}finally {
			Conexao.fecharConexao(con);
		}
		return false;
	}
	
	public static List<CaixaModel> listar() {
		Connection con = Conexao.getConexao();
		List<CaixaModel> caixaModels = new ArrayList<>();		
		try {
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM tbCaixa");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				CaixaModel caixaModel = new CaixaModel();
				caixaModel.setId(rs.getInt("id"));
				caixaModel.setNome(rs.getString("nome"));
				caixaModel.setEmail(rs.getString("email"));
				caixaModels.add(caixaModel);
			}
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}finally {
			Conexao.fecharConexao(con);
		}
		return caixaModels;
	}
	
	public static CaixaModel select(int id) {
		Connection con = Conexao.getConexao();
		CaixaModel caixaModel = new CaixaModel();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbCaixa WHERE id = "+id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				caixaModel.setId(rs.getInt("id"));
				caixaModel.setNome(rs.getString("nome"));
				caixaModel.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}finally {
			Conexao.fecharConexao(con);
		}
		return caixaModel;
	}
	
	public static CaixaModel selectByEmail(String email) {
		Connection con = Conexao.getConexao();
		CaixaModel caixaModel = new CaixaModel();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbCaixa WHERE email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				caixaModel.setId(rs.getInt("id"));
				caixaModel.setNome(rs.getString("nome"));
				caixaModel.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}finally {
			Conexao.fecharConexao(con);
		}
		return caixaModel;
	}
	
	public static boolean login(CaixaModel caixaModel) {
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbCaixa WHERE email = ? and senha = ?");
			pstmt.setString(1, caixaModel.getEmail());
			pstmt.setString(2, caixaModel.getSenha());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}
		return false;
	}
}
