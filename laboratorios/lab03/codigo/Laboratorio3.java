
/**
 * Write a description of class Punto1 here.
 * 
 * @author Agustin Rico & Santiago Cano 
 * @version (a version number or a date)
 */
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class Laboratorio3 {
    /**
     * Returns the product of the numbers in the list. 
     * @param list - List of integers.
     * @return An integer.
     */
    public static int multiply(List<Integer> list) {
        return multiply(list, 0);
    }

    private static int multiply(List <Integer> list, int n) {
        if(list.size() <= n) {
            return 1;
        }        
        return list.get(n) * multiply(list, n + 1);
    }

    /**
     * Tests the methods.
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7}));
        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Integer[] {2, 4, 6, 8}));

        // // // Multiply
        // System.out.println(multiply(linked));
        // System.out.println(multiply(array));

        //smartInsert
        smartInsert(linked, 9); 
        System.out.println(multiply(linked));

        smartInsert(array, 3);
        System.out.println(multiply(array));

        // //pivot
        // System.out.println(pivot(linked));
        // System.out.println(pivot(array));

        // //fridges
        // LinkedList <String> f = new LinkedList<>();
        // f.addAll(Arrays.asList(new String[] {"A","b", "c", "d","e","f","g"}));
        // fridges(f,linked);

    }

    /**
     * Dados una lista y un elemento, agrega el elemento a lista únicamente si no es una repitición de cualquiera de los elementos ya existentes de la lista
     * @param l El parámetro l es la lista existente
     * @param data El parámetro data es elemento que se quiere insertar
     * @return Retorna la lista final
     */
    public static void smartInsert(List l, int data) {
        for(int i = 0; i < l.size(); i++) {
            if((int)l.get(i) == data) {
                return;
            }
        }
        l.add(data);
    }    

    /**
     * Dada una lista de enteros, se escoge la posición del elemento, tal que, la suma de los elementos a su izquierda sea la más cercana a la suma de los elementos de su derecha
     * @param l La lista dada
     * @return Retorna el elemento tal que cumpla la suma de los elementos a su izquierda sea la más cercana a la suma de los elementos de su derecha
     */
    public static int pivot(List l) {

        int rigthSum = 0; int leftSum = (int)l.get(0);
        for(int i = 2; i < l.size(); i++) {
            rigthSum += (int)l.get(i);
        }
        int [] array = new int [l.size()];
        for(int i = 1; i < l.size() - 1; i++) {
            array[i] = Math.abs(leftSum - rigthSum);
            leftSum += (int)l.get(i);
            rigthSum -= (int)l.get(i + 1);
        }
        int bestPivotSum = array[1]; int bestPivot = 1;
        for(int i = 1; i < array.length - 1; i++) {
            int challenger = array[i];
            if(challenger < bestPivotSum) {
                bestPivotSum = challenger;
                bestPivot = i;
            }
        }
        return bestPivot;
    }

    /**
     * Dada una lista de compras y un almacen de neveras, imprime las neveras que se enviarán a sus correspondientes compradores, teniendo como prioridad el orden cronológico en el que se recibieron las compras
     * @param f La lista de neveras disponibles en el almacén
     * @param r La lista de los compradores
     */public static void fridges(List f, List r) {
        for(int i = 1; i < r.size(); i++) {            
            int fridgesRequested = (int)r.get(i - 1);
            for(int j = 0; j < fridgesRequested; j++) {
                if(f.size() > 0) {
                    System.out.println("Request #" + i + ": " + f.get(f.size() - 1));
                    f.remove(f.size() - 1);
                } else {
                    return;
                }
            }
        } 
    }
}
