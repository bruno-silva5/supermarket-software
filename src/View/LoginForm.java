package View;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Controller.AdmController;
import Controller.CaixaController;
import Model.AdmModel;
import Model.CaixaModel;

public class LoginForm extends JFrame{
	Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
	LoginForm(){
		setUndecorated(true);
		setBounds(0,0,435,375);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		init();
		setVisible(true);
		setIconImage(icon);
	}
	
	JLabel login, caixa, senha, cadastrar;
	JTextField user, password, name;
	JTextField txtEmail = new JTextField();
	JPasswordField passwordField= new JPasswordField();
	JButton btn_cadastrar, btn_voltar;
	
	void init() {
		
		JLabel barraAzul = new JLabel();
		barraAzul.setOpaque(true);
		barraAzul.setBackground(new Color(53,152,220));
		barraAzul.setBounds(0, 0, 450, 10);
		add(barraAzul);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		lblLogin.setForeground(new Color(53,152,220));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(0, 20, 435, 40);
		add(lblLogin);
		
		

		txtEmail.setFont(new Font("Ubuntu",Font.PLAIN,16));
		txtEmail.setBounds(10, 101, 414, 36);
		add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					logar();
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
			}
		});
		
		
		passwordField.setBounds(10, 190, 414, 36);
		passwordField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					logar();
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
			}
		});
		add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setSelectedIcon(null);
		btnEntrar.setIcon(null);
		btnEntrar.setContentAreaFilled(false);
		btnEntrar.setBackground(new Color(53,152,220));
		btnEntrar.setOpaque(true);
		btnEntrar.setFocusable(false);
		btnEntrar.setBorderPainted(false);
		btnEntrar.setForeground(UIManager.getColor("RadioButton.highlight"));
		btnEntrar.setFont(new Font("Ubuntu", Font.PLAIN, 23));
		btnEntrar.setBounds(10, 255, 414, 42);
		btnEntrar.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				logar();
			}	
		});
		
		btnEntrar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			
			@SuppressWarnings("deprecation")
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		
		add(btnEntrar);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Ubuntu", Font.PLAIN, 23));
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setBounds(10, 310, 414, 42);
		lblSair.setOpaque(true);
		lblSair.setForeground(Color.white);
		lblSair.setBackground(Color.red);
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		add(lblSair);
		
		
		JLabel lblLogin_1 = new JLabel("E-mail");
		lblLogin_1.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		lblLogin_1.setForeground(new Color(122,122,122));
		lblLogin_1.setBounds(10, 81, 145, 14);
		add(lblLogin_1);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Ubuntu", Font.PLAIN, 15));
		lblSenha.setForeground(new Color(122,122,122));
		lblSenha.setBounds(10, 165, 145, 14);
		add(lblSenha);
		
		JLabel fundo = new JLabel();
		fundo.setHorizontalAlignment(SwingConstants.CENTER);
		fundo.setOpaque(true);
		fundo.setBackground(new Color(255,255,255));
		fundo.setBounds(0, 0, 450, 450);
		add(fundo);
		
	}
	
	public void logar() {
		CaixaModel caixaModel = new CaixaModel();
		AdmModel admModel = new AdmModel();
		if(txtEmail.getText().equals("") || (new String(passwordField.getPassword()).equals(""))) {
			new TelaDialago(2,"É obrigatório preencher todos os campos!");
		}else {					
			caixaModel.setEmail(txtEmail.getText());
			caixaModel.setSenha(new String(passwordField.getPassword()));
			
			admModel.setEmail(txtEmail.getText());
			admModel.setSenha(new String(passwordField.getPassword()));
			
			if(CaixaController.login(caixaModel)) {
				setVisible(false);
				new RestritoCaixa();
			}else if(AdmController.login(admModel)){
				admModel.setNome(AdmController.selectByEmail(admModel.getEmail()).getNome());
				setVisible(false);
				new RestritoAdm(admModel);
			}else {
				new TelaDialago(0,"E-mail ou senha incorretos!");
			}
		}
	}

	
}
