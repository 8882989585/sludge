package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Cane329 {

  public int longestIncreasingPath(int[][] matrix) {
    int max = 0;
    Node[] nodes = new Node[matrix.length * matrix[0].length];
      HashMap<String, Integer> map = new HashMap<>();
    int t = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        nodes[t] = new Node(matrix[i][j], i, j);
        t++;
      }
    }
    Arrays.sort(nodes, Comparator.comparingInt(node -> node.v));
    for(int i=nodes.length-1;i>-1;i--) {
        Node temp = nodes[i];
      Integer node2 = null;
        if(temp.j -1 > -1 && matrix[temp.i][temp.j-1] > temp.v) {
          node2 = map.get(temp.i+"-"+(temp.j-1));
        }
        if(temp.j +1<matrix[0].length && matrix[temp.i][temp.j+1] > temp.v) {
          if(node2 == null) {
            node2 = map.get(temp.i+"-"+(temp.j+1));
          } else {
            Integer node21 = map.get(temp.i+"-"+(temp.j+1));
            if(node21!=null && node21 > node2) {
              node2 = node21;
            }
          }
        }
        if(temp.i-1 > -1 && matrix[temp.i-1][temp.j] > temp.v) {
          if(node2 == null) {
            node2 = map.get((temp.i-1)+"-"+(temp.j));
          } else {
            Integer node21 = map.get((temp.i-1)+"-"+(temp.j));
            if(node21!=null && node21 > node2) {
              node2 = node21;
            }
          }
        }
      if(temp.i +1<matrix.length && matrix[temp.i+1][temp.j] > temp.v) {
        if(node2 == null) {
          node2 = map.get((temp.i+1)+"-"+(temp.j));
        } else {
          Integer node21 = map.get((temp.i+1)+"-"+(temp.j));
          if(node21!=null && node21 > node2) {
            node2 = node21;
          }
        }
      }
      if(node2!= null) {
        map.put(temp.i+"-"+temp.j, node2+1);
        if(node2+1 > max) {
          max = node2+1;
        }
      } else {
        map.put(temp.i+"-"+temp.j, 1);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    //
    Cane329 cane329 = new Cane329();
    System.out.println(
    cane329.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
  }

  class Node {
    int v;
    int i;
    int j;

    public Node(int v, int i, int j) {
      this.v = v;
      this.i = i;
      this.j = j;
    }
  }

}
