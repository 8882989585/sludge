package sugarcane;

public class Cane91 {

  public int numDecodings(String s) {
    char[] ch = s.toCharArray();
    if (ch.length == 0 || ch[0] == '0') {
      return 0;
    }
    int ptr1 = 0, ptr2 = 0;
    for (int i = ch.length - 1; i > -1; i--) {
      if (i - 1 > -1 && ch[i - 1] == '0' && ch[i] == '0') {
        return 0;
      }
      if (i + 1 >= ch.length && ch[i] != '0') {
        ptr2 = 1;
        continue;
      }
      if (i + 2 >= ch.length) {
        ptr1 = ptr2;
        if (ch[i] <= '2' && (ch[i] != '2' || ch[i + 1] <= '6') && ch[i] != '0') {
          ptr2 = ptr2 + 1;
        }
        continue;
      }
      if (ch[i] == '0') {
        ptr1 = ptr2;
        continue;
      }
      boolean flag1 = true, flag2 = true;
      if (ch[i] > '2' || (ch[i] == '2' && ch[i + 1] > '6') || ch[i + 2] == '0') {
        flag1 = false;
      }
      if (ch[i + 1] == '0') {
        flag2 = false;
      }
      if (!(flag1 || flag2)) {
        return 0;
      }
      if (flag1 && flag2) {
        int t = ptr2;
        ptr2 = ptr1 + ptr2;
        ptr1 = t;
      } else {
        ptr1 = ptr2;
      }
    }
    return ptr2;
  }

  public static void main(String[] args) {
    Cane91 cane91 = new Cane91();
    System.out.println(cane91.numDecodings("213616"));
    System.out.println(cane91.numDecodings("226"));
    System.out.println(cane91.numDecodings("2101"));
    System.out.println(cane91.numDecodings("2136"));
    System.out.println(cane91.numDecodings("2836"));
    System.out.println(cane91.numDecodings("0"));
    System.out.println(cane91.numDecodings("00"));
    System.out.println(cane91.numDecodings("10"));
    System.out.println(cane91.numDecodings("01"));
    System.out.println(cane91.numDecodings("10011"));
    System.out.println(cane91.numDecodings("123123"));
    System.out.println(cane91.numDecodings("301"));
    System.out.println(cane91.numDecodings("280"));
    System.out.println(cane91.numDecodings("12120"));
    System.out.println(cane91.numDecodings("7206"));
  }
}
