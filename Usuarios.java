/**
 * Clase abstracta Usuarios que es extendida por Vendedor y Almacenista.
 * Representa a los dos tipos de usuarios que usan el programa. 
 */
public abstract class Usuarios{
  protected String nombre;
  protected String rol;
  protected String iD;
  protected CACServidor cac;

  /**
   * Constructor de la clase Usuarios que es heredado por sus clases hijas.
   * @param nombre El nombre del usuario.
   * @param iD El ID del usuario.
   */
  public Usuarios (String nombre, String iD){
    this.nombre = nombre;
    this.iD = iD;
    this.cac = null;
  }

  /**
   * Método inicializarServidor
   * Permite inicializar la instancia única del servidor para hacer uso de ella.
   */
  public void inicializarServidor(){
    this.cac = CACServidor.getServidor();
  }

  /**
   * Método getNombre
   * Devuelve un String con el nombre del usuario.
   * @return nombre El nombre del usuario.
   */
  public String getNombre(){
    return nombre;
  }

  /**
   * Método getRol
   * Devuelve un String con el rol de trabajo del usuario.
   * @return rol El puesto de trabajo que desempeña el usuario.
   */
  public String getRol(){
    return rol;
  }

  /**
   * Metodo getID
   * Devuelve un String con el ID del usuario.
   * @return iD El id del usuario.
   */
  public String getID(){
    return iD;
  }

  
  /**
   * Método abstracto mostrarDisponibles
   * Imprime la lista de chips disponibles según el usuario.
   */
  public abstract void mostrarDisponibles();
  
  /**
   * Método abstracto mostrarReservados
   * Imprime la lista de chips reservados según el usuario.
   */
  public abstract void mostrarReservados();
  
  /**
   * Método abstracto mostrarVendidos
   * Imprime la lista de chips vendidos según el usuario.
   */
  public abstract void mostrarVendidos();

}