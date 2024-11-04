public class EstadoVendido implements EstadosChip{
  public Chip chip;

  public EstadoVendido(Chip chip){
    this.chip = chip;
  }

  public void reservar(){
    System.out.println("No es posible reservar un chip ya vendido.");
  }

  public void cancelarReserva(){
    System.out.println("No es posible cancelar la reservación de un chip ya vendido.");
  }

  public void confirmarCompra(){
    System.out.println("Chip vendido.");
  }

  public void venta(){
    System.out.println("Se ha realizado correctamente la venta del chip.");
  }
}