package leetcode.daily152121feb;

import java.util.*;
import java.util.stream.Collectors;

public class KillProcess {

  public static void main(String[] args) {
    KillProcess killProcess = new KillProcess();
    System.out.println(
        killProcess.killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5).stream()
            .map(Object::toString)
            .collect(Collectors.joining(",")));
  }

  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    if (pid == null || pid.isEmpty()) {
      return Collections.emptyList();
    }
    Map<Integer, List<Integer>> processes = new HashMap<>();
    Iterator<Integer> itr1 = pid.iterator(), itr2 = ppid.iterator();
    while (itr1.hasNext()) {
      Integer c = itr1.next(), p = itr2.next();
      if (!processes.containsKey(p)) {
        processes.put(p, new ArrayList<>());
      }
      processes.get(p).add(c);
      if (!processes.containsKey(c)) {
        processes.put(c, new ArrayList<>());
      }
    }
    pid = new LinkedList<>();
    ppid = new LinkedList<>();
    pid.add(kill);
    while (!pid.isEmpty()) {
      int t = pid.remove(0);
      if (processes.containsKey(t)) {
        ppid.add(t);
        pid.addAll(processes.get(t));
      }
    }
    return ppid;
  }
}
