import java.util.ArrayList;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
/**
 * Write a description of class Nodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nodo
{
    double xMax; double lonX;
    double yMax; double lonY;
    double xMin; double yMin;
    ArrayList <Abeja> a;
    Nodo [] n = new Nodo [4];
    Nodo(double x, double y, double lonX, double lonY, double x1, double y1) {
        this.xMax = x; this.lonX = lonX;
        this.yMax = y; this.lonY = lonY;
        this.xMin=x1; this.yMin=y1;
    }
    
    public double diagonal() {
        return sqrt(pow(this.lonX, 2) + pow(this.lonY, 2));
    }
    
}
