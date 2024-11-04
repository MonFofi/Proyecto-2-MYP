public class EstadoReservado implements EstadosChip{
  public Chip chip;

  public EstadoReservado(Chip chip){
    this.chip = chip;
  }

  public void reservar(){
    System.out.println("Chip reservado.");
  }

  public void cancelarReserva(){
    System.out.println("Chip disponible para cancelar su reservación.");
  }

  public void confirmarCompra(){
    System.out.println("Chip en espera de confirmación de compra.");
  }

  public void venta(){
    System.out.println("Chip disponible para comprar.");
  }
}