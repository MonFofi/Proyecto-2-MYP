/**
 * Interfaz que permite mostrar el mensaje adecuado tanto para un vendedor como para
 * un almacenista dependiendo de quien inicie sesión.
 */
public interface InterfazMenu{

  /**
   * Regresa un String que muestra las opciones disponibles en el menú para cada usuario.
   */
  public String mostrarSubmenu();

  /**
   * Regresa un String que muestra la autorización para registrar un chip o caja en el sistema dependiendo del usuario.
   */
  public String registrarUnidad();

  /**
   * Regresa un String que muestra un mensaje de que la unidad registrada se realizó correctamente.
   */
  public String registroExitoso();

  /**
   * Regresa un String que muestra un mensaje de que la unidad registrada no se realizó correctamente.
   */
  public String registroFallido();

  /**
   * Regresa un String que muestra una solicitud hecha o recibida según el usuario que haya iniciado sesión.
   */
  public String solicitudChips();

  /**
   * Regresa un String que muestra un mensaje de que se ha cerrado la sesión del usuario que ingresó al sistema.
   */
  public String cerrarSesion();
}