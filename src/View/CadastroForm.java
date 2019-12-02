package View;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Controller.CaixaController;
import Model.CaixaModel;

public class CadastroForm extends JFrame{
	Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
	CadastroForm(){
		setBounds(0,0,435,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		init();
		setIconImage(icon);
		setVisible(true);
		
	}
	
	void init() {
		
		JLabel barraAzul = new JLabel();
		barraAzul.setOpaque(true);
		barraAzul.setBackground(new Color(53,152,220));
		barraAzul.setBounds(0, 0, 450, 10);
		add(barraAzul);
		
		JLabel lblLogin = new JLabel("CADASTRO");
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 30));
		lblLogin.setForeground(new Color(53,152,220));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(0, 20, 450, 40);
		add(lblLogin);
		
		
		//NOME
		JLabel lblname = new JLabel("Nome Completo");
		lblname.setFont(new Font("Arial", Font.PLAIN, 15));
		lblname.setForeground(new Color(122,122,122));
		lblname.setBounds(10, 92, 145, 14);
		add(lblname);
		
		JTextField nome = new JTextField();
		nome.setFont(new Font("Arial", Font.PLAIN, 15));
		nome.setBounds(10, 112, 414, 36);
		add(nome);
		
		//EMAIL
		
		JLabel lblemail= new JLabel("E-mail");
		lblemail.setFont(new Font("Arial", Font.PLAIN, 15));
		lblemail.setForeground(new Color(122,122,122));
		lblemail.setBounds(10, 160, 145, 14);
		add(lblemail);
		
		JTextField email = new JTextField();
		email.setFont(new Font("Arial", Font.PLAIN, 15));
		email.setColumns(10);
		email.setBounds(10, 180, 414, 36);
		add(email);
		
		//SENHA
		
		JLabel lblsenha= new JLabel("Senha");
		lblsenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblsenha.setForeground(new Color(122,122,122));
		lblsenha.setBounds(10, 228, 145, 14);
		add(lblsenha);

		JPasswordField senha = new JPasswordField();
		senha.setFont(new Font("Arial", Font.PLAIN, 15));
		senha.setBounds(10, 248, 414, 36);
		add(senha);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setSelectedIcon(null);
		btnNewButton.setIcon(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(new Color(53,152,220));
		btnNewButton.setOpaque(true);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(UIManager.getColor("RadioButton.highlight"));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 23));
		btnNewButton.setBounds(10, 320, 414, 47);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CaixaModel user = new CaixaModel();
				if (nome.getText().equals("") || email.getText().equals("") || new String(senha.getPassword()).equals("")) {
					new TelaDialago(2,"É obrigatório preencher todos os campos");
				}else {
					user.setNome(nome.getText());
					user.setEmail(email.getText());
					user.setSenha(new String(senha.getPassword()));
					if(CaixaController.insert(user)) {
						new LoginForm();
						setVisible(false);
					}
					nome.setText("");
					email.setText("");
					senha.setText("");
					
					
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 31));
		add(btnNewButton);
		
		JLabel lblCadastrado_part1 = new JLabel("Já possui uma conta?");
		lblCadastrado_part1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCadastrado_part1.setFont(new Font("Arial", Font.PLAIN, 19));
		lblCadastrado_part1.setBounds(40, 390, 226, 30);
		add(lblCadastrado_part1);
		
		JLabel lblCadastrado_part2 = new JLabel("Faça login");
		lblCadastrado_part2.setForeground(new Color(53,152,220));
		lblCadastrado_part2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastrado_part2.setFont(new Font("Arial", Font.PLAIN, 19));
		lblCadastrado_part2.setBounds(269, 390, 185, 30);
		lblCadastrado_part2.addMouseListener(new MouseAdapter() {
				
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginForm();
				setVisible(false);
			}
			
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		add(lblCadastrado_part2);
		
		JLabel fundo = new JLabel();
		fundo.setHorizontalAlignment(SwingConstants.CENTER);
		fundo.setOpaque(true);
		fundo.setBackground(new Color(255,255,255));
		fundo.setBounds(0, 0, 450, 550);
		add(fundo);
	}
}
