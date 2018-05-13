import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.Math.abs;
/**
 * Write a description of class Abeja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Abeja
{
    double x;
    double y;
    Abeja(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double calcular(Abeja abeja) {
        double x = abs(this.x - abeja.x);
        double y = abs(this.y - abeja.y);
        double dist = sqrt(pow(x, 2) + pow(y, 2));
        return dist;
    }
}
