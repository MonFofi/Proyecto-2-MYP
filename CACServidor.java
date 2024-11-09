import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
// import java.util.Scanner;

public class CACServidor{
  public ListaDeChips chipsDisponibles = new ListaDeChips();
  public ListaDeChips chipsReservados = new ListaDeChips();
  public ListaDeChips chipsVendidos = new ListaDeChips();
  public HashMapUsuarios usuarios = new HashMapUsuarios();
  public Queue<Solicitud> solicitudes = new LinkedList<>();

  public CACServidor(){
  }

  public ListaDeChips getChipsDisponibles(){
    return chipsDisponibles;
  }

  public ListaDeChips getChipsReservados(){
    return chipsReservados;
  }

  public ListaDeChips getChipsVendidos(){
    return chipsVendidos;
  }

  public HashMapUsuarios getUsuarios(){
    return usuarios;
  }

  public Iterator<Solicitud> getIteratorSolicitudes(){
    return solicitudes.iterator();
  }

  public void recibirSolicitud(Vendedor solicitante){
    Solicitud solicitud = new Solicitud(solicitante);
    solicitudes.offer(solicitud);
  }

  public void mostrarSolicitudes(){
    Iterator<Solicitud> i = getIteratorSolicitudes();
    while(i.hasNext()){
      System.out.println();
    }
  }

  public void asignarChips(String id){
    Vendedor v = usuarios.getHashMap().get(id);
    if (v != null && chipsDisponibles.getLongitud() > 0) {
      Iterator<Chip> iteradorChips = chipsDisponibles.getIteratorChips();        
      while (iteradorChips.hasNext()) {
        Chip chipAsignado = iteradorChips.next();
            // Asegurarnos de que no se repita el mismo chip asignado
        if (!v.chipsDisponibles.contiene(chipAsignado)) {
          v.chipsDisponibles.agregarChip(chipAsignado);
          break;
        }
      }
    } else {
      System.out.println("No se pudo asignar chip: vendedor no encontrado o no hay chips disponibles.");
    }
  }

  public void iniciarSesion(){

  }
}