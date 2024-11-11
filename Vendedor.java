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

  //auxiliar
  public Chip escanearCodigo(String codigo){
    return cac.escanearChip(codigo, this);
  }

  public void cambiarADisponible(String codigo){
    Chip c = escanearCodigo(codigo);
    if(c != null){
      cac.pasarADisponible(c, this);
    } else {
      System.out.println("El chip no se encuentra en el sistema.");
    }
  }

  public void cambiarAReservado(String codigo){
    Chip c = escanearCodigo(codigo);
    if(c != null){
      cac.pasarAReservado(c, this);
    } else {
      System.out.println("El chip no se encuentra en el sistema.");
    }
  }

  public void cambiarAVendido(String codigo){
    Chip c = escanearCodigo(codigo);
    if(c != null){
      cac.pasarAVendido(c, this);
    } else {
      System.out.println("El chip no se encuentra en el sistema.");
    }
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

  public ListaDeChips getChipsDisponibles(){
    return chipsDisponibles;
  }

  public ListaDeChips getChipsReservados(){
    return chipsReservados;
  }

  public ListaDeChips getChipsVendidos(){
    return chipsVendidos;
  }

  public void mostrarDisponibles(){
    chipsDisponibles.mostrarChips();
  }

  public void mostrarReservados(){
    chipsReservados.mostrarChips();
  }

  public void mostrarVendidos(){
    chipsVendidos.mostrarChips();
  }
  
}