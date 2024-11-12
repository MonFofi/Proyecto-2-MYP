public class CACcontrolador implements ControladorInterface{
  CACModeloInterface model;
	CACVista vista;

  public CACcontrolador(CACModeloInterface model) {
		this.model = model;
		vista = new CACVista(this,model);
		vista.initLogin();
		/*view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		view.disableChangeBPM();
    */
		//model.initialize();
	}
}