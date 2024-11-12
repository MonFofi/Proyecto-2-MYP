public class CAC{
  public static void main(String[] args) {

    Chip chip5 = new Chip("8952020224390939011");
    Almacenista a = new Almacenista("si", "123");
    Vendedor v = new Vendedor("Ola", "666");


   //Codigos con 19 digitos:
    //Numero con un cero al inicio. ("8952020224390939011")
    //Numero que inicia en ceros al inicio. ("8952020224390000001")
    //Numero con varios ceros al inicio. ("8952020224390000111")
   //Numeros con 18 digitos. ("895202022499860801")
    //Numero con ceros al inicio.("895202022400860801")
    //Numero sin ceros al inicio. ("895202002419499801")

    //Se registra una caja (o dos)
    a.escanearCaja("8952020024194998016");
    // a.escanearCaja("8952020224390939011");

    //se crea una solicitud
    Solicitud s = v.hacerSolicitud();

    //se guarda la solicitud en una lista
    a.solicitudRecibida(s);

    //El almacen revisa cuantas solicitudes tiene
    a.verSolicitudes();

    //se asigna chip a una solicitud en específico
    a.asignarChip(s);

    //el vendedor consulta sus chips disponibles 
    v.mostrarDisponibles();
    System.out.println("");
    
    //el almacen consulta los chips disponibles en el sistema para asignar.
    a.verChipsRegistrados();
    System.out.println("");

    //el almacen consulta los chips disponibles ya asignados a vendedores.
    a.mostrarDisponibles();

    // se reserva un chip y se imprime la lista de disponibles y de disponibles para 
    // corroborar que su estado cambia correctamente así como corroborar el
    // cambio correcto de lista en la que se encuentra.
    v.cambiarAReservado("8952020024194998036");
    v.mostrarDisponibles();
    System.out.println("");
    v.mostrarReservados();
    System.out.println("");
    //v.cambiarADisponible("8952020024194998036");
    
    //Se vende el chip y se vuelven a imprimir las listas del vendedor para
    //corroborar que se haya vendido correctamente
    //v.cambiarAVendido("8952020024194998036");
    v.mostrarDisponibles();
    v.mostrarReservados();
    v.mostrarVendidos();


    //impresion de listas del almacen (!es aqui donde se ve el error de las listas del server que les digo!)
    a.mostrarDisponibles();
    a.mostrarReservados();
    a.mostrarVendidos();

  }
}
