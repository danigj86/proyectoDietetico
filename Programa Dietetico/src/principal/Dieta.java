package principal;

import java.time.LocalDate;
import java.util.Arrays;

public class Dieta {
	 private String nombre;
	    private Plato[] plato;
	    private LocalDate fInicio;
	    private LocalDate fFin;
	    
		public Dieta(String nombre, Plato[] plato, LocalDate fInicio, LocalDate fFin) {
			super();
			this.nombre = nombre;
			this.plato = plato;
			this.fInicio = fInicio;
			this.fFin = fFin;
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

		public void setfInicio(LocalDate fInicio) {
			this.fInicio = fInicio;
		}

		public LocalDate getfFin() {
			return fFin;
		}

		public void setfFin(LocalDate fFin) {
			this.fFin = fFin;
		}

		@Override
		public String toString() {
			return "Dieta [nombre=" + nombre + ", plato=" + Arrays.toString(plato) + ", fInicio=" + fInicio + ", fFin="
					+ fFin + "]";
		}
	    

	  

}
