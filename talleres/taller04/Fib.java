
/**
 * Write a description of class Fib here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fib
{
    public static long fibonacci(int n) {
        if (n <= 1) { 
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    public static void tiempos() {
        for(int i = 30; i <= 40; i++) {
            long startTime = System.currentTimeMillis();
            fibonacci(i);
            long estimatedTime = System.currentTimeMillis() -
            startTime;
            System.out.println(i+" "+estimatedTime);            
        }
    }
}
