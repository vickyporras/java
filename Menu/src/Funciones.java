import java.util.ArrayList;

public class Funciones {
	
	ArrayList<String> lista = new ArrayList<String>();

	public Funciones(ArrayList<String> lista) {
		super();
		this.lista = lista;
	}

	public Funciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getLista() {
		return lista;
	}

	public void setLista(ArrayList<String> lista) {
		this.lista = lista;
	}
	
	public void crearTarea(String tarea) {
		lista.add(tarea);
	}
	
	public void borrarTarea(String tarea) {
		/*si tarea es == a algun valor delArryList, borrar ese valor*/
		lista.remove(tarea);
		
	}
	
	public void actualizarTarea(String tarea) {
		
	}
	
	public void editarTarea(String nuevatarea) {
		/*si tarea es equals a un valor del ArrayList intercambiar x el valor nuevo*/
		int indice = lista.indexOf(nuevatarea);
		
		if(indice != -1) {
			lista.set(indice, nuevatarea);
		}
		
	}
	
	
}
