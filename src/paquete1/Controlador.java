package paquete1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Controlador
{

    static Nodo<Archivo> nodoActual;
    static ArrayList<String> rutaActual = new ArrayList<>();
    static Multilista m = new Multilista();

    public static Archivo creaArchivo(String nombreExtension, char tipo, String ruta)
    {
        String arr[] = new String[2];//arreglo para guardar [0]= nombre [1]=extension
        if (tipo == 'A')
        {
            arr = separa(nombreExtension);
            // Obtener el nombre de usuario de la computadora
        } else
        {
            arr[0] = nombreExtension;
            arr[1] = "";
        }
        String nombreUsuario = System.getProperty("user.name");
        // Obtener la fecha actual
        LocalDate fecha = LocalDate.now();
        // Formatear la fecha en un formato legible (por ejemplo, "dd-MM-yyyy")
        String fechaString = fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Archivo nvoArchivo = new Archivo(arr[0], arr[1], fechaString, nombreUsuario, tipo, 0, ruta + "\\" + arr[0]);
        return nvoArchivo;
    }

    public static Nodo creaNodoArchivo(Archivo nvo)
    {
        if (nvo != null)
        {
            Nodo<Archivo> nvoNodo = new Nodo(nvo.getNomre(), nvo);
            return nvoNodo;
        } else
        {
            return null;
        }
    }

    public static void altaArchivo(Nodo<Archivo> nodo)
    {

        String[] array = new String[rutaActual.size()+1];
        array = rutaActual.toArray(array);
        m.inserta(nodo, array);
        array = null;

    }

    public static void recorre(Nodo<Archivo> r, String ruta[], int entrar)
    {
        if (entrar == 1)
        {
            r.getAbajo();
        }
    }

    public static String[] separa(String texto)
    {
        String separados[] = new String[2];
        for (int i = 0; i < texto.length(); i++)
        {
            if (texto.charAt(i) == '.')
            {
                separados[0] = texto.substring(0, i);
                separados[1] = texto.substring(i + 1, texto.length());
                break;
            }
        }
        return separados;
    }

    public static String concatena(String nombre, String extension)
    {
        return nombre + "." + extension;
    }

    public static String rutaAString()
    {
        String ruta = "";
        for (int i = 0; i < rutaActual.size(); i++)
        {
            ruta += rutaActual.get(i);
            if (i != rutaActual.size() - 1)
            {
                ruta += "\\";
            }
        }
        return ruta;
    }

    public static void main(String[] args)
    {

        altaArchivo(creaNodoArchivo(creaArchivo("documentos", 'C', rutaAString())));
        rutaActual.add("documentos");
        Archivo nvo=creaArchivo("archivo1.pdf", 'A', rutaAString());
        altaArchivo(creaNodoArchivo(nvo));
        System.out.println(nvo.toString());

        m.desp2();

    }

}
