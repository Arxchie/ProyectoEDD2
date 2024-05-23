/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HP
 */
public class Validaciones
{
    public static boolean validaNaturales(KeyEvent evento, String texto, int longitud)
    {
        Pattern pattern = Pattern.compile("[1-9]([0-9])*");
        Matcher matcher = pattern.matcher(texto);
        if (!matcher.matches() || texto.length() > longitud)
        {
            if (evento != null)
            {
                evento.consume();
            }
            return false;
        }
        return true;
    }
    public static boolean validaAlfabeticos(KeyEvent evento, String texto, int longitud)
    {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(texto);
        if (!matcher.matches() || texto.length() > longitud)
        {
            if (evento != null)
            {
                evento.consume();
            }
            return false;
        }
        return true;
    }
    public static boolean validaNombreExtension(KeyEvent evento, String texto, int longitud)
    {
        Pattern pattern = Pattern.compile("\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(texto);
        if (!matcher.matches() || texto.length() > longitud)
        {
            if (evento != null)
            {
                evento.consume();
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(validaNombreExtension(null, "ssasw.txt", 20)); 
      

    }
}
