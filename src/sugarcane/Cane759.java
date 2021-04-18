package sugarcane;

import java.util.*;

public class Cane759 {

  public static void main(String[] args) {
    Cane759 cane759 = new Cane759();
    cane759.runner();
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    ArrayList<Interval> res = new ArrayList<>();
    TreeMap<Integer, Character> treeMap = new TreeMap<>();
    for (List<Interval> intervals : schedule) {
      for (Interval interval : intervals) {
        Map.Entry<Integer, Character> entry1 = treeMap.floorEntry(interval.start);
        Map.Entry<Integer, Character> entry2 = treeMap.ceilingEntry(interval.end);
        if (entry1 == null) {
          treeMap.put(interval.start, 'S');
        } else if (entry1.getValue() == 'E') {
          if (entry1.getKey() != interval.start) {
            treeMap.put(interval.start, 'S');
          } else {
            treeMap.remove(interval.start);
          }
        }
        if (entry2 == null) {
          treeMap.put(interval.end, 'E');
        } else if (entry2.getValue() == 'S') {
          if (entry2.getKey() != interval.end) {
            treeMap.put(interval.end, 'E');
          } else {
            treeMap.remove(interval.end);
          }
        }
        entry1 = treeMap.ceilingEntry(interval.start + 1);
        while (entry1 != null && entry1.getKey() < interval.end) {
          treeMap.remove(entry1.getKey());
          entry1 = treeMap.ceilingEntry(entry1.getKey() + 1);
        }
      }
    }
    for(Map.Entry<Integer, Character> entry:treeMap.entrySet()) {
        if(entry.getValue() == 'E') {
            Map.Entry<Integer, Character> tmp = treeMap.ceilingEntry(entry.getKey()+1);
            if(tmp!=null) {
                res.add(new Interval(entry.getKey(), tmp.getKey()));
            }
        }
    }
    return res;
  }

  public void runner() {
    employeeFreeTime(
        Arrays.asList(
            Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
            Arrays.asList(new Interval(1, 3), new Interval(4, 10))));
  }

  class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }
  }
}
