package hackerearth.march2021circuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LengthOfValley {

  public static void main(String[] args) throws IOException {
    //
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    for (int i = 0; i < count; i++) {
      br.readLine();
      int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      TreeSet<Integer> set1 = new TreeSet<>();
      TreeSet<Integer> set2 = new TreeSet<>();
      for (int j = 1; j < A.length; j++) {
        if (A[j] <= A[j - 1]) {
          set1.add(j - 1);
        }
      }
      set1.add(A.length - 1);
      for (int j = A.length - 2; j > -1; j--) {
        if (A[j] <= A[j + 1]) {
          set2.add(j + 1);
        }
      }
      set2.add(0);
      for (int j = 0; j < A.length; j++) {
        A[j] = set1.ceiling(j) -  set2.floor(j) + 1;
      }
      System.out.println(Arrays.stream(A).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
  }
}
