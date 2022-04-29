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
