// import javax.swing.*;

public class CAC{
  public static void main(String[] args) {

    Chip chip1 = new Chip(123456);
    Chip chip2 = new Chip(124567);
    Chip chip3 = new Chip(234567);
    Chip chip4 = new Chip(345678);
    Chip chip5 = new Chip(456789);

    System.out.println("\n" + chip1.getNumeroDeSerie());
    System.out.println(chip2.getNumeroDeSerie());
    System.out.println(chip3.getNumeroDeSerie());
    System.out.println(chip4.getNumeroDeSerie());
    System.out.println(chip5.getNumeroDeSerie());

    chip1.mostrarChip();
    //pruebas de state
    chip1.estadoDisponible();
    chip1.estadoReservado();
    chip1.estadoCancelado();
    // chip1.estadoCancelado();
    chip1.estadoVendido();
    chip1.chipVendido();

    chip2.mostrarChip();
    chip3.mostrarChip();
    chip4.mostrarChip();
    chip5.mostrarChip();


  }
}