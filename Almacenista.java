public class Almacenista extends Usuarios{

  public Almacenista(String nombre){
    super(nombre);
    rol = "almacenista";
  }

  //registras caja
  @Override
  public void escanearCodigo(String codigo){
    CajaChips caja = new CajaChipsBuilder().setListaDeChips(cac.getChipsDisponibles()).setCodigoDeBarras(codigo).construir();
  }

  public void asignarChip(){
    // cac.
  }
  
  public void asignarChipsATodos(){

  }

}