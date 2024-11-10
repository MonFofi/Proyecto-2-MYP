public class CAC{
  public static void main(String[] args) {

    Chip chip1 = new Chip(123456);
    Chip chip2 = new Chip(124567);
    Chip chip3 = new Chip(234567);
    Chip chip4 = new Chip(345678);
    Chip chip5 = new Chip(456789);

    /**
     * pruebas de state 
     */
    // chip1.estadoReservado()
    chip1.estadoDisponible();
    chip1.estadoReservado();
    chip1.estadoCancelado();
    chip1.estadoVendido();
    chip1.confirmarVenta();

    /**
     * pruebas de builder
     */

    //prueba con un cero al inicio. Imprime 6 dígitos correctamente
      // ListaDeChips lista1 = new ListaDeChips();
      // CajaChips caja1 = new CajaChipsBuilder().setListaDeChips(lista1).setCodigoDeBarras("8952020224390939011").construir();
      // caja1.mostrarCaja();

    // prueba con un cero al inicio. Imprime 6 dígitos correctamente
      ListaDeChips lista1 = new ListaDeChips();
      CajaChips caja1 = new CajaChipsBuilder().setListaDeChips(lista1).setCodigoDeBarras("8952020224390000001").construir();
      caja1.mostrarCaja();

    //prueba con más de un 0 al inicio. Imprime 6 dígitos correctamente
      // ListaDeChips lista3 = new ListaDeChips();
      // CajaChips caja3 = new CajaChipsBuilder().setListaDeChips(lista3).setCodigoDeBarras("8952020224390000111").construir();
      // caja3.mostrarCaja();

    //prueba con numero con primer dígito distinto de 0. Imprime 6 dígitos correctamente
      // ListaDeChips lista2 = new ListaDeChips();
      // CajaChips caja2 = new CajaChipsBuilder().setListaDeChips(lista2).setCodigoDeBarras("895202002419499801").construir();
      // caja2.mostrarCaja();

  }
}