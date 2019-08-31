
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeerEscribirArchivo {

    private String ruta;
    File archivo;

    public LeerEscribirArchivo() {
        ruta = "";
    }

    LeerEscribirArchivo(String mitext1txt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setruta(String rut) {
        this.ruta = rut;
    }

    public String getruta() {
        return ruta;
    }

    public void guardarArchivo(Persona dato) throws IOException {

        archivo = new File(getruta());
        BufferedWriter escribir;

        if (archivo.exists()) {
            escribir = new BufferedWriter(new FileWriter(archivo, true));
            escribir.write(" INFORMACION DE LOS MEDICOS \t"
                    + "Nombre: " + dato.getNombre() + " / " + "Identificacion: " + dato.getId() + "\n");
            escribir.newLine();
        } else {
            escribir = new BufferedWriter(new FileWriter(archivo));
            escribir.write(" INFORMACION DE LOS MEDICOS \t"
                    + "Nombre: " + dato.getNombre() + " / " + "Identificacion: " + dato.getId() + "\n");
            escribir.newLine();
        }
        escribir.close();
    }
//Metodo para agregar la informacion desde el archivo de texto

    public void leerArchivo_Y_Guardar(Persona dato) {
        // crea el flujo para leer desde el archivo
        File file = new File(getruta());
        ColaPacientes listPaciente = new ColaPacientes();

        Scanner scanner;
        try {
            //se pasa el flujo al objeto scanner
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // el objeto scanner lee linea a linea desde el archivo
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                //se usa una expresión regular
                //que valida que antes o despues de una coma (,) exista cualquier cosa
                //parte la cadena recibida cada vez que encuentre una coma				
                delimitar.useDelimiter("\\s*,\\s*");
                Persona e = new Persona();
                e.setNombre(delimitar.next());
                e.setId(delimitar.next());
                listPaciente.Agregar(e); //agregamos la informacion
                //para que se quite el error cambia en el metodo agregar de la siguiete manera 
                //public void Agregar(persona e)
            }
            //se cierra el ojeto scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
