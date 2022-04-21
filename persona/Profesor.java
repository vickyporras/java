public class Profesor extends Persona {
  protected   String sueldo;

  public Profesor(){
    super();
    this.sueldo = "";
  }
  public Profesor(String nombre, String dni, String sueldo){
    super(nombre,dni);
    this.sueldo = sueldo;
  }
  public Profesor(Profesor profesor){
    super(profesor.nombre, profesor.dni);
    this.sueldo = profesor.sueldo;
  }
  public String getSueldo(){
    return this.sueldo;
  }
  public void setSueldo(String sueldo){
   this.sueldo = sueldo;
 }
 public String toString(){
   return super.toString() + " Su sueldo es:  " + this.sueldo;
 }
}
