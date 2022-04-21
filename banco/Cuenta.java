public class Cuenta{
  protected String titular;
  protected Double cantidad;

  //constructores
  public Cuenta(){
    this.titular="";
    this.cantidad=0;
  }
  public Cuenta(String titular, Double cantidad){
    this.titular=titular;
    this.cantidad=cantidad;
  }
  public Cuenta(Cuenta cuenta){
    this.titular = cuenta.titular;
    this.cantidad = cuenta.cantidad;
  }
  public String getTitular(){
    return this.titular;
  }
  public Double getCantidad(){
    return this.cantidad;
  }
  public void setTitular(String titular){
   this.titular = titular;
  }
  public void setCantidad(Double cantidad){
   this.cantidad = cantidad;
  }



  //ToString
  public String toString(){
    return "El titular de la cuenta es  " + this.titular + ", y la cantidad de su cuenta es " + this.cantidad;
  }
}
