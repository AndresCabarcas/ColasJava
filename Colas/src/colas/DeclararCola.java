/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

/**
 *
 * @author ANDACAMES
 */
public class DeclararCola {

    static final int N = 10; //Número máximo de elementos que se podrán almacenar en la cola. 
    private int frente; //Atributo para hacer referencia a la posición del primer elemento de la cola.    
    private int finalCola; //Atributo para hacer referencia a la posición del último elemento de la cola.
    //Vector que se usara como estructura auxiliar para guardar los elementos de la cola.    
    private String[] datosCola = new String[N]; //Se declara el método constructor de la clase.   

    public DeclararCola() {
        frente = 0;
        //Asignamos al frente la primera posición del arreglo.       
        finalCola = -1; //La cola está vacía al principio, cuando la posición del final es -1.   
    }

    public void crearVector() { //No se utiliza.   
        datosCola = new String[N];
    } //Se declara un método auxiliar para mover los elementos del vector de derecha a izquierda.
//El método será de uso interno en la clase (privado), este se llama cuando se quita el elemento del
//frente y se quieren correr los demás elementos de la cola hacia el frente de la misma.    

    private void desplazar() {
        for (int i = 1; i <= getFinal(); i++) {
//Cada elemento de la derecha (i) pasa a su izquierda inmediata(i-1).           
            datosCola[i - 1] = datosCola[i];
        }
    }
//Declaración del método que retorna la posición del frente de la cola.     

    public int getFrente() {
        return frente;
    } //Retornamos la posición del frente.    
    //Declaración del método que retorna la posición del final de la cola.     

    public int getFinal() {
        return finalCola;
    } //Retornamos la posición del final.    
    //Métodos para determinar los estados de la cola (vacía o llena), si la cola está llena retorna un  
//valor de true; de lo contrario retorna el valor false. De igual forma si la pila está vacía retorna el 
//valor true.    

    public boolean colaVacia() {
//Se debe tener en cuenta que final indica cuantos elementos actualmente tiene la cola. La cola
//está vacía si final es igual a -1.   
        if (getFinal() == -1) {
            return true;
        } else {
            return false;
        }
    } //La cola estará llena si el final es igual al número máximo de elementos que pueda soportar la
//estructura de datos que se está utilizando, en este caso el número máximo de elementos del  
//vector. 

    public boolean colaLLena() {
        if (getFinal() >= N - 1) {
            return true;
        } else {
            return false;
        }
    } //Declaración de los métodos para realizar las operaciones básicas sobre la cola (agregar y quitar).
//Implementación del método que permite agregar elementos al final de la cola, dato será el 
//parámetro que se agregar a la cola.     

    public void agregar(String dato) {
        if (!colaLLena()) { //Si la cola no está llena         
            finalCola = getFinal() + 1;  //Final apunta a una nueva posición en el vector para agregar el nuevo elemento.    
            datosCola[getFinal()] = dato; //Se agrega el elemento por el final de la cola.   
        }
    }  //Implementación del método que permite eliminar un elemento de la cola, desplazando hacia la izquierda 
//todos sus elementos y disminuyendo el final de la cola en uno.    

    public void quitar() {
        if (!colaVacia()) { //Si la cola no está vacía           
            desplazar(); //Se corren una posición a la izquierda, todos los elementos de la cola.      
            finalCola = getFinal() - 1;  //Se disminuye el valor de final en uno (se apunta a una posición anterior del vector).     
        }
    } //Declaración de los métodos para obtener los valores de los extremos de la cola (valor del frente y  //valor del final).
//Implementación del método que retorna el valor del elemento del frente de la cola.        

    public String valorFrente() {
        return datosCola[getFrente()];
    }

    public String valorFinal() {
        return datosCola[getFinal()];
    } //Método para eliminar todos los nodos de la cola.      

    public void limpiarCola() {
        while (!colaVacia()) { //Mientras que la cola no este vacía.  
            quitar(); //Se elimina el elemento del frente.       
        }
    }
}