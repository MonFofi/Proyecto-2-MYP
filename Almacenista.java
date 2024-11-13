import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase que representa a un almacenista que puede introducir al sistema
 * cajas de chips y asignar estos a los vendedores. Hereda de la clase abstracta Usuario.
 */
public class Almacenista extends Usuarios{
  
  public ListaDeChips chipsDisponibles;
  public ListaDeChips chipsReservados;
  public ListaDeChips chipsVendidos;
  Scanner scanner = new Scanner(System.in);

  /**
   * Constructor de la clase Almacenista.
   * Hereda el constructor de la clase abstracta Usuarios
   * @param nombre El nombre del usuario.
   * @param iD El ID del usuario.
   */
  public Almacenista(String nombre, String iD){
    super(nombre, iD);
    rol = "almacenista";
    inicializarServidor();
    chipsDisponibles = cac.getChipsDisponibles();
    chipsReservados = cac.getChipsReservados();
    chipsVendidos = cac.getChipsVendidos();
  }

  /**
   * Metodo escanearCaja
   * Permite ingresar al sistema una caja de chips mediante el escaneo de su código de barras.
   * @param codigo El código de barras de la caja que se quiere registrar
   * en el sistema.
   */
  public void escanearCaja(String codigo){
    cac.registrarCaja(codigo);
  }

  public void SubmenuAsignarChips(Solicitud s){
    System.out.println("Asignacion de chips, elija una opcion:");
    System.out.println("1.- Asignar chips a todas las solicitudes \n 2.- Asignar chips a un empleado en especifico \n");

    System.out.print("Introduce una opcion: ");
        int opcionUsuario = scanner.nextInt();
        if(opcionUsuario == 1){
          asignarChipsATodos();
        } else if (opcionUsuario == 2){
          asignarChip(s);
        } else {
          System.out.println("opcion invalida");
        }
  }

  public void SubmenuConsultarChips(){
    try {
    System.out.println("Consulta de chips, elija una opcion:");
    System.out.println(" 1.- Consultar chips en existencia \n 2.- Consultar chips disponibles \n 3.- Consultar chips reservados \n 4.- Consultar chips vendidos");

    System.out.print("Introduce una opcion: ");
        int opcionUsuario = scanner.nextInt();
          switch(opcionUsuario){
            case 1: 
            verChipsRegistrados();
            break;

            case 2: 
            mostrarDisponibles();
            break;

            case 3:
            mostrarReservados();
            break;

            case 4: 
            mostrarVendidos();
            break;

            default:
            System.out.println("Opción inválida");
          }
    } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, introduce un número.");
            scanner.nextLine();
    }
  }

  /**
   * Metodo asignarChip
   * Permite al almacenista asignar chips de los que ya se han ingresado al sistema a un 
   * vendedor en específico que haya hecho una solicitud.
   * @param s La solicitud de asignación de chips.
   */
  public void asignarChip(Solicitud s){
    cac.procesarSolicitud(s);
  }
  
  /**
   * Metodo asignarChipsATodos
   * Permite asignar chips de los que ya se han ingresado al sistema a todos los vendedores
   * que hayan hecho una solicitud de más chips.
   */
  public void asignarChipsATodos(){
    cac.procesarTodasSolicitudes();
  }

  /**
   * Metodo verSolicitudes
   * Permite al almacenista ver cuantas solicitudes de aisngación de chips tiene y quien las hizo.
   */
  public void verSolicitudes(){
    cac.mostrarSolicitudes();
  }

  /**
   * Metodo solicitudRecibida
   * Permite al almacenista recibir una solicitud hecha para agregarla a una lista de solicitudes.
   * @param s La solicitud que se recibe.
   */
  public void solicitudRecibida(Solicitud s){
    cac.recibirSolicitud(s);
  }

  /**
   * Metodo verChipsRegistrados
   * Imprime la lista de chips que se tienen registrados en el sistema y están disponibles para ser
   * asignados a algún vendedor.
   */
  public void verChipsRegistrados(){
    cac.mostrarRegistrados();
  }  

  /**
   * Método mostrarDisponibles
   * Imprime la lista de chips disponibles para ser vendidos o reservados por los vendedores de los 
   * que ya han sido asignados.
   */
  @Override
  public void mostrarDisponibles(){
    cac.mostrarDisponibles();
  }

  /**
   * Método mostrarReservados
   * Imprime la lista de chips reservados por los vendedores y no pueden estar disponibles.
   */
  @Override
  public void mostrarReservados(){
    cac.mostrarReservados();
  }

  /**
   * Método mostrarVendidos
   * Imprime la lista de chips que ya han sido vendidos.
   */
  @Override
  public void mostrarVendidos(){
    cac.mostrarVendidos();
  }

}