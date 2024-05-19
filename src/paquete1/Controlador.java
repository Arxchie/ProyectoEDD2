
package paquete1;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author HP
 */
public class Controlador
{
    public static void altaArchivo(String nombreExtension, char tipo,String ruta)
    {
        
    }
    
    public static void main(String[] args)
    {
        // Obtener el nombre de usuario de la computadora
        String nombreUsuario = System.getProperty("user.name");
        // Obtener la fecha actual
        LocalDate fecha = LocalDate.now();
        // Formatear la fecha en un formato legible (por ejemplo, "dd-MM-yyyy")
        String fechaString = fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        // Mostrar los resultados
        System.out.println("Nombre de usuario: " + nombreUsuario);
        System.out.println("Fecha actual: " + fechaString);
    }
    
    
}
