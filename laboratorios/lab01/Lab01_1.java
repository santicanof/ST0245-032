import java.util.Random;
/**
 * Write a description of class Lab01_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lab01_1
{
    public static int sumArray(int [] nums) {
        return sumArray(0, nums, 0);
    }

    private static int sumArray(int start, int [] nums, int sumArray) {
        if(start >= nums.length) {
            return sumArray;
        } else {
            return sumArray(start + 1, nums, sumArray + nums[start]);
        }
    }

    public static float sumArrayTest() {
        int size = 100000000;
        int max = 50;
        int[] array = new int[size];
        Random generator = new Random();
        for (int i =0; i<size; i++) {
            array[i] = generator.nextInt(max);
        }
        return sumArray(array);
    }   

    public static int arrayMax(int [] nums) {
        return arrayMax(0, nums, 0);
    }

    private static int arrayMax(int start, int [] nums, int max) {
        if(start >= nums.length) {
            return max;
        } else {
            int challenge = nums[start];
            if(challenge > max) {
                max = challenge;
            }
            return arrayMax(start + 1, nums, max); 
        }
    }

    public static int arrayMaxTest() {
        int size = 100000000;
        int max = 50;
        int[] array = new int[size];
        Random generator = new Random();
        for (int i =0; i<size; i++) {
            array[i] = generator.nextInt(max);
        }
        return arrayMax(array);
    }

    public static int Fib(int n) {
        if(n <= 1) {
            return n;
        } else {
            return Fib(n - 1) + Fib(n - 2);
        }
    }

    public static float Fib10() {
        return Fib(10);
    }

    public static float Fib20() {
        return Fib(20);
    }

    public static float Fib100() {
        return Fib(100);
    }

    public static float Fib1000() {
        return Fib(1000);
    }

}
