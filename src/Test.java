public class Test {

  public static void main(String[] args) {
    int[] i = new int[]{0,0,0,0};
    int m=0,n=i.length-1;
    while (m <= n) {
      int mid = (m + n) / 2;
      if (i[mid] == 0) {
        m = mid + 1;
      } else {
        n = mid;
      }
      if(m==n && i[m] == 1) {
        break;
      }
    }
    if(m==n && i[m]==1) {
      System.out.println(m);
      return;
    }
    System.out.println(-1);
  }
}
