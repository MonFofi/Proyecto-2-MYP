import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase ListaDeChips representa nuestra estructura de datos donde se almacenan diversos chips utilizando
 * un ArrayList para manipularlos y poder definir también el uso de un iterador para la misma. 
 */
public class ListaDeChips {

    private ArrayList<Chip> listaDeChips;

    /**
     * Constructor de la clase ListaDeChips.
     */
    public ListaDeChips() {
        listaDeChips = new ArrayList<>();
        cargarDeJson(); 
    }

    /**
     * Metodo agregarChip 
     * Agrega un chip al ArrayList
     * @param chip El chip que se está agregando a la lista.
     */
    public void agregarChip(Chip chip) {
        listaDeChips.add(chip);
        guardarAJson(); 
    }

    /**
     * Metodo eliminarChip 
     * Elimina un chip del ArrayList.
     * @param chip El chip a eliminar.
     */
    public void eliminarChip(Chip chip) {
        listaDeChips.remove(chip);
        guardarAJson(); 
    }

    /**
     * Metodo getIteratorChips 
     * Devuelve un iterador para poder iterar sobre el ArrayList sin exponer su estructura y poder
     * así implementar el patrón Iterator.
     * @return Un iterador de tipo Chip.
     */
    public Iterator<Chip> getIteratorChips() {
        return listaDeChips.iterator();
    }

    /**
     * Metodo getLongitud 
     * Permite conocer la longitud del ArrayList.
     * @return Un int con el tamaño del ArrayList.
     */
    public int getLongitud() {
        return listaDeChips.size();
    }

    /**
     * Metodo contiene
     * Evalúa si existe un determinado chip en el ArrayList.
     * @return true si el chip se encuentra en el ArrayList.
     * @return false en caso contrario. 
     */
    public boolean contiene(Chip chip) {
        return listaDeChips.contains(chip);
    }

    /**
     * Metodo mostrarChips
     * Permite imprimir todo el ArrayList usando el iterador e imprimiendo
     * cada elemento de la lista mandando a llamar al método mostrarChip 
     * mientras se le asigna el número de su lugar en la lista mediante un contador.
     */
    public void mostrarChips() {
        Iterator<Chip> iterator = getIteratorChips();
        int contador = 1;
        while (iterator.hasNext()) {
            Chip chip = iterator.next();
            System.out.print(contador + ". ");
            chip.mostrarChip();
            contador++;
        }
    }

    /**
     * Metodo guardarAJson 
     * Permite guardar el ArrayList en un archivo .json para poder preservar la
     * información contenida en él posterior a una ejecución. 
     */
    private void guardarAJson() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ListaDeChips.json"))) {
            writer.write("[");
            for (int i = 0; i < listaDeChips.size(); i++) {
                writer.write(listaDeChips.get(i).toJson());
                if (i < listaDeChips.size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo cargarDeJson
     * Permite extraer la información de un .json para poder retomarla para posteriores ejecuciones.
     */
    private void cargarDeJson() {
        File file = new File("ListaDeChips.json");
        if (!file.exists()) {
            return; 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            String json = jsonBuilder.toString();
            if (json.startsWith("[") && json.endsWith("]")) {
                json = json.substring(1, json.length() - 1); 
                String[] chipJsons = json.split("},\\{"); 
                for (int i = 0; i < chipJsons.length; i++) {
                    String chipJson = chipJsons[i];
                    if (i > 0) chipJson = "{" + chipJson; 
                    if (i < chipJsons.length - 1) chipJson = chipJson + "}";
                    listaDeChips.add(Chip.fromJson(chipJson));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}