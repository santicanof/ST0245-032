
/**
 * Write a description of class Fibonacci here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SumaGrupo
{
    private static boolean sumaGrupo(int start, int []nums, int target){
        if(start > nums.length) {
            return target == 0;
        } else {
            return sumaGrupo(start + 1, nums, target - nums[start]) || sumaGrupo(start + 1, nums, target);
        }
    }
    public static boolean sumaGrupo(int [] nums, int target) {
        return sumaGrupo(0, nums, target);
    }
}

