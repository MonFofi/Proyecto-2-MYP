/**
 * Clase que representa a un almacenista que puede introducir al sistema
 * cajas de chips y asignar estos a los vendedores. Hereda de la clase abstracta Usuario.
 */
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

  @Override
  public void mostrarDisponibles(){
    cac.mostrarDisponibles();
  }

  @Override
  public void mostrarReservados(){
    cac.mostrarReservados();
  }

  @Override
  public void mostrarVendidos(){
    cac.mostrarVendidos();
  }


}