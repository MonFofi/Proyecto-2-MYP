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

  /**
   * ********************************************** Métodos para server **********************************************
   */  
  public void iniciarSesion(){

  }


  /**
   * ********************************************** Métodos para almacen **********************************************
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
        vendedor.getChipsDisponibles().agregarChip(chipAsignado);
        chipsDisponibles.agregarChip(chipAsignado);
        iteradorChips.remove();
        chipsAsignados++;
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
    if(!solicitudes.isEmpty()){
      Iterator<Solicitud> i = getIteratorSolicitudes();
      int contador = 1;
      while(i.hasNext()){
        String soli = i.next().solicitarChips();
        System.out.println(contador + ". " + soli);
        contador++;
      }
    } else {
      System.out.println("No se ha hecho ninguna solicitud.");
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
    getChipsReservados().mostrarChips();
  }

  //chips vendidos
  public void mostrarVendidos(){
    System.out.println("\n*** Chips vendidos: ***");
    getChipsVendidos().mostrarChips();
  }
  

  /**
   * ********************************************** Métodos para vendedores **********************************************
   */  
  //auxiliar
  public Chip escanearChip(String c, Vendedor v){
    Chip chip = null;
    ListaDeChips disponibles = v.getChipsDisponibles();
    Iterator<Chip> i = disponibles.getIteratorChips();
    while(i.hasNext()){
      Chip temp1 = i.next();
      if (temp1.getCodigoDeBarras().equals(c)) {
        chip = temp1;
        break;
      }
    }
    ListaDeChips reservados = v.getChipsReservados();
    Iterator<Chip> t = reservados.getIteratorChips();
    while(t.hasNext()){
      Chip temp2 = t.next();
      if (temp2.getCodigoDeBarras().equals(c)) {
        chip = temp2;
        break;
      }
    }
    if (chip == null) {
      System.out.println("Chip no encontrado.");
    }
    return chip;
  }

  public void pasarADisponible(Chip c, Vendedor v, CACServidor cac){
    if (c.getEstadoActual() instanceof EstadoReservado) {
      c.estadoCancelado();      
      v.getChipsDisponibles().agregarChip(c);
      cac.getChipsDisponibles().agregarChip(c);
      v.getChipsReservados().eliminarChip(c);      
      cac.getChipsReservados().eliminarChip(c);
      System.out.println("Chip " + c.getCodigoDeBarras() + " se ha pasado a disponible desupues de la cancelación de su reservación.");
    } else {
      System.out.println("El chip no está reservado.");
    }
  }

  public void pasarAReservado(Chip c, Vendedor v, CACServidor cac){
    if (c.getEstadoActual() instanceof EstadoDisponible) {
      c.estadoReservado();
      v.getChipsReservados().agregarChip(c);
      cac.getChipsReservados().agregarChip(c);
      v.getChipsDisponibles().eliminarChip(c);
      cac.getChipsDisponibles().eliminarChip(c);
      System.out.println("Chip " + c.getCodigoDeBarras() + " ha sido reservado.");
    } else {
      System.out.println("El chip no está disponible para ser reservado.");
    }
  }

  public void pasarAVendido(Chip c, Vendedor v, CACServidor cac){
    if (c.getEstadoActual() instanceof EstadoDisponible) {
      c.estadoVendido();      
      v.getChipsVendidos().agregarChip(c);
      cac.getChipsVendidos().agregarChip(c);
      v.getChipsDisponibles().eliminarChip(c);      
      cac.getChipsDisponibles().eliminarChip(c);
      System.out.println("Chip " + c.getCodigoDeBarras() + " ha sido vendido.");
    } else if (c.getEstadoActual() instanceof EstadoReservado) {
      c.estadoVendido();
      v.getChipsVendidos().agregarChip(c);
      cac.getChipsVendidos().agregarChip(c);
      v.getChipsReservados().eliminarChip(c);
      cac.getChipsReservados().eliminarChip(c);
      System.out.println("Chip " + c.getCodigoDeBarras() + " ha sido vendido desde la reserva.");
    } else {
      System.out.println("El chip ya ha sido vendido.");
    }
  }

}