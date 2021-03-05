package sugarcane;

import java.util.Arrays;

public class Cane1753 {
  public int maximumScore(int a, int b, int c) {
    int[] arr = new int[] {a, b, c};
    Arrays.sort(arr);
    int count = 0;
    while (arr[1] > 0) {
      arr[1]--;
      arr[2]--;
        Arrays.sort(arr);
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    Cane1753 cane1753 = new Cane1753();
    System.out.println(cane1753.maximumScore(4, 4, 6));
    System.out.println(cane1753.maximumScore(24, 19, 24));
      System.out.println(cane1753.maximumScore(1, 8, 8));
  }
}
