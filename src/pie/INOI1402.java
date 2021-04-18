package pie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class INOI1402 {

  public static void main(String[] args) throws java.lang.Exception {
    INOI1402 inoi1402 = new INOI1402();
    inoi1402.solution();
  }

  public void solution() throws IOException {
    HashMap<Integer, HashMap<Integer, Integer>> allFligthsMap = new HashMap<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] constraints =
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    for (int i = 0; i < constraints[1]; i++) {
      int[] flightDetails =
          Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      allFligthsMap.putIfAbsent(flightDetails[0], new HashMap<>());
      allFligthsMap.get(flightDetails[0]).put(flightDetails[1], flightDetails[2]);
      allFligthsMap.putIfAbsent(flightDetails[1], new HashMap<>());
      allFligthsMap.get(flightDetails[1]).put(flightDetails[0], flightDetails[2]);
    }
    int maxTillNow = 0;
    for (int i = 1; i <= constraints[0]; i++) {
      HashMap<Integer, Integer> minDistance = new HashMap<>();
      PriorityQueue<Node> bfs = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
      bfs.add(new Node(i, 0));
      while (!bfs.isEmpty()) {
        Node currentDestination = bfs.poll();
        if (minDistance.containsKey(currentDestination.destination)
            && minDistance.get(currentDestination.destination) <= currentDestination.cost) {
          continue;
        } else {
          minDistance.put(currentDestination.destination, currentDestination.cost);
        }
        HashMap<Integer, Integer> itrDestinationFlightMap =
            allFligthsMap.get(currentDestination.destination);
        if (itrDestinationFlightMap != null) {
          for (Map.Entry<Integer, Integer> entry : itrDestinationFlightMap.entrySet()) {
            Integer currentMinDistance = minDistance.get(entry.getKey());
            if (currentMinDistance == null
                || currentMinDistance > currentDestination.cost + entry.getValue()) {
              bfs.add(new Node(entry.getKey(), currentDestination.cost + entry.getValue()));
            }
          }
        }
      }
      if (minDistance.size() > 0) {
        minDistance.remove(i);
        int currentMax = minDistance.values().stream().reduce(Integer::max).get();
        if (currentMax > maxTillNow) {
          maxTillNow = currentMax;
        }
      }
    }
    System.out.println(maxTillNow);
  }

  class Node {
    int destination;
    int cost;

    public Node(int destination, int cost) {
      this.destination = destination;
      this.cost = cost;
    }
  }
}
