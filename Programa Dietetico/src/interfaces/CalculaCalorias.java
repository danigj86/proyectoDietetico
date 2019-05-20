package interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JPanel;

import componentes.MiLabel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Usuario;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import componentes.BotonMenu;

public class CalculaCalorias extends JPanel{
	
	private Ventana ventana;
	private JTextField alturaUser;
	private JTextField edadUser;
	private JTextField pesoUser;
	private JLabel lblEdad;
	private JRadioButton femeninoUser;
	private JRadioButton masculinoUser;
	private JLabel lblCalorasMantenimiento;
	private JLabel lblPrdidaDeGrasa;
	private JLabel lblAumentoDePeso;
	private JLabel cMantener;
	private JLabel cPerder;
	private JLabel cGanar;
	private JComboBox comboBoxActividad ;
	
	public CalculaCalorias(Ventana v, String nombre) {
		super();
		
		
		this.ventana=v;
		setSize(500,500);
		setBackground(new Color(30, 144, 255));
		
		
		setVisible(true);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EDAD:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 134, 61, 14);
		add(lblNewLabel);
		
		
		MiLabel mlblREG = new MiLabel("Bienvenido/a", 35);
		mlblREG.setText("C A L C U L A   C A L O R I A S ");
		mlblREG.setForeground(Color.WHITE);
		mlblREG.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		mlblREG.setBackground(new Color(30, 144, 255));
		mlblREG.setBounds(82, 5, 387, 28);
		add(mlblREG);
		
		JLabel label = new JLabel("ALTURA:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 94, 61, 14);
		add(label);
		
		JLabel lblPeso = new JLabel("PESO:");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPeso.setBounds(10, 171, 61, 14);
		add(lblPeso);
		
		alturaUser = new JTextField();
		alturaUser.setBounds(86, 91, 86, 20);
		add(alturaUser);
		alturaUser.setColumns(10);
		
		edadUser = new JTextField();
		edadUser.setBounds(86, 131, 86, 20);
		add(edadUser);
		edadUser.setColumns(10);
		
		pesoUser = new JTextField();
		pesoUser.setBounds(86, 168, 86, 20);
		add(pesoUser);
		pesoUser.setColumns(10);
		
		ButtonGroup grupoGenero = new ButtonGroup();
		femeninoUser = new JRadioButton("Femenino");
		femeninoUser.setBounds(208, 90, 109, 23);
		grupoGenero .add(femeninoUser);
		add(femeninoUser);
		
		masculinoUser = new JRadioButton("Masculino");
		masculinoUser.setBounds(336, 90, 109, 23);
		grupoGenero .add(masculinoUser);
		add(masculinoUser);
		
		lblCalorasMantenimiento = new JLabel("Calor\u00EDas mantenimiento:");
		lblCalorasMantenimiento.setForeground(Color.WHITE);
		lblCalorasMantenimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCalorasMantenimiento.setBounds(10, 246, 144, 14);
		add(lblCalorasMantenimiento);
		
		lblPrdidaDeGrasa = new JLabel("P\u00E9rdida de grasa:");
		lblPrdidaDeGrasa.setForeground(Color.WHITE);
		lblPrdidaDeGrasa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrdidaDeGrasa.setBounds(10, 292, 144, 14);
		add(lblPrdidaDeGrasa);
		
		lblAumentoDePeso = new JLabel("Aumento de peso:");
		lblAumentoDePeso.setForeground(Color.WHITE);
		lblAumentoDePeso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAumentoDePeso.setBounds(10, 343, 144, 14);
		add(lblAumentoDePeso);
		
		cMantener = new JLabel("0");
		cMantener.setForeground(Color.WHITE);
		cMantener.setFont(new Font("Tahoma", Font.BOLD, 11));
		cMantener.setBounds(173, 246, 144, 14);
		add(cMantener);
		
		cPerder = new JLabel("0");
		cPerder.setForeground(Color.WHITE);
		cPerder.setFont(new Font("Tahoma", Font.BOLD, 11));
		cPerder.setBounds(173, 292, 144, 14);
		add(cPerder);
		
		cGanar = new JLabel("0");
		cGanar.setForeground(Color.WHITE);
		cGanar.setFont(new Font("Tahoma", Font.BOLD, 11));
		cGanar.setBounds(173, 343, 144, 14);
		add(cGanar);
		
		comboBoxActividad = new JComboBox();
		comboBoxActividad.setModel(new DefaultComboBoxModel(new String[] {"Actividad sedentaria", "Actividad ligera", "Actividad moderada", "Actividad intensa"}));
		comboBoxActividad.setBounds(208, 168, 165, 20);
		add(comboBoxActividad);
		
		JLabel lblActividadFsica = new JLabel("ACTIVIDAD FISICA");
		lblActividadFsica.setForeground(Color.WHITE);
		lblActividadFsica.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblActividadFsica.setBounds(208, 134, 144, 14);
		add(lblActividadFsica);
		
		BotonMenu botonAtras = new BotonMenu("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAEligeLoginRegistro();
			}
		});
		
		botonAtras.setBounds(380, 392, 89, 23);
		add(botonAtras);
		
		
		
		BotonMenu botonCalcular = new BotonMenu("Calcular");
		botonCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Calorias();
			}
		});
		
		
		botonCalcular.setText("Calcular");
		botonCalcular.setBounds(33, 392, 89, 23);
		add(botonCalcular);
		
		BotonMenu botonRestaurar = new BotonMenu("Restaurar");
		botonRestaurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 alturaUser.setText("");
			        edadUser.setText("");
			        pesoUser.setText("");
			        comboBoxActividad.setSelectedItem("Actividad sedentaria");
			        cMantener.setText("");
			        cGanar.setText("");
			        cPerder.setText("");
			        alturaUser.requestFocus();
			}
		});
		
		
		botonRestaurar.setText("Restaurar");
		
		botonRestaurar.setBounds(165, 392, 89, 23);
		add(botonRestaurar);
		
		BotonMenu botonContinuar = new BotonMenu("Continuar");
		botonContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventana.irAPerfil();
			}
		});
		botonContinuar.setText("Continuar");
		botonContinuar.setBounds(275, 392, 89, 23);
		add(botonContinuar);
		
		
		
		setVisible(true);
		
		
		
	}
