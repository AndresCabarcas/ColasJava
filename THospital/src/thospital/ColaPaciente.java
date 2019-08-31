/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thospital;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDACAMES
 */
public class ColaPaciente {
    
    Icon autor;
    static final int cantidad_camillas = 75;
    private int totalNodos; //Atributo para contar los nodos agregados a la cola. 
    private Persona frente;
    private Persona cola;

    public ColaPaciente() {
        frente = null;
        cola = null;
        totalNodos = 0;
        autor = new ImageIcon("src/thospital/THospitalicon.png");
    }
    //Método que retorna el número de nodos agregados a la cola.

    public int getTotalNodos() {
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

    public void Agregar(Persona e) {
        Persona temp = frente;
        if (temp == null) {
            frente = new Persona();
            frente.Registro();
            cola = frente;
        } else {
            Persona aux = new Persona();
            aux.Registro();
            cola.siguente = aux;
            cola = aux;
        }
        totalNodos = totalNodos + 1;

    }

    public void VerFila() {
        Persona temp = frente;
        String m = "";
        if (temp != null) {
            while (temp != null) {
                m = m + String.valueOf(" " + temp.getNombre() + "," + temp.getId() + "\n\n");
                temp = temp.getSiguente();
            }
            JOptionPane.showMessageDialog(null, "----------LISTA DE PACIENTES EN COLA--------\n\n" + m);
        } else {
            JOptionPane.showMessageDialog(null, "No hay Paciente en la cola");
        }

    }

    //Métodos para determinar si la cola está llena o vacía.
    public boolean colaLLena() {
        if (getTotalNodos() >= cantidad_camillas) {
            return true;
        } else {
            return false;
        }
    }

    public boolean colaVacia() {
        if (getTotalNodos() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Elimina el nodo del frente de la cola.
    public void quitar() {
        Persona temp;
        if (!colaVacia()) { //Si la cola no está vacía, se pueden eliminar nodos.
            temp = getFrente(); //Se asigna una referencia temporal al nodo del frente.
            frente = getFrente().getSiguente(); //ahora frente, será el siguiente del nodo frente.
            if (getFrente() == null) { //Esta condición es para cuando se elimina el único nodo que hay.
                cola = null;
            }
            temp = null; //La referencia temporal se hace nulo, que era el anterior nodo del frente.
            totalNodos = totalNodos - 1; //El contador de nodos se decremento en uno.
        }
    }

    public void Atender(ListaMedicos lisM) {

        Persona temp = frente;
        Persona tempMedic = lisM.getcabeza();

        if (lisM.getcabeza() != null) {//si ya hay medicos que atiendan 
            while (getTotalNodos() != 0) {

                JOptionPane.showMessageDialog(null, "EL PACIENTE:   " + temp.getNombre() + "  " + "IDENTIFICADO CON:  " + "C.C" + temp.getId() + "  " + "\n\n"
                        + "SERA ATENDIDO POR EL DR." + tempMedic.getNombre());
                quitar();
                tempMedic = tempMedic.getSiguente();
                if (tempMedic == null) {
                    tempMedic = lisM.getcabeza();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por el momento aun no hay medicos para atencion");
        }
    }
    
    public void bienvenida(){
    
        String nl = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null, "BIENVENIDOS AL THOSPITAL: "
            + nl + "Codigo Desarrollado por: "
            + nl + " "    
            + nl + "Andrés Cabarcas"
            + nl + "Yeinis Espinosa"
            + nl + " "
            + nl + "Programacion II","THospital", JOptionPane.WARNING_MESSAGE,autor);
    
    }
    
    public void Despedida(){
    
        String nl = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null, "====== THOSPITAL ====="
            + nl + " "
            + nl + " "    
            + nl + "¡Gracias!"
            + nl + " Que tenga un buen dia"
            + nl + " "
            + nl + "=====================","THospital", JOptionPane.WARNING_MESSAGE,autor);
    
    }

}
