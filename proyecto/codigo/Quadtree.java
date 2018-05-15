import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


/**
 * Write a description of class Quadtree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quadtree {
    
    ArrayList<Abeja> repetidas = new ArrayList<>();
    Set<String> b = new TreeSet<>();
    Set<String> colision=new TreeSet<>();
    double xMapaLeft = -75.60;
    double xMapaRight = -75.50;
    double yMapaDown = 6.3;
    double yMapaUp = 6.37;
    int numAbejas = 1000;
    Nodo root = new Nodo(xMapaRight, yMapaUp, xMapaRight - xMapaLeft, yMapaUp - yMapaDown, xMapaLeft, yMapaDown);

    public Quadtree() throws FileNotFoundException, IOException {
        Scanner input = new Scanner(new File("ConjuntoDeDatosCon" + numAbejas + "abejas.txt"));
        ArrayList<Abeja> abejas = new ArrayList<>(numAbejas);
        int j=0;
        for (int i = 0; i < numAbejas; i++) { //Lee el archivo y agrega las abejas al ArrayList del nodo raiz
            String line = input.nextLine();
            Scanner scanLine = new Scanner(line);
            //scanLine.skip("-");
            scanLine.useDelimiter(",");
            String StringX = scanLine.next();
            //PosX = PosX.replace(".",",");
            double tempX = Double.parseDouble(StringX);
            String StringY = scanLine.next();
            double tempY = Double.parseDouble(StringY);
            Abeja temp = new Abeja(tempX, tempY);
            abejas.add(temp);
            b.add("" + temp.x + temp.y);
            j = j + 1;
            if (b.size() != j) {
                //Se repiten las coordenadas

                repetidas.add(temp);
                j = b.size();
            }
        }
        this.root.a = abejas;
        this.root.n = dividir(this.root);

    }

    public int numColisiones() {
        numColisiones(this.root.n, 0);
        
        String primero = "";
        int count = 0;
        for (int i = 0; i < repetidas.size(); i++) {    //colisiones.size()*repetidas.size()
            primero = "" + repetidas.get(i).x + repetidas.get(i).y;
            Iterator<String> it = this.colision.iterator();
            while (it.hasNext()) {
                String str = it.next();
                if (str.contains(primero)) {
                    count++;
                }

            }
        }
        
        return colision.size()+count-repetidas.size();
    }

    
    private void numColisiones(Nodo[] n, int nodos) {
        double min = 9.000009 * pow(10, -4);
        if (nodos > 3) {
            return;
        }
        if (n[nodos].a.size() < 2) {
            numColisiones(n, nodos + 1);
        }else if (n[nodos].a.size() == 2) {
            colisionesFB(n[nodos].a);
            numColisiones(n, nodos + 1);            
        } else if (n[nodos].diagonal() <= min) {
            colisionesFB(n[nodos].a);
            numColisiones(n, nodos + 1);
        } else {
            numColisiones(dividir(n[nodos]), 0);
            numColisiones(n, nodos + 1);
        }
    }

    
    public void colisionesFB(ArrayList<Abeja> a) {
        double min = 9.000009 * pow(10, -4);
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                double distancia = a.get(i).calcular(this.root.a.get(j));
                if (distancia <= min) {
                    colision.add(""+a.get(i).x+a.get(i).y+ " "+ a.get(j).x+a.get(j).y);
                }
            }
        }
    }
    double min = 9.000009 * pow(10, -4);
    
    public int colisionesFuerzaBruta() {
        int colisiones = 0;
        
        for (int i = 0; i < numAbejas; i++) {
            for (int j = i + 1; j < numAbejas; j++) {
                double distancia = this.root.a.get(i).calcular(this.root.a.get(j));
                if (distancia <= min) {
                    colisiones++;
                }
            }
        }
        return colisiones;
    }

    

    
    public Nodo[] dividir(Nodo nodo) {
        double min = 9.000009 * pow(10, -4);
        double mitadX = nodo.xMax / 2.0;
        double mitadY = nodo.yMax / 2.0;

        ArrayList<Abeja> a1 = new ArrayList<>();
        ArrayList<Abeja> a2 = new ArrayList<>();
        ArrayList<Abeja> a3 = new ArrayList<>();
        ArrayList<Abeja> a4 = new ArrayList<>();

        for (int i = 0; i < nodo.a.size(); i++) { //Complejidad nodo.a.size()
            if (nodo.a.get(i).x >= mitadX) {
                if (nodo.a.get(i).y >= mitadY) {
                    a2.add(nodo.a.get(i));
                    if(sqrt(pow(nodo.a.get(i).x-mitadX,2))<=min){
                        a1.add(nodo.a.get(i));
                    }
                    if(sqrt(pow(nodo.a.get(i).y-mitadY,2))<=min){
                        a3.add(nodo.a.get(i));
                    }
                } else {
                    a4.add(nodo.a.get(i));
                    if(sqrt(pow(nodo.a.get(i).x-mitadX,2))<=min){
                        a3.add(nodo.a.get(i));
                    }
                    if(sqrt(pow(nodo.a.get(i).y-mitadY,2))<=min){
                        a2.add(nodo.a.get(i));
                    }
                }
            } else {
                if (nodo.a.get(i).y >= mitadY) {
                    a1.add(nodo.a.get(i));
                    if(sqrt(pow(nodo.a.get(i).x-mitadX,2))<=min){
                        a2.add(nodo.a.get(i));
                    }
                    if(sqrt(pow(nodo.a.get(i).y-mitadY,2))<=min){
                        a3.add(nodo.a.get(i));
                    }
                } else {
                    a3.add(nodo.a.get(i));
                    if(sqrt(pow(nodo.a.get(i).x-mitadX,2))<=min){
                        a4.add(nodo.a.get(i));
                    }
                    if(sqrt(pow(nodo.a.get(i).y-mitadY,2))<=min){
                        a1.add(nodo.a.get(i));
                    }
                }
            }
        }

        Nodo n1 = new Nodo(mitadX, nodo.yMax, nodo.lonX / 2, nodo.lonY / 2, nodo.xMin, mitadY);
        n1.a = a1;
        Nodo n2 = new Nodo(nodo.xMax, nodo.yMax, nodo.lonX / 2, nodo.lonY / 2, mitadX, mitadY);
        n2.a = a2;
        Nodo n3 = new Nodo(mitadX, mitadY, nodo.lonX / 2, nodo.lonY / 2, nodo.xMin, nodo.yMin);
        n3.a = a3;
        Nodo n4 = new Nodo(nodo.xMax, mitadY, nodo.lonX / 2, nodo.lonY / 2, mitadX, nodo.yMin);
        n4.a = a4;

        nodo.n[0] = n1;
        nodo.n[1] = n2;
        nodo.n[2] = n3;
        nodo.n[3] = n4;
        return nodo.n;
    }

}

