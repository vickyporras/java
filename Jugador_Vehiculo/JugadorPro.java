public class JugadorPro extends Jugador{
  protected Vehiculo coche;

  public JugadorPro(String nombre){
    super(nombre);
    this.coche = new Vehiculo();

  }

  public String toString(){
    return super.toString() + "" + coche.toString();
  }
}
