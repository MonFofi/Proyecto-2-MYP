public interface CACModeloInterface{
    String iniciarSesion(String usuario, String contrasenia);

    void registrarCaja(String codigo);

    void revisarSolicitudes();

    void consultarChips();
    
    Chip escanerChip(String codigo);

    void solicitarMasChips();

    void venderChip(String codigo);

    void reservarChip(String codigo);

    void cancelarReservacionChip(String codigo);
    
    void registrarObservador(CACObservador o);

    void notificarCACObservadores();
  
	void removerObservador(CACObservador o);
}