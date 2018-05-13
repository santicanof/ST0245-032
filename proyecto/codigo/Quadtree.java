import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.pow;
/**
 * Write a description of class Quadtree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Quadtree
{
    double xMapaLeft = -75.60;
    double xMapaRight = -75.50;
    double yMapaDown = 6.3;
    double yMapaUp = 6.37;
    int numAbejas = 100;
    int MaxDivisiones = 68; //Cuantas veces se puede subdividir el espacio para que la diagonal de los rectangulos mas pequeños sea 100 
    Nodo root = new Nodo(xMapaRight, yMapaUp, xMapaRight - xMapaLeft, yMapaUp - yMapaDown);
    public Quadtree() throws FileNotFoundException {
        Scanner input = new Scanner(new File("ConjuntoDeDatosCon" + numAbejas + "abejas.txt"));
        ArrayList <Abeja> abejas = new ArrayList<>(numAbejas);
        for(int i = 0; i < numAbejas; i++) { //Lee el archivo y agrega las abejas al ArrayList del nodo raiz
            String line = input.nextLine();
            Scanner scanLine = new Scanner(line);
            //scanLine.skip("-");
            scanLine.useDelimiter(",");
            String StringX = scanLine.next();
            //PosX = PosX.replace(".",",");
            double tempX = Double.parseDouble(StringX);
            String StringY = scanLine.next();
            double tempY = Double.parseDouble(StringY);
            Abeja temp = new Abeja(tempX,tempY);
            abejas.add(temp);
        }
        this.root.a = abejas;

        double mitadMapaX = xMapaRight - ((xMapaRight - xMapaLeft)/2);
        double mitadMapaY = yMapaUp - ((yMapaUp - yMapaDown)/2);

        ArrayList <Abeja> a1 = new ArrayList<>();
        ArrayList <Abeja> a2 = new ArrayList<>();
        ArrayList <Abeja> a3 = new ArrayList<>();
        ArrayList <Abeja> a4 = new ArrayList<>();

        for(int i = 0; i < abejas.size(); i++) {
            if(abejas.get(i).x > mitadMapaX) {
                if(abejas.get(i).y > mitadMapaY) {
                    a2.add(abejas.get(i));
                } else {
                    a4.add(abejas.get(i));
                }
            } else {
                if(abejas.get(i).y > mitadMapaY) {
                    a1.add(abejas.get(i));
                } else {
                    a3.add(abejas.get(i));
                }
            }
        }

        Nodo n1 = new Nodo(mitadMapaX,yMapaUp,root.lonX/2, root.lonY/2);
        Nodo n2 = new Nodo(xMapaRight, yMapaUp,root.lonX/2, root.lonY/2);
        Nodo n3 = new Nodo(mitadMapaX, mitadMapaY,root.lonX/2, root.lonY/2);
        Nodo n4 = new Nodo(xMapaRight, mitadMapaY,root.lonX/2, root.lonY/2);

        root.n[0] = n1; root.n[0].a = a1;
        root.n[1] = n2; root.n[1].a = a2;
        root.n[2] = n3; root.n[2].a = a3;
        root.n[3] = n4; root.n[3].a = a4;
    }

    public static double t() {
        return 8.982708287 * pow(10, -4);
    }

    public int numColisiones() {
        return numColisiones(this.root.n, 0, 0);
    }

    private int numColisiones(Nodo [] n, int colisiones, int maxD) {
        
    }

    public int colisiones() {
        int colisiones = 0;
        double min = 8.982708287 * pow(10, -4);;
        for(int i = 0; i < numAbejas; i++) {
            for(int j = i + 1; j < numAbejas; j++) {
                double distancia = this.root.a.get(i).calcular(this.root.a.get(j));
                if(distancia <= min) {
                    colisiones++;
                }
            }
        }
        return colisiones;
    }

    public Nodo [] dividir(Nodo nodo) {
        double mitadX = nodo.xMax/2.0;
        double mitadY = nodo.yMax/2.0;

        ArrayList <Abeja> a1 = new ArrayList<>();
        ArrayList <Abeja> a2 = new ArrayList<>();
        ArrayList <Abeja> a3 = new ArrayList<>();
        ArrayList <Abeja> a4 = new ArrayList<>();

        for(int i = 0; i < nodo.a.size(); i++) {
            if(nodo.a.get(i).x >= mitadX) {
                if(nodo.a.get(i).y >= mitadY) {
                    a2.add(nodo.a.get(i));
                } else {
                    a4.add(nodo.a.get(i));
                }
            } else {
                if(nodo.a.get(i).y >= mitadY) {
                    a1.add(nodo.a.get(i));
                } else {
                    a3.add(nodo.a.get(i));
                }
            }
        }

        Nodo n1 = new Nodo(mitadX, nodo.yMax, nodo.lonX/2, nodo.lonY/2); n1.a = a1;
        Nodo n2 = new Nodo(nodo.xMax, nodo.yMax, nodo.lonX/2, nodo.lonY/2); n2.a = a2;
        Nodo n3 = new Nodo(mitadX, mitadY, nodo.lonX/2, nodo.lonY/2); n3.a = a3;
        Nodo n4 = new Nodo(nodo.xMax, mitadY, nodo.lonX/2, nodo.lonY/2); n4.a = a4;

        nodo.n[0] = n1; nodo.n[1] = n2; nodo.n[2] = n3; nodo.n[3] = n4;
        return nodo.n;
    }

    public static double factorial(int n) {
        double [] arr = new double [n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] * i;
        }
        return arr[n];
    }

    public static double combinatoria(int n) {
        return factorial(n)/(factorial(2) * factorial(n - 2));
    }
}
