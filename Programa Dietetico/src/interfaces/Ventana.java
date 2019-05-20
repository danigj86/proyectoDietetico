package interfaces;
import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

import clases.Usuario;
import principal.Dieta;
import principal.Plato;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Ventana extends JFrame{

	private EligeLoginRegistro elr;
	private Login login;
	private Registro registro;
	private Usuario usuario;
	private Dieta dietaUsuario;
	private CalculaCalorias calCa;
	private Perfil perfil;
	private DiseñaDieta diseñaDieta;
	private TuDieta tuDieta;
	private Plato plato;
	private Connection con;
	private  final HashMap<String,HashMap<Integer,Plato>> todosLosPlatos;
	
	
	
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	/**
	 * @return the todosLosPlatos
	 */
	public HashMap<String, HashMap<Integer, Plato>> getTodosLosPlatos() {
		return todosLosPlatos;
	}

	/**
	 * @return the dietaUsuario
	 */
	public Dieta getDietaUsuario() {
		return dietaUsuario;
	}

	/**
	 * @param dietaUsuario the dietaUsuario to set
	 */
	public void setDietaUsuario(Dieta dietaUsuario) {
		this.dietaUsuario = dietaUsuario;
	}

	
	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ventana(HashMap<String,HashMap<Integer,Plato>> todos) {
		super();
		this.todosLosPlatos=todos;
		elr = new EligeLoginRegistro(this,"fondo.jpg");
		this.setTitle("Programa dietético");
		this.setSize(500, 500);
		this.setContentPane(elr);
		this.setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/interfaces/icono.JPG")).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setVisible(true);
	
	}
	
	public void irALogin() {
		//1- Inicializar login, si no lo está ya
		if (login==null) {
			this.login = new Login(this,"fondoazul2.jpg");
		}
		//2- Hacer invisible las ventanas anteriores
		elr.setVisible(false);
		
		//3- Establecer el contentPane a esta nueva pantalla
		this.setContentPane(login);
		this.login.setVisible(true);
		
	}
	
	public void irARegistro() {
		if (registro==null) {
			this.registro= new Registro(this,"fondoazul2.jpg");
			
		}
		elr.setVisible(false);
		this.setContentPane(registro);
		this.registro.setVisible(true);
	}
		
	
	
	public void irAEligeLoginRegistro() {
		if (elr==null) {
			this.elr= new EligeLoginRegistro(this,"fondo.jpg");
			
		}
		if(login!=null) {
			login.setVisible(false);}
		this.setContentPane(elr);
		this.elr.setVisible(true);
	}
	
	public void irACalculacalorias() {
		if (calCa==null) {
			this.calCa= new CalculaCalorias(this,"fondo.jpg");
			
		}
		if(registro!=null) {
			registro.setVisible(false);}
		this.setContentPane(calCa);
		this.calCa.setVisible(true);
	}
	
	public void irAPerfil() {
		if (perfil==null) {
			this.perfil= new Perfil(this);
			
		}
		if(calCa!=null) {
			calCa.setVisible(false);}
		if(login!=null) {
			login.setVisible(false);}
		this.setContentPane(perfil);
		this.perfil.setVisible(true);
	}
	
	public void irADiseñaDieta() {
		if (diseñaDieta==null) {
			this.diseñaDieta= new DiseñaDieta(this);
			
		}
		if(this!=null) {
			perfil.setVisible(false);}
		this.setContentPane(diseñaDieta);
		this.diseñaDieta.setVisible(true);
	}
	
	public void irATuDieta() {
		if (tuDieta==null) {
			this.tuDieta= new TuDieta(this);
			
		}
		if(diseñaDieta!=null) {
			diseñaDieta.setVisible(false);}
		
		
		if(perfil!=null) {
			perfil.setVisible(false);}
		
		this.setContentPane(tuDieta);
		this.tuDieta.setVisible(true);
	}
	
	
}
