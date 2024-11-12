/**
 * Clase que representa el menú que se mostrará a los almacenistas posterior a que
 * inicien sesión que implementa InterfazMenu para poder hacer uso del patrón Strategy.
 */
public class MenuAlmacenista implements InterfazMenu{
  
  /**
   * Método que muestra las opciones del menú con las acciones disponibles para los almacenistas.
   * @return Un String con el menú.
   */
  @Override()
  public String mostrarSubmenu(){
    return "Bienvenido al almacen. \n¿Que acción quieres realizar?" +
                        "1- Registrar caja" +
                        "2- Revisar solicitudes" +
                        "3- Consultar chips " +
                        "4- Cerrar Sesion";
  }

  /**
   * Método que da la indicación para poder escanear una caja de chips y poder registrarla en el sistema.
   * @return Un String con la indicación para registrar una caja.
   */
  @Override
  public String registrarUnidad(){
    return "A continuación escanea el código de barras para registrar el lote de una caja en el sistema:";
  }

  /**
   * Método que indica el registro exitoso de las cajas de chips en el sistema.
   * @return Un String con el mensaje de registro exitoso.
   */
  @Override
  public String registroExitoso(){
    return "La caja se ha registrado exitosamente.";
  }

  /**
   * Método que indica el registro fallido de una caja en el sistema.
   * @return Un String con el mensaje de registro fallido.
   */
  @Override
  public String registroFallido(){
    return "La caja no se ha podido registrar en el sistema.";
  }

  /**
   * Método que indica que se hicieron solicitudes de más chips al almacen.
   * @return Un String con el mensaje de una solicitud hecha por un vendedor.
   */
  @Override
  public String solicitudChips(){
    return "Has recibido solicitudes de asignaciones de chips.";
  }

  /**
   * Método que indica el cierre de sesión de un almacenista.
   * @return Un String con el mensaje de cierre de sesión del usuario.
   */
  @Override
  public String cerrarSesion(){
    return "Cerrando interfaz de almacen.";
  }

}