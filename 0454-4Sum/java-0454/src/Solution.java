import java.util.HashMap;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {


        if(A == null || B == null || C == null || D == null)
            throw new IllegalArgumentException("Illegal argument");

        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int temp = C[i] + D[j];
                if (!record.containsKey(temp))
                    record.put(temp, 1);
                else
                    record.put(temp, record.get(temp) + 1);
            }
        }

        int res = 0;

        for (int j = 0; j < A.length; j++) {
            for (int k = 0; k < B.length; k++) {
                int target = 0 - A[j] -B[k];
                if (record.containsKey(target))
                    res += record.get(target);
            }
        }


    return res;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{-2, -1};
        int[] c = new int[]{-1, 2};
        int[] d = new int[]{0, 2};

        System.out.println((new Solution()).fourSumCount(a, b, c, d));
    }
}