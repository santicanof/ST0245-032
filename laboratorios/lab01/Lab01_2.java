
/**
 * Solutions for selected problems taken from CodingBat, sections 'Recursion-1' and 'Recursion-2'
 * 
 * @author Agustin Rico & Santiago Cano 
 * @version 16/02/2018
 * @see <a href = "http://www.codingbat.com" /> codingbat.com – Recursion-1 and Recursion-2 </a>
 */
public class Lab01_2
{
    /**
     * Problem buunyEars2: Given a line of bunnies, calculates the amount of ears and raised foot, acording to: the bunnies in odd positions (1, 3, ...) have the normal 2 ears, 
     * and the even bunnies (2, 4, ..) we'll have 2 ears and they each have a raised foot.
     * @param bunnies The parameter 'bunnies' represents the ammount of bunnies on the line
     * @return Number of ears and raised foot of the line
     */
    public int bunnyEars2(int bunnies) {
        if(bunnies == 0) {
            return 0;
        } else if (bunnies%2 != 0) {
            return 2 + bunnyEars2(bunnies - 1);
        } else {
            return 3 + bunnyEars2(bunnies - 1);
        }
    }

    /** Problem triangle: A triangle made of blocks will be build, the topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on,
     * this method calculates the amount of blocks of the triangle, given the number of rows.
     * @param rows The parameter rows indicates the number of rows the triangle has.
     * @return Returns the amount of blocks the triangle will have.
     */
    public int triangle(int rows) {
        if(rows <= 1) {
            return rows;
        } else {
            return rows + triangle(rows - 1);
        }
    }

    /** Problem sumDigits: Given a number, calculates the sum of it's digits.
     * @param n The number
     * @return Returns the sum of the number's digits
     */
    public int sumDigits(int n) {
        if(n < 10) {
            return n;
        } else {
            return n%10 + sumDigits(n/10);
        }
    }

    /**Problem count7: Given a non-negative number, calculates the amount of appearances of 7 as digit.
     * @param n The number
     * @return Returns the amount of appearances of '7' as digit.
     */
    public int count7(int n) {
        if(n < 10 && n == 7) {
            return 1;
        } else if(n < 10 && n != 7) {
            return 0;
        }else {
            if(n%10 == 7) {
                return 1 + count7(n/10);
            } else {
                return count7(n/10);
            }
        }
    }

    /**Problem count8: Given a non-negative number, calculates the amount of appearances of 8 as digit, except that an '8' with another '8' immediately to its left counts double.
     * @param n The number
     * @return Returns the amount of appearences of 8 as digit
     */
    public int count8(int n) {
        if(n < 10 && n == 8) {
            return 1;
        } else if(n < 10 && n != 8) {
            return 0;
        } else {
            if(n%100 == 88) {
                return 2 + count8(n/10); 
            }else if(n%10 == 8) {
                return 1 + count8(n/10);
            }else {
                return count8(n/10);
            }
        }
    }

    /**Problem groupSum6: Given an array of numbers, determines if it is possible to select a group of them such that their sums equals the target, but all the 6's must be chosen
     * @param nums The array of numbers
     * @param target The target sum
     * @return Returns true/false depending if it's possible or not
     */
    public boolean groupSum6(int[] nums, int target) {
        return groupSum6(0, nums, target);
    }

    private boolean groupSum6(int start, int[] nums, int target) {
        if(start >= nums.length) {
            return target == 0;
        } else {
            if(nums[start] == 6) {
                return groupSum6(start + 1, nums, target - nums[start]);
            } else {
                return groupSum6(start + 1, nums, target) ||
                groupSum6(start + 1, nums, target - nums[start]);
            }
        }
    }

    /**Problem groupSum6: Given an array of numbers, determines if it is possible to select a group of them such that their sums equals the target,
     * but if one value is chosen, the immediately next to it, musn't be chosen.
     * @param nums The array of numbers
     * @param target The target sum
     * @return Returns true/false depending if it's possible or not
     */
    public boolean groupNoAdj(int[] nums, int target) {
        return groupNoAdj(0, nums, target);
    }

