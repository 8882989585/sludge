package sugarcane.daily222821feb;

public class Search2DMatrix {

  public static void main(String[] args) {
    Search2DMatrix search2DMatrix = new Search2DMatrix();
        search2DMatrix.searchMatrix(
            new int[][] {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}},
            13);
        search2DMatrix.searchMatrix(
                new int[][] {
                        {1,1}
                },
                0);
    search2DMatrix.searchMatrix(new int[][] {{5}, {6}}, 6);
  }

  public int[] binarySearch(int[] arr, int x) {
    int start = 0, end = arr.length - 1, mid = -1;
    if (arr.length < 3) {
      return new int[] {start, end};
    }
    while (end - start > 1) {
      mid = (start + end) / 2;
      if (arr[mid] == x) {
        return new int[] {mid, mid};
      }
      if (arr[mid] < x) {
        start = mid;
      } else {
        end = mid;
      }
    }
    return new int[] {start, end};
  }

  public int[] binarySearch(int[][] arr, int x, int col) {
    int start = 0, end = arr.length - 1, mid = -1;
    if (arr.length < 3) {
      return new int[] {start, end};
    }
    while (end - start > 1) {
      mid = (start + end) / 2;
      if (arr[mid][col] == x) {
        return new int[] {mid, mid};
      }
      if (arr[mid][col] < x) {
        start = mid;
      } else {
        end = mid;
      }
    }
    return new int[] {start, end};
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) {
      return false;
    }
    for(int i=0;i<matrix.length;i++) {
      if(target>= matrix[i][0] && target <= matrix[i][matrix[0].length-1]) {
        int[] d = binarySearch(matrix[i], target);
        for (int j = d[0]; j <= d[1]; j++) {
          int[] t = binarySearch(matrix, target, j);
          if (matrix[t[0]][d[0]] == target
                  || matrix[t[0]][d[1]] == target
                  || matrix[t[1]][d[0]] == target
                  || matrix[t[1]][d[1]] == target){
            return true;
          }
        }
      }
    }
    return false;
  }
}
