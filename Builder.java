/**
 * Interfaz que permite implementar el patrón de diseño builder. Es implementada por CajaChipsBuilder.
 */
public interface Builder{

  
  /**
   * Metodo setCodigoDeBarras.Permite asignar a la clase el código de barras del primer chip de la
   * caja para generarla y registrarla en el sistema.
   * @param codigo El código de barras del primer chip de la caja a escanear.
   */
  public Builder setCodigoDeBarras(String codigo);
  
  /**
   * Metodo setListaDeChips
   * Permite agregar a una lista los chips de la caja generada anteriormente para poder almacenarlos
   * y permite establecer dicha lista para la clase.
   */
  public Builder setListaDeChips(ListaDeChips listaDeChips);
  
  /**
   * Metodo construir
   * Permite crear un objeto de tipo CajaChips con los parámetros de la clase ya asignados.
   */
  public CajaChips construir();

}
