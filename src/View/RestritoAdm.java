package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Model.AdmModel;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RestritoAdm extends JFrame implements KeyListener{

	public RestritoAdm(AdmModel admModel) {
		setBounds(100, 100, 650, 450);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(Color.white);
		getContentPane().setLayout(null);
		
		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaixa.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblCaixa.setBounds(22, 96, 146, 15);
		getContentPane().add(lblCaixa);
		
		JLabel lblAdm = new JLabel("Adm");
		lblAdm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdm.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblAdm.setBounds(265, 97, 146, 15);
		getContentPane().add(lblAdm);
		
		JLabel lblProduto = new JLabel("Produtos");
		lblProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduto.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblProduto.setBounds(483, 97, 146, 15);
		getContentPane().add(lblProduto);
		
		//IMAGES
		
		JLabel imgCaixa = new JLabel(new ImageIcon("images/man-user.png"));
		imgCaixa.setBounds(22, 138, 146, 146);
		getContentPane().add(imgCaixa);
		
		JLabel imgAdm = new JLabel(new ImageIcon("images/admin-with-cogwheels.png"));
		imgAdm.setBounds(265, 138, 146, 146);
		getContentPane().add(imgAdm);
		
		JLabel imgProduto = new JLabel(new ImageIcon("images/product.png"));
		imgProduto.setBounds(483, 138, 146, 146);
		getContentPane().add(imgProduto);
		
		//BOTOES ICONES CRUD-----------------------------------------------------------------------------
		
		//CAIXA
		JLabel lblListar = new JLabel(new ImageIcon("images/icons/list.png"));
		lblListar.setBounds(22, 311, 40, 40);
		lblListar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ListarCaixaEditar listarCaixaEditar = new ListarCaixaEditar();
				listarCaixaEditar.criaJanela();
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		getContentPane().add(lblListar);
		
		JLabel lblAdd = new JLabel(new ImageIcon("images/icons/plus.png"));
		lblAdd.setBounds(74, 311, 40, 40);
		lblAdd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new AdicionarCaixa();
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
			
		});
		getContentPane().add(lblAdd);
		
		JLabel lblRemover = new JLabel(new ImageIcon("images/icons/icon.png"));
		lblRemover.setBounds(128, 311, 40, 40);
		lblRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RemoverCaixa();
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		getContentPane().add(lblRemover);
		
		//ADM
		JLabel lblListar_1 = new JLabel(new ImageIcon("images/icons/list.png"));
		lblListar_1.setBounds(264, 311, 40, 40);
		lblListar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarAdmEditar listarAdmEditar = new ListarAdmEditar();
				listarAdmEditar.criaJanela();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		getContentPane().add(lblListar_1);
		
		JLabel lblAdd_1 = new JLabel(new ImageIcon("images/icons/plus.png"));
		lblAdd_1.setBounds(316, 311, 40, 40);
		lblAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AdicionarAdm();
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
			
		});
		getContentPane().add(lblAdd_1);
		
		JLabel lblRemover_1 = new JLabel(new ImageIcon("images/icons/icon.png"));
		lblRemover_1.setBounds(371, 311, 40, 40);
		lblRemover_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RemoverAdm();
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		getContentPane().add(lblRemover_1);
		
		
		//PRODUTO
		JLabel lblListar_2 = new JLabel(new ImageIcon("images/icons/list.png"));
		lblListar_2.setBounds(483, 311, 40, 40);
		lblListar_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ListarProdutoEditar listarProdutoEditar = new ListarProdutoEditar();
				listarProdutoEditar.criaJanela();
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
			
		});
		getContentPane().add(lblListar_2);
		
		JLabel lblAdd_2 = new JLabel(new ImageIcon("images/icons/plus.png"));
		lblAdd_2.setBounds(535, 311, 40, 40);
		lblAdd_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new AdicionarProduto();
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
			
		});
		getContentPane().add(lblAdd_2);
		
		JLabel lblRemover_2 = new JLabel(new ImageIcon("images/icons/icon.png"));
		lblRemover_2.setBounds(587, 311, 40, 40);
		lblRemover_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new RemoverProduto();
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		getContentPane().add(lblRemover_2);
		
		JLabel label = new JLabel("Sair");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new LoginForm();
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		label.setBackground(Color.RED);
		label.setBounds(533, 398, 99, 40);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel();
		label_1.setOpaque(true);
		label_1.setBackground(new Color(53, 152, 220));
		label_1.setBounds(0, 0, 650, 9);
		getContentPane().add(label_1);
		
		String nome = admModel.getNome();
		String[] nomes = nome.split(" ");
		
		JLabel lblBemVindo = new JLabel("Bem vindo, "+nomes[0]);
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setForeground(new Color(53, 152, 220));
		lblBemVindo.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		lblBemVindo.setBounds(0, 21, 650, 30);
		getContentPane().add(lblBemVindo);
		
		JLabel label_2 = new JLabel();
		label_2.setOpaque(true);
		label_2.setBackground(new Color(53, 152, 220));
		label_2.setBounds(483, 290, 146, 9);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setOpaque(true);
		label_3.setBackground(new Color(53, 152, 220));
		label_3.setBounds(265, 290, 146, 9);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel();
		label_4.setOpaque(true);
		label_4.setBackground(new Color(53, 152, 220));
		label_4.setBounds(22, 290, 146, 9);
		getContentPane().add(label_4);
		
		JLabel fundo = new JLabel();
		fundo.setBounds(0,0,650,450);
		fundo.setOpaque(true);
		fundo.setBackground(Color.white);
		
		getContentPane().add(fundo);
		
		addKeyListener(this);
		setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			setVisible(false);
			new LoginForm();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
