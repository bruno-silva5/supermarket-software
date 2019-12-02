package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.ProdutoController;
import Model.ProdutoModel;

import javax.swing.JTextField;

import java.awt.Font;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AtualizarProduto extends JFrame{
	
	JTextField txtMarca = new JTextField();
	JTextField txtNomeproduto = new JTextField();
	JTextField txtValor = new JTextField();
	JTextField quantidade = new JTextField();
	JTextField txtCodigo = new JTextField();
	int id;
	
	public AtualizarProduto(ProdutoModel produtoModel) {
		id = produtoModel.getId();
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 366, 548);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblAtualizarProduto = new JLabel("Atualizar Produto");
		lblAtualizarProduto.setFont(new Font("Arial", Font.PLAIN, 26));
		lblAtualizarProduto.setForeground(new Color(53,152,220));
		lblAtualizarProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarProduto.setBounds(0, 12, 366, 51);
		getContentPane().add(lblAtualizarProduto);
		
		JLabel lblR = new JLabel("R$");
		lblR.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblR.setOpaque(true);
		lblR.setBackground(Color.WHITE);
		lblR.setBounds(12, 273, 43, 28);
		getContentPane().add(lblR);
		
		
		txtMarca.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMarca.setBounds(12, 102, 342, 37);
		txtMarca.addKeyListener(new KeyAdapter() {
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
		getContentPane().add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMarca.setForeground(new Color(122,122,122));
		lblMarca.setBounds(10, 75, 66, 15);
		getContentPane().add(lblMarca);
		
		quantidade.setFont(new Font("Arial", Font.PLAIN, 16));
		quantidade.setBounds(12, 345, 342, 37);
		quantidade.addKeyListener(new KeyAdapter() {
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
		getContentPane().add(quantidade);
		
		JLabel lblNomeProduto = new JLabel("Nome do produto");
		lblNomeProduto.setForeground(new Color(122,122,122));
		lblNomeProduto.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNomeProduto.setBounds(10, 159, 174, 15);
		getContentPane().add(lblNomeProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 15));
		lblQuantidade.setForeground(new Color(122,122,122));
		lblQuantidade.setBounds(12, 321, 172, 15);
		getContentPane().add(lblQuantidade);
		
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
		lblCancelar.setBounds(57, 492, 100, 35);
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
		lblAtualizar.setBounds(197, 492, 100, 35);
		getContentPane().add(lblAtualizar);
		
		
		JLabel lblValor = new JLabel("Valor\n");
		lblValor.setForeground(new Color(122, 122, 122));
		lblValor.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblValor.setBounds(12, 240, 174, 15);
		getContentPane().add(lblValor);
		
		
		txtNomeproduto.setBounds(12, 186, 342, 42);
		txtNomeproduto.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtNomeproduto.addKeyListener(new KeyAdapter() {
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
		getContentPane().add(txtNomeproduto);
		txtNomeproduto.setColumns(10);
		
		
		txtValor.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtValor.setBounds(57, 267, 297, 42);
		txtValor.addKeyListener(new KeyAdapter() {
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
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setForeground(new Color(122, 122, 122));
		lblCodigo.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCodigo.setBounds(12, 394, 172, 15);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtCodigo.addKeyListener(new KeyAdapter() {
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
		txtCodigo.setBounds(12, 417, 342, 37);
		getContentPane().add(txtCodigo);
		
		txtMarca.setText(produtoModel.getMarca());
		txtNomeproduto.setText(produtoModel.getNomeProduto());
		txtValor.setText(produtoModel.getValor());
		txtCodigo.setText(produtoModel.getCodigo());
		quantidade.setText(produtoModel.getQuantidade()+"");
		setVisible(true);
		
	}
	
	private void cadastrar() {
		if(!(txtMarca.getText().equals("") || txtNomeproduto.getText().equals("") || quantidade.getText().equals("") || txtValor.getText().equals(""))) {
			try {
				ProdutoModel produtoModel = new ProdutoModel();
				produtoModel.setId(id);
				produtoModel.setMarca(txtMarca.getText());
				produtoModel.setNomeProduto(txtNomeproduto.getText());
				produtoModel.setQuantidade(Integer.valueOf(quantidade.getText()));
				produtoModel.setValor(txtValor.getText());
				produtoModel.setCodigo(txtCodigo.getText());
					
				if (ProdutoController.update(produtoModel)) {
					txtMarca.setText("");
					txtNomeproduto.setText("");
					quantidade.setText("1");
					txtValor.setText("");
					txtCodigo.setText("");
					setVisible(false);
				}
				
			} catch (Exception e2) {
				new TelaDialago(0,"Insira dados válidos!");
			}
		}else {
			new TelaDialago(2,"É obrigatório preencher todos os campos!");
		}
	}
}
