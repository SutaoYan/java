package com.sutao.leetcode.array;

public class Island {

    public static void main(String[] args) {
        String[][] grid = new String[][]{
                {"1", "1", "1", "1", "0"},
                {"1", "1", "0", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"}
        };

        String[][] grid2 = new String[][]{
                {"1", "1", "0", "0", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "1", "0", "0"},
                {"0", "0", "0", "1", "1"}
        };

        System.out.println(calcIsland(grid));
        System.out.println(calcIsland(grid2));

    }

    public static int calcIsland(String[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ("1".equals(grid[i][j])) {
                    sum++;
                    dfs(grid, i, j);
                }
            }
        }
        return sum;
    }

    public static void dfs(String[][] grid, int i, int j) {
        if (null == grid || i >= grid.length || j >= grid[0].length
                || i < 0 || j < 0
                || !grid[i][j].equals("1")) return;
        grid[i][j] = "0";
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }
}
