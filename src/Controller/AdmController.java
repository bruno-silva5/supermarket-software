package Controller;

import java.util.List;

import Model.AdmModel;
import Model.AdmDAO;
import Model.CaixaDAO;
import Model.ProdutoDAO;
import Model.ProdutoModel;
import View.TelaDialago;
import Model.AdmModel;
import Model.AdmDAO;

public class AdmController {
	public static boolean insert(AdmModel admModel) {
		if(AdmDAO.selectByEmail(admModel.getEmail()).getEmail() == null && CaixaDAO.selectByEmail(admModel.getEmail()).getEmail() == null) {
			AdmDAO.inserir(admModel);
			new TelaDialago(1, "Adm <b>cadastrado</b> com sucesso!");
			return true;
		}else {
			new TelaDialago(0, "E-mail já cadastrado!");
			return false;
		}
	}
	
	public static boolean update(AdmModel admModel) {
		if (AdmDAO.update(admModel)) {
			new TelaDialago(1, "Adm <b>atualizado</b> com sucesso!");
			return true;
		}else {
			new TelaDialago(0,"Id não encontrado!");
			return false;
		}
		
	}
	
	public static void deletar(int id) {
		if (AdmDAO.deletar(id)) {
			new TelaDialago(1, "Adm <b>removido</> com sucesso!");
		}else {
			new TelaDialago(0, "ID não encontrado!");
		}
	}
	
	public static AdmModel selectById(int id) {
		return AdmDAO.selectById(id);
	}
	
	public static AdmModel selectByEmail(String email) {
		return AdmDAO.selectByEmail(email.trim());
	}
	
	public static List<AdmModel> listar() {
		return AdmDAO.listar();
	}
	
	public static boolean login(AdmModel admModel) {
		return AdmDAO.login(admModel);
	}
	
	
	
}