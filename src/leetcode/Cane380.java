package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Cane380 {

  ArrayList<Integer> list;
  HashMap<Integer, Integer> set;

  /** Initialize your data structure here. */
  public Cane380() {
    list = new ArrayList<>();
    set = new HashMap<>();
  }

  public static void main(String[] args) {
    //
      Cane380 cane380 = new Cane380();
//      cane380.insert(0);
//      cane380.insert(1);
//      cane380.remove(0);
//      cane380.insert(2);
//      cane380.remove(1);
//      cane380.getRandom();

      cane380 = cane380;
      cane380.remove(0);
      cane380.remove(0);
      cane380.insert(0);
      cane380.getRandom();
      cane380.remove(0);
      cane380.insert(0);
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    if (!set.containsKey(val)) {
      list.add(val);
      set.put(val, list.size() - 1);
      return true;
    }
    return false;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (set.containsKey(val)) {
      int idx = set.get(val);
      list.set(idx, list.get(list.size() - 1));
      list.remove(list.size()-1);
      if(!list.isEmpty() && idx <list.size())
        set.put(list.get(idx), idx);
      set.remove(val);
      return true;
    }
    return false;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return list.get(list.size() / 2);
  }
}
