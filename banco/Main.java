import java.util.Scanner;

public class Main{
    public static void main (String[] args){
      Cuenta miCuenta = new Cuenta("Victoria", 200.769);
      System.out.println(miCuenta);
      Scanner sc = new Scanner(System.in);
      System.out.println("Que cantidad quieres  ingresar: ");
      double ingreso = sc.nextDouble();
      System.out.println("La cantidad total de tu cuenta ahora es:  " + miCuenta.ingresar(ingreso));

    }
}
