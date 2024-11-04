public class Almacenista implements InterfazUsuarios{
  
  @Override()
  public void mostrarSubmenu(){
    System.out.println("Bienvenido al almacen. \n¿Que accion quieres realizar?" +
                        "1- Registrar caja" +
                        "2- Revisar solicitudes" +
                        "3- Consultar chips " +
                        "4- Cerrar Sesion");
  }

  @Override
  public void registrarUnidad(){
    System.out.println("A continuación escanea el código de barras para registrar el lote de una caja en el sistema:");
  }

  @Override
  public void registroExitoso(){
    System.out.println("La caja se ha registrado exitosamente.");
  }

  @Override
  public void registroFallido(){
    System.out.println("La caja no se ha podido registrar en el sistema.");
  }

  @Override
  public void solicitudChips(){
    System.out.println("Has recibido solicitudes de asignaciones de chips.");
  }

  @Override
  public void cerrarSesion(){
    System.out.println("Cerrando interfaz de almacen.");
  }

}