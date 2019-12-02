package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import Controller.ProdutoController;
import Model.ProdutoModel;

public class ListarProdutoEditar extends JFrame{
	
	
	JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;
        
    String [][] dados = new String[ProdutoController.listar().size()][6];
     
    String [] colunas = {"<html><div style='padding:5px; font-size:12px; font-weight:bold;'>ID</div></html>", "<html><div style='padding:5px; font-size:12px; font-weight:bold;'>Marca</div></html>", "<html><div style='padding:5px; font-size:12px; font-weight:bold;'>Nome</div></html>","<html><div style='padding:5px; font-size:12px; font-weight:bold;'>Valor</div></html>", "<html><div style='padding:5px; font-size:12px; font-weight:bold;'>Quantidade</div></html>", "<html><div style='padding:5px; font-size:12px; font-weight:bold;'>Código</div></html>"};
    
    public void criaJanela(){
        
    	JLabel label = new JLabel("OK");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 25));
		label.setBackground(new Color(53,152,220));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		getContentPane().add(label, BorderLayout.SOUTH);
    	
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(dados, colunas);
        tabela.setRowHeight(20);
        tabela.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        tabela.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		ProdutoModel produtoModel = new ProdutoModel();
        		produtoModel.setId(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()));
        		produtoModel.setMarca(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        		produtoModel.setNomeProduto(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        		produtoModel.setValor(tabela.getValueAt(tabela.getSelectedRow(), 3).toString().replace("R$ ", ""));
        		produtoModel.setQuantidade(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 4).toString()));
        		produtoModel.setCodigo((tabela.getValueAt(tabela.getSelectedRow(), 5).toString()));
        		setVisible(false);
        		new AtualizarProduto(produtoModel);
        	}
		});
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem); 
        
        List<ProdutoModel> listaProdutos = ProdutoController.listar();
        
        for (int i = 0; i < ProdutoController.listar().size(); i++) {
			dados[i][0] = String.valueOf(listaProdutos.get(i).getId());
			dados[i][1] = String.valueOf(listaProdutos.get(i).getMarca());
			dados[i][2] = String.valueOf(listaProdutos.get(i).getNomeProduto());
			dados[i][3] = "R$ "+String.valueOf(listaProdutos.get(i).getValor());
			dados[i][4] = String.valueOf(listaProdutos.get(i).getQuantidade());
			dados[i][5] = String.valueOf(listaProdutos.get(i).getCodigo());
		}
        
        getContentPane().add(painelFundo);
        setSize(850, 435);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
     
}
