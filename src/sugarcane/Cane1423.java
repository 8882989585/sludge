package sugarcane;

import java.util.Arrays;

public class Cane1423 {

  public static void main(String[] args) {
    Cane1423 cane1423 = new Cane1423();
    cane1423.maxScore(new int[] {1, 2, 3, 4, 5, 6, 1}, 3);
  }

  public int maxScore(int[] cardPoints, int k) {
    int length = cardPoints.length - k;
    int sum = Arrays.stream(cardPoints).sum();
    int minSum = 0;
    for (int i = 0; i < length; i++) {
      minSum += cardPoints[i];
    }
    int tmpSum = minSum;
    for (int i = length; i < cardPoints.length; i++) {
      tmpSum = cardPoints[i] + tmpSum - cardPoints[i - length];
      if (minSum > tmpSum) {
        minSum = tmpSum;
      }
    }
    return sum - minSum;
  }
}
