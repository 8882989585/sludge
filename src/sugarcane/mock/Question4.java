package sugarcane.mock;

import java.util.HashMap;

public class Question4 {

    public int maxSubArrayLen(int[] nums, int k) {
        int sum =0; int max = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(sum == k)
                max = i+1;
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
            Integer t = map.get(sum-k);
            if(t!=null && i-t > max) {
                max = i-t;
            }
        }
        return max;
    }
}
