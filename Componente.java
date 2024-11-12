/**
 * Interfaz Componente utilizada para implementar el patrón de diseño Builder.
 */
public interface Componente{

  /**
   * Método getNumeroDeSerie.
   * Separa el código de barras del Chip para poder obtener los dígitos
   * deseados y así devuelve un String con el número del Chip.
   */
  public String getNumeroDeSerie();

}