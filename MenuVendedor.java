public class MenuVendedor implements InterfazMenu{
  
  @Override()
  public String mostrarSubmenu(){
    return "Bienvenido \n¿Que acción quieres realizar?" +
                        "1- Solicitar mas chips" +
                        "2- Vender chip" +
                        "3- Reservar chip" +
                        "4- Cancelar reservacion de chip" +
                        "5- Cerrar Sesion";
  }

  @Override
  public String registrarUnidad(){
    return "Escanee el código de barras del chip para registrar un movimiento en el sistema.";
  }

  @Override
  public String registroExitoso(){
    return "El chip se ha registrado correctamente.";
  }

  @Override
  public String registroFallido(){
    return "El chip no se ha podido registrar en el sistema.";
  }

  @Override
  public String solicitudChips(){
    return "Se solicitaron chips al almacén.";
  }

  @Override
  public String cerrarSesion(){
    return "Cerrando sesión de ***.";
  }

}