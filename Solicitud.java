/**
 * Clase Solicitud utilizada para que el vendedor pueda generar una solicitud de chips 
 * al almacén y se guarde la información de quien la hace y los chips que está solicitando.
 */
public class Solicitud{

  private int cantidadChips;
  private Vendedor solicitante;
  
  /**
   * Constructor de la clase Solicitud 
   * @param solicitante El vendedor que solicita los chips
   */
  public Solicitud(Vendedor solicitante){
    this.solicitante = solicitante;
    cantidadChips = solicitante.chipsFaltantes();
  }

  /**
   * Metodo getCantidadChips 
   * Método de acceso que regresa la cantidad de chips solicitados por el vendedor.
   * @return cantidadChips El número de chips que solicitanta el vendedor al almacen.
   */
  public int getCantidadChips(){
    return cantidadChips;
  }

  /**
   * Metodo getSolicitante 
   * Método de acceso que regresa el objeto Vendedor que está haciendo la solicitud. 
   * @return solicitante La instancia de vendedor que solicita los chips.
   */
  public Vendedor getSolicitante(){
    return solicitante;
  }

  /**
   * Metodo solicitarChips
   * Método de acceso que regresa un String de la solicitud hecha para que pueda ser leída por el almacén.
   * @return Un String con la cadena de la solicitud realizada.
   */
  public String solicitarChips(){
    return solicitante.getID() + " ha solicitado " + solicitante.chipsFaltantes() + " chips.";
  }

}