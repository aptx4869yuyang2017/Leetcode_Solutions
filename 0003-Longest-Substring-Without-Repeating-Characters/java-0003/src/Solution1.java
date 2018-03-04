/// Source : https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
/// Author : 禹洋
/// Time   : 2018-2-28

// Sliding Window
// Time Complexity: O(len(s))
// Space Complexity: O(len(charset))



public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];

        int left = 0;
        int right = -1;

        int maxLength = 0;

        while (right + 1 < s.length()){
            //System.out.println(left);
            //System.out.println(right);
            //System.out.println("--");

            if ((freq[s.charAt(right+1)] == 0) && (right  < s.length())){
                    freq[s.charAt(++right)] ++;
            }else{
                freq[s.charAt(left++)] --;
            }

            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;


    }

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        solution1.lengthOfLongestSubstring("abcabc");
        System.out.println(new Solution1().lengthOfLongestSubstring("abcabc"));
        System.out.println(new Solution1().lengthOfLongestSubstring("abcabcabcd"));
    }
}
