public class Vendedor implements InterfazUsuarios{
  
  @Override()
  public void mostrarSubmenu(){
    System.out.println("Bienvenido \n¿Que acción quieres realizar?" +
                        "1- Solicitar mas chips" +
                        "2- Vender chip" +
                        "3- Reservar chip" +
                        "4- Cancelar reservacion de chip" +
                        "5- Cerrar Sesion");
  }

  @Override
  public void registrarUnidad(){
    System.out.println("Escanee el código de barras del chip para registrar un movimiento en el sistema.");
  }

  @Override
  public void registroExitoso(){
    System.out.println("El chip se ha registrado correctamente.");
  }

  @Override
  public void registroFallido(){
    System.out.println("El chip no se ha podido registrar en el sistema.");
  }

  @Override
  public void solicitudChips(){
    System.out.println("Se solicitaron chips al almacén.");
  }

  @Override
  public void cerrarSesion(){
    System.out.println("Cerrando sesión de ***.");
  }

}