public class Persona{
  protected String nombre;
  protected String dni;

  //constructores
  public Persona(){
    this.nombre="celia";
    this.dni="74543005M";
  }
  public Persona(String nombre, String dni){
    this.nombre=nombre;
    this.dni=dni;
  }
  public Persona(Persona persona){
    this.nombre = persona.nombre;
    this.dni = persona.dni;
  }
  public String getNombre(){
    return this.nombre;
  }
  public String getDNI(){
    return this.dni;
  }
  public void setNombre(String nombre){
   this.nombre = nombre;
  }
  public void setDNI(String dni){
   this.dni = dni;
  }


  //ToString
  public String toString(){
    return "me llamo " + this.nombre + " y mi dni es " + this.dni;
  }
}
