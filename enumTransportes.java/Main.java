
enum MediosTransporte{
  AVION(900,0.1,1), TREN(200,0.14,1), COCHE(120,0.12,1), BICICLETA(20,0,1);
  private double km;
  private double precio;
  private double tiempo;
  MediosTransporte (double num, double precio, double tiempo ){
    this.km = num;
    this.precio = precio;
    this.tiempo = tiempo;
  }
  public double getKm(){
    return this.km;
  }
  public double getPrecio(){
    return this.precio;
  }
  public void setPrecio(double precio){
   this.precio = precio;
  }
  public double getTiempo(){
    return this.tiempo=tiempo;
  }
  public void setTiempo(){
    this.tiempo = tiempo;
  }
  public double calcularCuantoCuesta(double kmRecorridos){
    return kmRecorridos * precio;
  }
}

public class Main{
  public static void main(String[] args){
    MediosTransporte coche1 = MediosTransporte.COCHE;
    System.out.println("Me cuesta recorrer 70km en coche:");
    System.out.println(coche1.calcularCuantoCuesta(70));
    System.out.println("euros");
  }
}
