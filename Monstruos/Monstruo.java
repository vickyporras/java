


public class Monstruo{
  public int vida;
  public int dano;
  public int agilidad;


  public Monstruo(){
    this.vida=(int)(Math.random()*5+1);
    this.dano=(int)(Math.random()*(3-6+1)+6);
    this.agilidad=(int)(Math.random()*(3-7+1)+7);
  }

  public int getVida(){
    return this.vida;
  }
  public int getDano(){
    return this.dano;
  }
  public int getAgilidad(){
    return this.agilidad;
  }
  public void setVida(int vida){
    this.vida = vida;
  }
  public void setDano(int dano){
    this.dano = dano;
  }
  public void setAgilidad(int agilidad){
    this.agilidad = agilidad;
  }
  public int pelear(){
    int r = (int)(Math.random()*100+1);
    int peleo;
        if (r < agilidad ) {
            peleo = 1;
        } else {
            peleo = 2;
          }
        return peleo;
    }
  public void menosVida(){
      this.vida = vida -1;
  }




  public String toString(){
    return "Pepe tiene " + this.vida + " vidas, un daño de  " + this.dano+ " y una agilidad de " + this.agilidad;
  }
}
