
import javax.swing.JOptionPane;


public class Persona {
    private String Nombre;
    private String id;
   public Persona siguente;

    public Persona() {
        this.Nombre = "";
        this.id = "";
        this.siguente = null;
    } 

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Persona getSiguente() {
        return siguente;
    }

    public void setSiguente(Persona siguente) {
        this.siguente = siguente;
    }
     public void Registro(){
        setNombre(JOptionPane.showInputDialog(null,"Digite su nombre"));
        setId(JOptionPane.showInputDialog(null,"Digite su identficacion"));
    }

    
}
