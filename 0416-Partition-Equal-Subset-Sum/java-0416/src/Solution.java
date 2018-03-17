import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {

        int n = nums.length;

        if (n <= 1)
            return false;

        int sum = 0;

        for (int num : nums) {
            sum = sum + num;
        }

        if (sum % 2 == 1)
            return false;

        int c = sum/2;


        //System.out.println( "数组长度"+ n + "数组和的一半" + c);

        boolean[] res = new boolean[c+1];


        for (int i = 0; i < c + 1; i++) {
            res[i] = nums[0] == i;
            System.out.print(res[i] + " ");

        }

        System.out.println();

        // 遍历[0，n-1], 考虑[0,i]个元素是否能填充 重量j
        for (int i = 1; i < n; i++) {
            for (int j = c; j > nums[i]; j--) {
                res[j] = res[j] || res[j-nums[i]];
            }
            for (int j = 0; j < c + 1; j++) {
                System.out.print(res[j] + " ");
            }
            System.out.println();
        }


        return res[c];

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5};
        int[] nums2 = new int[]{1, 5, 11, 5};
        int[] nums3 = new int[]{1, 5, 3};



        System.out.println((new Solution()).canPartition(nums3));
    }
}