    private boolean groupNoAdj(int start, int[] nums, int target) {
        if(start >= nums.length) {
            return target == 0;
        } else {
            return groupNoAdj(start + 1, nums, target) ||
            groupNoAdj(start + 2, nums, target - nums[start]);
        }
    }

    /**Problem groupSum5: Given an array of numbers, determines if it is possible to select a group of them such that their sums equals the target,
     * but all the multiples of 5 must be chosen, and if there is a '1' immediately next to a multiple of 5, that '1' must not be chosen.
     * @param nums The array of numbers
     * @param target The target sum
     * @return Returns true/false depending if it's possible or not
     */
    public boolean groupSum5(int[] nums, int target) {
        return groupSum5(0, nums, target);
    }

    private boolean groupSum5(int start, int[] nums, int target) {
        if(start >= nums.length) {
            return target == 0;
        } else {
            if(nums[start] % 5 == 0 && start < nums.length - 1) {
                if(nums[start + 1] == 1) {
                    return groupSum5(start + 2, nums, target - nums[start]);
                } else {
                    return groupSum5(start + 1, nums, target - nums[start]);
                }
            } else {
                return groupSum5(start + 1, nums, target - nums[start]) || 
                groupSum5(start + 1, nums, target);
            }
        }
    }

    /**Problem groupSumClump: Given an array of numbers, determines if it's possible to select a group of them such that their sum equals the target, however, if there
     * are adjacencies of the same number, then all of them must be chosen, or none of them; as if they were a group or a single number
     * @param nums The array of numbers
     * @param target The target sum
     * @return Returns true/false depending if it's possible or not
     */
    public boolean groupSumClump(int [] nums, int target) {
        return groupSumClump(0, nums, target);
    }

    private boolean groupSumClump(int start, int[] nums, int target) {
        if(start >= nums.length) {
            return target == 0;
        } else {
            int countAdj = 1;
            int lastAdjIndex = 0;
            for(int i = start; i < nums.length - 1; i++) {
                if(nums[i] == nums[i + 1]) {
                    countAdj++;
                    lastAdjIndex = i + 1;
                }
            }    
            int firstAdjIndex = lastAdjIndex - countAdj + 1;
            if(countAdj > 1 && start == firstAdjIndex) {
                int adjSum = nums[lastAdjIndex] * countAdj;
                return groupSumClump(start + countAdj, nums, target - adjSum) ||
                groupSumClump(start + countAdj, nums, target);
            } else {
                return groupSumClump(start + 1, nums, target - nums[start]) ||
                groupSumClump(start + 1, nums, target);
            }
        } 
    }

    /**Problem splitArray Given an array of numbers, determines if it's possible to divide the array in two groups, such that the sum of each one is equal to the another's,
     * every number must be in a group.
     * @param nums The array of numbers
     * @return Returns true/false depending if it's possible or not
     */
    public boolean splitArray(int[] nums) {
        return splitArray(0, nums, 0, 0);
    }

    private boolean splitArray(int start, int [] nums, int sum1, int sum2) {
        if(start == nums.length) {
            return sum1 == sum2;
        } else {
            return splitArray(start + 1, nums, sum1 + nums[start], sum2) ||
            splitArray(start + 1, nums, sum1, sum2 + nums[start]);
        }
    }

    /**Problem split53: Given an array of numbers, determines if it's possible to divide the array in two groups, such that the sum of each one is equal to the another's,
     * but all the values that are multiple of 5 must be in one group, and all the values that are a multiple of 3 (and not a multiple of 5) must be in the other. 
     * @pararm nums The array of numbers
     * @return Returns true/false depending if it's possible or not
     */
    public boolean split53(int[] nums) {
        return split53(0, nums, 0, 0);
    }

    private boolean split53(int start, int [] nums, int sum5, int sum3) {
        if(start == nums.length) {
            return sum5 == sum3;
        } else {
            if(nums[start] % 5 == 0) {
                return split53(start + 1, nums, sum5 + nums[start], sum3);
            } else if(nums[start] % 3 == 0) {
                return split53(start + 1, nums, sum5, sum3 + nums[start]);
            } else {
                return split53(start + 1, nums, sum5 + nums[start], sum3) ||
                split53(start + 1, nums, sum5, sum3 + nums[start]);
            }
        }
    }
}
