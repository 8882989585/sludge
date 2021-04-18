package sugarcane;

import java.util.*;

public class Cane239 {

  public static void main(String[] args) {
    Cane239 cane239 = new Cane239();
    cane239.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
  }

  public int calculateMax(LinkedList<Integer> nums) {
    return nums.stream().reduce(Integer::max).get();
  }

  public int[] maxSlidingWindow(int[] a, int k) {
    if (a == null || k <= 0) {
      return new int[0];
    }
    int n = a.length;
    int[] r = new int[n-k+1];
    int ri = 0;
    // store index
    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < a.length; i++) {
      // remove numbers out of range k
      while (!q.isEmpty() && q.peek() < i - k + 1) {
        q.poll();
      }
      // remove smaller numbers in k range as they are useless
      while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
        q.pollLast();
      }
      // q contains index... r contains content
      q.offer(i);
      if (i >= k - 1) {
        r[ri++] = a[q.peek()];
      }
    }
    return r;
  }
}
