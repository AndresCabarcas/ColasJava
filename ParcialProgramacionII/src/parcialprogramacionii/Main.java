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
public class Main {
    public static int MenuAtencion() {

        int opc = 0;
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "---------Restaurante Bienvenido---------\n\n"
                    + "1. Agregar cliente a la cola(encolar) \n"
                    + "2. Atender Cliente(desencolar) \n"
                    + "3. Cliente en Primer lugar de la fila. \n"
                    + "4. Retiro del primer cliente \n"
                    + "5. Numero de Clientes. \n \n" 
                    + "6. Consultar extructura(si esta vacia o no) \n"
                    + "7. Salir. \n \n" + "           "
                    + "Seleccione una opción del 1 al 7     "));

        } while (opc <= 0 && opc > 7);
        return opc;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ColaClientes obj = new ColaClientes();
        Pedido nd = null;
        int opc;
        do {
            opc = MenuAtencion();
            switch (opc) {
                case 1:
                    if (!obj.colaLLena()) {
                        obj.Agregar(nd);//agrega el nodo en tiempo de ejecucion
                    } else {
                        JOptionPane.showMessageDialog(null, " Lo sentimos no mesas disponibles.\n"
                                + "Por favor Espere a que un cliente salga");
                    }
                    break;
                case 2:
                    obj.VerFila();
                    obj.Atender();
                    obj.VerFila();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Primer cliente en la Cola. \n\n"
                            + "Nombre  " + obj.getFrente().getNombre() + "\n" + "Cantidad: " + obj.getFrente().getId() + "\n");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Cliente que abandono la Cola. \n\n"
                            + "Nombre:  " + obj.getFrente().getNombre() + "\n" + "Cantidad: " + obj.getFrente().getId() + "\n");
                    obj.quitar();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "La cantidad de Clientes es: "+obj.getTotalNodos());
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
                    JOptionPane.showMessageDialog(null, "Gracias, que tenga un buen dia, vuelva pronto");
                    break;
            }
        } while (opc != 7);
    }
}
