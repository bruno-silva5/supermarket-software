package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.AdmController;
import Model.AdmModel;

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

public class AtualizarAdm extends JFrame{
	
	JTextField txtNome = new JTextField();
	JTextField txtEmail = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	int id;
	
	public AtualizarAdm(AdmModel adm) {
		id = adm.getId();
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 366, 385);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblAtualizarAdm = new JLabel("Atualizar Adm");
		lblAtualizarAdm.setFont(new Font("Arial", Font.PLAIN, 26));
		lblAtualizarAdm.setForeground(new Color(53,152,220));
		lblAtualizarAdm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarAdm.setBounds(0, 12, 366, 51);
		getContentPane().add(lblAtualizarAdm);
		
		
		txtNome.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNome.setBounds(12, 102, 342, 37);
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
		txtEmail.setBounds(12, 186, 342, 37);
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
		passwordField.setBounds(12, 273, 342, 37);
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
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.addMouseListener(new MouseAdapter() {
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
		lblAtualizar.setOpaque(true);
		lblAtualizar.setForeground(Color.black);
		lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizar.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAtualizar.setBackground(Color.green);
		lblAtualizar.setBounds(207, 330, 100, 35);
		getContentPane().add(lblAtualizar);
		
		txtNome.setText(adm.getNome());
		txtEmail.setText(adm.getEmail());
		setVisible(true);
		
	}
	
	private void cadastrar() {
		if(!(txtNome.getText().equals("") || txtEmail.getText().equals("") || new String(passwordField.getPassword()).equals(""))) {
			AdmModel admModel = new AdmModel();
			admModel.setId(id);
			admModel.setNome(txtNome.getText());
			admModel.setEmail(txtEmail.getText());
			admModel.setSenha(new String(passwordField.getPassword()));
			if (AdmController.update(admModel)) {
				txtEmail.setText("");
				txtNome.setText("");
				passwordField.setText("");	
				setVisible(false);
			}
		}else {
			new TelaDialago(2,"É obrigatório preencher todos os campos!");
		}
	}
}
