abstract class Contrasenia{
  protected String clave;
  public Contrasenia(){
    this.clave="0000";
  }
  public Contrasenia(String clave){
    this.clave=clave;
  }
  public Contrasenia(Contrasenia contrasenia){
    this.clave = contrasenia.clave;
  }
  public String getClave(){
    return this.clave;
  }
  public void setClave(String clave){
   this.clave = clave;
  }
  public abstract String caratValido();
  public abstract String tamaValido();
  public String no3Rep(){
    return "Contraseña no valida/ no3Rep no implementada";
  }
  public String toString(){
    return "La contraseña es " + this.clave + " El caracter valido es " + this.caratValido() + " Y el tamaño valido es " + this.tamaValido();
  }
}
