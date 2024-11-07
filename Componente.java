/**
 * Interfaz Componente utilizada para implementar el 
 * patrón de diseño Builder.
 */
public interface Componente{
  
  /**
   * Método getCodigoDeBarras.
   * Regresa el código de barras del Chip.
   */
  public String getCodigoDeBarras();

  /**
   * Método getNumeroDeSerie.
   * Separa el código de barras del Chip para
   * poder obtener los dígitos deseados y así
   * devuelve el número del Chip.
   */
  public int getNumeroDeSerie();

}