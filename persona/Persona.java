public class Persona{
  private String nombre;
  private String dni;

  //constructores
  public Persona(){
    this.nombre="celia";
    this.dni="74543005M";

  }
  //ToString
  public String toString(){
    return "me llamo " + this.nombre + " y mi dni es " + this.dni;
  }
}
