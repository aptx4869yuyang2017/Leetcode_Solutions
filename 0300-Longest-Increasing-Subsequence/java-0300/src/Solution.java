class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        if (n == 0)
            return 0;





        int[] res = new int[n];  // res[i] 记录了 [0,i] 区间能够构成的最长上升序列

        // 定义状态 res[i] 记录了以nums[i]元素结尾的最长上升子串
        // 初始化res， 各项为1
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }

        // 第一层循环遍历更新所有res的子项res[i]，
        // 第二层遍历res[i] 之前的所有子项 res[j],判断是否能够将res[i]顺接到res[j]后，形成更长的子串
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) //注意判断上升的条件是否含有等于号
                    res[i] = Math.max(res[j] + 1, res[i]);
            }
        }


        int maxL = 1;
        for (int i = 0; i < n; i++) {
            maxL = Math.max(maxL, res[i]);
        }

        return maxL;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 5, 4, 6, 7, 11, 2};
        int[] nums2 = new int[]{10,9,2,5,3,7,101,18};
        int[] nums3 = new int[]{1,3,6,7,9,4,10,5,6};

        System.out.println((new Solution()).lengthOfLIS(nums3));

    }
}
