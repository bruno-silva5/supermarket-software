package View;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.AdmController;
import Model.AdmModel;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;

public class ListarAdms extends JFrame{
	public ListarAdms() {
		
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
	}
	JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;
        
    String [][] dados = new String[AdmController.listar().size()][3];
     
    String [] colunas = {"<html><div style='padding:5px; font-size:12px; font-weight:bold;'>ID</div></html>", "<html><div style='padding:5px; font-size:12px; font-weight:bold;'>Nome</div></html>", "<html><div style='padding:5px; font-size:12px; font-weight:bold;'>E-mail</div></html>"}; 
     
     
    public void criaJanela(){
         
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(dados, colunas);
        tabela.setRowHeight(20);
        tabela.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem); 
        
        List<AdmModel> listaAdms = AdmController.listar();
        
        for (int i = 0; i < AdmController.listar().size(); i++) {
			dados[i][0] = String.valueOf(listaAdms.get(i).getId());
			dados[i][1] = String.valueOf(listaAdms.get(i).getNome());
			dados[i][2] = String.valueOf(listaAdms.get(i).getEmail());
		}
        
        getContentPane().add(painelFundo);
        setBounds(0,0,650, 435);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
     
}
