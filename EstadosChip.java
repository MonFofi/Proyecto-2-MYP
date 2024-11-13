/**
 * Interfaz EstadosChip será implementada por las diferentes clases que manejarán los tres estados de un chip.
 */
public interface EstadosChip{
  
  /**
   * Metodo disponible 
   * Permite cambiar el estado del chip a disponible.
   */
  public String disponible();
  
  /**
   * Metodo reservar 
   * Permite cambiar el estado del chip a reservado.
   */
  public String reservar();
  
  /**
   * Metodo cancelarReserva 
   * Permite cancelar la reserva de un chip cambiando su estado a disponible.
   */
  public String cancelarReserva();
  
  /**
   * Metodo confirmarCompra
   * Permite consultar si el chip ya ha sido vendido mediante un mensaje de confirmación de compra.
   */
  public String confirmarCompra();
  
  /**
   * Metodo venta
   * Permite cambiar el estado del chip a vendido.
   */
  public String venta();

}