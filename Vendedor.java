/**
 * Clase que representa a un vendedor que puede introducir al sistema
 * como va gestionando los chips que se le asignan. Hereda de la clase abstracta Usuario.
 */
public class Vendedor extends Usuarios{

  private ListaDeChips chipsDisponibles = new ListaDeChips();
  private ListaDeChips chipsReservados = new ListaDeChips();
  private ListaDeChips chipsVendidos = new ListaDeChips();
  public int chipsSolicitados;

  /**
   * Constructor de la clase Vendedor.
   * Hereda el constructor de la clase abstracta Usuarios
   * @param nombre El nombre del usuario.
   * @param iD El ID del usuario.
   */
  public Vendedor(String nombre, String iD){
    super(nombre, iD);
    rol = "vendedor";
    inicializarServidor();
  }

  /**
   * Metodo chipsFaltantes
   * Método auxiliar que permite determinar cuantos chips se le asignarán
   * a un vendedor al hacer una solicitud al almacén de más chips.
   * @return chipsSolicitados La cantidad de chips que será solicitada al almacén.
   */
  public int chipsFaltantes(){
    int chipsActuales = chipsDisponibles.getLongitud();
    if(chipsActuales >= 20){
      return 0;
    }
    chipsSolicitados = 20 - chipsActuales;
    return chipsSolicitados;
  }

  /**
   * Metodo getChipsDisponibles
   * Método de acceso que regresa la lista de los chips que aún están disponibles
   * para ser vendidos o reservados.
   * @return chipsDisponibles La lista de chips disponibles.
   */
  public ListaDeChips getChipsDisponibles(){
    return chipsDisponibles;
  }

  /**
   * Metodo getChipsReservados
   * Metodo de acceso que regresa la lista de los chips que han sido reservados, por
   * lo que ya no pueden usarse para otro cliente o cancelar su reservación para
   * dejarlo disponible nuevamente.
   * @return chipsReservados La lista de chips reservados.
   */
  public ListaDeChips getChipsReservados(){
    return chipsReservados;
  }

  /**
   * Metodo getChipsVendidos
   * Metodo de acceso que regresa la lista de los chips que ya han sido vendidos.
   * @return chipsVendidos La lista de chips vendidos.
   */
  public ListaDeChips getChipsVendidos(){
    return chipsVendidos;
  }

  /**
   * Método mostrarDisponibles
   * Imprime la lista de chips disponibles para ser vendidos o reservados de los que se le 
   * han asignado al vendedor.
   */
  @Override
  public void mostrarDisponibles(){
    System.out.println("\nChips disponibles para venta o reservación:");
    chipsDisponibles.mostrarChips();
  }

  /**
   * Método mostrarReservados
   * Imprime la lista de chips reservados y que no pueden estar disponibles.
   */
  @Override
  public void mostrarReservados(){
    System.out.println("\nChips reservados:");
    chipsReservados.mostrarChips();
  }

  /**
   * Método mostrarVendidos
   * Imprime la lista de chips que ya han sido vendidos.
   */
  @Override
  public void mostrarVendidos(){
    System.out.println("\nChips vendidos:");
    chipsVendidos.mostrarChips();
  }

  /**
   * Metodo hacerSolicitud
   * Crea un objeto de tipo solicitud que permite pedir al almacén más
   * chips para que le sean asignados.
   * @return new Solicitud Una nueva instancia de tipo Solicitud.
   */
  public Solicitud hacerSolicitud(){
    return new Solicitud(this);
  }
  
  /**
   * Metodo escanearCodigo
   * Permite al vendedor escanear un código de barras de un chip para poder gestionar
   * su uso y registrar el mismo en el sistema.
   * @param codigo El codigo de barras del chip a procesar.
   * @return una instancia de chip si es que se encuentra disponible o reservado en 
   * dichas listas del vendedor.
   * @return null En caso contrario.
   */
  public Chip escanearCodigo(String codigo){
    return cac.escanearChip(codigo, this);
  }

  /**
   * Metodo cambiarADisponible
   * Permite cambiar el estado del chip a disponible en caso de una cancelación de una reservación
   * usando una instancia de chip que fue creada con el método escanearCodigo.
   * @param codigo El codigo de barras del chip que se cambiará a estado disponible.
   */
  public void cambiarADisponible(String codigo){
    Chip c = escanearCodigo(codigo);
    if(c != null){
      cac.pasarADisponible(c, this, cac);
    } else {
      System.out.println("El chip no se encuentra en el sistema.");
    }
  }

  /**
   * Metodo cambiarAReservado
   * Permite cambiar el estado del chip a reservado en caso de que se encuentre disponible
   * usando una instancia de chip que fue creada con el método escanearCodigo.
   * @param codigo El codigo de barras del chip que se cambiará a estado reservado.
   */
  public void cambiarAReservado(String codigo){
    Chip c = escanearCodigo(codigo);
    if(c != null){
      cac.pasarAReservado(c, this, cac);
    } else {
      System.out.println("El chip no se encuentra en el sistema.");
    }
  }

  /**
   * Metodo cambiarAVendido
   * Permite cambiar el estado del chip a vendido en caso de que esté disponible o quiera concretarse la
   * reservación usando una instancia de chip que fue creada con el método escanearCodigo.
   * @param codigo El codigo de barras del chip que se cambiará a estado vendido.
   */
  public void cambiarAVendido(String codigo){
    Chip c = escanearCodigo(codigo);
    if(c != null){
      cac.pasarAVendido(c, this, cac);
    } else {
      System.out.println("El chip no se encuentra en el sistema.");
    }
  }
  
}