package sugarcane.daily010721feb;

public class Number1Bits {

  public int hammingWeight(int n) {
    int count = 0;
    while (n!=0) {
      n &= (n - 1);
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    //
    Number1Bits n1b = new Number1Bits();
    System.out.println(n1b.hammingWeight(0B11111111111111111111111111111101));
  }
}
