import java.util.ArrayList;
import java.util.Iterator;

public class ListaDeChips{
  private ArrayList<Chip> listaDeChips;
   
  public ListaDeChips(){
    listaDeChips =  new ArrayList<>();
  }

  public void agregarChip(Chip chip){
    listaDeChips.add(chip);
  }

  public Iterator<Chip> getIteratorChips(){
    return listaDeChips.iterator();
  }

  public void mostrarChips(){
    Iterator iterator = getIteratorChips();
    int contador = 1;
    while (iterator.hasNext()) {
      System.out.println(contador + ". " + iterator.next());
      contador++;
    }
  }
  
  // public void buscar(){
  //   Iterator iterator = getIteratorChips();
  //   int contador = 1;
  //   while (iterator.hasNext()) {
  //     System.out.println(iterator.next());
  //     contador++;
  //   }
  // }

}
