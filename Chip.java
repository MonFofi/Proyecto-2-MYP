public class Chip implements Componente{
  private String codigoBarras;
  private String numeroDeSerie;
  private EstadosChip disponible;
  private EstadosChip reservado;
  private EstadosChip vendido;
  private EstadosChip estadoActual;

  public Chip (String codigoBarras, String numeroDeSerie){
    this.codigoBarras = codigoBarras;
    this.numeroDeSerie = numeroDeSerie;
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
  public String getNumeroDeSerie(){
    return numeroDeSerie;
  }

  //Este es para imprimir los datos de cada chip?
  public void mostrarChip(){
    System.out.println("");
  }

  //estados
  public void estadoDisponible(){
    estadoActual.reservar();
  }

  public void estadoReservado(){
    estadoActual.confirmarCompra();
  }

  public void estadoVendido(){
    estadoActual.confirmarCompra();
  }

  public void chipVendido(){
    estadoActual.venta();
  }

}