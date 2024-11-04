public class EstadoDisponible implements EstadosChip{
  public Chip chip;

  public EstadoDisponible(Chip chip){
    this.chip = chip;
  }

  public void reservar(){
    System.out.println("Chip disponible para reservar.");
  }

  public void cancelarReserva(){
    System.out.println("No puede cancelarse una reservación que aún no se ha hecho.");
  }

  public void confirmarCompra(){
    System.out.println("No se puede confirmar una compra que aún no se ha hecho.");
  }

  public void venta(){
    System.out.println("Chip disponible para compra.");
  }

}