public class Alumno extends Persona{
  private   String grado;               // Acceso solo desde la clase.
            String gradoSinMod;         // Acceso desde el paquete.
  protected String gradoProt;           // Acceso desde los hijos y el paquete.
  public    String gradoPubl;           // Acceso global.

  enum Nota{ // Escribir hacia abajo si hay que hacer scroll.
    SOBRESALIENTE, NOTABLE, BIEN, SUFICIENTE, INSUFICIENTE; // El ; no es necesario
  }

  Nota nota;
  private String resultadoNotas; // Para el stringNotas.

  public Alumno(){
    super();
    this.grado = "DAW";
    this.nota = Nota.SUFICIENTE;

  }
  public Alumno(String nombre, String dni, String grado){
    super(nombre,dni);
    this.grado = grado;
    this.nota = Nota.SUFICIENTE;
  }
  public Alumno(Alumno alumno){
    super(alumno.nombre,alumno.dni);
    this.grado = alumno.grado;
    this.nota = alumno.nota;
  }

  private String stringNotas(){
    switch(this.nota){
      case SOBRESALIENTE:
        resultadoNotas = "Oleeeeeee! Asi se hase! :)";
        break;
      case NOTABLE:
        resultadoNotas = "Lo has hecho muy bien!!";
        break;
      case BIEN:
        resultadoNotas = "Bien!!";
        break;
      case SUFICIENTE:
        resultadoNotas = "Ta'bien... Pero por lo' peloh";
        break;
      case INSUFICIENTE:
        resultadoNotas = "Asi NO se hase! :(";
        break;
    }
    return resultadoNotas;
  }

  // Gets y Sets

  public Nota getNota(){
    return this.nota;
  }
  public void setNota(Nota nota){
    this.nota = nota;
  }

  public String toString(){
    return super.toString() + " Estoy en el grado de " + this.grado + ". " + this.stringNotas() + ".";
  }
}
