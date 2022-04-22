public class Electrodomestico{
  protected Double precio_base;
  protected String color;
  protected String consumo;
  protected String peso;
  public Double precio;

  //constructores
  public Electrodomestico(){
    this.precio_base=100.999;
    this.color="blanco";
    this.consumo="F";
    this.peso="20kg";
  }
  public Electrodomestico(Double precio_base, String color, String consumo, String peso){
    this.precio_base=precio_base;
    this.color=color;
    this.consumo=consumo;
    this.peso=peso;
  }
  public Electrodomestico(Electrodomestico electrodomestico){
    this.precio_base = electrodomestico.precio_base;
    this.color = electrodomestico.color;
    this.consumo = electrodomestico.consumo;
    this.peso = electrodomestico.peso;
  }
  public Double getPrecio_base(){
    return this.precio_base;
  }
  public String getColor(){
    return this.color;
  }
  public String getConsumo(){
    return this.consumo;
  }
  public String getPeso(){
    return this.peso;
  }
  public void setPrecio_base(Double precio_base){
   this.precio_base = precio_base;
  }
  public void setColor(String color){
   this.color = color;
  }
  public void setConsumo(String consumo){
    this.consumo=consumo;
  }
  public void setPeso(String peso){
    this.peso=peso;
  }
  public Double precio_final(Double precio_base, String consumo){
    if(consumo=="F"){
      precio= precio_base;
    }
    if(consumo=="E"){
      precio= precio_base+20;
    }
    if(consumo=="D"){
      precio= precio_base+40;
    }
    if(consumo=="C"){
      precio= precio_base+60;
    }
    if(consumo=="B"){
      precio= precio_base+80;
    }
    if(consumo=="A"){
      precio= precio_base+100;
    }
    return precio;
  }
  //ToString
  public String toString(){
    return "El precio base es  " + this.precio_base + "€, el color es " + this.color + ", el consumo es " + this.consumo + "  y pesa " + this.peso;
  }
}
