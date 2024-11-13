import java.util.ArrayList;

public class CACModelo implements CACModeloInterface{
    ArrayList<CACObservador> cacObservadores = new ArrayList<CACObservador>();
	Almacenista almacenista;
	Vendedor vendedor;
	Solicitud s;

	public CACModelo(){
		almacenista = new Almacenista("si", "123");
    	vendedor = new Vendedor("Ola", "666");
		
	}

	public void iniciarSesion(){

	}

    public void registrarCaja(String codigo){
		almacenista.escanearCaja(codigo);
	}

    public void revisarSolicitudes(){
			if(s != null){
				almacenista.solicitudRecibida(s);
				almacenista.verSolicitudes();
				almacenista.SubmenuAsignarChips(s);
			} else {
				almacenista.verSolicitudes();
			}

	}

    public void consultarChips(){
		almacenista.SubmenuConsultarChips();
	}

    public void solicitarMasChips(){
		s = vendedor.hacerSolicitud();

	}

    public void venderChip(){


	}

    public void reservarChip(){

	}

    public void cancelarReservacionChip(){

	}

    public void registrarObservador(CACObservador o) {
		cacObservadores.add(o);
	}

	public void notificarCACObservadores() {
		for(int i = 0; i < cacObservadores.size(); i++) {
			CACObservador observer = (CACObservador)cacObservadores.get(i);
			observer.actualizar();
		}
	}

	public void removerObservador(CACObservador o) {
		int i = cacObservadores.indexOf(o);
		if (i >= 0) {
			cacObservadores.remove(i);
		}
	}
}