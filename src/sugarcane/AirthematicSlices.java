package sugarcane;

import java.util.Arrays;

public class AirthematicSlices {

  public static void main(String[] args) {
    AirthematicSlices airthematicSlices = new AirthematicSlices();
      System.out.println(airthematicSlices.numberOfArithmeticSlices(new int[] {1, 2, 3,4,5}));
    System.out.println(
        airthematicSlices.numberOfArithmeticSlices(new int[] {1, 2, 3, 4, 6, 8, 10, 13, 16, 19}));
    System.out.println(
        airthematicSlices.numberOfArithmeticSlices(new int[] {1, 2, 3, 4, 13, 20, 22, 24, 26, 30}));
    System.out.println(
        airthematicSlices.numberOfArithmeticSlices(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    System.out.println(airthematicSlices.numberOfArithmeticSlices(new int[] {1, 2}));
    System.out.println(airthematicSlices.numberOfArithmeticSlices(new int[] {1, 2, 3}));
  }

  public int numberOfArithmeticSlices(int[] A) {
    if (A.length == 0) {
      return 0;
    }
    int counter = 0, res = 0;
    int[] arr = Arrays.copyOf(A, A.length);
    for (int i = 1; i < A.length; i++) {
      arr[i] = A[i] - A[i - 1];
    }
    arr[0] = Integer.MIN_VALUE;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] != arr[i - 1]) {
        if (counter > 0) {
          res += (counter * (counter + 1)) / 2;
        }
        counter = 0;
      } else if (arr[i] == arr[i - 1]) {
        counter++;
      }
    }
    if (counter > 0) {
      res += (counter * (counter + 1)) / 2;
    }
    return res;
  }
}
