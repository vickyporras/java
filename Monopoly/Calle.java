public enum Calle {
    VENTORMENTA("Celeste", 2000),
    BOSQUEELWIN("Celeste", 1500),
    PENINSULAINFERNAL("Rojo", 1000),
    DUROTAR("Rojo", 1500),
    TUERCESPINA("Verde", 1800),
    MONTEHYJAL("Verde", 1000),
    TELDRASSIL("Morado", 1300),
    NAGRAND("Morado", 1000),
    COSTAOSCURA("Negro", 1000),
    VALLEFRESNO("Amarillo", 1500),
    FERALAS("Amarillo", 1500);

    private String color;
    private double precioVenta;
    private boolean enPropiedad;
    private Jugador propietario;

    private Calle(String color, double precioVenta){
        this.color = color;
        this.precioVenta = precioVenta;
        this.enPropiedad = false;
    }

    //get
    public String getColor(){
        return this.color;
    }

    public double getPrecioVenta(){
        return this.precioVenta;
    }

    //set

    public void getColor(String color){
        this.color = color;
    }

    public void getPrecioVenta(double precioVenta){
        this.precioVenta = precioVenta;
    }

    //metodos

    public double getPrecioAlquiler(){
        return this.precioVenta * 0.25;
    }

    public boolean getEnPropiedad() {
    	return this.enPropiedad;
    }

    public void setEnPropiedad(boolean propiedad) {
    	this.enPropiedad = propiedad;
    }

    public Jugador getPropietario() {
    	return this.propietario;
    }
    public void setPropietario(Jugador jugador) {
    	this.propietario = jugador;
    }


}
