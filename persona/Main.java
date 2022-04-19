public class Main{
  public static void main (String[] args){
    Persona miPersona = new Persona("Paula", "9875640K");
    System.out.println(miPersona);
    System.out.println("el nombre es " + miPersona.getNombre());
    System.out.println("el dni es " + miPersona.getDNI());
    miPersona.setNombre("celia");
    miPersona.setDNI("17263m");
    System.out.println(miPersona);
  }
}
