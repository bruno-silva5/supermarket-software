package Controller;

import java.util.List;

import Model.AdmDAO;
import Model.CaixaModel;
import Model.ProdutoDAO;
import Model.ProdutoModel;
import Model.CaixaDAO;
import View.TelaDialago;

public class CaixaController {
	public static boolean insert(CaixaModel caixaModel) {
		if(CaixaDAO.selectByEmail(caixaModel.getEmail()).getEmail() == null && AdmDAO.selectByEmail(caixaModel.getEmail()).getEmail() == null) {
			CaixaDAO.inserir(caixaModel);
			new TelaDialago(1, "Caixa <b>cadastrado</b> com sucesso!");
			return true;
		}else {
			new TelaDialago(0, "E-mail já cadastrado!");
			return false;
		}
	}
	
	public static void deletar(int id) {
		if (CaixaDAO.deletar(id)) {
			new TelaDialago(1, "Caixa <b>removido</> com sucesso!");
		}else {
			new TelaDialago(0, "ID não encontrado!");
		}
	}
	
	public static boolean update(CaixaModel caixa) {
		if (CaixaDAO.update(caixa)) {
			new TelaDialago(1, "Caixa <b>atualizado</b> com sucesso!");
			return true;
		}else {
			new TelaDialago(0,"Id não encontrado!");
			return false;
		}
		
	}
	
	public static CaixaModel select(int id) {
		return CaixaDAO.select(id);
	}
	
	public static List<CaixaModel> listar() {
		return CaixaDAO.listar();
	}
	
	public static boolean login(CaixaModel caixaModel) {
		return CaixaDAO.login(caixaModel);
	}
}
