import java.util.Scanner;

public class Main{
  public static void main (String[] args){

    System.out.println("ESCAPA DE LOS MONSTRUOS");
    System.out.println("  EL JUEGO VA A EMPEZAR, TU MONSTRUO SE LLAMA   ¡¡PEPE!! ");
    Monstruo pepe = new Monstruo();
    Scanner sct = new Scanner(System.in);
    System.out.println("Quieres jugar ????? SI/NO");
    String juega = sct.nextLine();
    String si = "SI";
    String no = "NO";
    if (juega.equals(si)){
      System.out.println(pepe.toString());
      System.out.println(" Y te toca escapar de Lucas!!!!");
      MonstruoMalo lucas = new MonstruoMalo();
      System.out.println(lucas.toString());
      System.out.println("Elige que quieres hacer:");
      System.out.println("1) Pelear");
      System.out.println("2) Huir");
      System.out.println("3) Ver mis estadisticas");
      System.out.println("4) Ver las estadisticas del enemigo");
      Scanner scp = new Scanner(System.in);
      System.out.println("1/2/3/4 ???: ");
      int opcion = scp.nextInt();
      if (opcion == 1){
        int o;
        o = pepe.pelear();
        if (o == 1){
          System.out.println("Le has dasdo !! Lucas tiene una vida menos.");
          if (pepe.getDano()> lucas.getVida()){
            lucas.menosVidaAleatorio();
          }
          if (pepe.getDano()< lucas.getVida()){
            lucas.menosVida();
          }
        }
        if (o == 2){
          pepe.menosVida();
          System.out.println("No le diste !!! Tienes una vida menos :(" );
        }
      }
      if (opcion == 2){
        if(pepe.getAgilidad() >= lucas.getAgilidad() ){
          System.out.println(" Has esacpado!!! GANASTE EL JUEGO.!!!!");
        }
        if (pepe.getAgilidad() < lucas.getAgilidad()){
          pepe.menosVida();
          System.out.println("Perdiste una vida !! :(");
        }
      }
      if (opcion == 3){
        System.out.println(pepe.toString());
      }
      if (opcion == 4){
        System.out.println(lucas.toString());
      }
    }
    if (juega.equals(no)){
      System.out.println(" jo :( ");
    }

  }
}
