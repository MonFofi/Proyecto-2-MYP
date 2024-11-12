import java.util.ArrayList;

public class CACModelo implements CACModeloInterface{
    ArrayList<CACObservador> cacObservadores = new ArrayList<CACObservador>();

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