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

import Controller.AdmController;
import Controller.CaixaController;
import Model.CaixaModel;
import Model.ProdutoModel;

public class ListarCaixaEditar extends JFrame{
	public ListarCaixaEditar() {
	}
	JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;
        
    String [][] dados = new String[CaixaController.listar().size()][3];
     
    String [] colunas = {"<html><div style='padding:5px; font-size:12px; font-weight:bold;'>ID</div></html>", "<html><div style='padding:5px; font-size:12px; font-weight:bold;'>Nome</div></html>", "<html><div style='padding:5px; font-size:12px; font-weight:bold;'>E-mail</div></html>"}; 
     
    public void criaJanela(){
    	
    	JLabel label = new JLabel("<html><div style='padding:5px;'> OK</div></html>");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
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
        tabela.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		CaixaModel caixa = new CaixaModel();
        		caixa.setId(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()));
        		caixa.setNome(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        		caixa.setEmail(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        		setVisible(false);
        		new AtualizarCaixa(caixa);
        	}
        });
        tabela.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem); 
        
        List<CaixaModel> listaCaixas = CaixaController.listar();
        
        for (int i = 0; i < CaixaController.listar().size(); i++) {
			dados[i][0] = String.valueOf(listaCaixas.get(i).getId());
			dados[i][1] = String.valueOf(listaCaixas.get(i).getNome());
			dados[i][2] = String.valueOf(listaCaixas.get(i).getEmail());
		}
        
        
        getContentPane().add(painelFundo);
        setBounds(0,0,650, 435);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
     
}
