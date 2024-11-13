public interface CACModeloInterface{
    void iniciarSesion();

    void registrarCaja(String codigo);

    void revisarSolicitudes();

    void consultarChips();

    void solicitarMasChips();

    void venderChip();

    void reservarChip();

    void cancelarReservacionChip();
    
    void registrarObservador(CACObservador o);
  
	void removerObservador(CACObservador o);
}