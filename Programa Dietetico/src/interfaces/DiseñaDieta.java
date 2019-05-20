package interfaces;

import javax.swing.JPanel;
import java.awt.Color;

import componentes.BotonMenu;
import componentes.MiLabel;
import principal.Dieta;
import principal.Plato;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DiseñaDieta extends JPanel{
	
	
	private Ventana ventana;
	private Plato plato;
	private JTextField nombreDieta;
	private JTextField fechaIInicio;
	private JTextField fechaFin;
	
	
	
	
	public DiseñaDieta(Ventana v) {
		super();
		this.ventana=v;
		setSize(500,500);
		setBackground(new Color(30, 144, 255));
		setLayout(null);
		
		MiLabel mlblDIS = new MiLabel("Bienvenido/a", 35);
		mlblDIS.setText("D I S E \u00D1 A  T U  D I E T A ");
		mlblDIS.setForeground(Color.WHITE);
		mlblDIS.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		mlblDIS.setBackground(new Color(30, 144, 255));
		mlblDIS.setBounds(51, 22, 387, 28);
		add(mlblDIS);
		
		JLabel lblEligeTuObjetivo = new JLabel("ELIGE TU OBJETIVO DE PESO:");
		lblEligeTuObjetivo.setForeground(Color.WHITE);
		lblEligeTuObjetivo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEligeTuObjetivo.setBounds(51, 129, 257, 14);
		add(lblEligeTuObjetivo);
		
		ButtonGroup objetivo= new ButtonGroup();
		JRadioButton botonMantener = new JRadioButton("Mantener ");
		botonMantener.setBounds(20, 178, 109, 23);
		objetivo.add(botonMantener);
		add(botonMantener);
		
		JRadioButton botonPerder = new JRadioButton("Perder");
		botonPerder.setBounds(158, 178, 109, 23);
		objetivo.add(botonPerder);
		add(botonPerder);
		
		JRadioButton botonGanar = new JRadioButton("Ganar");
		botonGanar.setBounds(298, 178, 109, 23);
		objetivo.add(botonGanar);
		add(botonGanar);
		
		JLabel lblEligeTuAlimento = new JLabel("ELIGE TU ALIMENTO BASE:");
		lblEligeTuAlimento.setForeground(Color.WHITE);
		lblEligeTuAlimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEligeTuAlimento.setBounds(51, 232, 257, 14);
		add(lblEligeTuAlimento);
		
		
		ButtonGroup alimentoBase= new ButtonGroup();
		JRadioButton rdbtnArroz = new JRadioButton("Arroz");
		rdbtnArroz.setBounds(20, 281, 109, 23);
		alimentoBase.add(rdbtnArroz);
		add(rdbtnArroz);
		
		JRadioButton rdbtnPasta = new JRadioButton("Pasta");
		rdbtnPasta.setBounds(20, 324, 109, 23);
		alimentoBase.add(rdbtnPasta);
		add(rdbtnPasta);
		
		JRadioButton rdbtnLechuga = new JRadioButton("Lechuga");
		rdbtnLechuga.setBounds(158, 281, 109, 23);
		alimentoBase.add(rdbtnLechuga);
		add(rdbtnLechuga);
		
		JRadioButton rdbtnPatata = new JRadioButton("Patata");
		rdbtnPatata.setBounds(158, 324, 109, 23);
		alimentoBase.add(rdbtnPatata);
		add(rdbtnPatata);
		
		BotonMenu botonAtras = new BotonMenu("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAEligeLoginRegistro();
			}
		});
		
		botonAtras.setBounds(376, 430, 89, 23);
		add(botonAtras);
		
		BotonMenu botonCrearDieta = new BotonMenu("Crear Dieta");
		botonCrearDieta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				///Primero mira objetivo, comn eso guarda variable de calorias objetivo
				//Después coge el alimento base y entre ellos, el plato que más calorias tenga sin pasarse de las objetivo
				
				
				//A partir de todoslosPlatos seleccionar los que te convengan
				//Los que te convienen los metes en dieta
				LocalDate hoy = LocalDate.now();
		 		LocalDate mañana = LocalDate.now();
		 		//Plato [] platoo = {ventana.setPlato(pastaAtun), ventana.getTodosLosPlatos().get("arroz").
		 		/*
		 		}
				 - DEPENDIENDO DEL OBJETIVO Y DEL ALIMENTO BASE, HACER VARIOS IF, DONDE SE SELECIONA EL PLATO ADECUADO
				 - CUANDO YA TENGO CLARO LOS PLATOS, CREAR UN OBJETO Dieta. ESTE OBJETO HABRA QUE GUARDARLO EN LA BASE DE DATOS EN UNA NUEVA TABLA
				 - CUANDO LA DIETA ESTÁ CREADA, HACER QUE APAREZCA EN EL PANEL TuDieta 
				 
				 
				 */
				
				if(rdbtnPasta.isSelected() && botonPerder.isSelected()) {
					Set<Integer> platosPasta=ventana.getTodosLosPlatos().get("pasta").keySet(); //obtienes todas las calorias de todos los platos de pasta
					Iterator it=platosPasta.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
						
						
					}
					//CREAR UNA DIETA CON LOS PLATOS DE PASTA QUE TENGAN MENOS CALORIAS
					
					//ventana.setDietaUsuario(new Dieta("Adelgazar con pasta",new Plato(ventana.setPlato(pastaConTomate),ventana.setPlato(pastaConBesugo),ventana.setPlato(pastaConEspinaca),ventana.setPlato(pastaConMerluza)),hoy,mañana));
					//ventana.setDietaUsuario(new Dieta("Adelgazar con pasta",platosPasta.,hoy,mañana));

				}
				if (rdbtnArroz.isSelected()&& botonPerder.isSelected()) {
					Set<Integer> platosArroz=ventana.getTodosLosPlatos().get("arroz").keySet(); //obtienes todas las calorias de todos los platos de arroz
					Iterator it=platosArroz.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					//CREAR UNA DIETA CON LOS PLATOS DE ARROZ QUE TENGAN MENOS CALORIAS
				}
				if (rdbtnPatata.isSelected()&& botonPerder.isSelected()) {
					Set<Integer> platosPatata=ventana.getTodosLosPlatos().get("patata").keySet(); //obtienes todas las calorias de todos los platos de patata
					Iterator it=platosPatata.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					//CREAR UNA DIETA CON LOS PLATOS DE PATATA QUE TENGAN MENOS CALORIAS
				}
				
				if (rdbtnLechuga.isSelected()&& botonPerder.isSelected()) {
					Set<Integer> platosLechuga=ventana.getTodosLosPlatos().get("lechuga").keySet(); //obtienes todas las calorias de todos los platos de lechuga
					Iterator it=platosLechuga.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					//CREAR UNA DIETA CON LOS PLATOS DE LECHUGA QUE TENGAN MENOS CALORIAS
				}
				//ventana.setDietaUsuario(new Dieta(...));
			
				ventana.irATuDieta();
			}
		});
		botonCrearDieta.setText("Crear Dieta");
		botonCrearDieta.setBounds(336, 377, 142, 42);
		add(botonCrearDieta);
		
		JLabel lblNombreDeTu = new JLabel("NOMBRE DE TU DIETA:");
		lblNombreDeTu.setForeground(Color.WHITE);
		lblNombreDeTu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDeTu.setBounds(51, 90, 189, 14);
		add(lblNombreDeTu);
		
		nombreDieta = new JTextField();
		nombreDieta.setBounds(250, 84, 168, 20);
		add(nombreDieta);
		nombreDieta.setColumns(10);
		
		JLabel lblFechaDeInicio = new JLabel("FECHA DE INICIO:");
		lblFechaDeInicio.setForeground(Color.WHITE);
		lblFechaDeInicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaDeInicio.setBounds(21, 373, 142, 14);
		add(lblFechaDeInicio);
		
		JLabel lblFecha = new JLabel("FECHA FIN :");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(20, 405, 142, 14);
		add(lblFecha);
		
		fechaIInicio = new JTextField();
		fechaIInicio.setText("");
		fechaIInicio.setBounds(173, 372, 128, 20);
		add(fechaIInicio);
		fechaIInicio.setColumns(10);
		
		fechaFin = new JTextField();
		fechaFin.setBounds(173, 404, 128, 20);
		add(fechaFin);
		fechaFin.setColumns(10);
		
		
		setVisible(true);
	}
}
