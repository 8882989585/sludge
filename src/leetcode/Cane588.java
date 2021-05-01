package leetcode;

import java.util.*;

public class Cane588 {

  HashMap<String, TreeMap<String, String>> fs;

  public Cane588() {
    fs = new HashMap<>();
  }

  public static void main(String[] args) {
    //
    Cane588 cane588 = new Cane588();
    cane588.mkdir("/a");
    cane588.ls("/a");
    cane588.ls("/");
  }

  public List<String> ls(String path) {
    String[] paths = path.split("/");
    if (paths.length == 0) {
      paths = new String[] {""};
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < paths.length - 1; i++) {
      sb.append(paths[i]).append("/");
    }
    TreeMap<String, String> set1 = fs.get(sb.toString());
    TreeMap<String, String> set2 =
        fs.get(sb.append(paths[paths.length - 1]).append("/").toString());
    if (set2 != null) return new ArrayList<>(set2.keySet());
    if (set1 != null && set1.containsKey(paths[paths.length - 1])) {
      return Collections.singletonList(paths[paths.length - 1]);
    }
    return Collections.emptyList();
  }

  public void mkdir(String path) {
    mkdirHelper(path.split("/"), -1);
  }

  public void mkdirHelper(String[] paths, int limiter) {
    String s = "";
    if (limiter == -1) {
      limiter = paths.length;
    }
    for (int i = 0; i < limiter; i++) {
      s = s + paths[i] + "/";
      if (!fs.containsKey(s)) {
        fs.put(s, new TreeMap<>());
      }
      if (i < limiter - 1) {
        fs.get(s).put(paths[i + 1], "directory");
      }
    }
  }

  public void addContentToFile(String filePath, String content) {
    String[] paths = filePath.split("/");
    mkdirHelper(paths, paths.length - 1);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < paths.length - 1; i++) {
      sb.append(paths[i]).append("/");
    }
    TreeMap<String, String> set = fs.get(sb.toString());
    String s = set.get(paths[paths.length - 1]);
    if (s == null) {
      s = "";
    }
    set.put(paths[paths.length - 1], s + content);
  }

  public String readContentFromFile(String filePath) {
    String[] paths = filePath.split("/");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < paths.length - 1; i++) {
      sb.append(paths[i]).append("/");
    }
    TreeMap<String, String> set = fs.get(sb.toString());
    if (set != null) {
      String s = set.get(paths[paths.length - 1]);
      if (s != null) {
        return s;
      }
      return "";
    }
    return "";
  }
}
