package principal;

import java.util.ArrayList;

public class Alimento {
	
	private String nombre;
    private int calorias;
    private float proteinas;
    private float carbohidratos;
    private float grasas;
    private ArrayList<Alimento> afines;

    public Alimento(String nombre, int calorias, float proteinas, float carbohidratos, float grasas) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public float getProteinas() {
        return proteinas;
    }

    public void setProteinas(float proteinas) {
        this.proteinas = proteinas;
    }

    public float getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public float getGrasas() {
        return grasas;
    }

    public void setGrasas(float grasas) {
        this.grasas = grasas;
    }

    public ArrayList<Alimento> getAfines() {
        return afines;
    }

    public void setAfines(ArrayList<Alimento> afines) {
        this.afines = afines;
    }

    
    
    @Override
    public String toString() {
        return "Alimentos- " + nombre + ". Valores (por cada 100gr de alimento) - calorias: " + calorias + ", proteinas: " + proteinas + ", carbohidratos: " + carbohidratos + ", grasas: " + grasas ;
    }
    

}
