package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Cane31 {

    public void nextPermutation(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i,j;
        boolean flag = false;
        for(i=nums.length-1;i>0;i--) {
            if(nums[i] > nums[i-1]) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            Arrays.sort(nums);
            return;
        }
        flag = false;
        i--;
        for(j=nums.length-1;j>i;j--) {
            if(!flag && nums[i] < nums[j]) {
                arr.add(nums[i]);
                nums[i] = nums[j];
                flag = true;
            } else {
                arr.add(nums[j]);
            }
        }
        Collections.sort(arr);
        for(i=nums.length-arr.size(),j=0;i<nums.length;i++,j++) {
            nums[i] = arr.get(j);
        }
    }

  public static void main(String[] args) {
    //
      Cane31 cane31 = new Cane31();
//      cane31.nextPermutation(new int[]{1,8,2,6,5,1});
      cane31.nextPermutation(new int[]{1,2});
  }
}
