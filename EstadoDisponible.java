public class EstadoDisponible implements EstadosChip{
  public Chip chip;

  public EstadoDisponible(Chip chip){
    this.chip = chip;
  }

  public String reservar(){
    chip.setEstado(chip.getEstadoReservado());
    return "Chip disponible para reservar.";
  }
  
  public String cancelarReserva(){
    return "No puede cancelarse una reservación que aún no se ha hecho.";
  }

  public String confirmarCompra(){
    return "No se puede confirmar una compra que aún no se ha hecho.";
  }

  public String venta(){
    chip.setEstado(chip.getEstadoVendido());
    return "Chip disponible para compra.";
  }

}