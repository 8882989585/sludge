package sugarcane.mock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Question5 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[0]==rec1[2] || rec1[1]==rec1[3] ||  rec2[0]==rec2[2] ||  rec2[1]==rec2[3]) {
            return false;
        }
        if(rec1[2]<=rec2[0] || rec2[2] <= rec1[0]) {
            return false;
        }
        return rec1[3] > rec2[1] && rec2[3] > rec1[1];
    }

  public static void main(String[] args) {
    //
      Question5 question5 = new Question5();
    System.out.println(
    question5.isRectangleOverlap(new int[]{7,8,13,15}, new int[]{10,8,12,20}));
  }
}
