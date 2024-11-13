/**
 * Clase que representa una caja de chips ya armada utilizando la clase CajaChipsBuilder.
 */
public class CajaChips{

  private String codigoDeBarras;
  private ListaDeChips listaDeChips;

  /**
   * Constructor de la clase CajaChips
   * @param builder el constructor que brinda los atributos a la clase.
   */
  public CajaChips(CajaChipsBuilder builder){
    codigoDeBarras = builder.getCodigoDeBarras();
    listaDeChips = builder.getListaDeChips();
  }

  /**
   * etodo getCodigoDeBarras
   * Metodo de acceso que regresa el codigo de barras que se usó para crear y registrar la caja en el sistema.
   * @return codigoDeBarras El String que contiene el código de barras.
   */
  public String getCodigoDeBarras(){
    return codigoDeBarras;
  }

  /**
   * Metodo getCaja
   * Metodo de acceso que regresa un objeto de tipo ListaDeChips en donde fueron almacenados los chips de la caja creada.
   * @return listaDeChips La instancia de ListaDeChips en donde se almacenaron los chips de la caja creada.
   */
  public ListaDeChips getCaja(){
    return listaDeChips;
  }

  /**
   * Metodo mostrarCaja
   * Imprime el contenido de la caja registrada, osea, los chips que fueron creada en ella.
   */
  public void mostrarCaja(){
    listaDeChips.mostrarChips();
  }

}