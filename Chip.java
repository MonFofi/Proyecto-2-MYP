/**
 * Clase que representa un chip que se repartirá a los vendedores y
 * podrá ser reservado, cancelar su reservación o venderse.
 */
public class Chip implements Componente{
  private int numeroDeSerie;
  private EstadosChip disponible;
  private EstadosChip reservado;
  private EstadosChip vendido;
  private EstadosChip estadoActual;

  /**
   * Constructor de la clase Chip.
   * @param codigoBarras El código de barras del Chip.
   */
  public Chip (int numeroDeSerie){
    this.numeroDeSerie = numeroDeSerie;
    disponible = new EstadoDisponible(this);
    reservado = new EstadoReservado(this);
    vendido = new EstadoVendido(this);
    estadoActual = disponible;
  }


  //Moverlo a builder para pasarle al constructor de cada chip solo
  //su número de serie.
  /**
   * Método getNumeroDeSerie.
   */
  @Override
  public String getNumeroDeSerie(){
    int numero = numeroDeSerie;
    String numeroComoTexto = String.format("%06d", numero);
    return numeroComoTexto;
  }


  //Este es para imprimir los datos de cada chip?
  public void mostrarChip(){
    if(numeroDeSerie == -1){
      System.out.println("\nEl código de barras no es válido.");
    } else {
      // System.out.println();
      System.out.println("Número de serie: " + getNumeroDeSerie());
    }
  }

  //estados
  public void setEstado(EstadosChip estado) {
    estadoActual = estado;
  }

  public EstadosChip getEstadoDisponible(){
    return disponible;
  }

  public EstadosChip getEstadoReservado(){
    return reservado;
  }
  
  public EstadosChip getEstadoVendido(){
    return vendido;
  }

  public EstadosChip getEstadoActual(){
    return estadoActual;
  }

  /**
   * Método que permite modificar el estado del Chip
   * a disponible para vender o reservar.
   */
  public void estadoDisponible(){
    System.out.println(estadoActual.disponible());
  }

  /**
   * Método que permite modificar el estado del Chip
   * a reservado para que no pueda ser usado, se puede
   * cancelar la reservación para pasarlo a disponible
   * nuevamente o venderlo.
   */
  public void estadoReservado(){
    System.out.println(estadoActual.reservar());
  }

  /**
   * Método que permite modificar el estado del Chip
   * a cancelar su reservación para pasarlo de nuevo a 
   * disponible y permitir su uso nuevamente.
   */
  public void estadoCancelado(){
    System.out.println(estadoActual.cancelarReserva());
  }

  /**
   * Método que permite modificar el estado del Chip
   * a vendido para indicar que el chip ya se ha vendido.
   */
  public void estadoVendido(){
    System.out.println(estadoActual.venta());
    // System.out.println(estadoActual.confirmarCompra());
  }

  /**
   * Método que permite ver la confirmación de venta del
   * chip.
   */
  public void confirmarVenta(){
    // System.out.println(estadoActual.venta());
    System.out.println(estadoActual.confirmarCompra());
  }

}