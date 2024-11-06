import java.util.ArrayList;
import java.util.Iterator;

public class ListaDeChips{
  private ArrayList<Chip> listaDeChips;
   
  public ListaDeChips(){

  }

  public void agregarChip(Chip chip){
    listaDeChips.add(chip);
  }

  // public Iterator<String> getIteratorChips(){

  // }

  public void mostrarChips(){
    System.out.println("si");
  }

}