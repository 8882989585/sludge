package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Cane973 {

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingDouble(t -> Math.pow(Math.abs(t[0]), 2) + Math.pow(Math.abs(t[1]), 2)));
        return Arrays.copyOfRange(points, 0, K);
    }
}
