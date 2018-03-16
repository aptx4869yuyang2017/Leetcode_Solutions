
// O(n)
// 动态规划求解


class Solution2 {
    public int rob(int[] nums) {

        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];


        int preMax = nums[0];
        int curMax = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = temp;
        }

        return curMax;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 6};

        System.out.println((new Solution2()).rob(nums));

    }
}
