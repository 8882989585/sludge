package streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

  public static void flatMap() {
    String[][] array = new String[][] {{"a", "b"}, {"c", "d"}, {"e", "f"}};
    Arrays.stream(array).flatMap(Arrays::stream).collect(Collectors.toList());
  }

  public static void reduce() {
    int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(Arrays.stream(arr).reduce(0, Integer::sum));
  }

  public static void group() {
    class Node {
      final int i;
      final char c;

      public Node(int i, char c) {
        this.i = i;
        this.c = c;
      }
    }

    List<Node> list = Arrays.asList(new Node(2, 'c'), new Node(2, 'c'), new Node(4, 'd'));
  }
}
