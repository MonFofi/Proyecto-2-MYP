public class Vendedor extends Usuarios{

  private ListaDeChips chipsDisponibles = new ListaDeChips();
  private ListaDeChips chipsReservados = new ListaDeChips();
  private ListaDeChips chipsVendidos = new ListaDeChips();
  public int chipsSolicitados;
  // public Solicitud solicitud;

  public Vendedor(String nombre, String iD){
    super(nombre, iD);
    rol = "vendedor";
    inicializarServidor();
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

  public ListaDeChips getChipsDisponibles(){
    return chipsDisponibles;
  }

  public ListaDeChips getChipsReservados(){
    return chipsReservados;
  }

  public ListaDeChips getChipsVendidos(){
    return chipsVendidos;
  }

  @Override
  public void mostrarDisponibles(){
    System.out.println("\nChips disponibles para venta o reservación:");
    chipsDisponibles.mostrarChips();
  }

  @Override
  public void mostrarReservados(){
    System.out.println("\nChips reservados:");
    chipsReservados.mostrarChips();
  }

  @Override
  public void mostrarVendidos(){
    System.out.println("\nChips vendidos:");
    chipsVendidos.mostrarChips();
  }

  public Solicitud hacerSolicitud(){
    return new Solicitud(this);
  }
  
  //auxiliar
  public Chip escanearCodigo(String codigo){
    return cac.escanearChip(codigo, this);
  }

  public void cambiarADisponible(String codigo){
    Chip c = escanearCodigo(codigo);
    if(c != null){
      cac.pasarADisponible(c, this, cac);
    } else {
      System.out.println("El chip no se encuentra en el sistema.");
    }
  }

  public void cambiarAReservado(String codigo){
    Chip c = escanearCodigo(codigo);
    if(c != null){
      cac.pasarAReservado(c, this, cac);
    } else {
      System.out.println("El chip no se encuentra en el sistema.");
    }
  }

  public void cambiarAVendido(String codigo){
    Chip c = escanearCodigo(codigo);
    if(c != null){
      cac.pasarAVendido(c, this, cac);
    } else {
      System.out.println("El chip no se encuentra en el sistema.");
    }
  }

  
}