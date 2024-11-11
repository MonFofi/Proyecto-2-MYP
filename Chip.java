/**
 * Clase que representa un chip que se repartirá a los vendedores y podrá ser reservado, cancelar su reservación o venderse.
 */
public class Chip implements Componente{
  private String codigoDeBarras;
  private String parteAnterior;
  private String partePosterior;
  private String numeroDeSerie;
  private EstadosChip disponible;
  private EstadosChip reservado;
  private EstadosChip vendido;
  private EstadosChip estadoActual;

  /**
   * Constructor de la clase Chip.
   * @param codigoBarras El código de barras del Chip.
   */
  public Chip (String codigoDeBarras){
    if (!codigoDeBarrasValido(codigoDeBarras)) {
      throw new IllegalArgumentException("Código de barras inválido.");
    }
    this.codigoDeBarras = codigoDeBarras;
    this.parteAnterior = obtenerParteAnterior(codigoDeBarras);
    this.numeroDeSerie = obtenerNumeroSerie(codigoDeBarras);
    this.partePosterior = obtenerPartePosterior(codigoDeBarras);
    disponible = new EstadoDisponible(this);
    reservado = new EstadoReservado(this);
    vendido = new EstadoVendido(this);
    estadoActual = disponible;
  }

  private boolean codigoDeBarrasValido(String codigoDeBarras) {
    return codigoDeBarras.length() == 18 || codigoDeBarras.length() == 19;
  }

  private String obtenerParteAnterior(String codigoDeBarras) {
    return codigoDeBarras.substring(0, 12);
  }

  private String obtenerNumeroSerie(String codigoDeBarras) {
    return codigoDeBarras.substring(12, 18); // Guardar el número de serie como String
  }

  private String obtenerPartePosterior(String codigoDeBarras) {
    return codigoDeBarras.length() == 19 ? codigoDeBarras.substring(18) : "";
  }
  
  // Métodos getters para cada parte del código de barras
  public String getParteAnterior() {
    return parteAnterior;
  }

  public String getNumeroDeSerie() {
    return numeroDeSerie;
  }

  public String getCodigoDeBarras(){
    return codigoDeBarras;
  }

  public String getPartePosterior() {
    return partePosterior;
  }

  public void mostrarChip(){
    System.out.println(parteAnterior + "\033[4m" + numeroDeSerie + "\033[0m" + partePosterior);
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
   * Método que permite modificar el estado del Chip a disponible para vender o reservar.
   */
  public void estadoDisponible(){
    System.out.println(estadoActual.disponible());
  }

  /**
   * Método que permite modificar el estado del Chip a reservado para que no pueda ser usado,
   * se puede cancelar la reservación para pasarlo a disponible nuevamente o venderlo.
   */
  public void estadoReservado(){
    System.out.println(estadoActual.reservar());
  }

  /**
   * Método que permite modificar el estado del Chip a cancelar su reservación para pasarlo de
   * nuevo a disponible y permitir su uso nuevamente.
   */
  public void estadoCancelado(){
    System.out.println(estadoActual.cancelarReserva());
  }

  /**
   * Método que permite modificar el estado del Chip a vendido para indicar que el chip ya se ha vendido.
   */
  public void estadoVendido(){
    System.out.println(estadoActual.venta());
    // System.out.println(estadoActual.confirmarCompra());
  }

  /**
   * Método que permite ver la confirmación de venta del chip.
   */
  public void confirmarVenta(){
    // System.out.println(estadoActual.venta());
    System.out.println(estadoActual.confirmarCompra());
  }

}