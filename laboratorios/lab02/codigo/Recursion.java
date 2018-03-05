import java.util.Random;
/**
 * Write a description of class RFib here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recursion
{
    public static void main(String[] args) {
        System.out.println("ArraySum Recursivo");
        testRArraySum();
        
        System.out.println("ArrayMax Recursivo");
        testRArrayMax();
        
        System.out.println("Fibonacci Recursivo");
        testRFib();
    }

    public static int RFib(int n) {
        if(n <= 1) {
            return n;
        } else {
            return RFib(n - 1) + RFib(n - 2);
        }     
    }
    private static void testRFib() {
        for(int size = 25; size <= 40; size += 5) {
            long startTime = System.currentTimeMillis();
            RFib(size);
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println(size + " " + estimatedTime); 
        }
    }

    public static int rArrayMax(int [] a) {
        return rArrayMax(a, a.length - 1);
    }

    private static int rArrayMax(int [] a, int n) {
        int max = 0; int temp = 0;
        max = a[n];
        if(n==0) {
            max = a[0];
        } else {
            temp = rArrayMax(a, n-1);
            if(temp > max) {
                max = temp;
            }
        }
        return max;
    }
    
    private static void testRArrayMax() {
        for (int size = 100000; size <= 100000000; size *= 10) {
            int max = 100;
            int[] array = new int[size];
            Random generator = new Random();
            for (int i =0; i < size; i++) {
                array[i] = generator.nextInt(max);
            }
            long startTime = System.currentTimeMillis();
            rArrayMax(array);
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println(size + " " + estimatedTime);    
        }  
    }
        

    public static int rArraySum(int [] nums) {
        return rArraySum(0,nums,0);
    }

    private static int rArraySum(int start, int [] nums, int n) {
        if(start >= nums.length) {
            return n;
        } else {
            return rArraySum(start + 1, nums, n + nums[start]);
        }        
    }    

    public static void testRArraySum() {
        for (int size = 100000; size <= 100000000; size *= 10) {
            int max = 100;
            int[] array = new int[size];
            Random generator = new Random();
            for (int i =0; i < size; i++) {
                array[i] = generator.nextInt(max);
            }
            long startTime = System.currentTimeMillis();
            rArraySum(array);
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println(size + " " + estimatedTime);    
        }  
    } 
}

