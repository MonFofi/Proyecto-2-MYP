public class EstadoReservado implements EstadosChip{
  public Chip chip;

  public EstadoReservado(Chip chip){
    this.chip = chip;
  }

  public String disponible(){
    return "Chip no disponible, ha sido reservado.";
  }

  public String reservar(){
    return "Chip reservado.";
  }

  public String cancelarReserva(){
    chip.setEstado(chip.getEstadoDisponible());
    return "Chip disponible para cancelar su reservación. Pasará a disponible.";
  }

  public String confirmarCompra(){
    chip.setEstado(chip.getEstadoVendido());
    return "Chip reservado. En espera de confirmación de compra.";
  }

  public String venta(){
    chip.setEstado(chip.getEstadoVendido());
    return "Chip disponible para comprar.";
  }
}