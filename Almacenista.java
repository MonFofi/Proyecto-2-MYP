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
    chipsVendidos = cac.getChipsVendidos();
  }

  //registrar caja
  public void escanearCaja(String codigo){
    cac.registrarCaja(codigo);
  }

  public void asignarChip(Solicitud s){
    cac.procesarSolicitud(s);
  }
  
  public void asignarChipsATodos(){
    cac.procesarTodasSolicitudes();
  }

  public void verSolicitudes(){
    cac.mostrarSolicitudes();
  }

  public void solicitudRecibida(Solicitud s){
    cac.recibirSolicitud(s);
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