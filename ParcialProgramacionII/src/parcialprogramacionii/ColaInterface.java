/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialprogramacionii;

/**
 *
 * @author ANDACAMES
 */
public interface ColaInterface {
    
    public int getTotalNodos();// equivalente a tam()
    public boolean colaVacia();//equivalente a esVacia()  
    public Pedido getFrente();//equivalente a frente()
    public void Agregar(Pedido e);//equivalente a encolar(object info)
    public void Atender();//equivalente a desencolar()
}
