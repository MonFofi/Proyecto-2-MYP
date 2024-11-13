/**
 * Clase EstadoVendido que implementa la interfaz EstadosChip representa el
 * estado vendido de un chip, llegando al estado final que puede alcanzar.
 */
public class EstadoVendido implements EstadosChip{

  public Chip chip;

  /**
   * Constructor de la clase EstadoVendido 
   * @param chip El chip que se cambiará de estado.
   */
  public EstadoVendido(Chip chip){
    this.chip = chip;
  }

  /**
   * Mensaje disponible
   * Muestra un mensaje indicando que el chip no puede usarse pues ya se ha vendido.
   */
  public String disponible(){
    return "Chip no disponible, ha sido vendido.";
  }

  /**
   * Metodo reservar
   * Muestra un mensaje indicando que el chip no se puede reservar puesto que ya se ha vendido.
   */
  public String reservar(){
    return "No es posible reservar un chip ya vendido.";
  }

  /**
   * Metodo cancelarReserva
   * Muestra un mensaje indicando que no se puede cancelar la reserva del chip una vez vendido.
   */
  public String cancelarReserva(){
    return "No es posible cancelar la reservación de un chip ya vendido.";
  }

  /**
   * Metodo confirmarCompra
   * Muestra un mensaje reafirmando que se ha vendido el chip correctamente.
   */
  public String confirmarCompra(){
    return "Chip vendido.";
  }

  /**
   * Metodo venta
   * Muestra un mensaje indicando que se ha vendido el chip.
   */
  public String venta(){
    return "Se ha realizado correctamente la venta del chip.";
  }
  
}