/**
 * Interfaz que permite mostrar el mensaje adecuado
 * tanto para un vendedor como para un almacenista
 * dependiendo de quien inicie sesión.
 */
public interface InterfazMenu{

  /**
   * Muestra las opciones disponibles en el menú
   * para cada usuario.
   */
  public String mostrarSubmenu();

  /**
   * Muestra la autorización para registrar un chip
   * o caja en el sistema dependiendo del usuario.
   */
  public String registrarUnidad();

  /**
   * Muestra un mensaje de que la unidad registrada se 
   * realizó correctamente.
   */
  public String registroExitoso();

  /**
   * Muestra un mensaje de que la unidad registrada no
   * se realizó correctamente.
   */
  public String registroFallido();

  /**
   * Muestra una solicitud hecha o recibida según el
   * usuario que haya iniciado sesión.
   */
  public String solicitudChips();

  /**
   * Muestra un mensaje de que se ha cerrado la sesión del
   * usuario que ingresó al sistema.
   */
  public String cerrarSesion();
}