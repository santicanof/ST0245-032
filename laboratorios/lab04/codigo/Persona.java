
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona
{
    String nombre;
    String genero;   
    Persona right;
    Persona left;

    Persona(String nombre, String genero) {
        if(genero.equals("f") == false && genero.equals("m") == false) {
            System.out.println("En 'genero' ingrese 'f' para femenino o 'm' para masculino");
            return;
        }
        this.nombre = nombre;
        this.genero = genero;
    }

    public void addFamiliar(String nombre, String g) {
        Persona temp = new Persona(nombre, g);
        if(temp.genero.equals("f") == true) {
            this.left = temp;
        } else {
            this.right = temp;
        }
    }

    //Punto 1.4
    public void abuelaMatera() {
        if(this.left == null || this.left.left == null) {
            System.out.println("No se conoce la abuela paterna de esta persona"); 
        } else {
            System.out.println("La abuela materna de " + this.nombre + " es " + this.left.left.nombre);
        }
    }
}
