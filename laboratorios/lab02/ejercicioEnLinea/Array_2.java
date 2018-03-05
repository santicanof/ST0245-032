
/**
 * Write a description of class Array_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Array_2
{
    public boolean lucky13(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1 || nums[i] == 3) {
                return false;
            }
        }
        return true;
    }

    public boolean sum28(int[] nums) {
        int sum8 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 2) {
                sum8 += nums[i];
            }
        }
        if(sum8 == 8) {
            return true;
        }
        return false;
    }

    public boolean more14(int[] nums) {
        int count1 = 0; int count4 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                count1++;
            } else if(nums[i] == 4) {
                count4++;
            }
        }
        if(count1 > count4) {
            return true;
        }
        return false;
    }

    public int[] fizzArray(int n) {
        int [] nums = new int [n];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        return nums;
    }

    public boolean only14(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 4 && nums[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
