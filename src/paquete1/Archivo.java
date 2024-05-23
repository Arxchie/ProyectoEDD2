
package paquete1;

/**
 *
 * @author HP
 */
public class Archivo
{
    private String nomre;
    private String extension;
    private String fecha;
    private String autor;
    private char tipo;
    private int tamanio;
    private String ruta;

    /**
     * 
     * @param nomre nombre del archivo
     * @param extension extension 
     * @param fecha fecha 
     * @param autor
     * @param tipo
     * @param tamanio
     * @param ruta 
     */
    public Archivo(String nomre, String extension, String fecha, String autor, char tipo, int tamanio, String ruta)
    {
        this.nomre = nomre;
        this.extension = extension;
        this.fecha = fecha;
        this.autor = autor;
        this.tipo = tipo;
        this.tamanio = tamanio;
        this.ruta = ruta;
    }

    /**
     * @return the nomre
     */
    public String getNomre()
    {
        return nomre;
    }

    /**
     * @return the extension
     */
    public String getExtension()
    {
        return extension;
    }

    /**
     * @return the fecha
     */
    public String getFecha()
    {
        return fecha;
    }

    /**
     * @return the autor
     */
    public String getAutor()
    {
        return autor;
    }

    /**
     * @return the tipo
     */
    public char getTipo()
    {
        return tipo;
    }

    /**
     * @return the tamanio
     */
    public int getTamanio()
    {
        return tamanio;
    }

    /**
     * @return the ruta
     */
    public String getRuta()
    {
        return ruta;
    }

    /**
     * @param nomre the nomre to set
     */
    public void setNomre(String nomre)
    {
        this.nomre = nomre;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(char tipo)
    {
        this.tipo = tipo;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(int tamanio)
    {
        this.tamanio = tamanio;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta)
    {
        this.ruta = ruta;
    }

    @Override
    public String toString()
    {
        return "Archivo{" + "nomre=" + nomre + ", extension=" + extension + ", fecha=" + fecha + ", autor=" + autor + ", tipo=" + tipo + ", tamanio=" + tamanio + ", ruta=" + ruta + '}';
    }
    
    
    
    
}
