package sugarcane;

public class Cane1041 {

  public int face(int f, char i) {
    switch (f) {
      case 0:
        return i == 'R' ? 3 : 1;
      case 1:
        return i == 'R' ? 0 : 2;
      case 2:
        return i == 'R' ? 1 : 3;
      case 3:
        return i == 'R' ? 2 : 0;
      default:
        return f;
    }
  }

  public int[] step(int f, int x, int y) {
    switch (f) {
      case 0:
        return new int[] {x, y + 1};
      case 1:
        return new int[] {x - 1, y};
      case 2:
        return new int[] {x, y - 1};
      case 3:
        return new int[] {x + 1, y};
      default:
        return new int[] {x, y};
    }
  }

  public boolean isRobotBounded(String instructions) {
    char[] ch = instructions.toCharArray();
    int[] cr = new int[] {0, 0};
    int f = 0, counter = 0;
    while (counter < 4) {
      for (char c : ch) {
        if (c == 'G') {
          cr = step(f, cr[0], cr[1]);
        } else {
          f = face(f, c);
        }
      }
      counter++;
      if (cr[0] == 0 && cr[1] == 0 && f == 0) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Cane1041 cane1041 = new Cane1041();
    System.out.println(cane1041.isRobotBounded("GGLLGG"));
      System.out.println(cane1041.isRobotBounded("GG"));
      System.out.println(cane1041.isRobotBounded("GL"));
  }
}
