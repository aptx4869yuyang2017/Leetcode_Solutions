import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 4)
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


        if (target%4==0 && map.containsKey(target/4) && map.get(target/4) >= 4)
            res.add(Arrays.asList(target/4, target/4, target/4, target/4));

        for (Integer integer : set) {
            if ((target - integer) % 3 == 0 && set.contains((target - integer) / 3) && map.get((target - integer) / 3) > 2 && (target-integer)/3 != integer) {
                res.add(Arrays.asList(integer, (target - integer) / 3, (target - integer) / 3, (target - integer) / 3));
            }
        }


        for (int i = 0; i < newNums.length; i++) {
            for (int j = i+1; j < newNums.length; j++) {
                if (newNums[i]*2 + newNums[j]*2 == target && map.get(newNums[i]) > 1 && map.get(newNums[j]) > 1)
                    res.add(Arrays.asList(newNums[i], newNums[i], newNums[j], newNums[j]));
            }
        }


        for (int i = 0; i < newNums.length; i++) {
            for (int j = i+1; j < newNums.length; j++) {
                for (int k = j+1; k < newNums.length; k++) {
                    if (newNums[i]*2 + newNums[j] + newNums[k] == target && map.get(newNums[i]) > 1)
                        res.add(Arrays.asList(newNums[i], newNums[i], newNums[j], newNums[k]));
                    if (newNums[i] + newNums[j]*2 + newNums[k] == target && map.get(newNums[j]) > 1)
                        res.add(Arrays.asList(newNums[i], newNums[j], newNums[j], newNums[k]));
                    if (newNums[i] + newNums[j] + newNums[k]*2 == target && map.get(newNums[k]) > 1)
                        res.add(Arrays.asList(newNums[i], newNums[j], newNums[k], newNums[k]));

                    int temp = target - newNums[i] - newNums[j] - newNums[k];
                    if (!map.containsKey(temp))
                        continue;

                    if (temp > newNums[k] && map.containsKey(temp) && map.get(temp) != 0)
                        res.add(Arrays.asList(newNums[i], newNums[j], newNums[k], temp));
                }

            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, 0, -2};
        int[] nums1 = new int[0];
        int[] nums2 = new int[]{-3,-1,0,2,4,5};
        int[] nums3 = new int[]{0,1,5,0,1,5,5,-4};
        int[] nums4 = new int[]{0, 0, 0, 0};
        int[] nums5 = new int[]{-1, -1, 4, -4, 0, 0, 0, 1};
        System.out.println((new Solution()).fourSum(nums5, 6));
    }
}
