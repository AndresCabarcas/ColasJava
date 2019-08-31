/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialprogramacionii;

import javax.swing.JOptionPane;

/**
 *
 * @author ANDACAMES
 */
public class Pedido {
    private String Nombre;
    private String Cant;
   public Pedido siguente;

    public Pedido() {
        this.Nombre = "";
        this.Cant = "";
        this.siguente = null;
    } 

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getId() {
        return Cant;
    }

    public void setId(String id) {
        this.Cant = id;
    }

    public Pedido getSiguente() {
        return siguente;
    }

    public void setSiguente(Pedido siguente) {
        this.siguente = siguente;
    }
     public void Registro(){
        setNombre(JOptionPane.showInputDialog(null,"Nombre De la Persona: "));
        setId(JOptionPane.showInputDialog(null,"Cantidad: "));
    }

    
}
