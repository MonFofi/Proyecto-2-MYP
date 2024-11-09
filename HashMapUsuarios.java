import java.util.HashMap;
import java.util.Iterator;

public class HashMapUsuarios{
  //en el diagrama de clases viene de tipo Usuarios pero no supe si
  //se refería a otra clase o a la interfaz xd
  private HashMap<String, Vendedor> usuarios;

  public HashMapUsuarios(){
    usuarios = new HashMap<>();
    usuarios.put("12345", new Vendedor("Carlos"));
    usuarios.put("24680", new Vendedor("Andrea"));
    usuarios.put("13579", new Vendedor("Roberto"));
    usuarios.put("12457", new Vendedor("Julian"));
    usuarios.put("23568", new Vendedor("Cintia"));
    usuarios.put("98653", new Vendedor("Karla"));
  }

  public HashMap<String, Vendedor> getHashMap(){
    return usuarios;
  }

  public Iterator<String> getIteratorUsuarios(){
    return usuarios.keySet().iterator();
  }

}