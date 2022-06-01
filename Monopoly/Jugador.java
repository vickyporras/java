import java.util.ArrayList;
import java.util.Arrays;

public class Jugador{
	private String nombre;
	private String faccion;
	private String figura;
	private double dinero;
	private ArrayList<Calle> propiedades = new ArrayList<Calle>();
	private int posicion;
	
	public Jugador(String nombre, String faccion, String figura) {
		this.nombre = nombre;
		this.faccion = faccion;
		this.figura = figura;
		this.dinero = 7000;
		this.posicion = 0;
	}
		
	public String getFaccion() {
		return this.faccion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	
	public double getDinero() {
		return this.dinero;
	}
	
	public int getPosicion() {
		return this.posicion;
	}
		
	public void setPosicion(int posicion) {
		this.posicion = posicion;
		
	}
	public void aniadirPropiedad(Calle calle) {
		this.propiedades.add(calle);
	}
	public void retirarPropiedad(Calle calle) {
		this.propiedades.remove(calle);
	}
	public ArrayList<Calle> getPropiedades(){
		return this.propiedades;
	}
}
