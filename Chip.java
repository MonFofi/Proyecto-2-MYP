/**
 * Clase que representa un chip que podrá ser asignado a vendedores
 * para poder realizar diversas acciones con ellos.
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
     * Constructor de la clase Chip
     * @param codigoDeBarras El código de barras del chip para poder obtener su identificador único.
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
     * Metodo codigoDeBarrasValido
     * Evalua si el código de barras tiene 18 o 19 dígitos para evaluar si es válido o no.
     * @return true si el código de barras tiene 18 o 19 dígitos.
     * @return false en caso contrario.
     */
    private boolean codigoDeBarrasValido(String codigoDeBarras) {
        return codigoDeBarras.length() == 18 || codigoDeBarras.length() == 19;
    }

    /**
     * Metodo obtenerParteAnterior 
     * Devuelve los 12 dígitos que se encuentran antes del número de serie identificador del chip.
     * @param String  El código de barras a separar
     * @return Un string con los dígitos anteriores al número de serie.
     */
    private String obtenerParteAnterior(String codigoDeBarras) {
        return codigoDeBarras.substring(0, 12);
    }

    /**
     * Metodo obtenerNumeroSerie 
     * Permite obtener el número de serie del chip.
     * @param codigoDeBarras El código de barras a separar.
     * @return un String con el número de serie del chip.
     */
    private String obtenerNumeroSerie(String codigoDeBarras) {
        return codigoDeBarras.substring(12, 18);
    }

    /**
     * Metodo obtenerPartePosterior 
     * Devuelve el último dígito que se encuentran después del número de serie identificador del chip.
     * @param String  El código de barras a separar
     * @return Un string con el dígito posterior al número de serie en caso de que tenga 19 dígitos.
     */
    private String obtenerPartePosterior(String codigoDeBarras) {
        return codigoDeBarras.length() == 19 ? codigoDeBarras.substring(18) : "";
    }

    /**
     * Metodo getCodigoDeBarras 
     * Método de acceso que permite obtener el código de barras del chip
     * @return Un String con el código de barras del chip.
     */
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    /**
     * Metodo getParteAnterior 
     * Método de acceso que permite obtener la parte anterior al número de serie del código de barras del chip.
     * @return  Un String con los dígitos anteriores al número de serie del chip.
     */
    public String getParteAnterior() {
        return parteAnterior;
    }

    /**
     * Metodo getPartePosterior 
     * Método de acceso que permite obtener el último dígito del código
     * de barras posterior al número de serie del chip en caso de que lo haya.
     * @return Un String con el último dígito del código de barras.
     */
    public String getPartePosterior() {
        return partePosterior;
    }

    /**
     * Metodo getNumeroDeSerie 
     * Método de acceso que permite obtener el número de serie del chip.
     * @return Un String con el número de serie del chip.
     */
    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    /**
     * Metodo mostrarChip
     * Permite imprimir en pantalla al chip resaltando el número de serie del chip subrayando éste.
     */
    public void mostrarChip() {
        System.out.println(parteAnterior + "\033[4m" + numeroDeSerie + "\033[0m" + partePosterior);
    }

    /**
     * Metodo setEstado
     * Permite cambiar el estado del chip.
     @param estado El estado nuevo que se le quiere asignar al chip.
     */
    public void setEstado(EstadosChip estado) {
        this.estadoActual = estado;
    }

    /**
     * Metodo getEstadoActual
     * Método de acceso que regresa el estado actual en el que se encuentra el chip.
     * @return estadoActual El estado en el que se encuentra el chip.
     */
    public EstadosChip getEstadoActual() {
        return estadoActual;
    }

    /**
     * Metodo getEstadoDisponible 
     * Método de acceso que regresa el estado disponible que se le puede asignar a un chip.
     * @return disponible El estado disponible del chip.
     */
    public EstadosChip getEstadoDisponible() {
        return disponible;
    }

    /**
     * Metodo getEstadoReservado 
     * Método de acceso que regresa el estado reservado que se le puede asignar a un chip.
     * @return reservado El estado reservado del chip.
     */
    public EstadosChip getEstadoReservado() {
        return reservado;
    }

    /**
     * Metodo getEstadoVendido
     * Método de acceso que regresa el estado vendido que se le puede asignar a un chip.
     * @return vendido El estado vendido del chip.
     */
    public EstadosChip getEstadoVendido() {
        return vendido;
    }

    /**
     * Metodo estadoDisponible
     * Cambia el estado actual del chip a disponible. 
     */
    public void estadoDisponible() {
        estadoActual.disponible();
    }

    /**
     * Metodo estadoReservado 
     * Cambia el estado actual del chip a reservado.
     */
    public void estadoReservado() {
        estadoActual.reservar();
    }

    /**
     * Metodo estadoCancelado
     * Cambia el estado actual del chip a cancelado.
     */
    public void estadoCancelado() {
        estadoActual.cancelarReserva();
    }

    /**
     * Metodo estadoVendido 
     * Cambia el estado actual del chip a vendido.
     */
    public void estadoVendido() {
        estadoActual.venta();
    }

    /**
     * Metodo toJson
     * Permite hacer un parseo de la clase a un formato amigable para ser procesado.
     * @return json.toString Un String con la cadena formada para pasarla al json.
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
     * Metodo fromJson
     * Permite convertir lo guardado en el Json a formato de la clase Chip.
     * @return chip El chip creado después de obtener su información del Json.
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
     * Metodo getEstadoActualName 
     * Método de acceso que permite obtener una cadena con el estado del chip consultando el tipo de su instancia. 
     * @return Un String con una cadena donde guarda en que estado se encuentra el chip.
     * @return unknown en caso de que el estado no sea válido.
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
     * Metodo extractJsonValue
     * Método que permite obtener la información en el .json para parsearla y convertirla a un String.
     * @return Un string con el contenido del .Json sin los primeros y últimos caracteres.
     */
    private static String extractJsonValue(String json, String key) {
        String searchKey = "\"" + key + "\":\"";
        int inicio = json.indexOf(searchKey) + searchKey.length();
        int fin = json.indexOf("\"", inicio);
        return json.substring(inicio, fin);
    }

}