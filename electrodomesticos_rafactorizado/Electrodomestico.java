/*
------------------------
|   Electrodomestico   |
|----------------------|
| - precioBase         |
| - color              |
| - consumoEnergetico  |
| - peso               |
|----------------------|
| + precioFinal()      |
|----------------------|
*/

public class Electrodomestico{
  private double precioBase;
  private String color;                 //Blanco, Negro, Rojo, Azul, Metalizado.
  private String consumoEnergetico;
  private double peso;

  // No es necesario utilizar listas dinámicas ni, por tanto, ArrayList.
  // Se declaran aquí y no dentro de las funciones porque se van a utilizar más de una vez.
  String colores[] = {"blanco","negro","rojo","azul","metalizado"};
  String codigos[] = {"F","E","D","C","B","A","AA","AAA"};

  // NUEVO -> final static == const
  private final static double PRECIO = 100;
  private final static String COLOR = "blanco"; // Para escribir COLOR cada vez que queramo poner el color por defecto.
  private final static String CONSUMO = "F";
  private final static double PESO = 20;

  //Constructores
  public Electrodomestico(){
    /*this.precioBase = 100;
    this.color = "Blanco";
    this.consumoEnergetico = "F";
    this.peso = 20;*/
    this(PRECIO,COLOR,CONSUMO,PESO);            //Llama al constructor con parámetros.
  }
  public Electrodomestico(double precioBase, String consumoEnergetico){
    /*this.precioBase = precioBase;
    this.color = "Blanco";
    this.consumoEnergetico = consumoEnergetico;
    this.peso = 20;*/
    this(precioBase,COLOR,consumoEnergetico,PESO);
  }
  public Electrodomestico(double precioBase, String color, String consumoEnergetico, double peso){
    this.precioBase = precioBase;
    //this.color = color;
    this.setColor(color);
    //this.consumoEnergetico = consumoEnergetico;
    comprobarCodigoEnergetico(consumoEnergetico);
    this.peso = peso;
  }
  public Electrodomestico(Electrodomestico electrodomestico){
    /*this.precioBase = electrodomestico.precioBase;
    this.color = electrodomestico.color;
    this.consumoEnergetico = electrodomestico.consumoEnergetico;
    this.peso = electrodomestico.peso;*/
    this(electrodomestico.precioBase,electrodomestico.color,electrodomestico.consumoEnergetico,electrodomestico.peso);
  }

  // Set y Get
  public void setPrecioBase(double precioBase){
    this.precioBase = precioBase;
  }
  public void setColor(String color){
    //this.color = color;
    comprobarColor(color);
  }
  public void setConsumoEnergetico(String consumoEnergetico){
    //this.consumoEnergetico = consumoEnergetico;
    comprobarCodigoEnergetico(consumoEnergetico);
  }
  public void setPeso(double peso){
    this.peso = peso;
  }
  public double getPrecioBase(){
    return this.precioBase;
  }
  public String getColor(){
    return this.color;
  }
  public String getConsumoEnergetico(){
    return this.consumoEnergetico;
  }
  public double getPeso(){
    return this.peso;
  }

  private void comprobarColor(String color){
    boolean encontrado = false;

    this.color = COLOR;              //Por defecto.
    color = color.toLowerCase();
    for (int i = 0 ; i < colores.length && !encontrado ; i++){
      if (colores[i].equals(color)){
        encontrado = true;
        this.color = color;
      }
    }
  }
  /*
  private void comprobarCodigoEnergetico(String codigo){
    boolean encontrado = false;
    this.consumoEnergetico = CONSUMO;              //Por defecto.
    codigo = codigo.toUpperCase();
    for (int i = 0 ; i < codigos.length && !encontrado ; i++){
      if (codigos[i].equals(codigo)){
        encontrado = true;
        this.consumoEnergetico = codigo;
      }
    }
  }
  */
  // Podemos mejorar comprobarCodigoEnergetico para que devuelva la posición en la que ha encontrado la letra:
  private int comprobarCodigoEnergetico(String codigo){
    boolean encontrado = false;

    this.consumoEnergetico = CONSUMO;              //Por defecto.
    codigo = codigo.toUpperCase();
    int i;
    for (i = 0 ; i < codigos.length && !encontrado ; i++){
      if (codigos[i].equals(codigo)){
        encontrado = true;
        this.consumoEnergetico = codigo;
      }
    }
    return i-1; //Porque si no el i++ devuelve la siguiente posición.
  }

  public double precioFinal(){
    return this.precioBase + extraPeso() + extraEficiencia() + extraColor();

  }

  private double extraPeso(){
    int rango = (int)(this.peso/20);  // Cada 20kg que aumenta el peso
    return rango*30;                  // El precio aumenta 30€
  }
  private double extraEficiencia(){
    /*
    |F| E| D| C| B|  A| AA|AAA|
    |0|20|40|60|80|100|120|140|
    */
    // hemos mejorado comprobarCodigoEnergetico() para que devuelva la posición.
    int posicion = comprobarCodigoEnergetico(this.consumoEnergetico);
    return posicion*20;
  }
  private double extraColor(){
    double descuento = 0;
    if ((this.color).equals(COLOR)) descuento = -20;
    return descuento;
  }

  // EXTRA: Pensar en la posible refactorización de los métodos comprobarColor() y comprobarCodigoEnergetico()

  public String toString(){
    return "El precio base es  " + this.precioBase + ", el color es " + this.color + ", el consumo es " + this.consumoEnergetico + ", el peso es "+ this.peso + ".\nEl precio final es: " + precioFinal() + ".";
  }
}
