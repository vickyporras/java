/*
 public class Gato extends Animal{
  public String onomatopeya(){
  return "Miau";
  }
  public String durmiendo(){
    return "Zzz... RrrrrrrrrrrRRRRrrr";
  }
  public String comiendo(){
    this.alimentacion = "Raspa de pescado";
    return "Yo como " + this.alimentacion;
  }
}
*/
public class Gato implements Animales_Intfz{
  public String onomatopeya(){
  return "Miau";
  }
  public String durmiendo(){
    return "Zzz... RrrrrrrrrrrRRRRrrr";
  }
  public String comiendo(){
    String alimentacion = "Raspa de pescado";
    return "Yo como " + alimentacion;
  }
}
