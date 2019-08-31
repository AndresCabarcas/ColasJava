/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colalistas;

import javax.swing.JOptionPane;

/**
 *
 * @author ANDACAMES
 */
public class Main {

    //Método para asignar un menú de opciones de la aplicación.  
    public static int menu() {
        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("===== IMPLEMENTACIÓN DE COLAS - OPCIÓN DEL MENÚ ===== \n\n"
                    + "1. Agregar Datos a la Cola \n"
                    + "2. Eliminar Datos de la Cola \n"
                    + "3. Mostrar Datos de la Cola \n"
                    + "4. Vaciar la Cola \n"
                    + "5. Salir"
                    + "\n \n Seleccione una opción del 1 al 5"));

        } while (opcion <= 0 || opcion > 5);
        return opcion;

    }
//Método para mostrar los datos de la cola.  

    public static void mostrarCola(DeclararCola cola) {
//Así se mueven los elementos de la cola, se quita el elemento del frente y se agrega por el final.   
        DeclararCola temp = new DeclararCola();
//Se crea un nuevo objeto de la clase cola.     
        String verDatosCola = "";
//variable tipo cadena vacía para almacenar los datos.  
        while (!cola.colaVacia()) {
//Mientras la cola no este vacía se muestran sus datos.  
            verDatosCola = verDatosCola + String.valueOf("---- " + cola.valorFrente() + "\n");
            temp.agregar(cola.valorFrente());
//Se agrega el elemento del frente a una cola temporal.     
            cola.quitar();
//Luego se quita el elemento del frente de la cola actual.   
        }
        JOptionPane.showMessageDialog(null, "========= ELEMENTOS DE LA DE COLA ==========" + "\n" + verDatosCola + "\n");
        while (!temp.colaVacia()) {
//Se pasan los datos a la cola temporal a la original.    
            cola.agregar(temp.valorFrente());
            temp.quitar();
        }
    }

    public static void main(String[] args) {
        DeclararCola cola = new DeclararCola();

        String dato;
        int opcion;

        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                    dato = JOptionPane.showInputDialog(null, "Digite el dato que quiere agregar a la Cola:");

                    if (!cola.colaLLena()) { //Se agrega siempre que la cola no esté llena.     
                        cola.agregar(dato);
//Se agrega a la cola el dato por el final.      
                        JOptionPane.showMessageDialog(null, "============ IMPLEMENTACIÓN DE COLAS ============" + "\n\n"
                                + "--- Dato agregado: " + cola.valorFinal());
                        mostrarCola(cola);
                    } else {
                        JOptionPane.showMessageDialog(null, "============ IMPLEMENTACIÓN DE COLAS ============" + "\n\n"
                                + "La cola está llena, No puede agregar más elementos \n\n");
                    }
                    break;
                case 2:
//Para poder eliminar el dato del frente, la cola esta no debe estar vacía.      
                    if (!cola.colaVacia()) {
                        String elemento = cola.valorFrente();
                        cola.quitar();
                        JOptionPane.showMessageDialog(null, "============ IMPLEMENTACIÓN DE COLAS ============" + "\n\n"
                                + "--- Se eliminó el elemento: " + elemento + " de la cola");
                        mostrarCola(cola);
                    } else {
                        JOptionPane.showMessageDialog(null, "============ IMPLEMENTACIÓN DE COLAS ============" + "\n\n"
                                + "La cola está vacía, No pueden quitar datos \n\n");
                    }

                    break;
                case 3:
                    mostrarCola(cola);

                    break;
                case 4:
                    cola.limpiarCola();

                    JOptionPane.showMessageDialog(
                            null, "============ IMPLEMENTACIÓN DE COLAS ============" + "\n\n"
                            + "La cola está vacía, No pueden quitar datos \n\n");
                    mostrarCola(cola);
                    break;

                case 5:
                    break;
            }

        } while (opcion!= 5);
    }
}
