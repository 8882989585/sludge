package hackerearth.march2021circuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EqualElements {

  public static void main(String[] args) throws IOException {
    //
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    for (int i = 0; i < count; i++) {
      br.readLine();
      int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int counter = 0;
        for (int k : A) {
            if ((k % 2) == 0) {
                counter++;
            }
        }
      System.out.println(counter == A.length ? 0: Math.min(A.length - counter, counter));
    }
  }
}
