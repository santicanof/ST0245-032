/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author scano&ARico10
 */
public class Punto2 {
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
