import java.util.concurrent.ForkJoinPool;

class Solution {
    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0)
            return 0;

        int n = heights.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i]);
        }

        int[] memo = new int[n];
        for (int i = 0; i < max; i++) {
            memo[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j >= 0 || heights[j] >= heights[i])
                memo[j--]++;
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (i+1)*memo[i]);
        }

        return maxArea;

    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        int[] nums1 = new int[]{2, 1, 2};
        System.out.println((new Solution()).largestRectangleArea(nums1));
    }
}
