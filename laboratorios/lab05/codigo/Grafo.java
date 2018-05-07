/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

/**
 *
 * @author usuario
 */
import java.util.Scanner;

public class Grafo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner consola = new Scanner(System.in);
        DigraphAL grafos;
        int i = 0;
        boolean esNodo = true;
        int numero = -1;
        numero= consola.nextInt();
        grafos= new DigraphAL(numero);
        numero= consola.nextInt();
        int x=0;
        int y=0;
        while(numero>0){
            x=consola.nextInt();
            y=consola.nextInt();
            grafos.addArc(x, y, 0);
            grafos.addArc(y, x, 0);
            numero--;
        }
        
    }

   

}
