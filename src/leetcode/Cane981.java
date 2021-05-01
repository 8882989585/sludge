package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Cane981 {

  class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
      map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      map.putIfAbsent(key, new TreeMap<>());
      map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
      Map.Entry<Integer, String> entry =
          map.getOrDefault(key, new TreeMap<>()).floorEntry(timestamp);
      if (entry != null) {
        String s = entry.getValue();
        return s == null ? "" : s;
      }
      return "";
    }
  }
}
