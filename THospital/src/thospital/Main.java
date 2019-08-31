package thospital;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import thospital.Archivo;
import thospital.ColaPaciente;
import thospital.ListaMedicos;
import thospital.Persona;


/**
 *
 * @author ANDACAMES
 */

public class Main extends Archivo {
    

    //Metodo para asignar una ruta y nombre del archivo que se creara para guardar los datos del medico 
    public static String Ruta_del_Archivo() {
        return ("Medicos.txt");
    }

    //Método para asignar un menú de opciones de la aplicación.
    public static int MenuAtencion() {
  
        int opc = 0;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "---------THospital Bienvenido---------\n\n"
                    + "1. Agregar Paciente a la cola \n"
                    + "2. Guardar informacion de los medicos que atenderan a los pacientes \n"
                    + "3. Atender Pacientes(Asignar paciente a Medico) \n"
                    + "4. Paciente en Primer lugar de la fila. \n"
                    + "5. Retiro del primer paciente \n"
                    + "6. Consultar extructura(si esta vacia o no) \n"
                    + "7. Salir. \n \n" + "             "
                    + "Seleccione una opción del 1 al 7     "));

        } while (opc <= 0 && opc > 7);
        return opc;
    }

    public static void main(String[] args) throws IOException {
        
        ColaPaciente obj = new ColaPaciente();
        ListaMedicos medic = new ListaMedicos();
        Persona nd = null;
        int opc;
        obj.bienvenida();
        do {
            opc = MenuAtencion();
            switch (opc) {
                case 1:
                    if (!obj.colaLLena()) {
                        obj.Agregar(nd);//agrega el nodo en tiempo de ejecucion
                    } else {
                        JOptionPane.showMessageDialog(null, " Lo sentimos no hay camillas disponibles.\n"
                                + "Por favor Espere a que un paciente sea atendido");
                    }
                    break;
                case 2:
                    if (medic.contarNodos() <= 5) {
                        nd = new Persona();
                        nd.Registro();
                        medic.agregarMedico(nd, Ruta_del_Archivo());
                    } else {
                        JOptionPane.showMessageDialog(null, "  Ha excedido el limite de medicos en el Hospital  ");
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
                    JOptionPane.showMessageDialog(null, "Primer Paciente en la Cola. \n\n"
                            + "Nombre  " + obj.getFrente().getNombre() + "\n" + "ID: " + obj.getFrente().getId() + "\n");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Paciente que abandono la Cola. \n\n"
                            + "Nombre  " + obj.getFrente().getNombre() + "\n" + "ID: " + obj.getFrente().getId() + "\n");
                    obj.quitar();
                    break;
                case 6:
                    if (obj.getTotalNodos() >= 1) {
                        JOptionPane.showMessageDialog(null, "  La extructura tiene elementos   ");
                    } else {
                        if (obj.getTotalNodos() == 0) {
                            JOptionPane.showMessageDialog(null, "  la extructura esta vacia   ");
                        }
                    }
                    break;
                case 7:
                   obj.Despedida();
                    break;
            }
        } while (opc != 7);
    }
    

}
