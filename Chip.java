public class Chip implements Componente{
  private String codigoBarras;
  private int numeroDeSerie;
  private EstadosChip disponible;
  private EstadosChip reservado;
  private EstadosChip vendido;
  private EstadosChip estadoActual;

  public Chip (String codigoBarras){
    this.codigoBarras = codigoBarras;
    numeroDeSerie = getNumeroDeSerie();
    disponible = new EstadoDisponible(this);
    reservado = new EstadoReservado(this);
    vendido = new EstadoVendido(this);
    estadoActual = disponible;
  }

  @Override
  public String getCodigoDeBarras(){
    return codigoBarras;
  }

  @Override
  public int getNumeroDeSerie(){
    if (codigoBarras.length() == 18 || codigoBarras.length() == 19) {
      return numeroDeSerie = Integer.parseInt(codigoBarras.substring(12, 18));
    } else {
      return -1;
    }
  }

  //Este es para imprimir los datos de cada chip?
  public void mostrarChip(){
    if(numeroDeSerie == -1){
      System.out.println("\nEl código de barras no es válido.");
    } else {
      System.out.println("\nCódigo de barras: " + getCodigoDeBarras() +
                         "\nNúmero de serie: " + getNumeroDeSerie());
    }
  }

  //estados
  public void estadoDisponible(){
    estadoActual.reservar();
  }

  public void estadoReservado(){
    estadoActual = reservado;
    estadoActual.confirmarCompra();
  }

  public void estadoCancelado(){
    estadoActual.cancelarReserva();
    estadoActual = disponible;
  }

  public void estadoVendido(){
    estadoActual = vendido;
    estadoActual.confirmarCompra();
  }

  public void chipVendido(){
    estadoActual.venta();
  }

}