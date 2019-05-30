package interfaces;
import javax.swing.JPanel;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import clases.ContraseñaCortaException;
import principal.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import componentes.BotonMenu;
import componentes.MiLabel;
import excepciones.AlturaException;
import excepciones.ContraseñaException;
import excepciones.EdadException;
import excepciones.NombreException;

import java.awt.Font;
import java.awt.Graphics;

public class Login extends JPanel {
	private JTextField campoUsuario;
	private JPasswordField campoContrasenia;
	private Ventana ventana;
	ImageIcon imagen;
	
	public Login(Ventana v, String nombre) {
        super();
        this.ventana = v;
		setSize(120,10);
		setBackground(new Color(30, 144, 255));
		imagen = new ImageIcon(getClass().getResource(nombre));//CODIGO IMAGEN PRIMERA FORMA
		setSize(imagen.getIconWidth(),imagen.getIconHeight());//CODIGO IMAGEN PRIMERA FORMA
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(50, 122, 79, 14);
		add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasea.setBounds(50, 181, 79, 14);  
		add(lblContrasea);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(139, 119, 86, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoContrasenia = new JPasswordField();
		campoContrasenia.setBounds(139, 178, 86, 20);
		add(campoContrasenia);
		campoContrasenia.setColumns(10);
		
		BotonMenu botonLogin = new BotonMenu("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				String usuario = campoUsuario.getText();
				String contrasenia = String.copyValueOf(campoContrasenia.getPassword());
				
				try {
					
					ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));//CONECTAMOS A LA BASE DE DATOS
					
					//AHORA USAMOS LA BASE DE DATOS
					
					Statement smt = ventana.getCon().createStatement(); //smt para los datos del usuario
					Statement smt2=ventana.getCon().createStatement();  //smt para calorias mantener 
					Statement smt3=ventana.getCon().createStatement();  //smt para calorias perder 
					Statement smt4=ventana.getCon().createStatement();  //smt para calorias ganar
					
					//ESTE CODIGO ES PARA LLAMAR A LOS DATOS DE LA TABLA DATOS_USUARIOS1
					ResultSet rs = smt.executeQuery("select * from datos_usuario1 where usuario ='"+usuario+"' and pass = '"+contrasenia+"'");//AQUI SOLO PONEMOS LOS CAMPOS QUE ESTAMOS BUSCANDO PARA HACER LOGIN
					if (rs.next()) {
						//AQUI PONEMOS EL RESTO DE CAMPOS
						int altura = rs.getInt("altura");
						int edad = rs.getInt("edad");
						ventana.setUsuario(new Usuario(usuario, contrasenia, altura, edad));
					}
					
				   		
					//ESTE CODIGO ES PARA QUE APAREZCAN CALORIAS MANTENER, YA QUE ESTAN GUARDADAS EN OTRA TABLA	
					ResultSet rs2 = smt2.executeQuery("select * from calorias where nombre ='"+ventana.getUsuario().getNombre()+"'");
					System.out.println("select * from calorias where nombre ='"+ventana.getUsuario().getNombre()+"'");
					if(rs2.next()) {
						
						ventana.getUsuario().setCaloriasMantener(rs2.getFloat("c_mantener"));
						
					   }
					
					//ESTE PARA CALORIAS PERDER
					 ResultSet rs3 = smt3.executeQuery("select * from calorias where nombre ='"+ventana.getUsuario().getNombre()+"'");
					   System.out.println("select * from calorias where nombre ='"+ventana.getUsuario().getNombre()+"'");
					   if(rs3.next()) {
								
						ventana.getUsuario().setCaloriasPerder(rs3.getFloat("c_perder"));
									
						}
					//ESTE PARA CALORIAS GANAR   
				   ResultSet rs4 = smt4.executeQuery("select * from calorias where nombre ='"+ventana.getUsuario().getNombre()+"'");
				   System.out.println("select * from calorias where nombre ='"+ventana.getUsuario().getNombre()+"'");
				   if(rs4.next()) {
							
					   ventana.getUsuario().setCaloriasGanar(rs4.getFloat("c_ganar"));
						
						ventana.irAPerfil();
					}else {
						JOptionPane.showMessageDialog(ventana, "Contraseña incorrecta","Contraseña incorrecta", JOptionPane.ERROR_MESSAGE);
					}
		
					ventana.getCon().close();
					
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(ventana, "Usuario no encontrado","Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				} /*catch (ContraseñaCortaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */ catch (NombreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ContraseñaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AlturaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (EdadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonLogin.setBounds(139, 235, 89, 23);
		add(botonLogin);
		
		BotonMenu botonAtras = new BotonMenu("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAEligeLoginRegistro();
			}
		});
		botonAtras.setBounds(136, 279, 89, 23);
		add(botonAtras);
		
		MiLabel mlblLOG = new MiLabel("Bienvenido/a", 35);
		mlblLOG.setText("L O G I N   U S U A R I O");
		mlblLOG.setForeground(Color.WHITE);
		mlblLOG.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		mlblLOG.setBackground(new Color(30, 144, 255));
		mlblLOG.setBounds(10, 25, 459, 28);
		add(mlblLOG);
		
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
