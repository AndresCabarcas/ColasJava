
package tallervir;

public class Profesores 
{
    private String nombrePro;
    private long identificacion;
    private String nombreAsig;
    private long numTelf;
    
    public Profesores()
    {
        nombrePro = "";
        identificacion = 0;
        nombreAsig = "";
        numTelf = 0;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombreAsig(String nombreAsig) {
        this.nombreAsig = nombreAsig;
    }

    public void setNumTelf(long numTelf) {
        this.numTelf = numTelf;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public String getNombreAsig() {
        return nombreAsig;
    }

    public long getNumTelf() {
        return numTelf;
    }
    
    
}
