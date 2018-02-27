
/**
 * Write a description of class ArrayList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayList
{
    private int size;
    private int [] A;
    private int DEFAULT_SIZE;
    public ArrayList() {
        this.size = 0;
        this.A = new int[DEFAULT_SIZE];
    }
    public int size() {
        return size;
    }
    public int get(int n) {
        return A[n];
    }
    public void add(int n) {
        /**
        *Hay que poner el elemento n en la primera posición, la solución consiste en mover todos los elementos a la derecha.
        *Hay dos casos, cuando el arreglo tiene espacios vacíos, y cuando está lleno. Cuando tiene espacios vacíos simplemente se mueve todo a la derecha y 
        *en la posición 0 se pone n.
        *Cuando está lleno, hay que crear uno nuevo con el doble de length del primero y hacerle lo del caso cuando no está lleno.
        */
    }
}
