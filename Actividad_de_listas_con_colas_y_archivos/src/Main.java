
import java.io.IOException;
import javax.swing.JOptionPane;


public class Main extends LeerEscribirArchivo {
    

    //Metodo para asignar una ruta y nombre del archivo que se creara para guardar los datos del medico 
    public static String Ruta_del_Archivo(){
        return ("Medicos.txt");
    }
    //Método para asignar un menú de opciones de la aplicación.
    public static int MenuAtencion() {
        
        int opc=0;
        do{ opc=Integer.parseInt(JOptionPane.showInputDialog(null, "        WELCOME         \n\n"+
                "1. Dar cabida a los pacientes a la Cola \n"+
                "2. Guardar informacion de los medicos que atenderan los pacientes \n"+
                "3. Atendere: muestra por pantalla la asignación de un paciente con un médico, \n"+
                "4. Información del paciente que será atendido en primer lugar. \n"+
                "5. Quitar Información del paciente que seriá atendido en primer lugar. \n"+
                "6. indica si la estructura está vacía o no. \n"+
                "7. Salir. \n \n"+"             Seleccione una opción del 1 al 7     "));
            
        }while(opc<=0 && opc >7);
        return opc;
    }
    public static void main(String[] args) throws IOException {
         ColaPacientes obj = new ColaPacientes();
         ListMedicos medic=new ListMedicos();
         Persona nd = null ;
        int opc;
        do{ opc=MenuAtencion();
            switch(opc){
                case 1:
                    if(!obj.colaLLena()){ //si la cola no esta llena que agregue 
                     //medic.leerArchivo_Y_Guardar(nd); //agrega el nodo dede el archivo de texto
                       obj.Agregar(nd);//agrega el nodo en teimpo de ejecucuion
                    }else{
                        JOptionPane.showMessageDialog(null," Actual mente no hay camillas disponible.\n"+
                                "Espere que los doctores den dealta a un paciente");
                    }
                    
                break;
                    
                case 2:
                    
                   if(medic.contarNodos()<=5){
                     nd = new Persona();
                     nd.Registro();             
                     medic.agregarMedico(nd,Ruta_del_Archivo());
                    }else{
                        JOptionPane.showMessageDialog(null,"  Ya no puede agregar mas medicos   ");
                    }
                   medic.leer();//lee y muetra los datos que se agregaron en el archivo
                   medic.VerMedicos();//Muestra los medicos agregados
                break;
                case 3:
                    obj.VerFila();
                    obj.Atender(medic);
                    obj.VerFila();
                break;
                case 4:
                    JOptionPane.showMessageDialog(null,"paciente que será atendido en primer lugar. \n\n"+
                            "Nombre  "+obj.getFrente().getNombre()+"\n"+"ID: "+obj.getFrente().getId()+"\n"); 
                break;
                case 5:
                    
                   JOptionPane.showMessageDialog(null,"Informe de Pasiente que decidio abandonar la fila. \n\n"+
                           "Nombre  "+obj.getFrente().getNombre()+"\n"+"ID: "+obj.getFrente().getId()+"\n");
                   obj.quitar();
                break;
                case 6:
                    if(obj.getTotalNodos()>=1){
                        JOptionPane.showMessageDialog(null,"  La extructura tiene elementos   ");  
                    }else{
                        if(obj.getTotalNodos()==0){
                            JOptionPane.showMessageDialog(null,"  la extructura esta vacia   ");
                        }
                    }
                 break;   
                case 7:
                    JOptionPane.showMessageDialog(null,"  QUE TENGA UN BUENDIA   ");
                break;
            }
        }while(opc!=7);
    }
    

}
    

