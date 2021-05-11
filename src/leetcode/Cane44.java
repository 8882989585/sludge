package leetcode;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Cane44 {

  public static void main(String[] args) {
    Cane44 cane44 = new Cane44();
    System.out.println(cane44.isMatch("", "****"));
  }

  public boolean isMatch(String s, String p) {
    LinkedList<Integer> itr1 = new LinkedList<>();
    LinkedList<Integer> itr2;

    int max = -1;
    char[] stoChar = s.toCharArray();

    int i = 0;
    boolean flag;
    for (char ch : p.toCharArray()) {
      flag = false;
      itr2 = new LinkedList<>();
      switch (ch) {
        case '*':
          if (i == p.length() - 1) {
            flag = true;
            return true;
          } else if (i == 0) {
            flag = true;
            for (int j = 0; j < stoChar.length; j++) {
              itr2.add(j);
              if (j > max) {
                max = j;
              }
            }
          } else if (itr1.size() > 0) {
            flag = true;
            for (int j = itr1.get(0) + 1; j < stoChar.length; j++) {
              itr2.add(j);
              if (j > max) {
                max = j;
              }
            }
          }
          break;
        case '?':
          if (i == 0 && stoChar.length > 0) {
            flag = true;
            itr2.add(0);
            max = 0;
          } else {
            for (Integer j : itr1) {
              flag = true;
              if (j + 1 < stoChar.length) {
                itr2.add(j + 1);
                if (j + 1 > max) {
                  max = j + 1;
                }
              }
            }
          }
          break;
        default:
          if (i == 0 && stoChar.length > 0) {
            if (stoChar[0] == ch) {
              flag = true;
              itr2.add(0);
              max = 0;
            }
          } else {
            for (Integer j : itr1) {
              if (stoChar[j] == ch) {
                flag = true;
                if (j + 1 < stoChar.length) {
                  itr2.add(j + 1);
                  if (j + 1 > max) {
                    max = j + 1;
                  }
                }
              }
            }
          }
      }
      itr1 = itr2;
      if (itr1.isEmpty() && !flag) {
        return false;
      }
      i++;
    }
    return max == stoChar.length - 1;
  }
}
