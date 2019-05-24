package interfaces;
import javax.swing.JPanel;

import componentes.BotonMenu;
import componentes.MiLabel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.awt.Font;
import java.awt.Graphics;

import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class EligeLoginRegistro extends JPanel{
	private Ventana ventana;
	ImageIcon imagen;
	
	
	
	public EligeLoginRegistro(Ventana v, String nombre){
		super();
		this.ventana = v;
		
		imagen = new ImageIcon(getClass().getResource(nombre));//CODIGO IMAGEN PRIMERA FORMA
		setSize(imagen.getIconWidth(),imagen.getIconHeight());//CODIGO IMAGEN PRIMERA FORMA
		
		
		
		
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		
		
		
		setSize(new Dimension(500, 500));
		setBackground(new Color(30, 144, 255));
		setLayout(null);
		
		
		BotonMenu botonLogin = new BotonMenu("Login");
		botonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ventana.irACalculacalorias();
				ventana.irALogin();
			}
			
		});
		botonLogin.setBounds(182, 130, 145, 64);
		add(botonLogin);
		
		BotonMenu botonRegistro = new BotonMenu("Registro");
		
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irARegistro();
			}
		});
		
		botonRegistro.setBounds(182, 257, 145, 64);
		add(botonRegistro);
		
		MiLabel  lblBienvenidoa = new MiLabel("Bienvenido/a", 35);
		lblBienvenidoa.setBackground(new Color(30, 144, 255));
		lblBienvenidoa.setForeground(Color.WHITE);
		lblBienvenidoa.setFont(new Font("Broadway", Font.BOLD, 20));
		lblBienvenidoa.setText("P  R  O  G  R  A  M  A     D  I  E  T  E  T  I  C  O ");
		lblBienvenidoa.setBounds(10, 36, 480, 28);
		add(lblBienvenidoa);
		
		
		this.setVisible(true);
		
		
	}
	//CODIGO IMAGEN PRIMERA FORMA
	
	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(),0,0, d.width, d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
	
	
}
