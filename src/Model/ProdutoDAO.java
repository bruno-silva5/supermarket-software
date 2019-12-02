package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Controller.Conexao;
import View.TelaDialago;

public abstract class ProdutoDAO {
	public static boolean inserir(ProdutoModel produtoModel) {
		Connection con =  null;
		try {
			con = Conexao.getConexao();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbProduto WHERE codigo = ?");
			stmt.setString(1, produtoModel.getCodigo());
			ResultSet rs = stmt.executeQuery();
			if(!rs.next()) {
				stmt = con.prepareStatement("INSERT INTO tbProduto(marca,nomeProduto,quantidade,valor, codigo) VALUES(?,?,?,?,?)");
				stmt.setString(1, produtoModel.getMarca());
				stmt.setString(2, produtoModel.getNomeProduto());
				stmt.setInt(3, produtoModel.getQuantidade());
				stmt.setString(4, produtoModel.getValor());
				stmt.setString(5, produtoModel.getCodigo());
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
	
	public static boolean update(ProdutoModel produtoModel) {
		Connection con =  null;
		PreparedStatement stmt;
		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement("UPDATE tbProduto SET marca = ? , nomeProduto = ?, quantidade = ?, valor = ?  WHERE id = ?");
			stmt.setString(1, produtoModel.getMarca());
			stmt.setString(2, produtoModel.getNomeProduto());
			stmt.setInt(3, produtoModel.getQuantidade());
			stmt.setString(4, produtoModel.getValor());
			stmt.setInt(5, produtoModel.getId());
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
			con = null;
			con = Conexao.getConexao();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbProduto WHERE id = "+id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				stmt = con.prepareStatement("DELETE FROM tbProduto WHERE id = "+id);
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
	
	public static List<ProdutoModel> listar() {
		Connection con = Conexao.getConexao();
		List<ProdutoModel> produtoModels = new ArrayList<>();		
		try {
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM tbProduto");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				ProdutoModel produtoModel = new ProdutoModel();
				produtoModel.setId(rs.getInt("id"));
				produtoModel.setMarca(rs.getString("marca"));
				produtoModel.setNomeProduto(rs.getString("nomeProduto"));
				produtoModel.setQuantidade(rs.getInt("quantidade"));
				produtoModel.setValor(rs.getString("valor"));
				produtoModel.setCodigo(rs.getString("codigo"));
				produtoModels.add(produtoModel);
			}
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}finally {
			Conexao.fecharConexao(con);
		}
		return produtoModels;
	}
	
	public static ProdutoModel selectById(int id) {
		Connection con = Conexao.getConexao();
		ProdutoModel produtoModel = new ProdutoModel();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbProduto WHERE id = "+id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				produtoModel.setId(rs.getInt("id"));
				produtoModel.setMarca(rs.getString("marca"));
				produtoModel.setNomeProduto(rs.getString("nomeProduto"));
				produtoModel.setQuantidade(rs.getInt("quantidade"));
				produtoModel.setValor(rs.getString("valor"));
				produtoModel.setCodigo(rs.getString("codigo"));
			}
		} catch (Exception e) {
			new TelaDialago(0, "Erro: "+e.getMessage());
		}finally {
			Conexao.fecharConexao(con);
		}
		return produtoModel;
	}
	
	public static ProdutoModel selectByCode(String codigo) {
		Connection con = Conexao.getConexao();
		ProdutoModel produtoModel = new ProdutoModel();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbProduto WHERE codigo = "+codigo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				produtoModel.setId(rs.getInt("id"));
				produtoModel.setMarca(rs.getString("marca"));
				produtoModel.setNomeProduto(rs.getString("nomeProduto"));
				produtoModel.setQuantidade(rs.getInt("quantidade"));
				produtoModel.setValor(rs.getString("valor"));
				produtoModel.setCodigo(rs.getString("codigo"));
			}else {
				new TelaDialago(0, "Produto não encontrado");
			}
		} catch (Exception e) {
			new TelaDialago(0, "Código inválido!");
		}finally {
			Conexao.fecharConexao(con);
		}
		return produtoModel;
	}
	
}
