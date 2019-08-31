
import javax.swing.JOptionPane;


public class ColaPacientes extends Persona {
    static final int cantidad_camillas = 75;
     private int totalNodos; //Atributo para contar los nodos agregados a la cola. 
    private  Persona frente;
    private Persona  cola;
   
   
   public ColaPacientes(){
       frente=null;
       cola=null;
       totalNodos=0;
   }
   //Método que retorna el número de nodos agregados a la cola.
    public int getTotalNodos(){
        return totalNodos;
    }
    public Persona getFrente() {
        return frente;
    }
    public void setFrente(Persona fr) {
        frente = fr;
    }
    public Persona getCola() {
        return cola;
    }
    public void setCola(Persona fin) {
        cola = fin;
    }
    public void Agregar(Persona e){
       Persona temp = frente;
        if(temp==null){
                frente =new Persona();
                frente.Registro();
                cola=frente;
            }else{
                Persona aux=new Persona();
                aux.Registro();
                cola.siguente=aux;
                cola=aux;
            }
             totalNodos = totalNodos + 1;
        
    }
    public void VerFila(){
        Persona temp=frente;
        String m="";
        if(temp!=null){            
            while(temp!=null){
                m = m+String.valueOf(" "+ temp.getNombre()+","+temp.getId()+"\n\n" );
                temp=temp.getSiguente();
            }
            JOptionPane.showMessageDialog(null,"                    LISTA DE PACIENTES EN ESPERA                     \n\n"+m);
        }else{
            JOptionPane.showMessageDialog(null,"Disculpe No hay Paciente que atender");
        }
        
    }
    //Métodos para determinar si la cola está llena o vacía.
    public boolean colaLLena(){
        if(getTotalNodos() >= cantidad_camillas){
            return true;
        }else{ return false;
        }
    }
     public boolean colaVacia(){
        if(getTotalNodos() == 0){
            return true;
        }else{ 
            return false; 
        }
    } 
    //Elimina el nodo del frente de la cola.
    public void quitar(){ 
       Persona temp;
        if (!colaVacia()){ //Si la cola no está vacía, se pueden eliminar nodos.
           temp = getFrente(); //Se asigna una referencia temporal al nodo del frente.
           frente = getFrente().getSiguente(); //ahora frente, será el siguiente del nodo frente.
           if (getFrente() == null){ //Esta condición es para cuando se elimina el único nodo que hay.
            cola = null;
           } 
           temp = null; //La referencia temporal se hace nulo, que era el anterior nodo del frente.
           totalNodos = totalNodos - 1; //El contador de nodos se decremento en uno.
       }
    }
    public void Atender(ListMedicos lisM){
        
        
        Persona temp=frente;
        Persona tempMedic = lisM.getcabeza();
        
        if(lisM.getcabeza()!= null){//si ya hay medicos que atiendan 
            while(getTotalNodos()!=0){
                
               JOptionPane.showMessageDialog(null,"El paciente "+temp.getNombre()+" identificado con la id "+temp.getId()+
                    " sera atendido por el Medico "+tempMedic.getNombre());
                quitar();
                 tempMedic=tempMedic.getSiguente();
                 if(tempMedic==null){
                     tempMedic=lisM.getcabeza();
                 }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Disculpe No hay medicos que atiendan");
        }
    }
    
}
