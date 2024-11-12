import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 */
public class HashMapUsuarios{

  private HashMap<String, Vendedor> usuarios;

  /**
   * 
   */
  public HashMapUsuarios(){
    usuarios = new HashMap<>();
  }

  /**
   * 
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
   * 
   */
  public HashMap<String, Vendedor> getHashMap(){
    return usuarios;
  }

  /**
   * 
   */
  public Iterator<String> getIteratorUsuarios(){
    return usuarios.keySet().iterator();
  }

}