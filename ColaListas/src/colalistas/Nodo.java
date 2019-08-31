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
public class Nodo {

    private String dato;
    private Nodo siguiente;

    public void Nodo() {
        dato = "";
        siguiente = null;
    }

    public void setDato(String inf) {
        dato = inf;
    }

    public void setSiguiente(Nodo sig) {
        siguiente = sig;
    }

    public String getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
}
