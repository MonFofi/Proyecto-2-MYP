import java.util.LinkedList;
import java.util.Iterator;
// import java.util.Scanner;

public class CACServidor{
  private ListaDeChips chipsRegistrados = new ListaDeChips();
  private ListaDeChips chipsDisponibles = new ListaDeChips();
  private ListaDeChips chipsReservados = new ListaDeChips();
  private ListaDeChips chipsVendidos = new ListaDeChips();
  private HashMapUsuarios usuarios;
  private LinkedList<Solicitud> solicitudes = new LinkedList<>();

  //singleton para que puedan trabajar todas las instancias de usuarios
  //con las mismas listas del servidor y no lleguen a haber inconsistencias
  //de información.
  private static CACServidor instanciaUnica;

  private CACServidor(){
    usuarios = new HashMapUsuarios();
  }

  public static CACServidor getServidor() {
    if (instanciaUnica == null) {
      instanciaUnica = new CACServidor();
      instanciaUnica.usuarios.cargarVendedores();
    }
    return instanciaUnica;
  }

  //getters
  public ListaDeChips getChipsDisponibles(){
    return chipsDisponibles;
  }

  public ListaDeChips getChipsReservados(){
    return chipsReservados;
  }

  public ListaDeChips getChipsVendidos(){
    return chipsVendidos;
  }

  public ListaDeChips getChipsRegistrados(){
    return chipsRegistrados;
  }

  public HashMapUsuarios getUsuarios(){
    return usuarios;
  }

  public Iterator<Solicitud> getIteratorSolicitudes(){
    return solicitudes.iterator();
  }

  /**Servidor
   * + Registrar cajas °
   * + recibir solicitud °
   * + almacenar solicitud °
   * + procesar una solicitud (asignar chips) °
   * + procesar todas las solicitudes (asignar chips) °
   * + Mostrar solicitudes °
   * + Mostrar chips (por estados) °
   * + cambiar chips de estado
   */
  public void iniciarSesion(){

  }


  /**
   * Metodos para almacen
   */
  //registrar caja
  public void registrarCaja(String codigo){
    CajaChips caja = new CajaChipsBuilder().setListaDeChips(chipsRegistrados).setCodigoDeBarras(codigo).construir();
  }

  //auxiliar
  public void recibirSolicitud(Solicitud s){
    solicitudes.add(s);
  }

  //auxiliar
  public void asignarChips(Solicitud solicitud){
    Vendedor vendedor = solicitud.getSolicitante();
    int cantidadSolicitada = solicitud.getCantidadChips();
    if (vendedor != null && chipsRegistrados.getLongitud() >= cantidadSolicitada) {
      Iterator<Chip> iteradorChips = chipsRegistrados.getIteratorChips(); 
      int chipsAsignados = 0;
      while (iteradorChips.hasNext() && chipsAsignados < cantidadSolicitada) {
        Chip chipAsignado = iteradorChips.next();
        vendedor.chipsDisponibles.agregarChip(chipAsignado);
        chipsDisponibles.agregarChip(chipAsignado);
        chipsAsignados++;
        iteradorChips.remove();
      }
      if (chipsAsignados < cantidadSolicitada) {
        System.out.println("No se pudo asignar la cantidad completa de chips solicitada para el vendedor: " + vendedor.getID());
      } else {
        System.out.println("Se asignaron " + chipsAsignados + " chips al vendedor: " + vendedor.getID());
      }
    } else {
      System.out.println("No se pudo asignar chips: vendedor no encontrado o cantidad de chips insuficiente.");
    }
  }

  //revisar solicitudes
  //asignar chips a una solicitud
  public void procesarSolicitud(Solicitud s) {
    Iterator<Solicitud> i = solicitudes.iterator();
    while (i.hasNext()) {
      Solicitud solicitudActual = i.next();
      if (solicitudActual.equals(s)) {
        asignarChips(solicitudActual);
        i.remove();
        break;
      }
    }
  }

  //asignar chips a todas las solicitudes
  public void procesarTodasSolicitudes(){
    Iterator<Solicitud> iteradorSolicitudes = solicitudes.iterator();
    while (iteradorSolicitudes.hasNext()) {
      Solicitud solicitud = iteradorSolicitudes.next();
      asignarChips(solicitud);
      iteradorSolicitudes.remove();
    }
    System.out.println("Se han asignado chips a todos los vendedores.");
  }

  //imprimir solicitudes
  public void mostrarSolicitudes(){
    Iterator<Solicitud> i = getIteratorSolicitudes();
    while(i.hasNext()){
      System.out.println(i.next().solicitarChips());
    }
  }

  //consultar chips
  //chips registrados en el sistema
  public void mostrarRegistrados(){
    System.out.println("\n*** Chips disponibles para asignar: ***");
    getChipsRegistrados().mostrarChips();
  }

  //chips disponibles (ya asignados)
  public void mostrarDisponibles(){
    System.out.println("\n*** Chips disponibles para vender o reservar: ***");
    getChipsDisponibles().mostrarChips();
  }

  //chips reservados
  public void mostrarReservados(){
    System.out.println("\n*** Chips reservados: ***");
    getChipsDisponibles().mostrarChips();
  }

  //chips vendidos
  public void mostrarVendidos(){
    System.out.println("\n*** Chips vendidos: ***");
    getChipsDisponibles().mostrarChips();
  }


  /**Vendedores
   * + hacer solicitud
   * + escanear chip (cambiarlo de estado)
   * + vender chip
   * + reservar chip
   * + cancelar reservacion
   */


  /**
   * Métodos para vendedores
   */


}