package sugarcane;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Single pass approach by using a hashmap and storing the index.
 */
public class Cane1 {
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
        Cane1 cane1 = new Cane1();
        System.out.println(Arrays.stream(cane1.twoSum(new int[]{2, 7, 11, 15}, 9))
                .mapToObj(String::valueOf).collect(Collectors.joining(",")));
        System.out.println(Arrays.stream(cane1.twoSum(new int[]{3, 3, 3}, 6))
                .mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}
