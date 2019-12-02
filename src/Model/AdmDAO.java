package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Controller.Conexao;
import View.TelaDialago;

public abstract class AdmDAO {
	public static boolean inserir(AdmModel admModel) {
		Connection con =  null;
		try {
			con = Conexao.getConexao();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO tbAdm(nome, email, senha) VALUES (?,?,?)");
			stmt.setString(1, admModel.getNome());
			stmt.setString(2, admModel.getEmail());
			stmt.setString(3, admModel.getSenha());
			stmt.execute();			
			return true;
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}finally {
			Conexao.fecharConexao(con);
		}
		return false;
	}
	
	public static boolean update(AdmModel caixa) {
		Connection con =  null;
		PreparedStatement stmt;
		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement("UPDATE tbAdm SET nome = ? , email = ?, senha = ? WHERE id = ?");
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
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbAdm WHERE id = "+id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				stmt = con.prepareStatement("DELETE FROM tbAdm WHERE id = "+id);
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
	
	public static List<AdmModel> listar() {
		Connection con = Conexao.getConexao();
		List<AdmModel> admModels = new ArrayList<>();		
		try {
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM tbAdm");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				AdmModel admModel = new AdmModel();
				admModel.setId(rs.getInt("id"));
				admModel.setNome(rs.getString("nome"));
				admModel.setEmail(rs.getString("email"));
				admModels.add(admModel);
			}
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}finally {
			Conexao.fecharConexao(con);
		}
		return admModels;
	}
	
	public static AdmModel selectById(int id) {
		Connection con = Conexao.getConexao();
		AdmModel admModel = new AdmModel();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbAdm WHERE id = "+id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				admModel.setId(rs.getInt("id"));
				admModel.setNome(rs.getString("nome"));
				admModel.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}finally {
			Conexao.fecharConexao(con);
		}
		return admModel;
	}
	
	public static AdmModel selectByEmail(String email) {
		Connection con = Conexao.getConexao();
		AdmModel admModel = new AdmModel();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbAdm WHERE email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				admModel.setId(rs.getInt("id"));
				admModel.setNome(rs.getString("nome"));
				admModel.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}finally {
			Conexao.fecharConexao(con);
		}
		return admModel;
	}
	
	public static boolean login(AdmModel admModel) {
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbAdm WHERE email = ? and senha = ?");
			pstmt.setString(1, admModel.getEmail());
			pstmt.setString(2, admModel.getSenha());
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
