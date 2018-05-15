import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author usuario
 */
public class Prueba {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Quadtree qd = new Quadtree();
        System.out.println("Viejo " + qd.colisionesFuerzaBruta());
        System.out.println("Nuevo " + qd.numColisiones());

    }
}
