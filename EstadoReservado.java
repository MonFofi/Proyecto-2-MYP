/**
 * Clase EstadoReservado que implementa la interfaz EstadosChip representa el estado
 * reservado de un chip, permitiendo así su venta o cancelación de la reservación para ello.
 */
public class EstadoReservado implements EstadosChip{
  
  public Chip chip;

  /**
   * Constructor de la clase EstadoReservado 
   * @param chip El chip que se cambiará de estado.
   */
  public EstadoReservado(Chip chip){
    this.chip = chip;
  }

  /**
   * Metodo disponible
   * Muestra un mensaje indicando que el chip no está disponible para venta inmediata.
   */
  public String disponible(){
    return "Chip no disponible, ha sido reservado.";
  }

  /**
   * Metodo reservado
   * Muestra un mensaje indicando que el chip ya está reservado.
   */
  public String reservar(){
    return "Chip reservado.";
  }

  /**
   * Metodo cancelarReserva
   * Cambia el chip a estado disponible y muestra un mensaje de dicho cambio.
   */
  public String cancelarReserva(){
    chip.setEstado(chip.getEstadoDisponible());
    return "Chip disponible para cancelar su reservación. Pasará a disponible.";
  }

  /**
   * Metodo confirmarCompra
   * Cambia el chip a estado vendido en caso de querer concretar la compra y
   * muestra un mensaje de dicho cambio.
   */
  public String confirmarCompra(){
    chip.setEstado(chip.getEstadoVendido());
    return "Chip reservado. En espera de confirmación de compra.";
  }

  /**
   * Metodo venta
   * Cambia el chip a estado vendido y muestra un mensaje de dicho cambio.
   */
  public String venta(){
    chip.setEstado(chip.getEstadoVendido());
    return "Chip disponible para comprar.";
  }
  
}