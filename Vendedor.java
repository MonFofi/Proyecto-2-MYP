public class Vendedor extends Usuarios{
  public ListaDeChips chipsDisponibles = new ListaDeChips();
  public ListaDeChips chipsReservados = new ListaDeChips();
  public ListaDeChips chipsVendidos = new ListaDeChips();
  public int chipsSolicitados;
  // public Solicitud solicitud;

  public Vendedor(String nombre){
    super(nombre);
    rol = "vendedor";
  }

  @Override
  public void escanearCodigo(String codigo){
    System.out.println("si");
  }

  // @Override
  public int chipsFaltantes(){
    int chipsActuales = chipsDisponibles.getLongitud();
    if(chipsActuales >= 20){
      return 0;
    }
    chipsSolicitados = 20 - chipsActuales;
    return chipsSolicitados;
  }

  // public void hacerSolicitud(){
  //   solicitud = new Solicitud();
  // }

}