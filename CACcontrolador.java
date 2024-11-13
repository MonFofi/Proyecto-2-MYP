public class CACcontrolador implements ControladorInterface{
	CACModeloInterface model;
	CACVista vista;

	public CACcontrolador(CACModeloInterface model) {
		this.model = model;
		vista = new CACVista(this,model);
		iniciarLogin();
	}

	public void iniciarLogin(){
		vista.initLogin();
	}
	
}