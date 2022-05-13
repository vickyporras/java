
import java.util.Scanner;


enum Habitaciones{
  SIMPLES(1,50), DOBLES(2,80), TRIPLES(3,100), MULTIPLES(6,150);
  private int personas;
  private double precio;
  Habitaciones (int personas, double precio){
    this.personas = personas;
    this.precio = precio;
  }
  public int getPersonas(){
    return this.personas;
  }
  public void setPersonas(int personas){
    this.personas=personas;
  }
  public double getPrecio(){
    return this.precio;
  }
  public void setPrecio(double precio){
   this.precio = precio;
  }
  public String suficientesCamas(int gente){
    String nota;
    if(gente > personas){
      nota = "Necesitas una haitacion mas grande... ";
    }
    else nota = "PERFECTO :)";
    return nota;
  }
  public double precioHabitacion(int noches){
    return noches * precio;
  }
}

public class Main{
  public static void main(String[] args){
    String problema;
    System.out.println("Vicky Porras :)");
    System.out.println("Prueba de codigo: ");
    Habitaciones habitacionMaria = Habitaciones.SIMPLES;
    System.out.println("La habitacion de maria tiene " + habitacionMaria.getPersonas() + " personas.");
    System.out.println("------------------------------------ ");
    System.out.println("Llega un cliente!");
    Scanner sct = new Scanner(System.in);
    System.out.println("¿Que tipo de habitacion quiere? SIMPLES/DOBLES/TRIPLES/MULTIPLES ");
    String tipo = sct.nextLine();
    Habitaciones habitacionNueva = Habitaciones.valueOf(tipo);
    Scanner scp = new Scanner(System.in);
    System.out.println("Cuantas personas son ??");
    int gente = scp.nextInt();
    System.out.println(habitacionNueva.suficientesCamas(gente));
    Scanner scn = new Scanner(System.in);
    System.out.println("Cuantas noches se quedan ???");
    int noches = scn.nextInt();
    System.out.println("El precio de " + noches + " noches, en una habitacion " + tipo + " es de " + habitacionNueva.precioHabitacion(noches) + " euros.");

  }
}
