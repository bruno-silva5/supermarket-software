package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Controller.AdmController;
import Controller.CaixaController;
import Model.AdmModel;
import Model.CaixaModel;
import Controller.CaixaController;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RemoverCaixa extends JFrame{

	public RemoverCaixa() {
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(0, 0, 387, 223);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblCancelar = new JLabel("Cancelar");
		lblCancelar.setOpaque(true);
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setForeground(Color.WHITE);
		lblCancelar.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCancelar.setBackground(Color.GRAY);
		lblCancelar.addMouseListener(new MouseAdapter() {
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
		lblCancelar.setBounds(163, 168, 100, 35);
		getContentPane().add(lblCancelar);
		
		JLabel label_2 = new JLabel();
		label_2.setOpaque(true);
		label_2.setBackground(new Color(53, 152, 220));
		label_2.setBounds(0, -2, 397, 9);
		getContentPane().add(label_2);
		
		JLabel lblRemoverCaixa = new JLabel("Remover Caixa");
		lblRemoverCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverCaixa.setForeground(new Color(53, 152, 220));
		lblRemoverCaixa.setFont(new Font("Dialog", Font.PLAIN, 26));
		lblRemoverCaixa.setBounds(0, 12, 387, 51);
		getContentPane().add(lblRemoverCaixa);
		
		JLabel lblDigiteOId = new JLabel("Digite o ID do caixa que deseja remover");
		lblDigiteOId.setForeground(new Color(122, 122, 122));
		lblDigiteOId.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDigiteOId.setBounds(10, 77, 343, 15);
		getContentPane().add(lblDigiteOId);
		
		JTextField spinner = new JTextField();
		spinner.setFont(new Font("Arial", Font.PLAIN, 16));
		spinner.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						CaixaController.deletar(Integer.valueOf(spinner.getText()));
					} catch (Exception e2) {
						new TelaDialago(0,"ID inválido");
					}
					spinner.setText("");
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					setVisible(false);
				}
			}
		});
		spinner.setBounds(9, 104, 366, 35);
		getContentPane().add(spinner);
		
		JLabel lblCadastrar = new JLabel("Remover");
		lblCadastrar.setOpaque(true);
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setForeground(Color.WHITE);
		lblCadastrar.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCadastrar.setBackground(Color.RED);
		lblCadastrar.setBounds(275, 168, 100, 35);
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					CaixaController.deletar(Integer.valueOf(spinner.getText()));
				} catch (Exception e2) {
					new TelaDialago(0,"ID inválido!");
				}
				spinner.setText("");
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		getContentPane().add(lblCadastrar);
		
		setVisible(true);
		
	}
}
