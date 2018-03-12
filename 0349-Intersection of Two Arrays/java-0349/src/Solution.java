import java.util.TreeSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> record = new TreeSet<Integer>();
        for (int num1 : nums1) {
            record.add(num1);
            //System.out.println("num1:" + num1);
        }

        TreeSet<Integer> result = new TreeSet<Integer>();
        for (int num2 : nums2) {
            if (record.contains(num2))
                result.add(num2);
            //System.out.println("num2:" + num2);
        }

        int[] res = new int[result.size()];
        int index = 0;
        for (int item : result) {
            res[index++] = item;
            //System.out.println(item);
        }

        return res;

    }

    public static void main(String[] args) {

        int[] res = (new Solution()).intersection((new int[]{2, 3}), (new int[]{3, 4}));

        for (int item : res) {
            System.out.print(item);
        }
        System.out.println();

    }


}
