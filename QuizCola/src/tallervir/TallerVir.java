
package tallervir;

import javax.swing.JOptionPane;


public class TallerVir 
{

    public static void mostrarVector(Implementacion obj)
    {
        String datosVector = "";
        for(int i=0; i<=obj.getNumElementos()-1; i++)
        {
            datosVector = datosVector + String.valueOf("\n" + "NOMBRE: "
                    + obj.getDatosProfe(i).getNombrePro() + "\n" + "ID: " +
                    obj.getDatosProfe(i).getIdentificacion() + "\n" + "NUMERO TELEF: " +
                    obj.getDatosProfe(i).getNumTelf() + "\n" + "NOMBRE DE LA ASIGNATURA: " + 
                    obj.getDatosProfe(i).getNombreAsig() + "\n"
                    + "====================================");
        }
        
        JOptionPane.showMessageDialog(null, "============ ELEMENTOS DEL VECTOR============" 
                + "\n" + datosVector);
    }
    
    public static void mostrarVector2(Implementacion obj)
    {
        String datosVector = "";
        for(int i=0; i<=obj.getNumElementos()-1; i++)
        {
            datosVector = datosVector + String.valueOf("\n" + "NOMBRE: " +
                    obj.getDatosProfe(i).getNombrePro() + "\n" + "NUMERO TELEF: " + 
                    obj.getDatosProfe(i).getNumTelf() + "\n" + "====================================");
        }
        
        JOptionPane.showMessageDialog(null, "============ ELEMENTOS DEL VECTOR============" 
                + "\n" + datosVector);
    }

    public static void llenar(Profesores prof)
    {
        String nombrePro = JOptionPane.showInputDialog("Escriba el nombre del profesor: ");
        prof.setNombrePro(nombrePro);
        
        long ident = Long.parseLong(JOptionPane.showInputDialog("Digite la identificacion del profesor: "));
        prof.setIdentificacion(ident);
        
        long numTel = Long.parseLong(JOptionPane.showInputDialog("Digite el numero de telefono del profesor: "));
        prof.setNumTelf(numTel);
        
        String nombreAsi = JOptionPane.showInputDialog("Escriba el nombre de la asignatura que dicta el profesor: ");
        prof.setNombreAsig(nombreAsi);
    }
    
    public static int menu()
    {
        int opcion = 0;
        do
        {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("====== SELECCIONE UNA "
                    + "OPCION DEL 1 AL 5 ====== \n"
                    + "1. Buscar el nombre de la asignatura que imparte un docente en una determinada sede \n"
                    + "2. Buscar el número de celular de un docente \n"
                    + "3. Mostrar un listado con la información de los profesores \n"
                    + "4. Mostrar un listado ordenado alfabéticamente por el nombre de las asignaturas \n"
                    + "5. Salir \n \n"));
        }while(opcion <= 0 || opcion > 5);
        return opcion;
 }
    
    public static void main(String[] args) 
    {
        Implementacion obj = new Implementacion();
        Profesores prof;
        int numElemen = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el "
                + "numero de profesores que desea registrar: "));
        obj.setNumElementos(numElemen);
        obj.crearVector();
        
        for(int i = 0; i <= obj.getNumElementos()-1; i++ )
        {
            prof = new Profesores();
            JOptionPane.showMessageDialog(null, "============ ELEMENTOS DEL VECTOR============"+"\n \n" + 
                    "Ingresar la Información del profesor: #" + (i+1));
            llenar(prof);
            obj.setDatosProfe(i, prof);
        }
        
        mostrarVector(obj);
        
        long datoBuscar;
        String datoBuscar2;
        int posicionDato;
        int posicionDato2;
        int opcion;
        do
        {
            opcion = menu();
            switch(opcion)
            {
                case 1:
                    datoBuscar = Long.parseLong(JOptionPane.showInputDialog(null, "Digite la identificacion del profesor:"));
                    posicionDato = obj.busquedaBinaria(datoBuscar);
                    if(posicionDato != -1)
                    {
                    JOptionPane.showMessageDialog(null, "Nombre de la aisgnatura: " + obj.getDatosProfe(posicionDato).getNombreAsig() + "\n  Nombre del profesor: "+obj.getDatosProfe(posicionDato).getNombrePro());
                    }else
                        {
                            JOptionPane.showMessageDialog(null, "El profesor no se encuentra registrado");
                        }
                    break;
                    
                case 2:
                    datoBuscar2 = JOptionPane.showInputDialog(null, "Digite el nombre del profesor: ");
                    posicionDato2 = obj.busquedaSecuencial(datoBuscar2);
                    if(posicionDato2 != -1){
                        JOptionPane.showMessageDialog(null, "El numero de celular del docente " + obj.getDatosProfe(posicionDato2).getNombrePro() +" es " + obj.getDatosProfe(posicionDato2).getNumTelf());
                    }else{
                        JOptionPane.showMessageDialog(null, "El Elemento No se encuentra en elvector");
                    }
                        break;
                
                case 3:
                    obj.ordenarSeleccion();
                    mostrarVector2(obj);
                    break;
                    
                case 4:
                    obj.ordenarBurbuja();
                    mostrarVector(obj);
                    break;
            }
        }while(opcion != 5);
    }
    
}
