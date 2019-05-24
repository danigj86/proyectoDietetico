package clases;

import java.time.LocalDate;

public class Usuario {
	private String nombre;
	private String contrasenia;
	private int edad;
	private float altura;
	private float  caloriasMantener;
    private float caloriasPerder;
    private float caloriasGanar;

	

	public Usuario(String nombre, String contrasenia, int edad, float altura) {
		super();
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.edad = edad;
		this.altura = altura;
	}



	public Usuario(String nombre, float caloriasMantener, float caloriasPerder, float caloriasGanar) {

		super();
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.edad = edad;
		this.altura = altura;
		this.caloriasMantener = caloriasMantener;
		this.caloriasPerder = caloriasPerder;
		this.caloriasGanar = caloriasGanar;
	}

	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
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
