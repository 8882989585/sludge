package leetcode;

/**
 * Not working
 */
public class Cane829 {

  public boolean binarySearch(long[] arr, int start, long number) {
    int end = arr.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == number) {
        return true;
      }
      if (arr[mid] > number) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return false;
  }

  public int consecutiveNumbersSum(int N) {
    long[] sop = new long[(N / 2) + 2];
    int count = 0;
    for (int i = 0; i < sop.length; i++) {
      count = count + i;
      sop[i] = count;
    }
    int result = 0;
    for (int i = 0; i < sop.length; i++) {
      System.out.println(sop[i]);
      if (binarySearch(sop, i + 1, sop[i] + N)) {
        result++;
      }
    }
    result++;
    if (N < 3) {
      result--;
    }
    return result;
  }

  public static void main(String[] args) {
    Cane829 cane829 = new Cane829();
//    System.out.println(cane829.consecutiveNumbersSum(15));
//    System.out.println(cane829.consecutiveNumbersSum(1));
//    System.out.println(cane829.consecutiveNumbersSum(0));
//    System.out.println(cane829.consecutiveNumbersSum(4));
//    System.out.println(cane829.consecutiveNumbersSum(5));
//    System.out.println(cane829.consecutiveNumbersSum(9));
    System.out.println(cane829.consecutiveNumbersSum(855204));
  }
}
