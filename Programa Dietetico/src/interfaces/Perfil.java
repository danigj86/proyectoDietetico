package interfaces;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import componentes.MiLabel;
import excepciones.FechaException;
import principal.Dieta;
import principal.Plato;
import principal.Usuario;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import componentes.BotonMenu;

public class Perfil extends JPanel {
	private Ventana ventana;
	ImageIcon imagen;
	
	
	
	public Perfil(Ventana v, String nombre) {
		
		super();
		setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.ventana=v;
		setSize(500,500);
		
		imagen = new ImageIcon(getClass().getResource(nombre));//CODIGO IMAGEN PRIMERA FORMA
		setSize(imagen.getIconWidth(),imagen.getIconHeight());//CODIGO IMAGEN PRIMERA FORMA
		
		setBackground(new Color(30, 144, 255));
		setLayout(null);
		
		MiLabel mlblPER = new MiLabel("Bienvenido/a", 35);
		mlblPER.setText("P E R F I L ");
		mlblPER.setForeground(Color.WHITE);
		mlblPER.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		mlblPER.setBackground(new Color(30, 144, 255));
		mlblPER.setBounds(45, 34, 387, 28);
		add(mlblPER);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(38, 114, 61, 14);
		add(lblUsuario);
		
		JLabel lblCaloriasMantenimiento = new JLabel("CALORIAS");
		lblCaloriasMantenimiento.setForeground(Color.WHITE);
		lblCaloriasMantenimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCaloriasMantenimiento.setBounds(38, 156, 103, 14);
		add(lblCaloriasMantenimiento);
		
		JLabel lblMantenimineto = new JLabel("MANTENIMINETO:");
		lblMantenimineto.setForeground(Color.WHITE);
		lblMantenimineto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMantenimineto.setBounds(38, 197, 103, 14);
		add(lblMantenimineto);
		
		JLabel lblPerderPeso = new JLabel("PERDER PESO:");
		lblPerderPeso.setForeground(Color.WHITE);
		lblPerderPeso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPerderPeso.setBounds(38, 235, 103, 14);
		add(lblPerderPeso);
		
		JLabel lblGanarPeso = new JLabel("GANAR PESO:");
		lblGanarPeso.setForeground(Color.WHITE);
		lblGanarPeso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGanarPeso.setBounds(38, 279, 103, 14);
		add(lblGanarPeso);
		
		
		JLabel cMantener = new JLabel(ventana.getUsuario().getCaloriasMantener()+"");
		cMantener.setForeground(Color.WHITE);
		cMantener.setFont(new Font("Tahoma", Font.BOLD, 11));
		cMantener.setBounds(152, 197, 144, 14);
		add(cMantener);
		
		JLabel cPerder = new JLabel(ventana.getUsuario().getCaloriasPerder()+"");
		cPerder.setForeground(Color.WHITE);
		cPerder.setFont(new Font("Tahoma", Font.BOLD, 11));
		cPerder.setBounds(152, 235, 144, 14);
		add(cPerder);
					
		JLabel cGanar = new JLabel(ventana.getUsuario().getCaloriasGanar()+" ");
		cGanar.setForeground(Color.WHITE);
		cGanar.setFont(new Font("Tahoma", Font.BOLD, 11));
		cGanar.setBounds(152, 279, 144, 14);
		add(cGanar);
		
		JLabel nombreUsuario = new JLabel (ventana.getUsuario().getNombre());
		nombreUsuario.setForeground(Color.WHITE);
		nombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		nombreUsuario.setBounds(152, 114, 144, 14);
		add(nombreUsuario);
		
		BotonMenu botonAtras = new BotonMenu("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAEligeLoginRegistro();
			}
		});
		
		botonAtras.setBounds(380, 392, 89, 23);
		add(botonAtras);
		
		BotonMenu botonNuevaDieta = new BotonMenu("Nueva Dieta");
		botonNuevaDieta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irADiseñaDieta();
			}
		});
		botonNuevaDieta.setText("Nueva Dieta");
		botonNuevaDieta.setBounds(57, 325, 133, 34);
		add(botonNuevaDieta);
		
		BotonMenu botonDietaActual = new BotonMenu("Dieta Actual");
		botonDietaActual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					
					ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));//CONECTAMOS A LA BASE DE DATOS
					
					Statement smt = ventana.getCon().createStatement(); //smt para los datos del usuario
					
					ResultSet rs = smt.executeQuery("select * from dieta where nombre_usu ='"+ventana.getUsuario().getNombre()+"'");
					
					
					
					if (rs.next()) {
						
						String nombre_dieta = rs.getString("nombre_dieta");
						String desayuno = rs.getString("desayuno");
						String almuerzo = rs.getString("almuerzo");
						String merienda = rs.getString("merienda");
						String cena = rs.getString("cena");
						//las fecha no las pongo xq no las voy a usar
						System.out.println(desayuno + almuerzo+ merienda+ cena);
						ventana.setDietaUsuario(new Dieta(desayuno, almuerzo, merienda, cena));
						/*
						 OTRA FORMA:
						 
						 ventana.getDietaUsuario().setAlmuerzo(rs.getString("desayuno"));
						 ...
						 ...
						 ASI CON LOS VALORES QUE QUIERO OBTENER, SIN NECESIDAD DE CREAR EL OBJETO DIETA
						 */
					}
					
				
					
		
					ventana.getCon().close();
					
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(ventana, "Error","Error", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
				
				
				ventana.irATuDieta();
			}
		});
		botonDietaActual.setText("Dieta Actual");
		botonDietaActual.setBounds(283, 325, 133, 34);
		add(botonDietaActual);
		
	
		setVisible(true);
	}
	
	//CODIGO IMAGEN PRIMERA FORMA
	
	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(imagen.getImage(),0,0, d.width, d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
    }
}
