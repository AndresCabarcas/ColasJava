/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thospital;

import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDACAMES
 */
public class ListaMedicos extends Archivo {

    private Persona cabeza;

    public ListaMedicos() {
        cabeza = null;
    }

    public void setcabeza(Persona cab) {
        this.cabeza = cab;
    }

    public Persona getcabeza() {
        return cabeza;
    }

    public Persona ultimo() {

        Persona temp = cabeza;

        while (temp != null) {
            if (temp.getSiguente() == null) {
                break;
            } else {
                temp = temp.getSiguente();
            }
        }

        return temp;
    }

    public void agregarMedico(Persona nuevo, String ruta) throws IOException {
        setruta(ruta);
        if (cabeza == null) {
            cabeza = nuevo;
            guardarArchivo(nuevo);
        } else {
            ultimo().setSiguente(nuevo);
            guardarArchivo(nuevo);
        }
        JOptionPane.showMessageDialog(null, "---Se ha añadido un medico con exito---");

    }

    public int contarNodos() {

        int cont = 0;
        Persona temp = cabeza;
        while (temp != null) {
            cont++;
            temp = temp.getSiguente();
        }
        return cont;
    }

    public void VerMedicos() {
        Persona temp = getcabeza();
        String m = "";
        if (temp != null) {
            while (temp != null) {
                m = m + String.valueOf(" " + temp.getNombre() + "," + temp.getId() + "\n\n");
                temp = temp.getSiguente();
            }
            JOptionPane.showMessageDialog(null, "----------------LISTA DE ESPERA--------------\n\n" + m);
        } else {
            JOptionPane.showMessageDialog(null, "--No se han registrado medicos--");
        }

    }

    public void leer() {

        try {
            FileReader entrada = new FileReader(getruta());
            int c = entrada.read();

            while (c != -1) {
                c = entrada.read();
                char letra = (char) c;
                System.out.print(letra);

            }
        } catch (IOException e) {
            //Logger.getLogger(DeclararColaHospital.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se encontro el archivo");
        }

    }

}
