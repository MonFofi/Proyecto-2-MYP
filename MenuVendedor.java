/**
 * Clase que representa el menú que se mostrará
 * a los vendedores posterior a que inicien sesión
 * que implementa InterfazMenu para poder hacer uso
 * del patrón Strategy.
 */
public class MenuVendedor implements InterfazMenu{
  
  /**
   * Método que muestra las opciones del menú con
   * las acciones disponibles para los vendedores.
   * @return Un String con el menú.
   */
  @Override()
  public String mostrarSubmenu(){
    return "Bienvenido \n¿Que acción quieres realizar?" +
                        "1- Solicitar mas chips" +
                        "2- Vender chip" +
                        "3- Reservar chip" +
                        "4- Cancelar reservacion de chip" +
                        "5- Cerrar Sesion";
  }

  /**
   * Método que da la indicación para poder escanear
   * un chip y poder registrarlo en el sistema.
   * @return Un String con la indicación para registrar un chip.
   */
  @Override
  public String registrarUnidad(){
    return "Escanee el código de barras del chip para registrar un movimiento en el sistema.";
  }

  /**
   * Método que indica el registro exitoso del chip en el sistema.
   * @return Un String con el mensaje de registro exitoso.
   */
  @Override
  public String registroExitoso(){
    return "El chip se ha registrado correctamente.";
  }

  /**
   * Método que indica el registro fallido del chip en el sistema.
   * @return Un String con el mensaje de registro fallido.
   */
  @Override
  public String registroFallido(){
    return "El chip no se ha podido registrar en el sistema.";
  }

  /**
   * Método que indica que se solicitaron más chips al almacen.
   * @return Un String con el mensaje de solicitud al almacen.
   */
  @Override
  public String solicitudChips(){
    return "Se solicitaron chips al almacén.";
  }

  /**
   * Método que indica el cierre de sesión de un vendedor.
   * @return Un String con el mensaje de cierre de sesión del usuario.
   */
  @Override
  public String cerrarSesion(){
    return "Cerrando sesión de ***.";
  }

}