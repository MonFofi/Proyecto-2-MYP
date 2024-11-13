import java.util.LinkedList;
import java.util.Iterator;

/**
 * Clase CACServidor que representa un "servidor" en donde se reciben y procesan las
 * solicitudes que hacen los Vendedores y Almacenistas.
 */
public class CACServidor{

  private ListaDeChips chipsRegistrados = new ListaDeChips();
  private ListaDeChips chipsDisponibles = new ListaDeChips();
  private ListaDeChips chipsReservados = new ListaDeChips();
  private ListaDeChips chipsVendidos = new ListaDeChips();
  private HashMapUsuarios usuarios;
  private LinkedList<Solicitud> solicitudes = new LinkedList<>();

  private static CACServidor instanciaUnica;

  /**
   * Constructor de la clase CACServidor.
   * Este es privado para permitir crear una sola instancia de la clase.
   */
  private CACServidor(){
    usuarios = new HashMapUsuarios();
  }

  /**
   * Metodo getServidor
   * Permite obtener la única instancia inicializada del servidor evitando crear múltiples instancias.
   * @return new CACServidor si no se ha creado la instancia del servidor.
   * @return instanciaUnica La única instancia del servidor en caso de que ya haya sido creada. 
   */
  public static CACServidor getServidor() {
    if (instanciaUnica == null) {
      instanciaUnica = new CACServidor();
      instanciaUnica.usuarios.cargarVendedores();
    }
    return instanciaUnica;
  }


  
  /**
   * Metodo getChipsDisponibles
   * Regresa un objeto de tipo ListaDeChips en el que está contenida la lista de chips disponibles para venta.
   * @return chipsDisponibles La lista de chips disponibles del servidor.
   */
  public ListaDeChips getChipsDisponibles(){
    return chipsDisponibles;
  }
  
  /**
   * Metodo getChipsReservados
   * Regresa un objeto de tipo ListaDeChips en el que está contenida la lista de chips reservados.
   * @return chipsReservados La lista de chips reservados del servidor.
   */
  public ListaDeChips getChipsReservados(){
    return chipsReservados;
  }
  
  /**
   * Metodo getChipsVendidos
   * Regresa un objeto de tipo ListaDeChips en el que está contenida la lista de chips vendidos.
   * @return chipsVendidos La lista de chips vendidos del servidor.
   */
  public ListaDeChips getChipsVendidos(){
    return chipsVendidos;
  }
  
  /**
   * Metodo getChipsRegistrados
   * Regresa un objeto de tipo ListaDeChips en el que está contenida la lista de chips registrados.
   * @return chips La lista de chips registrados para ser asignados del servidor.
   */
  public ListaDeChips getChipsRegistrados(){
    return chipsRegistrados;
  }

  /**
   * Metodo getUsuarios
   * Regresa un objeto de tipo HashMapUsuarios en el que está contenido el HashMap donde se
   * encuentran registrados los usuarios que tendrán permitido utilizar el sistema.
   * @return usuarios El hash map de los usuarios registrados.
   */
  public HashMapUsuarios getUsuarios(){
    return usuarios;
  }

  /**
   * Metodo getIteratorSolicitudes
   * Regresa un iterador para recorrer la lista de solicitudes realizadas por los vendedores.
   * @return Un iterador de tipo Solicitud.
   */
  public Iterator<Solicitud> getIteratorSolicitudes(){
    return solicitudes.iterator();
  }

  //********************************************** Métodos para server **********************************************


  //********************************************** Métodos para almacen **********************************************

  /**
   * Metodo registrarCaja
   * Permite registrar una caja de chips en el sistema y armarla mediante el uso de un builder y se agregan
   * los chips de la caja a la lista chipsRegistrados.
   * @param codigo El código de barras de la caja que representa el primer chip de la misma.
   */
  public void registrarCaja(String codigo){
    CajaChips caja = new CajaChipsBuilder().setListaDeChips(chipsRegistrados).setCodigoDeBarras(codigo).construir();
    System.err.println("--------------------------Los chips se han guardado con exito--------------------------");
  }

  /**
   * Metodo recibirSolicitud
   * Agrega una solicitud hecha a la lista de solicitudes.
   * @param s La solicitud que se realizó.
   */
  public void recibirSolicitud(Solicitud s){
    solicitudes.add(s);
  }

  /**
   * Metodo asignarChips
   * Metodo auxiliar que permite asignar chips a una sola solicitud obteniendo los chips
   * de la lista de registrados, se mueven a la lista de chips disponibles del servidor y
   * de igual forma se agregan a la lista de chips disponibles del vendedor solicitante.
   * @param solicitud La solicitud que se procesará.
   */
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

