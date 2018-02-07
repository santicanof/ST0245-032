import java.io.*;
import java.util.*;


/**
 * Write a description of class Punto1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto1
{
    private static void t(int n, int origen, int intermedio, int destino) {
        if(n == 1) {
            System.out.println("Mover de " + origen + " a " + destino);
        } else {
            t(n-1, origen, destino, intermedio);
            t(1,origen, intermedio, destino);
            t(n-1, intermedio, origen, destino);
        }
    }
}
