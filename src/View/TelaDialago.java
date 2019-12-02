package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaDialago extends JFrame implements KeyListener {

	public TelaDialago(int indice, String mensagem) {
		setUndecorated(true);
		setSize(400,170);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblFundo = new JLabel();
		lblFundo.setOpaque(true);
		lblFundo.setBackground(Color.WHITE);
		lblFundo.setBounds(0, 0, 400, 200);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Ubuntu", Font.PLAIN, 21));
		lblX.setForeground(Color.WHITE);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setOpaque(true);
		lblX.setBackground(Color.red);
		lblX.setBounds(370, 0, 30, 30);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
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
				
		
		
		
		JLabel lblOk = new JLabel("OK");
		lblOk.setHorizontalAlignment(SwingConstants.CENTER);
		lblOk.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		lblOk.setForeground(Color.WHITE);
		lblOk.setOpaque(true);
		lblOk.setBackground(new Color(53, 152, 220));
		lblOk.setBounds(150, 130, 100, 28);
		lblOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
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
		getContentPane().add(lblOk);

		if(indice == 1) {
			JLabel lblTextoParaTeste = new JLabel("<html>"+mensagem+"</html>");
			lblTextoParaTeste.setFont(new Font("Ubuntu", Font.PLAIN, 18));
			lblTextoParaTeste.setBounds(163, 44, 199, 57);
			getContentPane().add(lblTextoParaTeste);
			
			JLabel lblCheckmark = new JLabel();
			lblCheckmark.setBounds(-8, 0, 200, 150);
			getContentPane().add(lblCheckmark);
			ImageIcon imgIcon = new ImageIcon("images/icons/checkmark.gif");
			Image img = imgIcon.getImage();
			Image newImg = img.getScaledInstance(lblCheckmark.getWidth(), lblCheckmark.getHeight(), Image.SCALE_DEFAULT);
			ImageIcon newImgIcon = new ImageIcon(newImg);
			lblCheckmark.setIcon(newImgIcon);			
		}
		
		
		
		if(indice == 0) {
			JLabel lblTextoParaTeste = new JLabel("<html>"+mensagem+"</html>");
			lblTextoParaTeste.setFont(new Font("Ubuntu", Font.PLAIN, 18));
			lblTextoParaTeste.setBounds(160, 41, 199, 57);
			getContentPane().add(lblTextoParaTeste);
			
			JLabel lblError = new JLabel();
			lblError.setBounds(50, 37, 70, 70);
			getContentPane().add(lblError);
			ImageIcon imgIcon = new ImageIcon("images/icons/error.png");
			Image img = imgIcon.getImage();
			Image newImg = img.getScaledInstance(lblError.getWidth(), lblError.getHeight(), Image.SCALE_DEFAULT);
			ImageIcon newImgIcon = new ImageIcon(newImg);
			lblError.setIcon(newImgIcon);
		}

		if(indice == 2) {
		JLabel lblTextoParaTeste = new JLabel("<html>"+mensagem+"</html>");
		lblTextoParaTeste.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		lblTextoParaTeste.setBounds(161, 30, 199, 87);
		getContentPane().add(lblTextoParaTeste);
		
		JLabel lblError = new JLabel();
		lblError.setBounds(50, 40, 70, 70);
		getContentPane().add(lblError);
		ImageIcon imgIcon = new ImageIcon("images/icons/warning.png");
		Image img = imgIcon.getImage();
		Image newImg = img.getScaledInstance(lblError.getWidth(), lblError.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon newImgIcon = new ImageIcon(newImg);
		lblError.setIcon(newImgIcon);
		}
		
		getContentPane().add(lblFundo);
		addKeyListener(this);
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			setVisible(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			setVisible(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
