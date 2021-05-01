package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * Just a irritating comparator.
 */
public class Cane937 {

    public String[] reorderLogFiles(String[] logs) {
        LinkedList<String> digitLogs = new LinkedList<>();
        TreeMap<String, List<String>> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (String log : logs) {
            String[] logArray = log.split(" ");
            if (Character.isDigit(logArray[1].charAt(0))) {
                digitLogs.add(log);
            } else {
                StringBuilder sb = new StringBuilder("");
                for (int i = 1; i < logArray.length; i++) {
                    sb.append(logArray[i]).append(" ");
                }
                sb.append(logArray[0]);
                String s = sb.toString();
                treeMap.putIfAbsent(s, new LinkedList<>());
                treeMap.get(s).add(log);
            }
        }
        for (List<String> values : treeMap.values()) {
            for (String log : values) {
                digitLogs.addFirst(log);
            }
        }
        return digitLogs.toArray(new String[]{});
    }

    public static void main(String[] args) {
        Cane937 cane937 = new Cane937();
        cane937.reorderLogFiles(new String[]{
                "dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"});
    }
}
