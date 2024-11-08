public class EstadoReservado implements EstadosChip{
  public Chip chip;

  public EstadoReservado(Chip chip){
    this.chip = chip;
  }

  public String reservar(){
    return "Chip reservado.";
  }

  public String cancelarReserva(){
    chip.setEstado(chip.getEstadoDisponible());
    return "Chip disponible para cancelar su reservación.";
  }

  public String confirmarCompra(){
    chip.setEstado(chip.getEstadoVendido());
    return "Chip en espera de confirmación de compra.";
  }

  public String venta(){
    return "Chip disponible para comprar.";
  }
}