import java.util.Scanner;

public class Main{
  public static void solucionAlternativa(int numPersonas){
    Albergue arrAlbergue[] = Albergue.values();
    double descuento = 0.85; // Descuento del 15% es *0,85
    double habitacionesNec;
    double precio;

    for (Albergue h : arrAlbergue){
      habitacionesNec = Math.ceil((double)numPersonas/(double)h.getPersonas());
      if (habitacionesNec <= h.getHabitaciones()){
        precio = habitacionesNec*h.getPrecio()*descuento;
        System.out.println("Con habitaciones de tipo " + h + " vas a necesitar " +
        habitacionesNec + " habitaciones y el precio por dia con descuento " +
        precio + " euros.");
      }
    }
  }

  public static void main(String[] args){
    Scanner sc = new Scanner (System.in);

    Albergue habitacion = Albergue.SIMPLE;
    String tipoHabit;
    int numPersonas = 0, numNoches;
    double precioTotal, precioNoche, precioPorPersona;
    boolean valido = false;

    //System.out.println("-- Comprobar que el tipo de habitacion es valido --");
    while (!valido){
      System.out.println("-- Solicitar tipo de habitacion, numero de personas y numero de noches --");
      System.out.print("Indica el tipo de habitacion que desea: ");
      tipoHabit = sc.nextLine();
      habitacion = Albergue.valueOf(tipoHabit);
      System.out.print("Indica el numero de personas que sois: ");
      //numPersonas = sc.nextInt(); sc.nextLine();
      numPersonas = Integer.parseInt(sc.nextLine());
      valido = habitacion.numPersValido(numPersonas);
    }
    System.out.print("Indica el numero de noches que os vais a quedar: ");
    //numNoches = sc.nextInt(); sc.nextLine();
    numNoches = Integer.parseInt(sc.nextLine());
    System.out.println("-- Calcular precio total -- ");
    precioTotal = habitacion.precioTotal(numNoches);
    System.out.println("El precio total es de: " + precioTotal);
    System.out.println("-- Calcular precio por persona -- ");
    precioPorPersona = habitacion.precioPorPersona(precioTotal,numPersonas);
    System.out.println("El precio por persona es de: " + precioPorPersona);
    System.out.println("-- Proponer habitacion alternativa con descuento --");
    if (habitacion.getHabitaciones() == 0){
      System.out.println("Hemos cometido un error y no quedan libres habitaciones como las reservada, tenemos estas opciones con descuento: ");
      solucionAlternativa(numPersonas);
    }
  }
}
