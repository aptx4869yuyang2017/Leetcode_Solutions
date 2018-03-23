import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return new ArrayList<List<Integer>>();


        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<Integer> set = new HashSet<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num)+1);

            set.add(num);

        }

        int[] newNums = new int[set.size()];
        int index = 0;
        for (Integer integer : set) {
            newNums[index++] = integer;
        }
        Arrays.sort(newNums);


        if (map.containsKey(0) && map.get(0) >= 3)
            res.add(Arrays.asList(0, 0, 0));

        for (int i = 0; i < newNums.length; i++) {
            for (int j = i+1; j < newNums.length; j++) {
                if (newNums[i]*2 + newNums[j] == 0 && map.get(newNums[i]) > 1)
                    res.add(Arrays.asList(newNums[i], newNums[i], newNums[j]));
                if (newNums[i] + newNums[j]*2 == 0 && map.get(newNums[j]) > 1)
                    res.add(Arrays.asList(newNums[i], newNums[j], newNums[j]));

                int target = 0 - newNums[i] - newNums[j];
                if (!map.containsKey(target))
                    continue;

                if (target > newNums[j] && map.containsKey(target) && map.get(target) != 0)
                    res.add(Arrays.asList(newNums[i], newNums[j], target));
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[0];
        int[] nums2 = new int[]{0, 0, 0, 0};
        int[] nums3 = new int[]{1, 1, -2};
        System.out.println((new Solution()).threeSum(nums3));
    }
}