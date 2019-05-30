package principal;


import excepciones.AlturaException;
import excepciones.ContraseñaException;
import excepciones.EdadException;
import excepciones.NombreException;

public class Usuario {

	  private String nombre;
	    private String pass;
	    private int altura;
	    private int edad;
	    private float  caloriasMantener;
	    private float caloriasPerder;
	    private float caloriasGanar;

	    
	  
	    //CONSTRUCTOR PARA DATOS USUARIO
	    public Usuario(String nombre, String pass, int altura, int edad) throws NombreException, ContraseñaException, AlturaException, EdadException  {
			super();
			this.setNombre(nombre);
			this.setPass(pass);
			this.setAltura(altura);
			this.setEdad(edad);
		}

		//CONSTRUCTOR PARA CALORIAS
	    public Usuario(String nombre, float caloriasMantener, float caloriasPerder, float caloriasGanar) {
			super();
			this.caloriasMantener = caloriasMantener;
			this.caloriasPerder = caloriasPerder;
			this.caloriasGanar = caloriasGanar;
		}

	    public String getNombre() {
	        return nombre;
	    }

	   
		public void setNombre(String nombre) throws NombreException {
	        if (nombre.length()<8) {
				throw new NombreException("Nombre incorrecto");
			}
			
			this.nombre = nombre;
		}
		
		

	    public String getPass() {
	        return pass;
	    }

	    public void setPass(String pass) throws ContraseñaException {
			if (pass.length()<8) {
				throw new ContraseñaException("Password incorrecto");
				
			}
			this.pass = pass;
		}
	    
	   

	    public int getAltura() {
	        return altura;
	    }

	    public void setAltura(int altura) throws AlturaException {
	    	
	    	if (!(altura >=0 && altura<=300)) {
				throw new AlturaException("Altura incorrecta");
			}
	    	this.altura = altura;
	    }

	    public int getEdad() {
	        return edad;
	    }

	    public void setEdad(int edad) throws EdadException {
	    	
	    	if (!(edad >=0 && edad<=100)) {
				throw new EdadException("Edad incorrecta");
			}
	        this.edad = edad;
	    }
	    
		public float getCaloriasMantener() {
			return caloriasMantener;
		}

		public void setCaloriasMantener(float caloriasMantener) {
			this.caloriasMantener = caloriasMantener;
		}

		public float getCaloriasPerder() {
			return caloriasPerder;
		}

		public void setCaloriasPerder(float caloriasPerder) {
			this.caloriasPerder = caloriasPerder;
		}

		public float getCaloriasGanar() {
			return caloriasGanar;
		}

		public void setCaloriasGanar(float caloriasGanar) {
			this.caloriasGanar = caloriasGanar;
		}
}
