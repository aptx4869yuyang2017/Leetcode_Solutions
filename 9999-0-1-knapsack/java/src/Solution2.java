public class Solution2 {



    public int knapsack(int[] w, int[] v, int C){

        assert w.length == v.length;

        int n = w.length;

        if (n==0 || C ==0)
            return 0;

        int[][] maxValue = new int[n][C+1];

        //for (int i = 0; i < n; i++) {
        //    maxValue[i][0] = 0;
        //}
        for(int j = 0 ; j <= C ; j ++)
            maxValue[0][j] = (j >= w[0] ? v[0] : 0 );

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C ; j++) {

                //if (i == 0 && w[i] > j)
                //    maxValue[i][j] = 0;
                //else if (i == 0 && w[i] <= j)
                //    maxValue[i][j] = v[i];
                //else if (w[i] > j )
                //    maxValue[i][j] = maxValue[i-1][j];
                //else
                //    maxValue[i][j] = Math.max(maxValue[i-1][j], maxValue[i-1][j-w[i]] + v[i]);
                maxValue[i][j] = maxValue[i-1][j];
                if(j>=w[i])
                    maxValue[i][j] = Math.max(maxValue[i][j], maxValue[i-1][j-w[i]] + v[i]);

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                System.out.print(maxValue[i][j] + " ");
            }
            System.out.println();

        }

        return maxValue[n-1][C];


    }

    public static void main(String[] args) {

        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{6, 10, 12};
        int c = 5;

        System.out.println((new Solution2()).knapsack(w, v, c));

    }



}
