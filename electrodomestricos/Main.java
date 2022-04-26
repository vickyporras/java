import java.util.Scanner;
public class Main{
    public static void main (String[] args){
      System.out.println("Vicky Porras");
      System.out.println("ELECTRODOMESTICO POR DEFECTO:");
      Electrodomestico porDefecto = new Electrodomestico();
      System.out.println(porDefecto);
      System.out.println("como quieres que sea tu electrodomestico?");
      Scanner scp = new Scanner(System.in);
      System.out.println("escribe un precio(en numero entero): ");
      double precio =scp.nextInt();
    //  Scanner scc =new Scanner(System.in);
    //  System.out.println("escribe un color para tu electrodomestico: ");
      //string color = scc.nextString();

      Electrodomestico miElectrodomestico = new Electrodomestico(precio, "color", "A", "80Kg");
      System.out.println(miElectrodomestico);
      System.out.println("el PRECIO final es  " + miElectrodomestico.precio_final(23.87,"A"));
    }
}
