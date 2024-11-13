/**
 * Clase EstadoDisponible que implementa la interfaz EstadosChip representa el
 * estado disponible de un chip, permitiendo así su venta o reservación para ello.
 */
public class EstadoDisponible implements EstadosChip{
  
  public Chip chip;

  /**
   * Constructor de la clase EstadoDisponible 
   * @param chip El chip que se cambiará de estado.
   */
  public EstadoDisponible(Chip chip){
    this.chip = chip;
  }

  /**
   * Metodo disponible 
   * Muestra un mensaje indicando que el chip está disponible para su venta o reservación.
   */
  public String disponible(){
    return "Chip disponible para reservar o comprar.";
  }

  /**
   * Metodo reservar 
   * Cambia el estado del chip a reservado y muestra un mensaje de dicho cambio.
   */
  public String reservar(){
    chip.setEstado(chip.getEstadoReservado());
    return "Chip disponible para reservar. Se reservará el chip.";
  }
  
  /**
   * Metodo cancelarReserva 
   * Muestra un mensaje de que no es posible cambiar a estado disponible un chip que ya lo está.
   */
  public String cancelarReserva(){
    return "No puede cancelarse una reservación que aún no se ha hecho.";
  }

  /**
   * Metodo confirmarCompra 
   * Muestra un mensaje de que el chip no se encuentra en estado vendido.
   */
  public String confirmarCompra(){
    return "No se puede confirmar una compra que aún no se ha hecho.";
  }

  /**
   * Metodo venta 
   * Cambia el estado del chip de disponible a vendido y muestra un mensaje de dicho cambio. 
   */
  public String venta(){
    chip.setEstado(chip.getEstadoVendido());
    return "Chip disponible para compra.";
  }

}