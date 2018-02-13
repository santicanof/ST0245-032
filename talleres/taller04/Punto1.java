
/**
 * Write a description of class Punto1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto1
{
    public static int ArrayMax(int [] a) {
        return ArrayMax(a, a.length - 1);
        
    }
    private static int ArrayMax(int [] a, int n) {
        int max = 0; int temp = 0;
        max = a[n];
        if(n==0) {
            max = a[0];
        } else {
            temp = ArrayMax(a, n-1);
            if(temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
