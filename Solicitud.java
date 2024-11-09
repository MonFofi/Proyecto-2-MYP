public class Solicitud{
  private int cantidadChips;
  private Vendedor solicitante;
  
  public Solicitud(Vendedor solicitante){
    this.solicitante = solicitante;
    cantidadChips = solicitante.chipsFaltantes();
  }

  public int getCantidadChips(){
    return cantidadChips;
  }

  public Vendedor getSolicitante(){
    return solicitante;
  }

  public String solicitarChips(){
    return solicitante.getNombre() + " ha solicitado " + solicitante.chipsFaltantes() + " chips.";
  }

}