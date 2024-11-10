public class Vendedor extends Usuarios{

  public ListaDeChips chipsDisponibles = new ListaDeChips();
  public ListaDeChips chipsReservados = new ListaDeChips();
  public ListaDeChips chipsVendidos = new ListaDeChips();
  public int chipsSolicitados;
  // public Solicitud solicitud;

  public Vendedor(String nombre, String iD){
    super(nombre, iD);
    rol = "vendedor";
    inicializarServidor();
  }

  @Override
  public void escanearCodigo(String codigo){
    System.out.println("si");
  }

  public Solicitud hacerSolicitud(){
    return new Solicitud(this);
  }

  //metodo propio de la clase (auxiliar)  
  public int chipsFaltantes(){
    int chipsActuales = chipsDisponibles.getLongitud();
    if(chipsActuales >= 20){
      return 0;
    }
    chipsSolicitados = 20 - chipsActuales;
    return chipsSolicitados;
  }
}