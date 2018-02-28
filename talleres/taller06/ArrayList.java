
/**
 * Write a description of class ArrayList here.
 * 
 * @author Agustin Rico y Santiago Cano
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class ArrayList {

    private int size;
    private int[] A;
    private int DEFAULT_SIZE=10;

    public ArrayList() {
        this.size = 0;
        this.A = new int[DEFAULT_SIZE];
    }

    public int size() {
        return size;
    }

    public int get(int n) {
        if(n>=size()){
            System.out.println("El array no tiene esa posición.");
            return -1;
        }else{
            return A[n];
        }
    }

    public void add(int n) {
        if (size() >= A.length) {
            this.A = Arrays.copyOf(this.A, this.A.length*2);
        } 
        for (int i = size() - 1; i >= 1; i--) {
            A[i] = A[i - 1];
        }
        A[0] = n;
        this.size++;
    }

}
