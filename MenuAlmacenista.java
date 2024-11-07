public class MenuAlmacenista implements InterfazMenu{
  
  @Override()
  public String mostrarSubmenu(){
    return "Bienvenido al almacen. \n¿Que acción quieres realizar?" +
                        "1- Registrar caja" +
                        "2- Revisar solicitudes" +
                        "3- Consultar chips " +
                        "4- Cerrar Sesion";
  }

  @Override
  public String registrarUnidad(){
    return "A continuación escanea el código de barras para registrar el lote de una caja en el sistema:";
  }

  @Override
  public String registroExitoso(){
    return "La caja se ha registrado exitosamente.";
  }

  @Override
  public String registroFallido(){
    return "La caja no se ha podido registrar en el sistema.";
  }

  @Override
  public String solicitudChips(){
    return "Has recibido solicitudes de asignaciones de chips.";
  }

  @Override
  public String cerrarSesion(){
    return "Cerrando interfaz de almacen.";
  }

}