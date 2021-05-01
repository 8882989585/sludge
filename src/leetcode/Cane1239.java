package leetcode;

import java.util.*;

public class Cane1239 {
  public static void main(String[] args) {
    Cane1239 cane1239 = new Cane1239();
    System.out.println(
        cane1239.maxLength(Arrays.asList("ab", "cd", "cde", "cdef", "efg", "fgh", "abxyz")));
  }

  public int maxLength(String[] arr) {
    LinkedList<HashSet<Character>> list = new LinkedList<>();
    list.add(new HashSet<>());
    int max = 0;
    for(String s:arr) {
        char[] ches = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        boolean flag =true;
        for(char ch:ches) {
            if(!set.add(ch)) {
                flag = false;
                break;
            }
        }
        if(flag) {
            LinkedList<HashSet<Character>> list2 = new LinkedList<>();
            for(HashSet<Character> hashSet:list) {
                if(Collections.disjoint(set, hashSet)) {
                    HashSet<Character> set2 = new HashSet<>();
                    set2.addAll(set);
                    set2.addAll(hashSet);
                    list2.add(set2);
                    if(set2.size() > max) {
                        max = set2.size();
                    }
                }
            }
            list.addAll(list2);
        }
    }
    return max;
  }

  public int maxLength(List<String> arr) {
    return maxLength(arr.toArray(new String[] {}));
  }
}
