import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        if (s.isEmpty() && t.isEmpty())
            return true;

        if (s.isEmpty() != t.isEmpty())
            return false;

        int[] charCount = new int[26];

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (int i = 0; i < sChar.length; i++) {
            charCount[sChar[i] - 'a'] ++;
            charCount[tChar[i] - 'a'] --;
        }

        for (int i : charCount) {
            if (i != 0)
                return false;

        }


        return true;


    }

    public void printMap(HashMap<Character, Integer> map){
        for (Character ch : map.keySet()){
            System.out.print(ch + " " + map.get(ch));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "ba";
        String t = "ab";
        System.out.println((new Solution()).isAnagram(s, t));
    }
}
