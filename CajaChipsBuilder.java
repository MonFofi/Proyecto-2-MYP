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
      int numSerie = numeroInicial + i;
      String codigoBarraCompleto = generarCodigoBarraCompleto(numSerie);
      Chip chip = new Chip(codigoBarraCompleto);
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

  public int getNumeroSerie() {
    return (codigoDeBarrasValido()) ? Integer.parseInt(codigoDeBarras.substring(12, 18)) : -1;
  }

  public boolean codigoDeBarrasValido() {
    return codigoDeBarras.length() == 18 || codigoDeBarras.length() == 19;
  }

  public String getParteAnterior() {
    return codigoDeBarras.substring(0, 12);
  }

  public String getPartePosterior() {
    return codigoDeBarras.length() == 19 ? codigoDeBarras.substring(18) : "";
  }

  private String generarCodigoBarraCompleto(int numeroSerie) {
    String numeroSerieFormateado = String.format("%06d", numeroSerie);
    return getParteAnterior() + numeroSerieFormateado + getPartePosterior();
  }
}