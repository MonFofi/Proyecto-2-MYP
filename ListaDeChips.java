import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaDeChips {
    private ArrayList<Chip> listaDeChips;

    public ListaDeChips() {
        listaDeChips = new ArrayList<>();
        cargarDeJson(); 
    }

    public void agregarChip(Chip chip) {
        listaDeChips.add(chip);
        guardarAJson(); 
    }

    public void eliminarChip(Chip chip) {
        listaDeChips.remove(chip);
        guardarAJson(); 
    }

    public Iterator<Chip> getIteratorChips() {
        return listaDeChips.iterator();
    }

    public int getLongitud() {
        return listaDeChips.size();
    }

    public boolean contiene(Chip chip) {
        return listaDeChips.contains(chip);
    }

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