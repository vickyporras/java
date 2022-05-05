
public class Jugador{
  protected String nombre;
  protected int vidas;
  protected int[] coordenadas;

  private final int MAXVIDAS = 3;
  private final int[] COOR = {0,0};
  public Jugador(String nombre){
    this.nombre = nombre;
    this.vidas = MAXVIDAS;
    this.coordenadas = COOR;
  }

  private String imprCoor(){
    return ("(" + coordenadas[0] + "," + coordenadas[1] + ")");
  }

  public String toString(){
    return "A " + this.nombre + " le quedan " + this.vidas + " vidas y esta en las coordenadas " + this.imprCoor();
  }
}
