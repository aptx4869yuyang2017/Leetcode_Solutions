
// O(n)
// 动态规划求解


class Solution {
    public int rob(int[] nums) {

        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int[] maxi = new int[nums.length];

        maxi[0] = nums[0];
        maxi[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            maxi[i] = Math.max(maxi[i-2] + nums[i], maxi[i-1]);
        }

        return maxi[nums.length-1];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 6};

        System.out.println((new Solution()).rob(nums));

    }
}