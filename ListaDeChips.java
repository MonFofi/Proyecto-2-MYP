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

  public void eliminarChip(Chip chip){
    listaDeChips.remove(chip);
  }

  public Iterator<Chip> getIteratorChips(){
    return listaDeChips.iterator();
  }

  public int getLongitud(){
    return listaDeChips.size();
  }

  public void mostrarChips(){
    Iterator<Chip> iterator = getIteratorChips();
    int contador = 1;
    while (iterator.hasNext()) {
      Chip chip = iterator.next();
      System.out.print(contador + ". ");
      chip.mostrarChip();
      contador++;
    }
  }  

  public boolean contiene(Chip chip){
    return listaDeChips.contains(chip);
  }

}
