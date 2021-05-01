package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberWithCounts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberWithCounts.containsKey(target - nums[i])) {
                return new int[]{i, numberWithCounts.get(target - nums[i])};
            }
            numberWithCounts.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.stream(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9))
                .mapToObj(String::valueOf).collect(Collectors.joining(",")));
        System.out.println(Arrays.stream(twoSum.twoSum(new int[]{3, 3, 3}, 6))
                .mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}
