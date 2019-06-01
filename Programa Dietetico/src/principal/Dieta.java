package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

import excepciones.EdadException;
import excepciones.FechaException;

public class Dieta {
	 private String nombre;
	    private Plato[] plato;
	    private LocalDate fInicio;
	    private LocalDate fFin;
	    private String desayuno;
	    private String almuerzo;
	    private String merienda;
	    private String cena;
	    
		public Dieta(String nombre, Plato[] plato, String fInicio, String fFin) throws FechaException {
			super();
			this.nombre = nombre;
			this.plato = plato;
			this.setfInicio(fInicio);
			this.setfFin(fInicio);
		}
		
		

		public Dieta(String desayuno, String almuerzo, String merienda, String cena) {
			super();
			this.desayuno = desayuno;
			this.almuerzo = almuerzo;
			this.merienda = merienda;
			this.cena = cena;
		}



		
		
		/**
		 * @return the desayuno
		 */
		public String getDesayuno() {
			return desayuno;
		}



		/**
		 * @param desayuno the desayuno to set
		 */
		public void setDesayuno(String desayuno) {
			this.desayuno = desayuno;
		}



		/**
		 * @return the almuerzo
		 */
		public String getAlmuerzo() {
			return almuerzo;
		}



		/**
		 * @param almuerzo the almuerzo to set
		 */
		public void setAlmuerzo(String almuerzo) {
			this.almuerzo = almuerzo;
		}



		/**
		 * @return the merienda
		 */
		public String getMerienda() {
			return merienda;
		}



		/**
		 * @param merienda the merienda to set
		 */
		public void setMerienda(String merienda) {
			this.merienda = merienda;
		}



		/**
		 * @return the cena
		 */
		public String getCena() {
			return cena;
		}



		/**
		 * @param cena the cena to set
		 */
		public void setCena(String cena) {
			this.cena = cena;
		}



		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Plato[] getPlato() {
			return plato;
		}

		public void setPlato(Plato[] plato) {
			this.plato = plato;
		}

		public LocalDate getfInicio() {
			return fInicio;
		}

		public void setfInicio(String fInicio) throws DateTimeParseException {
			this.fInicio = LocalDate.parse(fInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}

		public LocalDate getfFin() {
			return fFin;
		}

		public void setfFin(String fFin) throws DateTimeParseException {
			
			
			this.fFin =	LocalDate.parse(fFin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			
			
		}

		@Override
		public String toString() {
			return "Dieta [nombre=" + nombre + ", plato=" + Arrays.toString(plato) + ", fInicio=" + fInicio + ", fFin="
					+ fFin + "]";
		}
	    

	  

}