  /**
   * Metodo procesarSolicitud
   * Permite asignar chips a una solicitud en específico buscándola en la lista de solicitudes y, si la
   * encuentra, es atendida utilizando el método asignarChips.
   * @param s La solicitud que se buscará en la lista.
   */
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

  /**
   * Metodo procesarTodasSolicitud
   * Permite asignar chips a todas las solicitudes que se han recibido mediante un ciclo que recorre toda la
   * lista de solicitudes y ejecuta el método asignarChips.
   */
  public void procesarTodasSolicitudes(){
    Iterator<Solicitud> iteradorSolicitudes = solicitudes.iterator();
    while (iteradorSolicitudes.hasNext()) {
      Solicitud solicitud = iteradorSolicitudes.next();
      asignarChips(solicitud);
      iteradorSolicitudes.remove();
    }
    System.out.println("Se han asignado chips a todos los vendedores.");
  }

  /**
   * Metodo mostrarSolicitudes
   * Un print que permite al almacen conocer cuantas solicitudes ha recibido mediante la iteración de
   * la lista de solicitudes e imprimiendo una por una.
   */
  public void mostrarSolicitudes(){
    if(!solicitudes.isEmpty()){
      Iterator<Solicitud> i = getIteratorSolicitudes();
      int contador = 1;
      System.out.println("------------------Mostrando solicitudes: ------------------");
      while(i.hasNext()){
        if(i.next()!= null){
        String soli = i.next().solicitarChips();
        System.out.println(contador + ". " + soli);
        }
        contador++;
      }
    } else {
      System.out.println("No se ha hecho ninguna solicitud.");
    }
  }


  /**
   * Metodo mostrarRegistrados
   * Permite imprimir en pantalla la lista de chips registrados en el sistema que hay para asignar.
   */
  public void mostrarRegistrados(){
    System.out.println("\n*** Chips disponibles para asignar: ***");
    getChipsRegistrados().mostrarChips();
  }

  /**
   * Metodo mostrarDisponibles
   * Permite imprimir en pantalla la lista de chips disponibles para vender o registrar.
   */
  public void mostrarDisponibles(){
    System.out.println("\n*** Chips disponibles para vender o reservar: ***");
    getChipsDisponibles().mostrarChips();
  }

  /**
   * Metodo mostrarResevados
   * Permite imprimir en pantalla la lista de chips reservados.
   */
  public void mostrarReservados(){
    System.out.println("\n*** Chips reservados: ***");
    getChipsReservados().mostrarChips();
  }

  /**
   * Metodo mostrarVendidos
   * Permite imprimir en pantalla la lista de chips vendidos.
   */
  public void mostrarVendidos(){
    System.out.println("\n*** Chips vendidos: ***");
    getChipsVendidos().mostrarChips();
  }
  

  //********************************************** Métodos para vendedores **********************************************  
  
  /**
   * Metodo escanearChip
   * Busca un chip en las listas del vendedor de disponibles y reservados mediante su código de barras para
   * comprobar que está disponible su uso en el sistema y devuelve el chip para poder usarlo en otros métodos.
   * @param c El código de barras del chip escaneado que se quiere buscar.
   * @param v El vendedor que busca el chip en sus listas.
   * @return chip El chip que se busca 
   * @return null En caso de que no se encuentre en ninguna lista del vendedor.
   */
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

  /**
   * Metodo pasarADisponible
   * Obtiene el estado del chip y verifica si se encuentra reservado para poder modificar su estado y modificar
   * las listas tanto del servidor como las del mismo vendedor para mover el chip de la lista de reservados a la
   * lista de disponibles.
   * @param c El chip a cambiar de estado
   * @param v El vendedor del cual se modificarn las listas
   * @param cac El servidor para modificar sus listas.
   */
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

  /**
   * Metodo pasarAReservado
   * Obtiene el estado del chip y verifica si se encuentra disponible para poder modificar su estado y modificar
   * las listas tanto del servidor como las del mismo vendedor para mover el chip de la lista de disponibles a la
   * lista de reservados.
   * @param c El chip a cambiar de estado
   * @param v El vendedor del cual se modificarn las listas
   * @param cac El servidor para modificar sus listas.
   */
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

  /**
   * Metodo pasarAVendido
   * Obtiene el estado del chip y verifica si se encuentra disponible o reservado para poder modificar su estado
   * y modificar las listas tanto del servidor como las del mismo vendedor para mover el chip de la lista de
   * reservados o disponibles a la lista de vendidos.
   * @param c El chip a cambiar de estado
   * @param v El vendedor del cual se modificarn las listas
   * @param cac El servidor para modificar sus listas.
   */
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