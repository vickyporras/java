import java.util.ArrayList;
import java.util.Random;

public class Tablero {
	// Atributos
	private ArrayList<Calle> calles = new ArrayList<Calle>();
	private int numCalles;
	
	// Constructor (explicación: para que coja las calles de forma aleatoria, se utilizan índices aleatorios y se van restando de un
	// arrayList para que no se repitan -que se define al principio-).
	Tablero(int numCalles, Calle[] listaCalles) {
		this.numCalles = numCalles;
		Random rand = new Random();
		ArrayList<Calle> restandoCalles = new ArrayList<Calle>();
		for (Calle calle : listaCalles) {
			restandoCalles.add(calle);
		}
		Calle calleAleatoria;
		for (int i = 0; i < numCalles; i ++) {
			calleAleatoria = restandoCalles.get(rand.nextInt(restandoCalles.size()));
			this.calles.add(calleAleatoria);
			restandoCalles.remove(calleAleatoria);
		}
	}
	
	public int getNumCalles() {
		return this.numCalles;
	}
	
	public Calle getCalle(int indice) {
		return this.calles.get(indice);
	}
		
	// Imprimir
	public String toString() {
		return "Las calles del tablero han sido seleccionadas aleatoriamente, y son las siguientes:\n" + calles;
	}
			
}
			
