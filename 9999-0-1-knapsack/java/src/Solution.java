// 0-1 背包问题
// 记忆化搜索


public class Solution {

    private int[][] maxValueIW;

    public int knapsack(int[] w, int[] v, int C){
        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        maxValueIW = new int[n][C + 1];
        return bestValue(w, v, n - 1, C);
    }

    // [0,index]的物品，填充最大重量c，的最大价值
    private int bestValue(int[] w, int[] v, int index, int c ){

        if (index < 0 || c <= 0 )
            return 0;

        if (maxValueIW[index][c] != -1)
            return maxValueIW[index][c];

        int res = bestValue(w, v, index-1, c);
        if (c >= w[index])
            res = Math.max(bestValue(w, v, index-1, c-w[index]) + v[index], res);

        return maxValueIW[index][c] = res;

    }

    public static void main(String[] args) {

    }

}
