
package tallervir;

public class Implementacion 
{
    private Profesores datosProfe[];
    private int numElementos;
    
    public Implementacion()
    {
        datosProfe = null;
        numElementos = 0;
    }
    
    public void crearVector()
    {
        datosProfe = new Profesores[numElementos];
    }
    
    public void setDatosProfe(int p, Profesores dato)
    {
        datosProfe[p] = dato;
    }
    
    public Profesores getDatosProfe(int p)
    {
        return datosProfe[p];
    }
    
    public void setNumElementos(int num)
    {
        numElementos = num;
    }
    
    public int getNumElementos()
    {
        return numElementos;
    }
    
    public void cambiar(int p1, int p2)
    {
        Profesores temp;
        temp = getDatosProfe(p1);
        setDatosProfe(p1, getDatosProfe(p2));
        setDatosProfe(p2, temp);
    }
    
    public void ordenarShell()
    {
        int n, cont;
        n = (getNumElementos()-1)/2;
        while (n != 0)
        {
            cont = 1;
            while (cont != 0)
            {
                cont = 0;
                for (int i = n; i < getNumElementos()-1; i++)
                {
                    if(getDatosProfe(i).getIdentificacion() == getDatosProfe(i).getIdentificacion())
                    {
                        cambiar(i, i-n);
                        cont = cont + 1;
                    }
                }
            }
            n = n/2;
        }
    }
    
    public int busquedaBinaria(long dato)
    {
        int posicion, izq, der, centro;
        ordenarShell();
        izq = 0;
        der = getNumElementos()-1;
        posicion = -1;
        while((izq <= der) && (posicion == -1))
        {
            centro = (izq + der)/2;
            if((getDatosProfe(centro).getIdentificacion()) == dato)
            {
                posicion = centro;
            }else
                {
                    if(dato < (getDatosProfe(centro).getIdentificacion()))
                    {
                        der = centro - 1; 
                    }else
                        {
                            izq = centro + 1;
                        }
                }
        }
        
        return posicion;
    }
    
        public int busquedaSecuencial(String dato)
    {
        int i;
        int posicion;
        posicion = -1;
        i = 0;
        while((i <= getNumElementos()-1) && (posicion == -1))
        {
            if(getDatosProfe(i).getNombrePro().equals(dato))
            {
                posicion = i;
            }else
                {
                    i = i +1;
                }
        }
        
        return posicion;
    }
        
    public int posicionMenor(int inicio)
    {
        int i;
        int posMenor;
        String menorElemento;
        posMenor = inicio;
        menorElemento = getDatosProfe(inicio).getNombrePro();
        for(i = inicio+1; i <= getNumElementos()-1; i++)
        {
            if(getDatosProfe(i).getNombrePro().compareTo(menorElemento) < 0 )
            {
                menorElemento = getDatosProfe(i).getNombrePro();
                posMenor = i;
            }
        }
            return posMenor;
    }
    
    public void ordenarSeleccion()
    {
        for(int i = 0; i <= getNumElementos()-1; i++)
        {
            cambiar(i, posicionMenor(i));
        }
    }

    public void ordenarBurbuja()
    {
        int i,j;
        for(i = 0; i <= (getNumElementos()-1); i++)
        {
            for(j = 0; j <= (getNumElementos()-i)-2; j++)
            {
                if(getDatosProfe(j).getNombreAsig().compareTo(getDatosProfe(j+1).getNombreAsig()) > 0)
                {
                    cambiar(j, j+1);
                }
            }
        }
    }
}   

