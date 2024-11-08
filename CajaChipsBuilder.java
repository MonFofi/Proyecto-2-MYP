import java.util.LinkedList;
public class CajaChipsBuilder implements Builder{
  private String codigoDeBarras;
  private ListaDeChips listaDeChips;

  @Override
  public Builder setCodigoDeBarras(String codigoDeBarras){
    this.codigoDeBarras = codigoDeBarras;
    return this;
  }

  @Override
  public Builder setListaDeChips(ListaDeChips listaDeChips){
    this.listaDeChips = listaDeChips;
    return this;
  }
  
  @Override
  public CajaChips construir(){
    int numeroInicial = getNumeroSerie();
    if (numeroInicial == -1) {
      throw new IllegalArgumentException("Código de barras inválido.");
    }
    for (int i = 0; i < 100; i++) {
      Chip chip = new Chip(numeroInicial + i);
      listaDeChips.agregarChip(chip);
    }
    return new CajaChips(this);
  }

  public String getCodigoDeBarras(){
    return codigoDeBarras;
  }

  public ListaDeChips getListaDeChips(){
    return listaDeChips;
  }

  public int getNumeroSerie(){
    int numeroDeSerie;
    return numeroDeSerie = (codigoDeBarrasValido()) ? Integer.parseInt(codigoDeBarras.substring(12, 18)) : -1;
  }

  public boolean codigoDeBarrasValido(){
    return codigoDeBarras.length() == 18 || codigoDeBarras.length() == 19;
  }

}
