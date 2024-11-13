import java.util.LinkedList;

/**
 * Clase CajaChipsBuilder que representa el constructor de una caja de chips para la clase CajaChips.
 * Utilizada para implementar el patrón de diseño builder y dicha clase implementa la interfaz Builder.
 */
public class CajaChipsBuilder implements Builder{

  private String codigoDeBarras;
  private ListaDeChips listaDeChips;

  /**
   * Metodo setCodigoDeBarras.
   * Permite asignar a la clase el código de barras del primer chip de la caja para generarla y registrarla en el sistema.
   * @param codigo El código de barras del primer chip de la caja a escanear.
   * @return una instancia de si mismo para que pueda ser recibido por el constructor.
   */
  @Override
  public Builder setCodigoDeBarras(String codigoDeBarras){
    this.codigoDeBarras = codigoDeBarras;
    return this;
  }

  /**
   * Metodo setListaDeChips
   * Permite agregar a una lista los chips de la caja generada anteriormente para poder
   * almacenarlos y permite establecer dicha lista para la clase.
   * @return una instancia de si mismo para que pueda ser recibido por el constructor.
   */
  @Override
  public Builder setListaDeChips(ListaDeChips listaDeChips){
    this.listaDeChips = listaDeChips;
    return this;
  }
  
  /**
   * Metodo construir
   * Permite crear un objeto de tipo CajaChips con los parámetros de la clase ya asignados.
   * @return una nueva instancia de tipo CajaChips ya armada.
   */
  @Override
  public CajaChips construir(){
    int numeroInicial = getNumeroSerie();
    if (numeroInicial == -1) {
      throw new IllegalArgumentException("Código de barras inválido.");
    }
    for (int i = 0; i < 100; i++) {
      int numSerie = numeroInicial + i;
      String codigoBarraCompleto = generarCodigoBarraCompleto(numSerie);
      Chip chip = new Chip(codigoBarraCompleto);
      listaDeChips.agregarChip(chip);
    }
    return new CajaChips(this);
  }

  /**
   * Metodo getCodigoDeBarras
   * Metodo de acceso que permite obtener el código de barras con el que se comienza a armar la caja de chips.
   * @return codigoDeBarras el código de barras del primer chip de la caja con la que se creará una caja de chips nueva.
   */
  public String getCodigoDeBarras(){
    return codigoDeBarras;
  }

  /**
   * Metodo getListaDeChips 
   * Regresa un objeto de tipo ListaDeChips que permite acceder a la lista en donde se almacenan los chips de la caja creada.
   * @return listaDeChips la lista con los chips de la caja almacenados.
   */
  public ListaDeChips getListaDeChips(){
    return listaDeChips;
  }

  /**
   * Metodo getNumeroSerie
   * Evalúa si el código de barras es válido para escanear y si lo es, lo separa para obtener
   * el número identificador único del chip para crear la caja.
   * @return Un int con el número de serie del primer chip de la caja a crear.
   */
  public int getNumeroSerie() {
    return (codigoDeBarrasValido()) ? Integer.parseInt(codigoDeBarras.substring(12, 18)) : -1;
  }

  /**
   * Metodo codigoDeBarrasValido
   * Evalúa si el código de barras escaneado es válido para poder procesarse por el sistema.
   * @return true si tiene la longitud correcta.
   * @return  false en caso contrario.
   */
  public boolean codigoDeBarrasValido() {
    return codigoDeBarras.length() == 18 || codigoDeBarras.length() == 19;
  }

  /**
   * Metodo getParteAnterior 
   * Regresa los dígitos de antes del número de serie del chip que se escanea.
   * @return Un String con los 12 dígitos que se encuentran antes del número de serie de un chip.
   */
  public String getParteAnterior() {
    return codigoDeBarras.substring(0, 12);
  }

  /**
   * Metodo getPartePosterior
   * Evalúa si el código de barras tiene 18 o 19 dígitos y regresa el último dígito
   * del código de barras si es que es de 19 dígitos. 
   * @return String con el último dígito del código de barras si es que es de 19 dígitos. 
   * @return String vacío si el código de barras es de 18 dígitos.
   */
  public String getPartePosterior() {
    return codigoDeBarras.length() == 19 ? codigoDeBarras.substring(18) : "";
  }

  /**
   * Metodo generarCodigoBarraCompleto
   * Concatena las partes anterior y posterior al númedo de serie con este mismo para regresar el código de barras completo.
   * @param numeroSerie Para poder darle formato de estrictamente 6 dígitos si es que hay algún dígito
   * igual a 0 antes de otro que sea distinto de 0 para poder convertirlo a String y poder imprimirlo.
   * @return String con las 3 partes del código de barras concatenadas.
   */
  private String generarCodigoBarraCompleto(int numeroSerie) {
    String numeroSerieFormateado = String.format("%06d", numeroSerie);
    return getParteAnterior() + numeroSerieFormateado + getPartePosterior();
  }

}