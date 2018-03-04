
/**
 * Write a description of class Array_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Array_3
{
    public static int maxSpan(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        } else {
            int maxSpan = 0; 
            for(int i = 0; i < nums.length; i++) {
                int span = 0;
                for(int j = i; j < nums.length; j++) {
                    span++;
                    if(nums[j] == nums[i]) {
                        if(span > maxSpan) {
                            maxSpan = span;
                        }
                    }
                }
            }
            return maxSpan;
        }
    }
    public int[] fix34(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = nums.length - 1; j >= 0; j--) {
                if(nums[i] == 3 && nums[i + 1] != 4) {
                    if(nums[i] == 3 && nums[j] == 4) {
                        int temp = nums[i + 1];
                        nums[i + 1] = -4;
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == -4) {
                nums[i] = 4;
            }
        }
        return nums;
    }
    public static int[] fix45(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == 4 && nums[j] == 5) {
                    int temp = nums[i + 1];
                    if(temp != 5) {
                        nums[i + 1] = -5;
                        nums[j] = temp;
                        break;
                    } else {
                        nums[i + 1] = -5;
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == -5) {
                nums[i] = 5;
            }
        }
        return nums;
    }
    public boolean canBalance(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int sum1 = 0; int sum2 = 0;
            for(int j = 0; j <= i; j++) {
                sum1 += nums[j];
            }
            for(int k = i + 1; k < nums.length; k++) {
                sum2 += nums[k];
            }
            if(sum1 == sum2) {
                return true;
            }
        }
        return false;
    }
    public boolean linearIn(int[] outer, int[] inner) {
        for(int i = 0; i < inner.length; i++ ) {
            boolean appears = false;
            for(int j = 0; j < outer.length; j++) {
                if(outer[j] == inner[i]) {
                    appears = true;
                }
            }
            if(appears == false) {
                return false;
            }
        }
        return true;
    }
}
