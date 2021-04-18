package sugarcane;

import java.util.HashMap;

public class Cane13 {
  static HashMap<Character, Integer> map = new HashMap<>();

  static {
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
  }

  public static int romanToInt(String s) {
    char[] ch = s.toCharArray();
    if (ch.length == 0) {
      return 0;
    }
    int res = 0;
    for (int i = 0; i < ch.length;i++) {
        if(i+1 >= ch.length || map.get(ch[i]) >= map.get(ch[i+1])) {
            res += map.get(ch[i]);
        } else {
            res -= map.get(ch[i]);
        }
    }
    return res;
  }

  public static void main(String[] args) {
       System.out.println(Cane13.romanToInt("MCMXCIV"));
  }
}
