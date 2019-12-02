package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.AdmController;
import Controller.CaixaController;
import Model.CaixaModel;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Window.Type;

public class AdicionarCaixa extends JFrame{
	
	JTextField txtNome = new JTextField();
	JTextField txtEmail = new JTextField();
	JPasswordField passwordField = new JPasswordField();

	public AdicionarCaixa() {
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 366, 392);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblAdicionarCaixa = new JLabel("Adicionar Caixa");
		lblAdicionarCaixa.setFont(new Font("Arial", Font.PLAIN, 26));
		lblAdicionarCaixa.setForeground(new Color(53,152,220));
		lblAdicionarCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarCaixa.setBounds(0, 12, 366, 51);
		getContentPane().add(lblAdicionarCaixa);
		
		
		txtNome.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNome.setBounds(12, 102, 332, 37);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					cadastrar();
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					setVisible(false);
				}
			}
		});
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNome.setForeground(new Color(122,122,122));
		lblNome.setBounds(10, 75, 66, 15);
		getContentPane().add(lblNome);
		
		
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		txtEmail.setBounds(12, 186, 332, 37);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					cadastrar();
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					setVisible(false);
				}
			}
		});
		
		
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.setBounds(12, 273, 332, 37);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					cadastrar();
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					setVisible(false);
				}
			}
		});
		getContentPane().add(passwordField);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(new Color(122,122,122));
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEmail.setBounds(10, 159, 66, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenha.setForeground(new Color(122,122,122));
		lblSenha.setBounds(12, 246, 66, 15);
		getContentPane().add(lblSenha);
		
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(new Color(53,152,220));
		label.setBounds(0, 0, 366, 10);
		getContentPane().add(label);
		
		JLabel lblCancelar = new JLabel("Cancelar");
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
		lblCancelar.setOpaque(true);
		lblCancelar.setForeground(Color.white);
		lblCancelar.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCancelar.setBackground(Color.red);
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setBounds(60, 330, 100, 35);
		getContentPane().add(lblCancelar);
		
		JLabel lblCadastrar = new JLabel("Cadastrar");
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrar();
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		lblCadastrar.setOpaque(true);
		lblCadastrar.setForeground(Color.black);
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCadastrar.setBackground(Color.green);
		lblCadastrar.setBounds(207, 330, 100, 35);
		getContentPane().add(lblCadastrar);
		
		setVisible(true);
		
	}
	
	private void cadastrar() {
		if(!(txtNome.getText().equals("") || txtEmail.getText().equals("") || new String(passwordField.getPassword()).equals(""))) {
			CaixaModel caixa = new CaixaModel();
			caixa.setNome(txtNome.getText());
			caixa.setEmail(txtEmail.getText());
			caixa.setSenha(new String(passwordField.getPassword()));
			
			if(CaixaController.insert(caixa)) {
				txtNome.setText("");
				txtEmail.setText("");
				passwordField.setText("");						
			}
			
		}else {
			new TelaDialago(2,"É obrigatório preencher todos os campos");
		}
	}
}
