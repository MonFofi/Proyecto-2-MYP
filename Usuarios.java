public abstract class Usuarios{
  protected String nombre;
  protected String rol;
  protected CACServidor cac;

  public Usuarios (String nombre){
    this.nombre = nombre;
    cac = new CACServidor();
  }

  public String getNombre(){
    return nombre;
  }

  public String getRol(){
    return rol;
  }

  public abstract void escanearCodigo(String codigo);
  // public abstract void solicitudDeChips();
  
  public void cerrarSesion(){
    System.out.println("Cerrando sesión de " + nombre);
  }


}