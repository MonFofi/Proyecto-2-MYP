import java.util.LinkedList;
public class CajaChipsBuilder implements Builder{
  private String codigoDeBarras;
  private ListaDeChips listaDeChips;

  @Override
  public void setCodigoDeBarras(String codigo){
    this.codigoDeBarras = codigo;
  }

  @Override
  public void validarCodigoDeBarras(){
    
  }

  @Override
  public void construir(){

  }

  //no supe jaj no m funen
  public ListaDeChips getCaja(){
    return listaDeChips;
  }
}