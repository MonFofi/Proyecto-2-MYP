import java.util.HashMap;
import java.util.Iterator;

/**
 * Clase HashMapUsuarios que representa la estructura de datos que se utilizará para almacenar a los
 * Usuarios capaces de utilizar el sistema utilizando un hashmap.
 */
public class HashMapUsuarios{

  private HashMap<String, Vendedor> usuarios;

  /**
   * Constructor de la clase HashMapUsuarios
   */
  public HashMapUsuarios(){
    usuarios = new HashMap<>();
  }

  /**
   * Metodo cargarVendedores
   * Se añaden al hashmap los usuarios registrados en el sistema para almacenarlos.
   */
  public void cargarVendedores() {
    usuarios.put("12345", new Vendedor("Carlos", "12345"));
    usuarios.put("24680", new Vendedor("Andrea", "24680"));
    usuarios.put("13579", new Vendedor("Roberto", "13579"));
    usuarios.put("12457", new Vendedor("Julian", "12457"));
    usuarios.put("23568", new Vendedor("Cintia", "23568"));
    usuarios.put("98653", new Vendedor("Karla", "98653"));
  }

  /**
   * Metodo getHashMap
   * Método de acceso que regresa el hashmap donde se guardaron los usuarios.
   * @return usuarios El hashmap con los usuarios. 
   */
  public HashMap<String, Vendedor> getHashMap(){
    return usuarios;
  }

  /**
   * Metodo getIteratorUsuarios
   * Regresa un iterador de tipo String que permite recorrer las llaves del hashmap.
   * @return Un iterador de tipo String.
   */
  public Iterator<String> getIteratorUsuarios(){
    return usuarios.keySet().iterator();
  }

}