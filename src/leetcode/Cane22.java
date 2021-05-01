package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Cane22 {

  ArrayList<String> result = new ArrayList<>();

  public static void main(String[] args) {
    //
    Cane22 cane22 = new Cane22();
    cane22.generateParenthesis(8);
  }

  public void result(int open, int close, int length, int n, String s) {
    if (close > open) {
      return;
    }
    if (length == n * 2) {
      if (open == close) {
        result.add(s);
      }
      return;
    }
    result(open + 1, close, length + 1, n, s + "(");
    result(open, close + 1, length + 1, n, s + ")");
  }

  public List<String> generateParenthesis(int n) {
    result(1, 0, 1, n, "(");
    return result;
  }
}
