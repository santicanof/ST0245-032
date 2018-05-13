import java.util.ArrayList;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.abs;
/**
 * Write a description of class Nodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nodo
{
    double xMax; 
    double lonX;
    double yMax; 
    double lonY;
    
    ArrayList <Abeja> hor = new ArrayList<>();
    ArrayList <Abeja> ver = new ArrayList<>();

    ArrayList <Abeja> a;
    Nodo [] n = new Nodo [4];

    Nodo(double x, double y, double lonX, double lonY) {
        this.xMax = x; this.lonX = lonX;
        this.yMax = y; this.lonY = lonY;
    }

    public double diagonal() {
        return sqrt(pow(this.lonX, 2) + pow(this.lonY, 2));
    }

    public Nodo [] dividir() {
        double mitadX = this.xMax - (this.lonX/2.0);
        double mitadY = this.yMax - (this.lonY/2.0);

        ArrayList <Abeja> a1 = new ArrayList<>();
        ArrayList <Abeja> a2 = new ArrayList<>();
        ArrayList <Abeja> a3 = new ArrayList<>();
        ArrayList <Abeja> a4 = new ArrayList<>();

        Nodo n1 = new Nodo(mitadX, this.yMax, this.lonX/2, this.lonY/2); 
        Nodo n2 = new Nodo(this.xMax, this.yMax, this.lonX/2, this.lonY/2); 
        Nodo n3 = new Nodo(mitadX, mitadY, this.lonX/2, this.lonY/2); 
        Nodo n4 = new Nodo(this.xMax, mitadY, this.lonX/2, this.lonY/2); 

        double min = 9.000009 * pow(10, -4);
        for(int i = 0; i < this.a.size(); i++) {
            Abeja temp = new Abeja(a.get(i).x, a.get(i).y);
            if((abs(temp.x - mitadX) <= min) || (abs(temp.x - this.xMax) <= min) || abs(temp.x + 75.60) <= min) {
                this.ver.add(temp);
            } else  if((abs(temp.y - mitadY) <= min) || (abs(temp.y - mitadY) <= min) || abs(temp.y - 6.3) <= min) {
                this.hor.add(temp);
            }
                
            if(temp.x >= mitadX) {
                if(temp.y >= mitadY) {
                    a2.add(temp);
                } else {
                    a4.add(temp);
                }
            } else {
                if(temp.y >= mitadY) {
                    a1.add(temp);
                } else {
                    a3.add(temp);
                }
            }
        }

        n1.a = a1;
        n2.a = a2;
        n3.a = a3;
        n4.a = a4;

        this.n[0] = n1; this.n[1] = n2; this.n[2] = n3; this.n[3] = n4;
        return this.n;
    }
}
