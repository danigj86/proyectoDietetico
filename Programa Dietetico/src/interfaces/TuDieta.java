package interfaces;

import javax.swing.JPanel;
import java.awt.Color;

import componentes.BotonMenu;
import componentes.MiLabel;
import principal.Plato;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TuDieta extends JPanel{
	
	private Ventana ventana;
	private Plato plato1;
	
	public Plato getPlato1() {
		return plato1;
	}


	public void setPlato1(Plato plato1) {
		this.plato1 = plato1;
	}
	
	
	public TuDieta(Ventana v) {
		
		super();
		this.ventana=v;
		setSize(500,500);
		setBackground(new Color(30, 144, 255));
		setLayout(null);
		
		MiLabel mlblTUD = new MiLabel("Bienvenido/a", 35);
		mlblTUD.setText(" T U  D I E T A  A C T U A L:");
		mlblTUD.setForeground(Color.WHITE);
		mlblTUD.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		mlblTUD.setBackground(new Color(30, 144, 255));
		mlblTUD.setBounds(24, 26, 387, 28);
		add(mlblTUD);
		
		JLabel lblDesayuno = new JLabel("DESAYUNO:");
		lblDesayuno.setForeground(Color.WHITE);
		lblDesayuno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDesayuno.setBounds(10, 83, 189, 14);
		add(lblDesayuno);
		
		JLabel lblAlmuerzo = new JLabel("ALMUERZO:");
		lblAlmuerzo.setForeground(Color.WHITE);
		lblAlmuerzo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlmuerzo.setBounds(10, 176, 189, 14);
		add(lblAlmuerzo);
		
		JLabel lblMerienda = new JLabel("MERIENDA:");
		lblMerienda.setForeground(Color.WHITE);
		lblMerienda.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMerienda.setBounds(10, 269, 189, 14);
		add(lblMerienda);
		
		JLabel lblCena = new JLabel("CENA:");
		lblCena.setForeground(Color.WHITE);
		lblCena.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCena.setBounds(10, 362, 189, 14);
		add(lblCena);
		
		
		JLabel desayunoAqui = new JLabel(ventana.getDietaUsuario().getPlato()[0].getNombre()+", calorías: "+ventana.getDietaUsuario().getPlato()[0].getCalorias()); //ventana.getDietaUsuario().getPlato()[0].getPlato(0)
		desayunoAqui.setVerticalAlignment(SwingConstants.TOP);
		desayunoAqui.setForeground(Color.WHITE);
		desayunoAqui.setFont(new Font("Tahoma", Font.BOLD, 11));
		desayunoAqui.setBounds(10, 108, 466, 57);
		add(desayunoAqui);
		
		JLabel almuerzoAqui = new JLabel(ventana.getDietaUsuario().getPlato()[1].getNombre()+", calorías: "+ventana.getDietaUsuario().getPlato()[1].getCalorias());
		almuerzoAqui.setVerticalAlignment(SwingConstants.TOP);
		almuerzoAqui.setForeground(Color.WHITE);
		almuerzoAqui.setFont(new Font("Tahoma", Font.BOLD, 11));
		almuerzoAqui.setBounds(10, 201, 466, 57);
		add(almuerzoAqui);
		
		JLabel meriendaAqui = new JLabel(ventana.getDietaUsuario().getPlato()[2].getNombre()+", calorías: "+ventana.getDietaUsuario().getPlato()[2].getCalorias());
		meriendaAqui.setVerticalAlignment(SwingConstants.TOP);
		meriendaAqui.setForeground(Color.WHITE);
		meriendaAqui.setFont(new Font("Tahoma", Font.BOLD, 11));
		meriendaAqui.setBounds(10, 294, 466, 57);
		add(meriendaAqui);
		
		JLabel cenaAqui = new JLabel(ventana.getDietaUsuario().getPlato()[3].getNombre()+", calorías: "+ventana.getDietaUsuario().getPlato()[3].getCalorias());
		cenaAqui.setVerticalAlignment(SwingConstants.TOP);
		cenaAqui.setForeground(Color.WHITE);
		cenaAqui.setFont(new Font("Tahoma", Font.BOLD, 11));
		cenaAqui.setBounds(10, 387, 466, 48);
		add(cenaAqui);
		
		
		BotonMenu botonAtras = new BotonMenu("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAEligeLoginRegistro();
			}
		});
		
		botonAtras.setBounds(373, 438, 89, 23);
		add(botonAtras);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\DAW\\Programacion\\Tercer trimestre\\PROYECTO FINAL\\dieta2.jpg"));
		lblNewLabel.setBounds(387, 7, 103, 73);
		add(lblNewLabel);
		
		
		
		setVisible(true);
	}




	
}
