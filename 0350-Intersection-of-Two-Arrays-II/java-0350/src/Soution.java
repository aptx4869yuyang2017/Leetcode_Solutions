import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> record = new TreeMap<Integer, Integer>();
        for (int num1 : nums1) {
            if (record.containsKey(num1))
                record.put(num1, record.get(num1)+1);
            else
                record.put(num1, 1);
        }

        ArrayList<Integer> record2 = new ArrayList<>();
        for (int num2 : nums2) {
            if (record.containsKey(num2) && record.get(num2) > 0) {
                record2.add(num2);
                record.put(num2, record.get(num2) - 1);
            }
        }

        int[] res = new int[record2.size()];
        int index = 0;
        for (Integer integer : record2) {
            res[index++] = integer;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};
        int[] res = (new Solution()).intersect(num1, num2);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
