import java.util.Scanner;

public class Main{
    public static void main (String[] args){
      Cuenta miCuenta = new Cuenta("Victoria", 200.769);
      System.out.println("Menu");
      System.out.println("Opcion 1: Datos de tu cuenta");
      System.out.println("Opcion 2: Ingresar dinero");
      System.out.println("Opcion 3: Sacar dinero");
      Scanner sci = new Scanner(System.in);
      System.out.println("Que opcion quieres realizar: ");
      int opcion =sci.nextInt();
      if(opcion==1){
        System.out.println(miCuenta);
      }
      if(opcion==2){
        Scanner sc = new Scanner(System.in);
        System.out.println("Que cantidad quieres ingresar: ");
        double ingreso = sc.nextDouble();
        System.out.println("La cantidad total de tu cuenta ahora es:  " + miCuenta.ingresar(ingreso));
      }
      if(opcion == 3){
        Scanner sco = new Scanner(System.in);
        System.out.println("Que cantidad quieres sacar: ");
        double sacar = sco.nextDouble();
        System.out.println("La cantidad total de tu cuenta ahora es:  " + miCuenta.ingresar(sacar));
      }



    }
}
