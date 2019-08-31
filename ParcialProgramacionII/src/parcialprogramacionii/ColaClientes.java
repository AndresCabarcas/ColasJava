/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialprogramacionii;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDACAMES
 */
public class ColaClientes {
    
     Icon autor;
    static final int cantidad_camillas = 75;
    private int totalNodos; //Atributo para contar los nodos agregados a la cola. 
    private Pedido frente;
    private Pedido cola;

    public ColaClientes() {
        frente = null;
        cola = null;
        totalNodos = 0;
    }
    //Método que retorna el número de nodos agregados a la cola.

    public int getTotalNodos() {
        return totalNodos;
    }

    public Pedido getFrente() {
        return frente;
    }

    public void setFrente(Pedido fr) {
        frente = fr;
    }

    public Pedido getCola() {
        return cola;
    }

    public void setCola(Pedido fin) {
        cola = fin;
    }

    public void Agregar(Pedido e) {
        Pedido temp = frente;
        if (temp == null) {
            frente = new Pedido();
            frente.Registro();
            cola = frente;
        } else {
            Pedido aux = new Pedido();
            aux.Registro();
            cola.siguente = aux;
            cola = aux;
        }
        totalNodos = totalNodos + 1;

    }

    public void VerFila() {
        Pedido temp = frente;
        String m = "";
        if (temp != null) {
            while (temp != null) {
                m = m + String.valueOf(" " + temp.getNombre() + "," + temp.getId() + "\n\n");
                temp = temp.getSiguente();
            }
            JOptionPane.showMessageDialog(null, "----------LISTA DE CLIENTES EN COLA--------\n\n" + m);
        } else {
            JOptionPane.showMessageDialog(null, "No hay Clientes en la cola");
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
        Pedido temp;
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

    public void Atender() {

        Pedido temp = frente;
            while (getTotalNodos() != 0) {

                JOptionPane.showMessageDialog(null, "CLIENTE:   " + temp.getNombre() + "  " + "CANTIDAD:  " + temp.getId() + "  " + "\n\n");
                quitar();
            
            }
    }
    
    
}
