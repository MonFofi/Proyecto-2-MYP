public class Almacenista extends Usuarios{

  public ListaDeChips chipsDisponibles;
  public ListaDeChips chipsReservados;
  public ListaDeChips chipsVendidos;

  public Almacenista(String nombre, String iD){
    super(nombre, iD);
    rol = "almacenista";
    inicializarServidor();
    chipsDisponibles = cac.getChipsDisponibles();
    chipsReservados = cac.getChipsReservados();
    chipsVendidos = cac.getChipsReservados();
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
    cac.procesarTodasSolicitudes();
  }

  public void verSolicitudes(){
    cac.mostrarSolicitudes();
  }

  public void verChipsRegistrados(){
    cac.mostrarRegistrados();
  }  

  public void verChipsDisponibles(){
    cac.mostrarDisponibles();
  }

  public void verChipsReservados(){
    cac.mostrarReservados();
  }

  public void verChipsVendidos(){
    cac.mostrarVendidos();
  }


}