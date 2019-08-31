
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;


public class ListMedicos extends LeerEscribirArchivo {
    private  Persona cabeza;    
    
    public ListMedicos(){
        cabeza = null;
    }    
    public void setcabeza(Persona cab){
        this.cabeza = cab;
    }
    public Persona getcabeza(){
        return cabeza;
    }     
    public Persona ultimo(){
        
        Persona temp = cabeza;
        
        while(temp!=null){
            if(temp.getSiguente()==null){
                break;
            }else{
                temp = temp.getSiguente();
            }
        }
        
        return temp;
    }    
    public void agregarMedico(Persona nuevo,String ruta)throws IOException{
        setruta(ruta);
        if(cabeza==null){
            cabeza = nuevo;
            guardarArchivo(nuevo);
        }else{
            ultimo().setSiguente(nuevo);
            guardarArchivo(nuevo);
        }
         JOptionPane.showMessageDialog(null,"  GUARDADO  ");
        
    }    
    
    public int contarNodos(){
        
        int cont = 0;
        Persona temp = cabeza;        
        while(temp!=null){
            cont++;
            temp = temp.getSiguente();
        }
        return cont;
    }
    public void VerMedicos(){
        Persona temp=getcabeza();
        String m="";
        if(temp!=null){            
            while(temp!=null){
                m = m+String.valueOf(" "+ temp.getNombre()+","+temp.getId()+"\n\n" );
                temp=temp.getSiguente();
            }
            JOptionPane.showMessageDialog(null,"                    LISTA DE PACIENTES EN ESPERA                     \n\n"+m);
        }else{
            JOptionPane.showMessageDialog(null," No hay Medicos ");
        }
        
    }
    
    public void leer(){
        
            try {
                FileReader entrada =new FileReader(getruta());
                int c = entrada.read();
                 
                 
                while(c!= -1){
                    c=entrada.read();
                    char letra=(char)c;
                    System.out.print(letra);
                   
                 }
            } catch (IOException e ) {
                //Logger.getLogger(DeclararColaHospital.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se encontro el archivo");
            }
            
       
    }

    
}
