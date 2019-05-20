package principal;

import java.util.ArrayList;
import java.util.HashMap;

public class Dia {

	private String nombre;
    private HashMap<String,ArrayList<Plato>> platos;

    public Dia(String nombre, HashMap<String, ArrayList<Alimento>> alimentos) {
        this.nombre = nombre;
        this.platos = platos;
        
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  //  public HashMap getAlimento() {
    //    return this.alimentos;
    //}

    public void setAlimento1(HashMap<String,ArrayList<Alimento>> alimento1) {
       // this.alimentos = alimento1;
    }

   //@Override
  //  public String toString() {
    //    return "Dia= "  + nombre + alimentos + '}';
    //}


/*
public String getPlato(int i) {
	// TODO Auto-generated method stub
	return null;
}*/
}
