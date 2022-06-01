public class MonstruoMalo{
  public int vida;
  public int dano;
  public int agilidad;


  public MonstruoMalo(){
    this.vida=(int)(Math.random()*(5-7+1)+7);
    this.dano=(int)(Math.random()*(2-4+1)+4);
    this.agilidad=(int)(Math.random()*(5-7+1)+7);
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
  public void menosVida(){
    this.vida = vida -1;
  }
  public void menosVidaAleatorio(){
    int m = (int)(Math.random()*dano+1);
    this.vida = vida - m ;
  }



  public String toString(){
    return "Lucas tiene " + this.vida + " vidas, un daño de  " + this.dano+ " y una agilidad de " + this.agilidad;
  }
}
