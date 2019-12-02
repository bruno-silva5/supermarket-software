package Controller;

import java.util.List;


import Model.ProdutoModel;
import Model.ProdutoDAO;
import Model.CaixaDAO;
import View.TelaDialago;

public class ProdutoController {
	public static boolean insert(ProdutoModel produtoModel) {
		if(ProdutoDAO.inserir(produtoModel)) {
			new TelaDialago(1, "Produto <b>cadastrado</b> com sucesso!");		
			return true;
		}else {
			new TelaDialago(0, "Código já cadastrado!");
			return false;
		}
	}
	
	public static boolean update(ProdutoModel produtoModel) {
		if (ProdutoDAO.update(produtoModel)) {
			new TelaDialago(1, "Produto <b>atualizado</b> com sucesso!");
			return true;
		}else {
			new TelaDialago(0,"Id não encontrado!");
			return false;
		}
		
	}
	
	public static void deletar(int id) {
		if (ProdutoDAO.deletar(id)) {
			new TelaDialago(1, "Produto <b>removido</b> com sucesso!");
		}else {
			new TelaDialago(0,"ID não encontrado!");
		}
	}
	
	public static ProdutoModel select(int id) {
		return ProdutoDAO.selectById(id);
	}
	
	public static ProdutoModel selectByCode(String code) {
		return ProdutoDAO.selectByCode(code);
	}
	
	public static List<ProdutoModel> listar() {
		return ProdutoDAO.listar();
		
	}
}
