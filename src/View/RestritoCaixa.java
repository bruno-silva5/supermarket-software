package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.SwingConstants;

import Controller.ProdutoController;
import Model.ProdutoModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

public class RestritoCaixa extends JFrame{
	private JTextField txtQuantidadevalor;


	public RestritoCaixa() {
		setUndecorated(true);
		setBounds(0, 0, 727, 561);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JTextField txtProcurarProduto = new JTextField();
		txtProcurarProduto.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		txtProcurarProduto.setBounds(53, 24, 212, 35);
		getContentPane().add(txtProcurarProduto);
		txtProcurarProduto.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblMarca.setBounds(12, 110, 83, 15);
		getContentPane().add(lblMarca);
		
		JLabel lblMarcabanco = new JLabel();
		lblMarcabanco.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblMarcabanco.setOpaque(false);
		lblMarcabanco.setBackground(Color.black);
		lblMarcabanco.setBounds(170, 110, 116, 15);
		getContentPane().add(lblMarcabanco);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblNome.setBounds(12, 160, 66, 15);
		getContentPane().add(lblNome);
		
		JLabel lblNomeBanco = new JLabel();
		lblNomeBanco.setBounds(170, 160, 116, 15);
		lblNomeBanco.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		getContentPane().add(lblNomeBanco);
		
		JLabel lblValor = new JLabel("Valor (Uni.)");
		lblValor.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblValor.setBounds(12, 210, 100, 15);
		getContentPane().add(lblValor);
		
		JLabel lblValorBanco = new JLabel();
		lblValorBanco.setOpaque(false);
		lblValorBanco.setBackground(Color.black);
		lblValorBanco.setBounds(170, 210, 116, 15);
		lblValorBanco.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		getContentPane().add(lblValorBanco);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblCodigo.setBounds(12, 264, 66, 15);
		getContentPane().add(lblCodigo);
		
		JLabel lblCodigobanco = new JLabel("");
		lblCodigobanco.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblCodigobanco.setBounds(170, 264, 116, 15);
		lblCodigobanco.setOpaque(false);
		lblCodigobanco.setBackground(Color.black);
		getContentPane().add(lblCodigobanco);
		
		JLabel lblSubTotalbanco = new JLabel();
		lblSubTotalbanco.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblSubTotalbanco.setBounds(170, 367, 116, 15);
		getContentPane().add(lblSubTotalbanco);
		
		JLabel lblPesquisar = new JLabel();	
		lblPesquisar.setBounds(273, 24, 30, 30);
		lblPesquisar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ProdutoModel produto = ProdutoController.selectByCode(txtProcurarProduto.getText());
				if(produto.getMarca() != "" && produto.getNomeProduto() != "" && produto.getQuantidade() != 0 && produto.getValor() != "" && produto.getCodigo() != "") {
					lblMarcabanco.setText(produto.getMarca());
					lblNomeBanco.setText(produto.getNomeProduto());
					lblValorBanco.setText("R$ "+String.format("%.1f", Double.parseDouble(produto.getValor())));
					lblCodigobanco.setText(produto.getCodigo());
					lblSubTotalbanco.setText("R$ "+String.format("%.1f", Double.valueOf(produto.getValor())));
				}
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		ImageIcon imgIcon = new ImageIcon("images/icons/search.png");
		Image img = imgIcon.getImage();
		Image newImg = img.getScaledInstance(lblPesquisar.getWidth(), lblPesquisar.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon newImgIcon = new ImageIcon(newImg);
		lblPesquisar.setIcon(newImgIcon);
		getContentPane().add(lblPesquisar);
		
		JLabel lblLimpar = new JLabel();
		lblLimpar.setBounds(143, 480, 50, 50);
		lblLimpar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblMarcabanco.setText("");
				lblNomeBanco.setText("");
				lblValorBanco.setText("");
				lblCodigobanco.setText("");
				txtProcurarProduto.setText("");
				txtQuantidadevalor.setText("1");
				lblSubTotalbanco.setText("");
			}
			
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		ImageIcon imgIcon3 = new ImageIcon("images/icons/cross-remove-sign.png");
		Image img3 = imgIcon3.getImage();
		Image newImg3 = img3.getScaledInstance(lblLimpar.getWidth(), lblLimpar.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon newImgIcon3 = new ImageIcon(newImg3);
		lblLimpar.setIcon(newImgIcon3);
		getContentPane().add(lblLimpar);
		
		JLabel lblAdicionar = new JLabel();
		lblAdicionar.setBounds(236, 480, 50, 50);
		ImageIcon imgIcon2 = new ImageIcon("images/icons/blackPlus.png");
		Image img2 = imgIcon2.getImage();
		Image newImg2 = img2.getScaledInstance(lblAdicionar.getWidth(), lblAdicionar.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon newImgIcon2 = new ImageIcon(newImg2);
		lblAdicionar.setIcon(newImgIcon2);
		getContentPane().add(lblAdicionar);
		
		JLabel lblX = new JLabel("X");
		lblX.setOpaque(true);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Ubuntu", Font.PLAIN, 21));
		lblX.setBackground(Color.RED);
		lblX.setBounds(697, 0, 30, 30);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new LoginForm();
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
		getContentPane().add(lblX);

		JLabel lblSubTotal = new JLabel("Subtotal");
		lblSubTotal.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblSubTotal.setBounds(12, 367, 100, 15);
		getContentPane().add(lblSubTotal);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblQuantidade.setBounds(12, 312, 100, 15);
		getContentPane().add(lblQuantidade);
		
		
		JLabel lblFundodireito = new JLabel();
		lblFundodireito.setOpaque(true);
		lblFundodireito.setBackground(UIManager.getColor("Button.background"));
		lblFundodireito.setBounds(320, 0, 407, 561);
		getContentPane().add(lblFundodireito);
		
		JLabel lblList = new JLabel();
		lblList.setBounds(8, 24, 35, 35);
		ImageIcon imgIcon4 = new ImageIcon("images/icons/list2.png");
		Image img4 = imgIcon4.getImage();
		Image newImg4 = img4.getScaledInstance(lblList.getWidth(), lblList.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon newImgIcon4 = new ImageIcon(newImg4);
		lblList.setIcon(newImgIcon4);
		lblList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarProdutos listarProdutos = new ListarProdutos();
				listarProdutos.criaJanela();
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
		getContentPane().add(lblList);
		
		
		JLabel lblMais = new JLabel();
		lblMais.setBounds(245, 314, 20, 20);
		imgIcon = new ImageIcon("images/icons/blackPlus.png");
		img = imgIcon.getImage();
		newImg = img.getScaledInstance(lblMais.getWidth(), lblMais.getHeight(), Image.SCALE_DEFAULT);
		newImgIcon = new ImageIcon(newImg);
		lblMais.setIcon(newImgIcon);
		lblMais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtQuantidadevalor.setText(String.valueOf(Integer.valueOf(txtQuantidadevalor.getText())+1));
				if(!(lblValorBanco.getText() == "")) {
					lblSubTotalbanco.setText("R$ "+String.valueOf(Double.parseDouble(lblValorBanco.getText().replace("R$ ", ""))*Double.parseDouble(txtQuantidadevalor.getText())));
				}
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
		getContentPane().add(lblMais);
		
		JLabel lblMenos = new JLabel();
		lblMenos.setBounds(283, 314, 20, 20);
		imgIcon = new ImageIcon("images/icons/minus.png");
		img = imgIcon.getImage();
		newImg = img.getScaledInstance(lblMenos.getWidth(), lblMenos.getHeight(), Image.SCALE_DEFAULT);
		newImgIcon = new ImageIcon(newImg);
		lblMenos.setIcon(newImgIcon);
		lblMenos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!(Integer.valueOf(txtQuantidadevalor.getText()) < 2)) {
					txtQuantidadevalor.setText(String.valueOf(Integer.valueOf(txtQuantidadevalor.getText())-1));
				}
				if(!(lblValorBanco.getText() == "")) {
					lblSubTotalbanco.setText("R$ "+String.valueOf(Double.parseDouble(lblValorBanco.getText().replace("R$ ", ""))*Double.parseDouble(txtQuantidadevalor.getText())));
				}
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
		getContentPane().add(lblMenos);
		
		JLabel fundo = new JLabel();
		fundo.setBounds(0,0, getWidth(), getHeight());
		fundo.setOpaque(true);
		fundo.setBackground(Color.white);
		
		txtQuantidadevalor = new JTextField();
		txtQuantidadevalor.setText("1");
		txtQuantidadevalor.setBounds(118, 312, 109, 22);
		getContentPane().add(txtQuantidadevalor);
		txtQuantidadevalor.setColumns(10);
		setVisible(true);
		
		getContentPane().add(fundo);
	}
}
