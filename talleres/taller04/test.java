import java.util.Random;

/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test
{
    public static void main(String [] args) {
        int size = 1000;
        int max = 5000;
        int[] array = new int[size];
        Random generator = new Random();
        for (int i =0; i<size; i++) {
            array[i] = generator.nextInt(max);
        }
    }        
    }

