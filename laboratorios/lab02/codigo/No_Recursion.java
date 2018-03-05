import java.util.Random;
/**
 * Write a description of class No_Recursion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class No_Recursion
{
    public static void main (String [] args) {
        System.out.println("ArraySum");
        testArraySum();

        System.out.println("ArrayMax");
        testArrayMax();

        System.out.println("Insetion Sort");
        testInsSort();

        System.out.println("Merge Sort");
        testMergeSort();
    }

    public static int arraySum(int [] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private static void testArraySum() {
        for (int size = 100000; size <= 100000000; size *= 10) {
            int max = 10000;
            int[] array = new int[size];
            Random generator = new Random();
            for (int i =0; i<size; i++) {
                array[i] = generator.nextInt(max);
            }
            long startTime = System.currentTimeMillis();
            arraySum(array);
            long estimatedTime = System.currentTimeMillis() -
                startTime;
            System.out.println(size + " " + estimatedTime);    
        }  
    } 

    public static int arrayMax(int [] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int challenge = nums[i];
            if(challenge > max) {
                max = challenge;
            }
        }
        return max;
    }

    private static void testArrayMax() {
        for (int size = 100000; size <= 100000000; size *= 10) {
            int max = 100;
            int[] array = new int[size];
            Random generator = new Random();
            for (int i =0; i<size; i++) {
                array[i] = generator.nextInt(max);
            }
            long startTime = System.currentTimeMillis();
            arrayMax(array);
            long estimatedTime = System.currentTimeMillis() -
                startTime;
            System.out.println(size + " " + estimatedTime);    
        }  
    } 

    public static int [] insSort(int [] A) {
        int temp,j;
        for (int i = 0; i < A.length; i++)
        {
            j = i;
            while (j > 0 && A[j-1] > A[j])
            {
                temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
                j = j-1;
            }           
        }
        return A;
    }

    private static void testInsSort() {
        for (int size = 100000; size <= 100000000; size *= 10) {
            int max = 100;
            int[] array = new int[size];
            Random generator = new Random();
            for (int i =0; i<size; i++) {
                array[i] = generator.nextInt(max);
            }
            long startTime = System.currentTimeMillis();
            insSort(array);
            long estimatedTime = System.currentTimeMillis() -
                startTime;
            System.out.println(size + " " + estimatedTime);    
        } 

    }

    // Sorts an array using Merge Sort
    // Taken from www.cs.cmu.edu/
    public static void mergeSort(int [ ] a)
    {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }

    private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right] )
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }

    private static void testMergeSort() {
        for (int size = 100000; size <= 100000000; size *= 10) {
            int max = 100;
            int[] array = new int[size];
            Random generator = new Random();
            for (int i =0; i<size; i++) {
                array[i] = generator.nextInt(max);
            }
            long startTime = System.currentTimeMillis();
            mergeSort(array);
            long estimatedTime = System.currentTimeMillis() -
                startTime;
            System.out.println(size + " " + estimatedTime);    
        } 
    }
}
