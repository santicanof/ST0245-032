
/**
 * Solutions for selected problems taken from CodingBat, sections 'Recursion-1' and 'Recursion-2'
 * 
 * @author Agustin Rico & Santiago Cano 
 * @version 16/02/2018
 */
public class Recursion
{
    public int bunnyEars2(int bunnies) {
        if(bunnies == 0) {
            return 0;
        } else if (bunnies%2 != 0) {
            return 2 + bunnyEars2(bunnies - 1);
        } else {
            return 3 + bunnyEars2(bunnies - 1);
        }
    }

    public int triangle(int rows) {
        if(rows <= 1) {
            return rows;
        } else {
            return rows + triangle(rows - 1);
        }
    }

    public int sumDigits(int n) {
        if(n < 10) {
            return n;
        } else {
            return n%10 + sumDigits(n/10);
        }
    }

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
    
    public boolean groupSum6(int start, int[] nums, int target) {
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

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start >= nums.length) {
            return target == 0;
        } else {
            return groupNoAdj(start + 1, nums, target) ||
            groupNoAdj(start + 2, nums, target - nums[start]);
        }
    }

    public boolean groupSum5(int start, int[] nums, int target) {
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

    public boolean groupSumClump(int start, int[] nums, int target) {
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

    public boolean splitArray(int[] nums) {
        return splitArray(0, nums, 0, 0);
    }

    private boolean splitArray(int start, int [] nums, int suma1, int suma2) {
        if(start == nums.length) {
            return suma1 == suma2;
        } else {
            return splitArray(start + 1, nums, suma1 + nums[start], suma2) ||
            splitArray(start + 1, nums, suma1, suma2 + nums[start]);
        }
    }

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
