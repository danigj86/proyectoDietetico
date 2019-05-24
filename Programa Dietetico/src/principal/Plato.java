package principal;

import java.util.ArrayList;

public class Plato {

	private ArrayList<Alimento> ingredientes;
    private String preparacion;
     String nombre;
    
    
    public Plato(ArrayList<Alimento> ingredientes, String preparacion, String nombre) {
		super();
		this.ingredientes = ingredientes;
		this.preparacion = preparacion;
		this.nombre = nombre;
	}

	public ArrayList<Alimento> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Alimento> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/*
	public static Plato buscarPlato(Alimento base,int caloriasObjetivo){
        System.out.println("hola");
    }
    */
	
	
	
	public int getCalorias() {
		int suma=0;
		for (int i = 0; i < this.ingredientes.size(); i++) {
			suma+=ingredientes.get(i).getCalorias();
		}
		return suma;
	}
}
