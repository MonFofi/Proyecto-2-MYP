/**
 * 
 */
public class Chip {

    private String codigoDeBarras;
    private String parteAnterior;
    private String partePosterior;
    private String numeroDeSerie;
    private EstadosChip estadoActual;
    private EstadosChip disponible;
    private EstadosChip reservado;
    private EstadosChip vendido;

    /**
     * 
     */
    public Chip(String codigoDeBarras) {
        if (!codigoDeBarrasValido(codigoDeBarras)) {
            throw new IllegalArgumentException("Código de barras inválido.");
        }
        this.codigoDeBarras = codigoDeBarras;
        this.parteAnterior = obtenerParteAnterior(codigoDeBarras);
        this.numeroDeSerie = obtenerNumeroSerie(codigoDeBarras);
        this.partePosterior = obtenerPartePosterior(codigoDeBarras);

        disponible = new EstadoDisponible(this);
        reservado = new EstadoReservado(this);
        vendido = new EstadoVendido(this);
        estadoActual = disponible; 
    }

    /**
     * 
     */
    private boolean codigoDeBarrasValido(String codigoDeBarras) {
        return codigoDeBarras.length() == 18 || codigoDeBarras.length() == 19;
    }

    /**
     * 
     */
    private String obtenerParteAnterior(String codigoDeBarras) {
        return codigoDeBarras.substring(0, 12);
    }

    /**
     * 
     */
    private String obtenerNumeroSerie(String codigoDeBarras) {
        return codigoDeBarras.substring(12, 18);
    }

    /**
     * 
     */
    private String obtenerPartePosterior(String codigoDeBarras) {
        return codigoDeBarras.length() == 19 ? codigoDeBarras.substring(18) : "";
    }

    /**
     * 
     */
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    /**
     * 
     */
    public String getParteAnterior() {
        return parteAnterior;
    }

    /**
     * 
     */
    public String getPartePosterior() {
        return partePosterior;
    }

    /**
     * 
     */
    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    /**
     * 
     */
    public void mostrarChip() {
        System.out.println(parteAnterior + "\033[4m" + numeroDeSerie + "\033[0m" + partePosterior);
    }

    /**
     * 
     */
    public void setEstado(EstadosChip estado) {
        this.estadoActual = estado;
    }

    /**
     * 
     */
    public EstadosChip getEstadoActual() {
        return estadoActual;
    }

    /**
     * 
     */
    public EstadosChip getEstadoDisponible() {
        return disponible;
    }

    /**
     * 
     */
    public EstadosChip getEstadoReservado() {
        return reservado;
    }

    /**
     * 
     */
    public EstadosChip getEstadoVendido() {
        return vendido;
    }

    /**
     * 
     */
    public void estadoDisponible() {
        estadoActual.disponible();
    }

    /**
     * 
     */
    public void estadoReservado() {
        estadoActual.reservar();
    }

    /**
     * 
     */
    public void estadoCancelado() {
        estadoActual.cancelarReserva();
    }

    /**
     * 
     */
    public void estadoVendido() {
        estadoActual.venta();
    }

    /**
     * 
     */
    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"codigoDeBarras\":\"").append(codigoDeBarras).append("\",");
        json.append("\"parteAnterior\":\"").append(parteAnterior).append("\",");
        json.append("\"numeroDeSerie\":\"").append(numeroDeSerie).append("\",");
        json.append("\"partePosterior\":\"").append(partePosterior).append("\",");
        json.append("\"estadoActual\":\"").append(getEstadoActualName()).append("\"");
        json.append("}");
        return json.toString();
    }

    /**
     * 
     */
    public static Chip fromJson(String json) {
        String codigoDeBarras = extractJsonValue(json, "codigoDeBarras");
        Chip chip = new Chip(codigoDeBarras);

        String estadoActual = extractJsonValue(json, "estadoActual");
        if (estadoActual.equals("disponible")) {
            chip.setEstado(chip.getEstadoDisponible());
        } else if (estadoActual.equals("reservado")) {
            chip.setEstado(chip.getEstadoReservado());
        } else if (estadoActual.equals("vendido")) {
            chip.setEstado(chip.getEstadoVendido());
        }

        return chip;
    }

    /**
     * 
     */
    private String getEstadoActualName() {
        if (estadoActual == disponible) {
            return "disponible";
        } else if (estadoActual == reservado) {
            return "reservado";
        } else if (estadoActual == vendido) {
            return "vendido";
        }
        return "unknown";
    }

    /**
     * 
     */
    private static String extractJsonValue(String json, String key) {
        String searchKey = "\"" + key + "\":\"";
        int inicio = json.indexOf(searchKey) + searchKey.length();
        int fin = json.indexOf("\"", inicio);
        return json.substring(inicio, fin);
    }

}