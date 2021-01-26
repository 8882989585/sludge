package sugarcane;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Cane1244 {

  HashMap<Integer, Integer> map;
  TreeMap<Integer, Integer> sortedMap;

  public Cane1244() {
    map = new HashMap<>();
    sortedMap = new TreeMap<>(Comparator.reverseOrder());
  }

  public void addScore(int playerId, int score) {
    int previousScore = map.getOrDefault(playerId, 0);
    int previousCount = sortedMap.getOrDefault(previousScore, 0);
    map.put(playerId, score + previousScore);
    if (previousCount == 0 || previousCount - 1 == 0) {
      sortedMap.remove(previousScore);
    } else {
      sortedMap.put(previousScore, previousCount - 1);
    }
    sortedMap.put(score + previousScore, sortedMap.getOrDefault(score + previousScore, 0) + 1);
    System.out.println("null");
  }

  public int top(int K) {
    int count = 0;
    int sum = 0;
    for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
      for (int i = 0; i < entry.getValue(); i++) {
        if (count == K) {
          System.out.println(sum);
          return sum;
        }
        sum += entry.getKey();
        count++;
      }
    }
    System.out.println(sum);
    return sum;
  }

  public void reset(int playerId) {
    int sortedKey = map.get(playerId);
    map.remove(playerId);
    int scoreCount = sortedMap.get(sortedKey);
    if (scoreCount == 0 || scoreCount - 1 == 0) {
      sortedMap.remove(sortedKey);
    } else {
      sortedMap.put(sortedKey, scoreCount - 1);
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    Cane1244 leaderboard = new Cane1244();
//    leaderboard.addScore(1, 73);   // leaderboard = [[1,73]];
//    leaderboard.addScore(2, 56);   // leaderboard = [[1,73],[2,56]];
//    leaderboard.addScore(3, 39);   // leaderboard = [[1,73],[2,56],[3,39]];
//    leaderboard.addScore(4, 51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
//    leaderboard.addScore(5, 4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
//    leaderboard.top(1);           // returns 73;
//    leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
//    leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
//    leaderboard.addScore(2, 51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
//    leaderboard.top(3);

    String[] cmd = {
        "Leaderboard",
        "addScore", "addScore", "addScore", "addScore", "addScore",
        "addScore", "addScore", "addScore", "addScore", "addScore",
        "addScore", "addScore", "addScore", "addScore", "addScore",
        "addScore", "addScore", "addScore", "addScore", "addScore",
        "addScore", "addScore", "addScore", "addScore", "addScore",
        "addScore", "addScore", "addScore", "addScore", "addScore",
        "addScore", "addScore", "addScore", "addScore", "addScore",
        "addScore", "addScore", "addScore", "addScore", "addScore",
        "addScore", "addScore", "addScore", "addScore", "addScore",
        "addScore", "addScore", "addScore", "addScore", "addScore",
        "reset", "addScore", "reset", "addScore", "addScore",
        "addScore", "top", "top", "top", "top",
        "top", "addScore", "reset", "reset", "reset",
        "reset", "addScore", "addScore", "addScore", "reset",
        "addScore", "reset", "top", "reset", "reset"};
    int[][] arr = {{0, 0},
        {1, 17}, {2, 66}, {3, 18}, {4, 37}, {5, 59},
        {6, 26}, {7, 22}, {8, 54}, {9, 4}, {10, 40},
        {11, 93}, {12, 91}, {13, 10}, {14, 99}, {15, 3},
        {16, 18}, {17, 19}, {18, 35}, {19, 61}, {20, 52},
        {21, 46}, {22, 70}, {23, 90}, {24, 14}, {25, 60},
        {26, 62}, {27, 8}, {28, 89}, {29, 72}, {30, 63},
        {31, 61}, {32, 32}, {33, 72}, {34, 19}, {35, 45},
        {36, 97}, {37, 12}, {38, 62}, {39, 55}, {40, 98},
        {41, 48}, {42, 77}, {43, 91}, {44, 49}, {45, 25},
        {46, 8}, {47, 14}, {48, 8}, {49, 89}, {50, 93},
        {1}, {31, 91}, {2}, {44, 26}, {3, 60},
        {40, 66}, {39}, {18}, {32}, {11},
        {1}, {19, 53}, {3}, {4}, {5},
        {6}, {48, 32}, {25, 30}, {16, 2}, {7},
        {21, 69}, {8}, {13}, {9}, {10}};

    for (int i = 1; i < cmd.length; i++) {
      String cmdi = cmd[i];
      switch (cmdi) {
        case "addScore":
          leaderboard.addScore(arr[i][0], arr[i][1]);
          break;
        case "reset":
          leaderboard.reset(arr[i][0]);
          break;
        case "top":
          leaderboard.top(arr[i][0]);
          break;
      }
    }
  }
}

