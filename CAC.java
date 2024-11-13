public class CAC{
  public static void main(String[] args) {
    CACModeloInterface model = new CACModelo();
    ControladorInterface controller = new CACcontrolador(model);

  }
}
