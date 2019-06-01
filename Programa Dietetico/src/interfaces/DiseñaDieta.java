package interfaces;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import componentes.BotonMenu;
import componentes.MiLabel;
import excepciones.AlturaException;
import excepciones.FechaException;
import principal.Alimento;
import principal.Dieta;
import principal.Plato;
import principal.Usuario;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DiseñaDieta extends JPanel{
	
	
	private Ventana ventana;
	private Plato plato;
	private JTextField nombreDieta;
	private JTextField fechaIInicio;
	private JTextField fechaFin;
	private Dieta dieta;
	ImageIcon imagen;
	
	/**
	 * @return the plato
	 */
	public Plato getPlato() {
		return plato;
	}

	/**
	 * @param plato the plato to set
	 */
	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public DiseñaDieta(Ventana v, String nombre) {
		super();
		
		imagen = new ImageIcon(getClass().getResource(nombre));//CODIGO IMAGEN PRIMERA FORMA
		setSize(imagen.getIconWidth(),imagen.getIconHeight());//CODIGO IMAGEN PRIMERA FORMA
		
		Alimento arrozIntegral = new Alimento("Arroz integral", 357, 7, 77, 2);
        Alimento arrozNormal = new Alimento("Arroz normal", 361, 6, 87, 1);
        Alimento aguacate = new Alimento("Aguacate", 223, 4, 2, 22);
        Alimento almendras = new Alimento("Almendras", 357, 17, 4, 54);
        Alimento atunLata = new Alimento("Atún en lata", 357, 23, 0, 22);
        Alimento banana = new Alimento("Banana", 357, 3, 11, 1);
        Alimento batidoProteina = new Alimento("Batido de proteína",392,80, 8 ,5);
        Alimento besugo = new Alimento("Besugo", 118, 16, 0, 6);
        Alimento brocoli = new Alimento("Brocoli", 23, 3, 2, 0);
        Alimento calabacin = new Alimento("Calabacín", 16, 1, 4, 0);
        Alimento calabaza = new Alimento("Calabaza", 15, 1, 3, 0);
        Alimento cerdoMagro = new Alimento("Carne de cerdo Magro", 147, 21, 0, 7);
        Alimento carneConejo = new Alimento("Carne de conejo", 124, 22, 0, 4);
        Alimento corderoMagro = new Alimento("Carne de cordero Magro", 122, 21, 0, 7);
        Alimento carneTernera = new Alimento("Carne de ternera", 109, 21, 0, 3);
        Alimento champiniones = new Alimento("Champiñones", 13, 2, 0, 1);
        Alimento coliflor = new Alimento("Coliflor", 13, 2, 2, 0);
        Alimento esparragos = new Alimento("Esparragos", 18, 3, 1, 0);
        Alimento espinacas = new Alimento("Espinacas", 15, 2, 1, 0);
        Alimento fresas = new Alimento("Fresas", 26, 1, 6, 0);
        Alimento gambas = new Alimento("Gambas cocidas", 107, 23, 0, 2);
        Alimento garbanzos = new Alimento("Garbanzos", 314, 20, 49, 3);
        Alimento guisantes = new Alimento("Guisantes", 357, 6, 11, 0);
        Alimento hamburguesaTernera = new Alimento("Hamburguesa Ternera", 265, 15, 5, 20);
        Alimento harinaAvena = new Alimento("Harina de Avena", 401, 12, 73, 9);
        Alimento huevo = new Alimento("Huevo entero", 153, 12, 1, 11);
        Alimento lecheDesnatada = new Alimento("Leche desnatada", 35, 3, 5, 1);
        Alimento lechuga = new Alimento("Lechuga", 12, 1, 1, 0);
        Alimento lenguado = new Alimento("Lenguado", 81, 17, 0, 1);
        Alimento lentejas = new Alimento("Lentejas", 304, 24, 53, 1);
        Alimento pasta = new Alimento("Pasta", 370, 14, 79, 2);
        Alimento mandarinas = new Alimento("Mandarinas", 34, 1, 8, 0);
        Alimento manzana = new Alimento("Manzana", 46, 0, 12, 0);
        Alimento melocoton = new Alimento("Melocoton", 37, 1, 9, 0);
        Alimento merluza = new Alimento("Merluza", 46, 11, 0, 0);
        Alimento panIntegral = new Alimento("Pan integral", 216, 9, 42, 3);
        Alimento patataCocida = new Alimento("Patata cocida", 86, 2, 19, 0);
        Alimento pavo = new Alimento("Pavo", 107, 22, 0, 2);
        Alimento pepino = new Alimento("Pepino", 10, 1, 2, 0);
        Alimento pera = new Alimento("Pera", 41, 0, 11, 0);
        Alimento pinia = new Alimento("Piña", 46, 0, 12, 0);
        Alimento platano = new Alimento("Plátano", 79, 1, 19, 0);
        Alimento pollo = new Alimento("Pollo", 121, 20, 0, 4);
        Alimento quesoBurgos = new Alimento("Queso Burgos", 167, 11, 3, 11);
        Alimento solomillo = new Alimento("Carne de Solomillo", 272, 17, 0, 23);
        Alimento tomate = new Alimento("Tomate", 14, 1, 3, 0);
        Alimento uvas = new Alimento("Uvas", 61, 1, 16, 0);
        Alimento yogurDesnatado = new Alimento("Yogur Desnatado", 52, 5, 6, 1);
        Alimento zanahoria = new Alimento("Zanahoria", 42, 1, 9, 0);
        
      //PLATOS PARA ARROZ
        
        ArrayList<Alimento> arrozcMerluza=new ArrayList<Alimento>();
        arrozcMerluza.add(arrozIntegral);
        arrozcMerluza.add(merluza);
        Plato arrozConMerluza = new Plato(arrozcMerluza, "Mezclar con merluza", "Arroz con merluza");
        
        ArrayList<Alimento> arrozcCalabaza=new ArrayList<Alimento>();
        arrozcCalabaza.add(arrozIntegral);
        arrozcCalabaza.add(calabaza);
        Plato arrozConCalabaza = new Plato(arrozcCalabaza, "Mezclar con calabaza", "Arroz con calabaza");
        
        ArrayList<Alimento> arrozPavo=new ArrayList<Alimento>();
        arrozPavo.add(arrozIntegral);
        arrozPavo.add(pavo);
        Plato arrozConPavo = new Plato(arrozPavo, "Mezclar con pavo", "Arroz con pavo");
        
        ArrayList<Alimento> arrozEspinaca=new ArrayList<Alimento>();
        arrozEspinaca.add(arrozIntegral);
        arrozEspinaca.add(espinacas);
        Plato arrozConEspinacas = new Plato(arrozEspinaca, "Mezclar con espinacas", "Arroz con espinacas");
        
       ArrayList<Alimento> arrozAtun=new ArrayList<Alimento>();
       arrozAtun.add(arrozIntegral);
       arrozAtun.add(atunLata);
       Plato arrozConAtun = new Plato(arrozAtun, "Mezclar dos latas de atún con 200 gramos de arroz cocido", "Arroz con atún");
   
       ArrayList<Alimento> arrozPollo=new ArrayList<Alimento>();
       arrozPollo.add(arrozIntegral);
       arrozPollo.add(pollo);
       Plato arrozConPollo= new Plato(arrozPollo, "Mezclar 100 gramos de pollo con 200 gramos de arroz cocido", "Arroz con pollo");
        
       ArrayList<Alimento> arrozGamba=new ArrayList<Alimento>();
       arrozGamba.add(arrozIntegral);
       arrozGamba.add(gambas);
       Plato arrozConGamba = new Plato(arrozGamba, "Mezclar 100 gramos de gambas con 200 gramos de arroz cocido", "Arroz con gambas");
       
       ArrayList<Alimento> arrozTernera=new ArrayList<Alimento>();
       arrozTernera.add(arrozIntegral);
       arrozTernera.add(hamburguesaTernera);
       Plato arrozConTernera = new Plato(arrozTernera, "Mezclar 100 gramos de ternera con 200 gramos de arroz cocido", "Arroz con ternera");
       
       //PLATOS PARA PATATA
       
       ArrayList<Alimento> patataBrocoli=new ArrayList<Alimento>();
       patataBrocoli.add(patataCocida);
       patataBrocoli.add(brocoli);
       Plato patataConBrocoli = new Plato(patataBrocoli, "Aqui las instrucciones para cocinar", "Patata con brocoli");
       
       ArrayList<Alimento> patataGarbanzos=new ArrayList<Alimento>();
       patataGarbanzos.add(patataCocida);
       patataGarbanzos.add(garbanzos);
       patataGarbanzos.add(guisantes);
       Plato patataConGarbanzos = new Plato(patataGarbanzos, "Aqui las instrucciones para cocinar", "Patata con garbanzos y guisantes");
       
       ArrayList<Alimento> patataLenguado=new ArrayList<Alimento>();
       patataLenguado.add(patataCocida);
       patataLenguado.add(lenguado);
       Plato patataConLenguado = new Plato(patataLenguado, "Aqui las instrucciones para cocinar", "Patata con lenguado");
       
       ArrayList<Alimento> patataMerluza=new ArrayList<Alimento>();
       patataMerluza.add(patataCocida);
       patataMerluza.add(merluza);
       Plato patataConMerluza = new Plato(patataMerluza, "Aqui las instrucciones para cocinar", "Patata con merluza");
       
       ArrayList<Alimento> patataEspinaca=new ArrayList<Alimento>();
       patataEspinaca.add(patataCocida);
       patataEspinaca.add(espinacas);
       Plato patataConEspinaca = new Plato(patataEspinaca, "Aqui las instrucciones para cocinar", "Patata con espinacas");
       
       ArrayList<Alimento> patataTernera=new ArrayList<Alimento>();
       patataTernera.add(patataCocida);
       patataTernera.add(hamburguesaTernera);
       patataTernera.add(guisantes);
       Plato patataConTernera = new Plato(patataTernera, "Aqui las instrucciones para cocinar", "Patata con ternera y guisantes");
       
       ArrayList<Alimento> patataPollo=new ArrayList<Alimento>();
       patataPollo.add(patataCocida);
       patataPollo.add(pollo);
       Plato patataConPollo = new Plato(patataPollo, "Aqui las instrucciones para cocinar", "Patata con pollo");
       
       ArrayList<Alimento> patataPavo=new ArrayList<Alimento>();
       patataPavo.add(patataCocida);
       patataPavo.add(pavo);
       Plato patataConPavo = new Plato(patataPavo, "Aqui las instrucciones para cocinar", "Patata con pavo");
       
       //PLATOS PARA LECHUGA 
       
       ArrayList<Alimento> lechugaQueso=new ArrayList<Alimento>();
       lechugaQueso.add(tomate);
       lechugaQueso.add(lechuga);
       lechugaQueso.add(quesoBurgos);
       Plato lechugaConQueso = new Plato(lechugaQueso, "Aqui las instrucciones para cocinar", "Lechuga con queso de burgos y tomate");
       
       ArrayList<Alimento> lechugaPavo=new ArrayList<Alimento>();
       lechugaPavo.add(pavo);
       lechugaPavo.add(lechuga);
       lechugaPavo.add(arrozIntegral);
       Plato lechugaConPavo = new Plato(lechugaPavo, "Aqui las instrucciones para cocinar", "Lechuga con pavo y arroz");
       
       ArrayList<Alimento> lechugaMerluza=new ArrayList<Alimento>();
       lechugaMerluza.add(merluza);
       lechugaMerluza.add(lechuga);
       lechugaMerluza.add(tomate);
       Plato lechugaConMerluza = new Plato(lechugaMerluza, "Aqui las instrucciones para cocinar", "Lechuga con merluza y tomate");
       
       ArrayList<Alimento> lechugaPollo=new ArrayList<Alimento>();
       lechugaPollo.add(pollo);
       lechugaPollo.add(lechuga);
       lechugaPollo.add(tomate);
       lechugaPollo.add(guisantes);
       Plato lechugaConPollo = new Plato(lechugaPollo, "Aqui las instrucciones para cocinar", "Lechuga con pollo, tomate y guisantes.");
       
       ArrayList<Alimento> lechugaSolomillo=new ArrayList<Alimento>();
       lechugaSolomillo.add(solomillo);
       lechugaSolomillo.add(lechuga);
       lechugaSolomillo.add(garbanzos);
       lechugaSolomillo.add(guisantes);
       Plato lechugaConSolomillo = new Plato(lechugaSolomillo, "Aqui las instrucciones para cocinar", "Lechuga con solomillo, guisantes y garbanzos");
       
       ArrayList<Alimento> lechugaTernera=new ArrayList<Alimento>();
       lechugaTernera.add(hamburguesaTernera);
       lechugaTernera.add(lechuga);
       lechugaTernera.add(garbanzos);
       lechugaTernera.add(guisantes);
       Plato lechugaConTernera = new Plato(lechugaTernera, "Aqui las instrucciones para cocinar", "Lechuga con ternera, guisantes y garbanzos");
       
       ArrayList<Alimento> lechugaAtun=new ArrayList<Alimento>();
       lechugaAtun.add(atunLata);
       lechugaAtun.add(lechuga);
       lechugaAtun.add(tomate);
       Plato lechugaConAtun = new Plato(lechugaAtun, "Aqui las instrucciones para cocinar", "Lechuga con atún y tomate");
       
       ArrayList<Alimento> lechugaBesugo=new ArrayList<Alimento>();
       lechugaBesugo.add(besugo);
       lechugaBesugo.add(lechuga);
       lechugaBesugo.add(zanahoria);
       Plato lechugaConBesugo = new Plato(lechugaBesugo, "Aqui las instrucciones para cocinar", "Lechuga con besugo y zanahoria");
       
       //PLATOS PARA PASTA
       
       ArrayList<Alimento> pastaTomate=new ArrayList<Alimento>();
       pastaTomate.add(tomate);
       pastaTomate.add(pasta);
       Plato pastaConTomate = new Plato(pastaTomate, "Aqui las instrucciones para cocinar", "Pasta con tomate");
       
       ArrayList<Alimento> pastaBesugo=new ArrayList<Alimento>();
       pastaBesugo.add(pasta);
       pastaBesugo.add(besugo);
       Plato pastaConBesugo = new Plato(pastaBesugo, "Aqui las instrucciones para cocinar", "Pasta con besugo");
       
       ArrayList<Alimento> pastaMerluza=new ArrayList<Alimento>();
       pastaMerluza.add(pasta);
       pastaMerluza.add(merluza);
       Plato pastaConMerluza = new Plato(pastaMerluza, "Aqui las instrucciones para cocinar", "Pasta con merluza");
       
       ArrayList<Alimento> pastaEspinaca=new ArrayList<Alimento>();
       pastaEspinaca.add(pollo);
       pastaEspinaca.add(espinacas);
       Plato pastaConEspinaca = new Plato(pastaEspinaca, "Aqui las instrucciones para cocinar", "Pasta con espinacas");
       
       ArrayList<Alimento> pastaGarbanzos=new ArrayList<Alimento>();
       pastaGarbanzos.add(garbanzos);
       pastaGarbanzos.add(tomate);
       pastaGarbanzos.add(pasta);
       Plato pastaConGarbanzos = new Plato(pastaGarbanzos, "Aqui las instrucciones para cocinar", "Pasta con garbanzos y tomate");
       
       ArrayList<Alimento> pastaAtun=new ArrayList<Alimento>();
       pastaAtun.add(atunLata);
       pastaAtun.add(tomate);
       pastaAtun.add(pasta);
       Plato pastaConAtun = new Plato(pastaAtun, "Aqui las instrucciones para cocinar", "Pasta con atún y tomate");
       
       ArrayList<Alimento> pastaTernera=new ArrayList<Alimento>();
       pastaTernera.add(hamburguesaTernera);
       pastaTernera.add(tomate);
       pastaTernera.add(pasta);
       Plato pastaConTernera = new Plato(pastaTernera, "Aqui las instrucciones para cocinar", "Pasta con ternera y tomate");
       
       ArrayList<Alimento> pastaPollo=new ArrayList<Alimento>();
       pastaPollo.add(pollo);
       pastaPollo.add(espinacas);
       pastaPollo.add(pasta);
       Plato pastaConPollo = new Plato(pastaPollo, "Aqui las instrucciones para cocinar", "Pasta con pollo y espinacas");
       
       
       HashMap<String,HashMap<Integer,Plato>> alimentos=new HashMap<String,HashMap<Integer,Plato>>();
		
       //HASHMAPS PARA AFINEZ ARROZ
		alimentos.put("arroz", new HashMap<Integer,Plato>());
		//añadimos platos para arroz
		alimentos.get("arroz").put(arrozConAtun.getCalorias(),arrozConAtun);
		alimentos.get("arroz").put(arrozConPollo.getCalorias(),arrozConPollo);
		alimentos.get("arroz").put(arrozConGamba.getCalorias(),arrozConGamba);
		alimentos.get("arroz").put(arrozConTernera.getCalorias(),arrozConTernera);
		alimentos.get("arroz").put(arrozConEspinacas.getCalorias(),arrozConEspinacas);
		alimentos.get("arroz").put(arrozConPavo.getCalorias(),arrozConPavo);
		alimentos.get("arroz").put(arrozConCalabaza.getCalorias(),arrozConCalabaza);
		alimentos.get("arroz").put(arrozConMerluza.getCalorias(),arrozConMerluza);
		
		//HASMAPS PARA AFINES PATATA
		alimentos.put("patata", new HashMap<Integer,Plato>());
 		//añadimos plato para patata	
		alimentos.get("patata").put(patataConTernera.getCalorias(),patataConTernera);
		alimentos.get("patata").put(patataConPollo.getCalorias(),patataConPollo);
		alimentos.get("patata").put(patataConPavo.getCalorias(),patataConPavo);
		alimentos.get("patata").put(patataConEspinaca.getCalorias(),patataConEspinaca);
		alimentos.get("patata").put(patataConMerluza.getCalorias(),patataConMerluza);
		alimentos.get("patata").put(patataConLenguado.getCalorias(),patataConLenguado);
		alimentos.get("patata").put(patataConGarbanzos.getCalorias(),patataConGarbanzos);
		alimentos.get("patata").put(patataConBrocoli.getCalorias(),patataConBrocoli);

		
		//HASMAPS PARA AFINES LECHUGA
		alimentos.put("lechuga", new HashMap<Integer,Plato>());
		//añadimos plato para lechuga
		alimentos.get("lechuga").put(lechugaConAtun.getCalorias(),lechugaConAtun);
		alimentos.get("lechuga").put(lechugaConBesugo.getCalorias(),lechugaConBesugo);
		alimentos.get("lechuga").put(lechugaConTernera.getCalorias(),lechugaConTernera);
		alimentos.get("lechuga").put(lechugaConSolomillo.getCalorias(),lechugaConSolomillo);
		alimentos.get("lechuga").put(lechugaConPollo.getCalorias(),lechugaConPollo);
		alimentos.get("lechuga").put(lechugaConMerluza.getCalorias(),lechugaConMerluza);
		alimentos.get("lechuga").put(lechugaConPavo.getCalorias(),lechugaConPavo);
		alimentos.get("lechuga").put(lechugaConQueso.getCalorias(),lechugaConQueso);

		
		//HASMPAPS PARA AFINES PASTA
		alimentos.put("pasta", new HashMap<Integer,Plato>());
		//añadimos plato para patata
		alimentos.get("pasta").put(pastaConAtun.getCalorias(),pastaConAtun);
		alimentos.get("pasta").put(pastaConTernera.getCalorias(),pastaConTernera);
		alimentos.get("pasta").put(pastaConPollo.getCalorias(),pastaConPollo);
		alimentos.get("pasta").put(pastaConGarbanzos.getCalorias(),pastaConGarbanzos);
		alimentos.get("pasta").put(pastaConEspinaca.getCalorias(),pastaConEspinaca);
		alimentos.get("pasta").put(pastaConMerluza.getCalorias(),pastaConMerluza);
		alimentos.get("pasta").put(pastaConBesugo.getCalorias(),pastaConBesugo);
		alimentos.get("pasta").put(pastaConTomate.getCalorias(),pastaConTomate);

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
		lblFechaDeInicio.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaDeInicio.setBounds(21, 373, 141, 14);
		add(lblFechaDeInicio);
		
		JLabel lblFecha = new JLabel("FECHA FIN (dd/MM/yyyy):");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFecha.setBounds(20, 405, 142, 14);
		add(lblFecha);
		
		fechaIInicio = new JTextField();
		fechaIInicio.setBounds(173, 372, 128, 20);
		add(fechaIInicio);
		fechaIInicio.setColumns(10);
		
		fechaFin = new JTextField();
		fechaFin.setBounds(173, 404, 128, 20);
		add(fechaFin);
		fechaFin.setColumns(10);
		
		
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
				
				
				String nombre_dieta;
				String desayuno;
				String almuerzo;
				String merienda;
				String cena;
				String f_inicio =fechaIInicio.getText();
				String f_fin = fechaFin.getText();
				//LocalDate hoy = LocalDate.now();
				//LocalDate mañana = LocalDate.now();
				LocalDate inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				LocalDate fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				//PASTA & PERDER PESO
				if(rdbtnPasta.isSelected() && botonPerder.isSelected()) {
					Set<Integer> platosPasta=ventana.getTodosLosPlatos().get("pasta").keySet(); //obtienes todas las calorias de todos los platos de pasta
					Iterator it=platosPasta.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
										
					Plato[] pastaAdelgaza = {pastaConTomate, pastaConEspinaca, pastaConBesugo, pastaConMerluza};
					
					
					nombre_dieta = nombreDieta.getText();
					desayuno = pastaAdelgaza[0].getNombre();
					almuerzo = pastaAdelgaza[1].getNombre();
					merienda = pastaAdelgaza[2].getNombre();
					cena = pastaAdelgaza[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					try {
						ventana.setDietaUsuario(new Dieta("Adelgazar con pasta",pastaAdelgaza,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(FechaException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					}
				}
				//PASTA & MANTENER PESO
				if(rdbtnPasta.isSelected() && botonMantener.isSelected()) {
					Set<Integer> platosPasta=ventana.getTodosLosPlatos().get("pasta").keySet(); //obtienes todas las calorias de todos los platos de pasta
					Iterator it=platosPasta.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
										
					Plato[] pastaMantiene = {pastaConTomate, pastaConPollo, pastaConBesugo, pastaConPollo};
					nombre_dieta = nombreDieta.getText();
					desayuno = pastaMantiene[0].getNombre();
					almuerzo = pastaMantiene[1].getNombre();
					merienda = pastaMantiene[2].getNombre();
					cena = pastaMantiene[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					try {
						ventana.setDietaUsuario(new Dieta("Mantener con pasta",pastaMantiene,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(FechaException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					}
					
				}
				//PASTA & GANAR PESO
				if(rdbtnPasta.isSelected() && botonGanar.isSelected()) {
					Set<Integer> platosPasta=ventana.getTodosLosPlatos().get("pasta").keySet(); //obtienes todas las calorias de todos los platos de pasta
					Iterator it=platosPasta.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
										
					Plato[] pastaGana = {pastaConGarbanzos, pastaConPollo, pastaConAtun, pastaConTernera};
					nombre_dieta = nombreDieta.getText();
					desayuno = pastaGana[0].getNombre();
					almuerzo = pastaGana[1].getNombre();
					merienda = pastaGana[2].getNombre();
					cena = pastaGana[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					try {
						ventana.setDietaUsuario(new Dieta("Gana con pasta",pastaGana,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(FechaException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					}
					
				}
				//PERDER CON ARROZ
				if(rdbtnArroz.isSelected()&& botonPerder.isSelected()){
					Set<Integer> platosArroz=ventana.getTodosLosPlatos().get("arroz").keySet(); //obtienes todas las calorias de todos los platos de arroz
					Iterator it=platosArroz.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					Plato[] arrozAdelgaza = {arrozConEspinacas, arrozConMerluza, arrozConCalabaza, arrozConPavo};
					nombre_dieta = nombreDieta.getText();
					desayuno = arrozAdelgaza[0].getNombre();
					almuerzo = arrozAdelgaza[1].getNombre();
					merienda = arrozAdelgaza[2].getNombre();
					cena = arrozAdelgaza[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					try {
						ventana.setDietaUsuario(new Dieta("Adelgaza con arroz",arrozAdelgaza,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(FechaException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					}
				}
				//MANTENER CON ARROZ
				if(rdbtnArroz.isSelected()&& botonMantener.isSelected()){
					Set<Integer> platosArroz=ventana.getTodosLosPlatos().get("arroz").keySet(); //obtienes todas las calorias de todos los platos de arroz
					Iterator it=platosArroz.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					Plato[] arrozMantener = {arrozConGamba, arrozConPollo, arrozConCalabaza, arrozConPavo};
					nombre_dieta = nombreDieta.getText();
					desayuno = arrozMantener[0].getNombre();
					almuerzo = arrozMantener[1].getNombre();
					merienda = arrozMantener[2].getNombre();
					cena = arrozMantener[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					try {
						ventana.setDietaUsuario(new Dieta("Mantiene con arroz",arrozMantener,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(FechaException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					}
					
				}
				//GANAR CON ARROZ
				if(rdbtnArroz.isSelected()&& botonGanar.isSelected()){
					Set<Integer> platosArroz=ventana.getTodosLosPlatos().get("arroz").keySet(); //obtienes todas las calorias de todos los platos de arroz
					Iterator it=platosArroz.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					Plato[] arrozGanar = {arrozConGamba, arrozConPollo, arrozConAtun, arrozConTernera};
					nombre_dieta = nombreDieta.getText();
					desayuno = arrozGanar[0].getNombre();
					almuerzo = arrozGanar[1].getNombre();
					merienda = arrozGanar[2].getNombre();
					cena = arrozGanar[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					try {
						ventana.setDietaUsuario(new Dieta("Gana con arroz",arrozGanar,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(FechaException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					}
					
				}
				//PERDER CON PATATA
				if (rdbtnPatata.isSelected()&& botonPerder.isSelected()) {
					Set<Integer> platosPatata=ventana.getTodosLosPlatos().get("patata").keySet(); //obtienes todas las calorias de todos los platos de patata
					Iterator it=platosPatata.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					Plato[] patataPerder = {patataConEspinaca, patataConMerluza, patataConBrocoli, patataConPavo};
					nombre_dieta = nombreDieta.getText();
					desayuno = patataPerder[0].getNombre();
					almuerzo = patataPerder[1].getNombre();
					merienda = patataPerder[2].getNombre();
					cena = patataPerder[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					try {
						ventana.setDietaUsuario(new Dieta("Gana con patata",patataPerder,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(FechaException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					}
				}
				//MANTENER CON PATATA
				if (rdbtnPatata.isSelected()&& botonMantener.isSelected()) {
					Set<Integer> platosPatata=ventana.getTodosLosPlatos().get("patata").keySet(); //obtienes todas las calorias de todos los platos de patata
					Iterator it=platosPatata.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					Plato[] patataMantener = {patataConPavo, patataConMerluza, patataConLenguado, patataConPollo};
					nombre_dieta = nombreDieta.getText();
					desayuno = patataMantener[0].getNombre();
					almuerzo = patataMantener[1].getNombre();
					merienda = patataMantener[2].getNombre();
					cena = patataMantener[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					try {
						ventana.setDietaUsuario(new Dieta("Mantiene con patata",patataMantener,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(FechaException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					}
				}
				//GANAR CON PATATA
				if (rdbtnPatata.isSelected()&& botonGanar.isSelected()) {
					Set<Integer> platosPatata=ventana.getTodosLosPlatos().get("patata").keySet(); //obtienes todas las calorias de todos los platos de patata
					Iterator it=platosPatata.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					Plato[] patataGanar = {patataConPavo, patataConTernera, patataConGarbanzos, patataConPollo};
					nombre_dieta = nombreDieta.getText();
					desayuno = patataGanar[0].getNombre();
					almuerzo = patataGanar[1].getNombre();
					merienda = patataGanar[2].getNombre();
					cena = patataGanar[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					try {
						ventana.setDietaUsuario(new Dieta("Gana con patata",patataGanar,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(FechaException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					}
				}
				//PERDER CON LECHUGA
				if (rdbtnLechuga.isSelected()&& botonPerder.isSelected()) {
					Set<Integer> platosLechuga=ventana.getTodosLosPlatos().get("lechuga").keySet(); //obtienes todas las calorias de todos los platos de lechuga
					Iterator it=platosLechuga.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					Plato[] lechugaPerder = {lechugaConPavo, patataConMerluza, lechugaConQueso, lechugaConPollo};
					nombre_dieta = nombreDieta.getText();
					desayuno = lechugaPerder[0].getNombre();
					almuerzo = lechugaPerder[1].getNombre();
					merienda = lechugaPerder[2].getNombre();
					cena = lechugaPerder[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					try {
						ventana.setDietaUsuario(new Dieta("Pierde con lechuga",lechugaPerder,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(FechaException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					}
				}
				//MANTENER CON LECHUGA
				if (rdbtnLechuga.isSelected()&& botonMantener.isSelected()) {
					Set<Integer> platosLechuga=ventana.getTodosLosPlatos().get("lechuga").keySet(); //obtienes todas las calorias de todos los platos de lechuga
					Iterator it=platosLechuga.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					Plato[] lechugaMantener = {lechugaConPavo, lechugaConPollo, lechugaConQueso, lechugaConAtun};
					nombre_dieta = nombreDieta.getText();
					desayuno = lechugaMantener[0].getNombre();
					almuerzo = lechugaMantener[1].getNombre();
					merienda = lechugaMantener[2].getNombre();
					cena = lechugaMantener[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					
					try {
						ventana.setDietaUsuario(new Dieta("Mantiene con lechuga",lechugaMantener,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(DateTimeParseException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					} catch (FechaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//GANAR CON LECHUGA
				if (rdbtnLechuga.isSelected()&& botonGanar.isSelected()) {
					Set<Integer> platosLechuga=ventana.getTodosLosPlatos().get("lechuga").keySet(); //obtienes todas las calorias de todos los platos de lechuga
					Iterator it=platosLechuga.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					Plato[] lechugaGanar = {lechugaConTernera, lechugaConPollo, lechugaConSolomillo, lechugaConAtun};
					nombre_dieta = nombreDieta.getText();
					desayuno = lechugaGanar[0].getNombre();
					almuerzo = lechugaGanar[1].getNombre();
					merienda = lechugaGanar[2].getNombre();
					cena = lechugaGanar[3].getNombre();
					f_inicio = fechaIInicio.getText();
					f_fin = fechaFin.getText();
					inicio = LocalDate.parse(f_inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				    fin = LocalDate.parse(f_fin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					
					try {
						ventana.setDietaUsuario(new Dieta("Gana con lechuga",lechugaGanar,f_inicio,f_fin));
						ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/programanutricion","dietista","dietista"));
						//usamos
						PreparedStatement smt =
						ventana.getCon().prepareStatement("insert into dieta values(?,?,?,?,?,'"+inicio+"','"+fin+"',?)");
						
						//'inicio' y 'fin' lo inserto directamente en prepareStatement para que no me de problemas por ser LocalDAte 
						
						smt.setString(1, nombre_dieta);
						smt.setString(2, desayuno);
						smt.setString(3, almuerzo);
						smt.setString(4, merienda);
						smt.setString(5, cena);
						smt.setString(6, ventana.getUsuario().getNombre());
						
						
						
						smt.executeUpdate();
						ventana.getCon().close();
						ventana.irACalculacalorias();
						
	                } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(FechaException e4) {
						JOptionPane.showMessageDialog(ventana, "La fecha es incorrecta, usa formato dd/mm/yyyy", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
						//e4.printStackTrace();
					}
				}
				
			
				ventana.irATuDieta();
			}
		});
		botonCrearDieta.setText("Crear Dieta");
		botonCrearDieta.setBounds(336, 377, 142, 42);
		add(botonCrearDieta);
		
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
