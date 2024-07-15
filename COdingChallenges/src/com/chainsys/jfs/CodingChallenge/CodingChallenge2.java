package com.chainsys.jfs.CodingChallenge;

import java.util.ArrayList;
import java.util.List;

public class CodingChallenge2 {
	//calculate XOR Sum 
	    public static int calculateSubsetXORSum(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        int totalXORSum = 0;
	        
	        backtrack(nums, 0, new ArrayList<>(), result);
	        for (List<Integer> subset : result) {
	            int xorSum = 0;
	            for (int num : subset) {
	                xorSum ^= num;
	            }
	            totalXORSum += xorSum;
	        }
	        
	        return totalXORSum;
	    }

	    private static void backtrack(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> result) {
	        result.add(new ArrayList<>(currentSubset));
	        for (int i = index; i < nums.length; i++) {
	            currentSubset.add(nums[i]);
	            backtrack(nums, i + 1, currentSubset, result);
	            currentSubset.remove(currentSubset.size() - 1);
	        }
	    }

	    public static void main(String[] args) {
	        int[] nums = {3,4,5,6,7,8};
	        int totalXORSum = calculateSubsetXORSum(nums);
	        System.out.println(totalXORSum);
	    }
	}
