package leetcode.mock;

public class Question1 {

  public static void main(String[] args) {
    //
    Question1 question1 = new Question1();
    question1.sortColors(new int[]{2,0,2,1,1,0});
  }

  public void sortColors(int[] nums) {
    int count1 = 0, count2 = 0, count3 = 0;
    for (int num : nums) {
      switch (num) {
        case 0:
          count1++;
          break;
        case 1:
          count2++;
          break;
        case 2:
          count3++;
          break;
      }
    }
    int i = 0;
    while (count1 > 0) {
      nums[i] = 0;
      i++;
      count1--;
    }
    while (count2 > 0) {
      nums[i] = 1;
      i++;
      count2--;
    }
    while (count3 > 0) {
      nums[i] = 2;
      i++;
      count3--;
    }
  }
}