public void Calorias(){
	    
        //Declaramos las variables
        float altura, caloriasMantener, caloriasPerder,caloriasGanar, edad, peso;
        String actividad ;
        
        //Verificamos si los campos estan vacios
        
        
        if (alturaUser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese altura.","Atención", JOptionPane.INFORMATION_MESSAGE);
            alturaUser.requestFocus();
        }else{
            if (edadUser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese edad.","Atención", JOptionPane.INFORMATION_MESSAGE);
            edadUser.requestFocus();
        }else{
            if (pesoUser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese peso.","Atención", JOptionPane.INFORMATION_MESSAGE);
            pesoUser.requestFocus();
        }else{
            // ESTO ES PARA CONVERTIR EN FLOAT EL VALOR QUE HE PUESTO EN EL TEXTFIELD 
            
            altura = Float.parseFloat(alturaUser.getText());
            edad = Float.parseFloat(alturaUser.getText());
            peso = Float.parseFloat(alturaUser.getText());
            
            // ESTO ES PARA CONVERTIR EN STRING LA ELECCION DEL COMBOBOX
           
           
			actividad = comboBoxActividad.getSelectedItem().toString();
            
            switch (actividad){
                
                case "Actividad sedentaria":
                    //CONDICION PARA EL RADIO BUTTON GROUP
                    if (femeninoUser.isSelected()) {
                        //CALORIAS PARA MUJER: (655+(9,6* PESO) + (1,8 * ALTURA) - (4,7 * EDAD)) * ACTIVIDAD FISICA
                        caloriasMantener= Math.round((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.2f);
                        caloriasPerder= Math.round(((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.2f)-500);
                        caloriasGanar= Math.round(((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.2f)+500);        
                        
                        cMantener.setText(caloriasMantener+"");//ESTO ES PARA MOSTRAR EN EL JLABEL cMANTENER LAS CALORIAS DE MANTENIMIENTO
                        cGanar.setText(caloriasGanar+"");
                        cPerder.setText(caloriasPerder+"");
                        
                        try {
		                	ventana.setUsuario(new Usuario(ventana.getUsuario().getNombre(), caloriasMantener,caloriasPerder, caloriasGanar));
							ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.68:3306/programanutricion","dietista","dietista"));
							//usamos
							PreparedStatement smt =
							ventana.getCon().prepareStatement("insert calorias values(?,?,?,?)");
							
							smt.setString(1, ventana.getUsuario().getNombre());
							smt.setFloat(2, caloriasMantener);
							smt.setFloat(3, caloriasPerder);
							smt.setFloat(4, caloriasGanar);
							
							
							smt.executeUpdate();
							ventana.getCon().close();
							ventana.irAPerfil();
		                } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//CON ESTO RELLENO LOS VALORES DE LAS CALORIAS DEL USUARIO
                    }else{
                        //CALORIAS PARA HOMBRE: (66+(13,7* PESO) + (5* ALTURA) - (6,8 * EDAD)) * ACTIVIDAD FISICA
                        caloriasMantener= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.2f);
                        caloriasPerder= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.2f)-500;
                        caloriasGanar= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.2f)+500;        
                        
                        cMantener.setText(caloriasMantener+"");
                        cGanar.setText(caloriasGanar+"");
                        cPerder.setText(caloriasPerder+"");
                        
                        try {
		                	ventana.setUsuario(new Usuario(ventana.getUsuario().getNombre(), caloriasMantener,caloriasPerder, caloriasGanar));
							ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.68:3306/programanutricion","dietista","dietista"));
							//usamos
							PreparedStatement smt =
							ventana.getCon().prepareStatement("insert calorias values(?,?,?,?)");
							
							smt.setString(1, ventana.getUsuario().getNombre());
							smt.setFloat(2, caloriasMantener);
							smt.setFloat(3, caloriasPerder);
							smt.setFloat(4, caloriasGanar);
							
							
							smt.executeUpdate();
							ventana.getCon().close();
							ventana.irAPerfil();
		                } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//CON ESTO RELLENO LOS VALORES DE LAS CALORIAS DEL USUARIO
                    }
                    
                    break;
                    
                  case "Actividad ligera":
                    //Condicion para el radiobutton hombre o mujer
                    if (femeninoUser.isSelected()) {
                        //CALORIAS PARA MUJER: (655+(9,6* PESO) + (1,8 * ALTURA) - (4,7 * EDAD)) * ACTIVIDAD FISICA
                        caloriasMantener= Math.round((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.3f);
                        caloriasPerder= Math.round(((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.3f)-500);
                        caloriasGanar= Math.round(((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.3f)+500);        
                        
                        cMantener.setText(caloriasMantener+"");
                        cGanar.setText(caloriasGanar+"");
                        cPerder.setText(caloriasPerder+"");
                        
                        try {
		                	ventana.setUsuario(new Usuario(ventana.getUsuario().getNombre(), caloriasMantener,caloriasPerder, caloriasGanar));
							ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.68:3306/programanutricion","dietista","dietista"));
							//usamos
							PreparedStatement smt =
							ventana.getCon().prepareStatement("insert calorias values(?,?,?,?)");
							
							smt.setString(1, ventana.getUsuario().getNombre());
							smt.setFloat(2, caloriasMantener);
							smt.setFloat(3, caloriasPerder);
							smt.setFloat(4, caloriasGanar);
							
							
							smt.executeUpdate();
							ventana.getCon().close();
							ventana.irAPerfil();
		                } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//CON ESTO RELLENO LOS VALORES DE LAS CALORIAS DEL USUARIO
                    }else{
                        //CALORIAS PARA HOMBRE: (66+(13,7* PESO) + (5* ALTURA) - (6,8 * EDAD)) * ACTIVIDAD FISICA
                        caloriasMantener= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.3f);
                        caloriasPerder= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.3f)-500;
                        caloriasGanar= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.3f)+500;        
                        
                        cMantener.setText(caloriasMantener+"");
                        cGanar.setText(caloriasGanar+"");
                        cPerder.setText(caloriasPerder+"");
                        
                        try {
		                	ventana.setUsuario(new Usuario(ventana.getUsuario().getNombre(), caloriasMantener,caloriasPerder, caloriasGanar));
							ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.68:3306/programanutricion","dietista","dietista"));
							//usamos
							PreparedStatement smt =
							ventana.getCon().prepareStatement("insert calorias values(?,?,?,?)");
							
							smt.setString(1, ventana.getUsuario().getNombre());
							smt.setFloat(2, caloriasMantener);
							smt.setFloat(3, caloriasPerder);
							smt.setFloat(4, caloriasGanar);
							
							
							smt.executeUpdate();
							ventana.getCon().close();
							ventana.irAPerfil();
		                } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//CON ESTO RELLENO LOS VALORES DE LAS CALORIAS DEL USUARIO
                    }
                    
                    break;
                    
                case "Actividad moderada":
                    //Condicion para el radiobutton hombre o mujer
                    if (femeninoUser.isSelected()) {
                        //CALORIAS PARA MUJER: (655+(9,6* PESO) + (1,8 * ALTURA) - (4,7 * EDAD)) * ACTIVIDAD FISICA
                        caloriasMantener= Math.round((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.5f);
                        caloriasPerder= Math.round(((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.5f)-500);
                        caloriasGanar= Math.round(((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.5f)+500);        
                        
                        cMantener.setText(caloriasMantener+"");
                        cGanar.setText(caloriasGanar+"");
                        cPerder.setText(caloriasPerder+"");
                        
                        try {
		                	ventana.setUsuario(new Usuario(ventana.getUsuario().getNombre(), caloriasMantener,caloriasPerder, caloriasGanar));
							ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.68:3306/programanutricion","dietista","dietista"));
							//usamos
							PreparedStatement smt =
							ventana.getCon().prepareStatement("insert calorias values(?,?,?,?)");
							
							smt.setString(1, ventana.getUsuario().getNombre());
							smt.setFloat(2, caloriasMantener);
							smt.setFloat(3, caloriasPerder);
							smt.setFloat(4, caloriasGanar);
							
							
							smt.executeUpdate();
							ventana.getCon().close();
							ventana.irAPerfil();
		                } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//CON ESTO RELLENO LOS VALORES DE LAS CALORIAS DEL USUARIO
                    }else{
                        //CALORIAS PARA HOMBRE: (66+(13,7* PESO) + (5* ALTURA) - (6,8 * EDAD)) * ACTIVIDAD FISICA
                        caloriasMantener= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.5f);
                        caloriasPerder= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.5f)-500;
                        caloriasGanar= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.5f)+500;        
                        
                        cMantener.setText(caloriasMantener+"");
                        cGanar.setText(caloriasGanar+"");
                        cPerder.setText(caloriasPerder+"");
                        
                        try {
		                	ventana.setUsuario(new Usuario(ventana.getUsuario().getNombre(), caloriasMantener,caloriasPerder, caloriasGanar));
							ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.68:3306/programanutricion","dietista","dietista"));
							//usamos
							PreparedStatement smt =
							ventana.getCon().prepareStatement("insert calorias values(?,?,?,?)");
							
							smt.setString(1, ventana.getUsuario().getNombre());
							smt.setFloat(2, caloriasMantener);
							smt.setFloat(3, caloriasPerder);
							smt.setFloat(4, caloriasGanar);
							
							
							smt.executeUpdate();
							ventana.getCon().close();
							ventana.irAPerfil();
		                } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//CON ESTO RELLENO LOS VALORES DE LAS CALORIAS DEL USUARIO
                    }
                    
                    break; 
                case "Actividad intensa":
                    //Condicion para el radiobutton hombre o mujer
                    if (femeninoUser.isSelected()) {
                        //CALORIAS PARA MUJER: (655+(9,6* PESO) + (1,8 * ALTURA) - (4,7 * EDAD)) * ACTIVIDAD FISICA
                        caloriasMantener= Math.round((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.7f);
                        caloriasPerder= Math.round(((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.7f)-500);
                        caloriasGanar= Math.round(((655+(9.6f*peso)+(1.8*altura)-(4.7f*edad))*1.7f)+500);        
                        
                        cMantener.setText(caloriasMantener+"");
                        cGanar.setText(caloriasGanar+"");
                        cPerder.setText(caloriasPerder+"");
                        
                        try {
		                	ventana.setUsuario(new Usuario(ventana.getUsuario().getNombre(), caloriasMantener,caloriasPerder, caloriasGanar));
							ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.68:3306/programanutricion","dietista","dietista"));
							//usamos
							PreparedStatement smt =
							ventana.getCon().prepareStatement("insert calorias values(?,?,?,?)");
							
							smt.setString(1, ventana.getUsuario().getNombre());
							smt.setFloat(2, caloriasMantener);
							smt.setFloat(3, caloriasPerder);
							smt.setFloat(4, caloriasGanar);
							
							
							smt.executeUpdate();
							ventana.getCon().close();
							ventana.irAPerfil();
		                } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    }else{
                        //CALORIAS PARA HOMBRE: (66+(13,7* PESO) + (5* ALTURA) - (6,8 * EDAD)) * ACTIVIDAD FISICA
                        caloriasMantener= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.7f);
                        caloriasPerder= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.7f)-500;
                        caloriasGanar= Math.round((66+(13.7f*peso)+(5*altura)-(6.8f*edad))*1.7f)+500;        
                        
                        cMantener.setText(caloriasMantener+"");
                        cGanar.setText(caloriasGanar+"");
                        cPerder.setText(caloriasPerder+"");
                        
                        try {
		                	ventana.setUsuario(new Usuario(ventana.getUsuario().getNombre(), caloriasMantener,caloriasPerder, caloriasGanar));
							ventana.setCon(DriverManager.getConnection("jdbc:mysql://192.168.1.68:3306/programanutricion","dietista","dietista"));
							//usamos
							PreparedStatement smt =
							ventana.getCon().prepareStatement("insert calorias values(?,?,?,?)");
							
							smt.setString(1, ventana.getUsuario().getNombre());
							smt.setFloat(2, caloriasMantener);
							smt.setFloat(3, caloriasPerder);
							smt.setFloat(4, caloriasGanar);
							
							
							smt.executeUpdate();
							ventana.getCon().close();
							ventana.irAPerfil();
		                } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    }
                    
                    
                    ventana.setUsuario(new Usuario(ventana.getUsuario().getNombre(), caloriasMantener,caloriasPerder, caloriasGanar));  
                    break;    
                        
            }
            
            
            
           }
          }
        }
	}
}
