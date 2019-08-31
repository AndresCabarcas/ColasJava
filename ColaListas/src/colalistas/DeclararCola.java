/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colalistas;

/**
 *
 * @author ANDACAMES
 */
public class DeclararCola {

    static final int cantidad_nodos = 5;
//Número máximo de nodos que se podrán almacenar en la cola.   
    private int totalNodos; //Atributo para contar los nodos agregados a la cola. 
    private Nodo frente; //Apuntador que devuelve el nodo del frente de la cola.  
    private Nodo finalCola;  //Apuntador que devuelve el nodo del final de la cola.
    //Método constructor de la clase.       

    public void DeclaraCola() {
        totalNodos = 0;
        frente = null;
        finalCola = null;
    } //Método que retorna el número de nodos agregados a la cola. 

    public int getTotalNodos() {
        return totalNodos;
    }

//Método que retorna el apuntador al nodo del frente de la cola.     
    public Nodo getFrente() {
        return frente;
    } //Método que retorna el apuntador al nodo del final de la cola.  

    public Nodo getFinal() {
        return finalCola;
    } //Métodos para determinar si la cola está llena o vacía. 

    public boolean colaLLena() {
        if (getTotalNodos() >= cantidad_nodos) {
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
    } //Método para agregar un dato en el campo de información, de un nuevo nodo.   

    public void agregar(String dato) {
        if (!colaLLena()) {
            //Si la cola no está llena, se pueden agregar nodos.           
            Nodo temp = new Nodo();
            //Se crea un nuevo objeto o instancia de la clase Nodo (temp).             
            temp.setDato(dato); //Se asigna la información al respectivo atributo.    
            if (getFrente() == null) {
                //Esta condición es para cuando se agrega el primer nodo de la cola.     
                frente = temp;
            } else {
                getFinal().setSiguiente(temp);
            } //Si hay nodos en la cola, el ultimo nodo apuntara al nuevo. 
            finalCola = temp;
            totalNodos = totalNodos + 1;
        }

//El contador de nodos se incrementa en uno.      
    }

//Elimina el nodo del frente de la cola.   
    public void quitar() {
        Nodo temp;

        if (!colaVacia()) {
//Si la cola no está vacía, se pueden eliminar nodos.    
            temp = getFrente();
//Se asigna una referencia temporal al nodo del frente.   
            frente = getFrente().getSiguiente();
//ahora frente, será el siguiente del nodo frente.   
            if (getFrente() == null) {
//Esta condición es para cuando se elimina el único nodo que hay.   
                finalCola = null;
            }
            temp = null;
//La referencia temporal se hace nulo, que era el anterior nodo del frente.    
            totalNodos = totalNodos - 1;
//El contador de nodos se decremento en uno.   
        }
    }
//Método que muestra la información del nodo del frente de la cola.    

    public String valorFrente() {
        return getFrente().getDato();
    }  //Método que muestra la información del nodo del final de la cola.   

    public String valorFinal() {
        return getFinal().getDato();
    } //Método para eliminar todos los nodos de la cola.     

    public void limpiarCola() {
        while (!colaVacia()) {
            quitar();
        }
    }
}
