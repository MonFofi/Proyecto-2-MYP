public class CajaChips{
  private String codigoDeBarras;
  private ListaDeChips listaDeChips;

  public CajaChips(CajaChipsBuilder builder){
    codigoDeBarras = builder.getCodigoDeBarras();
    listaDeChips = builder.getListaDeChips();
  }

  public String getCodigoDeBarras(){
    return codigoDeBarras;
  }

  public ListaDeChips getCaja(){
    return listaDeChips;
  }
}