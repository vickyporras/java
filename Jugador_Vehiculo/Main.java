import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner (System.in);
    String avance;
    int avancex,avancey;

    Jugador miJugador = new Jugador("Yo");
    System.out.println(miJugador);
    JugadorPro miJugadorPro = new JugadorPro("YoPro");
    System.out.println(miJugadorPro);

    miJugador.andar(10,10);
    miJugadorPro.andar(20,20);
    System.out.println(miJugador);
    System.out.println(miJugadorPro);

    System.out.print("Indica cuanto avanzar en la X: ");
    avancex = Integer.parseInt(sc.nextLine());
    System.out.print("Indica cuanto avanzar en la Y: ");
    avancey = Integer.parseInt(sc.nextLine());
    miJugador.andar(avancex,avancey);
    System.out.println(miJugador);

  }
}
