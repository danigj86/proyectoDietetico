package interfaces;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import componentes.BotonMenu;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import componentes.MiLabel;
import excepciones.AlturaException;
import excepciones.ContraseñaException;
import excepciones.EdadException;
import excepciones.NombreException;
import principal.Usuario;

import java.awt.Font;
import java.awt.Graphics;

public class Registro extends JPanel{
	
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoEdad;
	private JTextField campoAltura;
	private JPasswordField campoContrasenia;
	private JButton botonAtras2;
	private JPasswordField campoContrasenia2;
	private Usuario usuario;
	ImageIcon imagen;
	
	public Registro (Ventana v, String nombre) {
		super();
		
		
		this.ventana=v;
		setSize(500,500);
		setBackground(new Color(30, 144, 255));
		imagen = new ImageIcon(getClass().getResource(nombre));//CODIGO IMAGEN PRIMERA FORMA
		setSize(imagen.getIconWidth(),imagen.getIconHeight());//CODIGO IMAGEN PRIMERA FORMA
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(105, 64, 62, 14);
		add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Edad:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(105, 108, 46, 14);
		add(lblEmail);
		
		JLabel lblFechaNacimiento = new JLabel("Altura:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaNacimiento.setForeground(new Color(255, 255, 255));
		lblFechaNacimiento.setBounds(105, 152, 94, 14);
		add(lblFechaNacimiento);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasea.setBounds(105, 200, 94, 14);
		add(lblContrasea);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(236, 61, 86, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		campoEdad = new JTextField();
		campoEdad.setBounds(236, 105, 86, 20);
		add(campoEdad);
		campoEdad.setColumns(10);
		
		campoAltura = new JTextField();
		campoAltura.setBounds(236, 149, 86, 20);
		add(campoAltura);
		campoAltura.setColumns(10);
		
		campoContrasenia = new JPasswordField();
		campoContrasenia.setBounds(236, 197, 86, 20);
		add(campoContrasenia);
		
		botonAtras2 = new BotonMenu("Atrás");
		botonAtras2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonAtras2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAEligeLoginRegistro();
			}
		});
		botonAtras2.setBounds(287, 306, 89, 23);
		add(botonAtras2);
		
		BotonMenu botonRegistrar = new BotonMenu("Registrar");
		botonRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String nombre = campoNombre.getText();
		        String pass = campoContrasenia.getText();
		        String repPass = campoContrasenia2.getText();
		        String altura1 = campoAltura.getText();//PONGO EL VALOR TIPO STRING PARA PODER VER SI ESTA VACIO
		        String edad1 = campoEdad.getText(); //PONGO EL VALOR TIPO STRING PARA PODER VER SI ESTA VACIO
		        int altura = Integer.parseInt(campoAltura.getText()); //AHORA LO CONVIERTO EN INT
		        int edad = Integer.parseInt(campoEdad.getText());
		        
				
			        if (nombre.isEmpty() || pass.isEmpty() || repPass.isEmpty() || altura1.isEmpty()||edad1.isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Alguno de los campos está vacío.");
			        }else{
			            if (!pass.equals(repPass)) {
			            JOptionPane.showMessageDialog(null, "Las contraseñas deben coincidir.");
			        }else{
			              
			                
			                JOptionPane.showMessageDialog(null, "Registro efectuado correctamente.","Atención", JOptionPane.INFORMATION_MESSAGE);
			                
			              
			                
			                try {
			                	ventana.setUsuario(new Usuario(nombre, pass,altura, edad));
								ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
								//usamos
								PreparedStatement smt =
								ventana.getCon().prepareStatement("insert into datos_usuario1 values(?,?,?,?)");
								
								smt.setString(1, nombre);
								smt.setString(2, pass);
								smt.setInt(3, altura);
								smt.setInt(4, edad);
								
								
								smt.executeUpdate();
								ventana.getCon().close();
								ventana.irACalculacalorias();
			                }catch (SQLIntegrityConstraintViolationException iex){
								JOptionPane.showMessageDialog(ventana, "El nombre de usuario ya está registrado","Nombre de usuario inválido", JOptionPane.ERROR_MESSAGE);
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}catch (ContraseñaException e2) {
								 //JOptionPane.showMessageDialog(ventana, "La contraseña debe tener al menos 8 caracteres", "Password incorrecto", JOptionPane.ERROR_MESSAGE);
									//e2.printStackTrace();
							}catch(NombreException e3) {
								JOptionPane.showMessageDialog(ventana, "El nombre debe tener al menos 8 caracteres", "Nombre incorrecto", JOptionPane.ERROR_MESSAGE);
								//e3.printStackTrace();
							}catch(AlturaException e4) {
								JOptionPane.showMessageDialog(ventana, "La altura es incorrecta", "Altura incorrecta", JOptionPane.ERROR_MESSAGE);
								//e4.printStackTrace();
							}catch(EdadException e5) {
								JOptionPane.showMessageDialog(ventana, "La edad es incorrecta", "Edad incorrecta", JOptionPane.ERROR_MESSAGE);
								//e5.printStackTrace();
							}
							
							
			        }
			        }

			           
	
			}});
		
		botonRegistrar.setBounds(110, 306, 89, 23);
		add(botonRegistrar);
		
		MiLabel mlblREG = new MiLabel("Bienvenido/a", 35);
		mlblREG.setText("R E G I S T R O    U S U A R I O");
		mlblREG.setForeground(Color.WHITE);
		mlblREG.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		mlblREG.setBackground(new Color(30, 144, 255));
		mlblREG.setBounds(10, 11, 459, 28);
		add(mlblREG);
		
		JLabel lblContrasea_1 = new JLabel("Contrase\u00F1a 2:");
		lblContrasea_1.setForeground(Color.WHITE);
		lblContrasea_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasea_1.setBounds(105, 243, 94, 14);
		add(lblContrasea_1);
		
		campoContrasenia2 = new JPasswordField();
		campoContrasenia2.setBounds(236, 241, 86, 20);
		add(campoContrasenia2);
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
