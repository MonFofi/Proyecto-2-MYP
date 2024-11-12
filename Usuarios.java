public abstract class Usuarios{
  protected String nombre;
  protected String rol;
  protected String iD;
  protected CACServidor cac;

  public Usuarios (String nombre, String iD){
    this.nombre = nombre;
    this.iD = iD;
    this.cac = null;
  }

  public void inicializarServidor(){
    this.cac = CACServidor.getServidor();
  }

  public String getNombre(){
    return nombre;
  }

  public String getRol(){
    return rol;
  }

  public String getID(){
    return iD;
  }

  public abstract void mostrarDisponibles();
  public abstract void mostrarReservados();
  public abstract void mostrarVendidos();

}