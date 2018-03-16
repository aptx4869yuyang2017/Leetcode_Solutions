class Solution {
    public boolean isSubsequence(String s, String t) {

        int sp = 0, tp = 0;

        while (sp < s.length() && tp < t.length()){

            if (s.charAt(sp) == t.charAt(tp)){

                sp++;
            }
            tp++;

        }
        if (sp == s.length())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String s = "acd";
        //String t = "abcd";
        //
        //System.out.println((new Solution()).isSubsequence(s, t));

        char ch = 'f';
        System.out.println(s.indexOf(ch));

    }
}
