import java.util.Scanner;

public class Main {
  public static void solucionAlternativa(int numPersonas){
    Albergue arrAlbergue[] = Albergue.values();
    double precio, habNecesarias;
    double descuento = 0.85; // 15% descuento == multiplicar * 0.85

    for ( Albergue h : arrAlbergue){
      habNecesarias = Math.ceil((double)numPersonas/(double)h.getPersonas());
      if (h.getDisponibles() > habNecesarias){
        precio = h.getPrecio()*descuento*habNecesarias;
        System.out.println("Con habitaciones de tipo " + h + " vas a necesitar " +
        habNecesarias + " habitaciones y el precio por dia con descuento es: " +
        precio + " euros.");
      }
    }

  }

  public static void main(String[] args){
    Scanner sc = new Scanner (System.in);

    String tipoHabitacion;
    Albergue habitacion = Albergue.SIMPLE;
    int numPersonas = 0, numNoches;
    double precioTotal, precioPorPersona;
    boolean numPersonasValido = false;

    while(!numPersonasValido){
      System.out.print("Indica el tipo de habitacion que desea: ");
      tipoHabitacion = sc.nextLine();
      habitacion = Albergue.valueOf(tipoHabitacion);
      System.out.print("Indica el numero de personas: ");
      numPersonas = sc.nextInt();
      sc.nextLine(); // Limpiamos el buffer.
      //System.out.println(" -- Comprobar que el numero de personas es valido -- ");
      numPersonasValido = habitacion.numPersonasValido(numPersonas);
    }
    System.out.print("Indica el numero de noches: ");
    numNoches = sc.nextInt();
    //System.out.println(" -- Cuanto vale la habitacion en total -- ");
    precioTotal = habitacion.precioTotal(numNoches);
    System.out.println("El precio total es de " + precioTotal + " euros.");
    //System.out.println(" -- Cuanto vale la habitacion en total por persona -- ");
    precioPorPersona = habitacion.precioPorPersona(numPersonas,precioTotal);
    System.out.println("El precio por persona es de " + precioPorPersona + " euros.");

    if (habitacion.getDisponibles() == 0){
      System.out.println("Hemos cometido un error, toma descuento (estas son las opciones): ");
      solucionAlternativa(numPersonas);
    }
  }
}
