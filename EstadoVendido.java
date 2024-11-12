/**
 * 
 */
public class EstadoVendido implements EstadosChip{
  /**
   * 
   */
  public Chip chip;

  /**
   * 
   */
  public EstadoVendido(Chip chip){
    this.chip = chip;
  }

  /**
   * 
   */
  public String disponible(){
    return "Chip no disponible, ha sido vendido.";
  }

  /**
   * 
   */
  public String reservar(){
    return "No es posible reservar un chip ya vendido.";
  }

  /**
   * 
   */
  public String cancelarReserva(){
    return "No es posible cancelar la reservación de un chip ya vendido.";
  }

  /**
   * 
   */
  public String confirmarCompra(){
    return "Chip vendido.";
  }

  /**
   * 
   */
  public String venta(){
    return "Se ha realizado correctamente la venta del chip.";
  }
  
}