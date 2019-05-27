package interfaces;

import javax.swing.JPanel;
import java.awt.Color;

import componentes.BotonMenu;
import componentes.MiLabel;
import principal.Alimento;
import principal.Dieta;
import principal.Plato;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
	private Dieta dieta;
	
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

	public DiseñaDieta(Ventana v) {
		super();
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
        Alimento solomillo = new Alimento("Carne de Solomillo", 272, 17, 0, 23);
        Alimento champiniones = new Alimento("Champiñones", 13, 2, 0, 1);
        Alimento coliflor = new Alimento("Coliflor", 13, 2, 2, 0);
        Alimento esparragos = new Alimento("Esparragos", 18, 3, 1, 0);
        Alimento espinacas = new Alimento("Espinacas", 15, 2, 1, 0);
        Alimento fresas = new Alimento("Fresas", 26, 1, 6, 0);
        Alimento gambas = new Alimento("Gambas cocidas", 107, 23, 0, 2);
        Alimento garbanzos = new Alimento("Garbanzos", 314, 20, 49, 3);
        Alimento guisantes = new Alimento("Guisantes", 357, 6, 11, 0);
        Alimento hamburgeusaTernera = new Alimento("Hamburguesa Ternera", 265, 15, 5, 20);
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
       Plato arrozConGamba = new Plato(arrozGamba, "Mezclar 100 gramos de gambas con 200 gramos de arroz cocido", "Arroz con pollo");
       
       ArrayList<Alimento> arrozTernera=new ArrayList<Alimento>();
       arrozGamba.add(arrozIntegral);
       arrozGamba.add(carneTernera);
       Plato arrozConTernera = new Plato(arrozTernera, "Mezclar 100 gramos de ternera con 200 gramos de arroz cocido", "Arroz con pollo");
       
       //PLATOS PARA PATATA
       
       ArrayList<Alimento> patataBrocoli=new ArrayList<Alimento>();
       patataBrocoli.add(patataCocida);
       patataBrocoli.add(brocoli);
       Plato patataConBrocoli = new Plato(patataBrocoli, "Aqui las instrucciones para cocinar", "Patata con brocoli");
       
       ArrayList<Alimento> patataGarbanzos=new ArrayList<Alimento>();
       patataGarbanzos.add(patataCocida);
       patataGarbanzos.add(garbanzos);
       Plato patataConGarbanzos = new Plato(patataGarbanzos, "Aqui las instrucciones para cocinar", "Patata con garbanzos");
       
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
       patataTernera.add(carneTernera);
       Plato patataConTernera = new Plato(patataTernera, "Aqui las instrucciones para cocinar", "Patata con ternera");
       
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
       Plato lechugaConPollo = new Plato(lechugaPollo, "Aqui las instrucciones para cocinar", "Lechuga con pollo y tomate");
       
       ArrayList<Alimento> lechugaSolomillo=new ArrayList<Alimento>();
       lechugaSolomillo.add(solomillo);
       lechugaSolomillo.add(lechuga);
       lechugaSolomillo.add(garbanzos);
       Plato lechugaConSolomillo = new Plato(lechugaSolomillo, "Aqui las instrucciones para cocinar", "Lechuga con garbanzos y solomillo");
       
       ArrayList<Alimento> lechugaTernera=new ArrayList<Alimento>();
       lechugaTernera.add(carneTernera);
       lechugaTernera.add(lechuga);
       lechugaTernera.add(garbanzos);
       Plato lechugaConTernera = new Plato(lechugaTernera, "Aqui las instrucciones para cocinar", "Lechuga con garbanzos y ternera");
       
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
       pastaTernera.add(carneTernera);
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
				
				LocalDate hoy = LocalDate.now();
				LocalDate mañana = LocalDate.now();
				
				
				//PASTA & PERDER PESO
				if(rdbtnPasta.isSelected() && botonPerder.isSelected()) {
					Set<Integer> platosPasta=ventana.getTodosLosPlatos().get("pasta").keySet(); //obtienes todas las calorias de todos los platos de pasta
					Iterator it=platosPasta.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
										
					Plato[] pastaAdelgaza = {pastaConTomate, pastaConEspinaca, pastaConBesugo, pastaConMerluza};
					ventana.setDietaUsuario(new Dieta("Adelgazar con pasta",pastaAdelgaza,hoy,mañana));
					
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
					ventana.setDietaUsuario(new Dieta("Mantener con pasta",pastaMantiene,hoy,mañana));
					
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
					ventana.setDietaUsuario(new Dieta("Ganar peso con pasta",pastaGana,hoy,mañana));
					
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
					ventana.setDietaUsuario(new Dieta("Adelgazar con arroz",arrozAdelgaza,hoy,mañana));
					//Dieta adelgazaArroz = new Dieta("Adelgazar con arroz",arrozAdelgaza,hoy,mañana);
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
					ventana.setDietaUsuario(new Dieta("Mantener con arroz",arrozMantener,hoy,mañana));
					
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
					ventana.setDietaUsuario(new Dieta("Ganar peso con arroz",arrozGanar,hoy,mañana));
					
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
					ventana.setDietaUsuario(new Dieta("Perder peso con patata",patataPerder,hoy,mañana));
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
					ventana.setDietaUsuario(new Dieta("Perder peso con patata",patataMantener,hoy,mañana));
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
					ventana.setDietaUsuario(new Dieta("Perder peso con patata",patataGanar,hoy,mañana));
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
					ventana.setDietaUsuario(new Dieta("Perder peso con lechuga",lechugaPerder,hoy,mañana));
				}
				//MANTENER CON LECHUGA
				if (rdbtnLechuga.isSelected()&& botonMantener.isSelected()) {
					Set<Integer> platosLechuga=ventana.getTodosLosPlatos().get("lechuga").keySet(); //obtienes todas las calorias de todos los platos de lechuga
					Iterator it=platosLechuga.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					Plato[] lechugaMantener = {lechugaConPavo, patataConPollo, lechugaConQueso, lechugaConAtun};
					ventana.setDietaUsuario(new Dieta("Mantener peso con lechuga",lechugaMantener,hoy,mañana));
				}
				//GANAR CON LECHUGA
				if (rdbtnLechuga.isSelected()&& botonGanar.isSelected()) {
					Set<Integer> platosLechuga=ventana.getTodosLosPlatos().get("lechuga").keySet(); //obtienes todas las calorias de todos los platos de lechuga
					Iterator it=platosLechuga.iterator();
					while(it.hasNext()) {
						int calorias=(int)it.next();
						System.out.println("calorias: "+calorias);
				}
					Plato[] lechugaGanar = {lechugaConTernera, patataConPollo, lechugaConSolomillo, lechugaConAtun};
					ventana.setDietaUsuario(new Dieta("Ganar peso con lechuga",lechugaGanar,hoy,mañana));
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
