public class Almacenista extends Usuarios{

  public ListaDeChips chipsDisponibles = cac.getChipsDisponibles();
  public ListaDeChips chipsReservados = cac.getChipsReservados();
  public ListaDeChips chipsVendidos = cac.getChipsReservados();

  public Almacenista(String nombre, String iD){
    super(nombre, iD);
    rol = "almacenista";
  }

  //registrar caja
  @Override
  public void escanearCodigo(String codigo){
    cac.registrarCaja(codigo);
  }

  public void asignarChip(){
    // cac.
  }
  
  public void asignarChipsATodos(){

  }

}