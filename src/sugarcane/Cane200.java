package sugarcane;

import java.util.LinkedList;

/**
 * Count the number of islands in boolean array. It's DFS don't use brain.
 */
public class Cane200 {
    public int numIslands(char[][] grid) {
        int count = 0, length = grid.length;
        if (length < 1) {
            return 0;
        }
        int breadth = grid[0].length;
        LinkedList<Integer> rowIndex;
        LinkedList<Integer> colIndex;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '2';
                    rowIndex = new LinkedList<>();
                    colIndex = new LinkedList<>();
                    rowIndex.add(i);
                    colIndex.add(j);
                    while (!rowIndex.isEmpty()) {
                        int k = rowIndex.pollFirst(), l = colIndex.pollFirst();
                        if (l - 1 >= 0 && grid[k][l - 1] == '1') {
                            grid[k][l - 1] = '2';
                            rowIndex.add(k);
                            colIndex.add(l - 1);
                        }
                        if (l + 1 < breadth && grid[k][l + 1] == '1') {
                            grid[k][l + 1] = '2';
                            rowIndex.add(k);
                            colIndex.add(l + 1);
                        }
                        if (k - 1 >= 0 && grid[k - 1][l] == '1') {
                            grid[k - 1][l] = '2';
                            rowIndex.add(k - 1);
                            colIndex.add(l);
                        }
                        if (k + 1 < length && grid[k + 1][l] == '1') {
                            grid[k + 1][l] = '2';
                            rowIndex.add(k + 1);
                            colIndex.add(l);
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Cane200 cane200 = new Cane200();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(cane200.numIslands(grid));
        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(cane200.numIslands(grid));
        grid = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}};
        System.out.println(cane200.numIslands(grid));
    }
}
