
/**
 * Write a description of class A here.
 * 
 * @author scanof&ARico10 
 */
public class Punto1
{
    public static int Eucl(int p, int q) {
        if(p%q == 0) {
            return q;
        } else {
            return Eucl(q, p%q);
        }
    }
}
